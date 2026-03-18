import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Paddle extends JPanel {
    private Point position;
    private Rectangle paddle;
    private int width, height;
    
    public Paddle(Point position, int width, int height) {
        this.position = position;
        this.paddle = new Rectangle();
        this.width = width;
        this.height = height;
    }

    public Point getPosition() {
        return position;
    }
    public int getPaddleWidth() {
        return width;
    }
    public int getPaddleHeight() {
        return height;
    }

    public void move(int dy) {
        position.displaceY(dy);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
    }

    private class Rectangle {
        private void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.WHITE);
            g2d.fillRect(position.getX(), position.getY(), width, height);
        }
    }
}
