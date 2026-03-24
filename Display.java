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
    
    // Default positions for paddles and ball
    private static Point leftPaddleDefault, rightPaddleDefault, ballDefault;
    private static JFrame frame;
    private static int width, height;

    // Paddle and ball objects
    private Paddle leftPaddle, rightPaddle;
    private Ball ball;

    // Internal classes and Timer class, allowing for I/O and game tracking
    private GameLoop gameLoop;
    private Game game;
    private Input input;
    private static Timer t;

    /*
        Constructor for the Display class that initializes the frame and all drawable components.
        It sets the paddles and ball to their default positions on screen and starts the timer for the main game loop.
        Sets the left paddle to be a wall if singleplayer was selected.
    */
    public Display() {
        frame = new JFrame("Pong Game");
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        setBackground(Color.BLACK);
        frame.add(this);
        frame.setVisible(true);

        width = frame.getWidth();
        height = frame.getHeight();

        leftPaddleDefault = new Point(50, height / 2 - 50);
        rightPaddleDefault = new Point(width - 70, height / 2 - 50);
        ballDefault = new Point(width / 2 - 10, height / 2 - 10);

        leftPaddle = new Paddle(new Point(leftPaddleDefault.getX(), Menu.isSinglePlayer() ? 0 : leftPaddleDefault.getY()), 12, Menu.isSinglePlayer() ? height : 150);
        rightPaddle = new Paddle(new Point(rightPaddleDefault.getX(), rightPaddleDefault.getY()), 12, 150);
        ball = new Ball(new Point(ballDefault.getX(), ballDefault.getY()), 20);
        gameLoop = new GameLoop(new Physics(leftPaddle, rightPaddle, ball));

        input = new Input();
        game = new Game();

        t = new Timer(4, gameLoop);
        t.start();
    }

    // Getters for the defaults and frame dimensions
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

    // Stops the game at victory and opens the menu again
    public static void reset() {
        frame.setVisible(false);
        frame.dispose();
        t.stop();
        new Menu();
    }

    // Paints the paddles, ball, and score onto the screen
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        leftPaddle.paintComponent(g);
        rightPaddle.paintComponent(g);
        ball.paintComponent(g);
        game.paintComponent(g);
    }

    // Internal class using the Timer and ActionListener to update the physics and repaint every frame
    private class GameLoop implements ActionListener {
        private Physics physics;

        public GameLoop(Physics physics) {
            this.physics = physics;
        }

        // Main game loop that updates every timer tick
        @Override
        public void actionPerformed(ActionEvent e) {
            physics.update();
            repaint();
        }
    }

    // Internal class to handle the input from the keyboard to move the paddles
    private class Input implements KeyListener {
        private Physics physics;
        
        // Adds a KeyListener to the frame
        public Input() {
            frame.addKeyListener(this);
            this.physics = gameLoop.physics;
        }
        
        // Implements KeyListener and moves the left paddle with W and S, and moves the right paddle with UP and DOWN
        // Restricts their movement within bounds
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_W -> { if (leftPaddle.getPosition().getY() > 0) physics.setLeftPaddleSpeed(-10); }
                case KeyEvent.VK_S -> { if (leftPaddle.getPosition().getY() < height - leftPaddle.getHeight()) physics.setLeftPaddleSpeed(10); }
                case KeyEvent.VK_UP -> { if (rightPaddle.getPosition().getY() > 0) physics.setRightPaddleSpeed(-10); }
                case KeyEvent.VK_DOWN -> { if (rightPaddle.getPosition().getY() < height - rightPaddle.getHeight()) physics.setRightPaddleSpeed(10); }
                case KeyEvent.VK_ESCAPE -> System.exit(0);
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
