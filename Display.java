import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Display extends JPanel {
    private static Point leftPaddleDefault, rightPaddleDefault, ballDefault;
    private static JFrame frame;
    private static int width, height;

    private Paddle leftPaddle, rightPaddle;
    private Ball ball;

    private GameLoop gameLoop;
    private Input input;
    private Timer t;
    
    public Display() {
        frame = new JFrame("Pong Game");
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        frame.add(this);
        frame.setVisible(true);

        width = frame.getWidth();
        height = frame.getHeight();

        leftPaddleDefault = new Point(50, height / 2 - 50);
        rightPaddleDefault = new Point(width - 70, height / 2 - 50);
        ballDefault = new Point(width / 2 - 10, height / 2 - 10);

        leftPaddle = new Paddle(new Point(leftPaddleDefault.getX(), leftPaddleDefault.getY()), 10, 100);
        rightPaddle = new Paddle(new Point(rightPaddleDefault.getX(), rightPaddleDefault.getY()), 10, 100);
        ball = new Ball(new Point(ballDefault.getX(), ballDefault.getY()), 20);
        gameLoop = new GameLoop(new Physics(leftPaddle, rightPaddle, ball));

        input = new Input();

        t = new Timer(8, gameLoop);
        t.start();
    }

    public static Point getLeftPaddleDefault() {
        return leftPaddleDefault;
    }
    public static Point getRightPaddleDefault() {
        return rightPaddleDefault;
    }
    public static Point getBallDefault() {
        return ballDefault;
    }
    public static int getFrameHeight() {
        return height;
    }
    public static int getFrameWidth() {
        return width;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        leftPaddle.paintComponent(g);
        rightPaddle.paintComponent(g);
        ball.paintComponent(g);
    }

    public class GameLoop implements ActionListener {
        private Physics physics;

        public GameLoop(Physics physics) {
            this.physics = physics;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            physics.update();
            repaint();
        }
    }

    public class Input implements KeyListener {
        private Physics physics;
        
        public Input() {
            frame.addKeyListener(this);
            this.physics = gameLoop.physics;
        }
        
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_W -> physics.setLeftPaddleSpeed(-5);
                case KeyEvent.VK_S -> physics.setLeftPaddleSpeed(5);
                case KeyEvent.VK_UP -> physics.setRightPaddleSpeed(-5);
                case KeyEvent.VK_DOWN -> physics.setRightPaddleSpeed(5);
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_W -> physics.setLeftPaddleSpeed(0);
                case KeyEvent.VK_S -> physics.setLeftPaddleSpeed(0);
                case KeyEvent.VK_UP -> physics.setRightPaddleSpeed(0);
                case KeyEvent.VK_DOWN -> physics.setRightPaddleSpeed(0);
            }
        }
    }
}
