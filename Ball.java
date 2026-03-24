import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Ball extends JPanel {
    private Point position;
    private Circle ball;
    private int diameter;
    
    // Constructor for the Ball class, initializes the position and diameter of the ball
    public Ball(Point position, int diameter) {
        this.position = position;
        this.ball = new Circle();
        this.diameter = diameter;
    }

    // Getters and setters for the position and diameter of the ball
    public Point getPosition() {
        return position;
    }
    public int getDiameter() {
        return diameter;
    }
    public void setPosition(Point position) {
        this.position = new Point(position.getX(), position.getY());
    }

    // Methods to move the ball in the x and y directions
    public void moveX(int dx) {
        position.displaceX(dx);
    }
    public void moveY(int dy) {
        position.displaceY(dy);
    }

    // Overrides the paintComponent method to draw the ball on the screen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
    }

    // Inner class to represent the ball as a circle and draw it on the screen
    private class Circle {
        private void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.WHITE);
            g2d.fillOval(position.getX(), position.getY(), diameter, diameter);
        }
    }
}
