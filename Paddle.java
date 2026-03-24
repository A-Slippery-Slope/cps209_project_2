import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Paddle extends JPanel {
    private Point position;
    private Rectangle paddle;
    private int width, height;
    
    // Constructor for the Paddle class, initializes the position, width, and height of the paddle
    public Paddle(Point position, int width, int height) {
        this.position = position;
        this.paddle = new Rectangle();
        this.width = width;
        this.height = height;
    }

    // Getters and setters for the position, width, and height of the paddle
    public Point getPosition() {
        return position;
    }
    public int getPaddleWidth() {
        return width;
    }
    public int getPaddleHeight() {
        return height;
    }
    public void setPosition(Point position) {
        this.position = new Point(position.getX(), position.getY());
    }

    // Method to move the paddle in the y direction, checks for boundaries to prevent moving off the screen
    public void move(int dy) {
        if (position.getY() + dy >= 0 && position.getY() + dy <= Display.getFrameHeight() - height) {
            position.displaceY(dy);
        }
    }

    // Overrides the paintComponent method to draw the paddle on the screen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
    }

    // Inner class to represent the paddle as a rectangle and draw it on the screen
    private class Rectangle {
        private void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.WHITE);
            g2d.fillRect(position.getX(), position.getY(), width, height);
        }
    }
}
