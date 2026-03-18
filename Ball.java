import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Ball extends JPanel {
    private Point position;
    private Circle ball;
    private int diameter;
    
    public Ball(Point position, int diameter) {
        this.position = position;
        this.ball = new Circle();
        this.diameter = diameter;
    }

    public Point getPosition() {
        return position;
    }
    public int getDiameter() {
        return diameter;
    }

    public void moveX(int dx) {
        position.displaceX(dx);
    }
    public void moveY(int dy) {
        position.displaceY(dy);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
    }

    private class Circle {
        private void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.WHITE);
            g2d.fillOval(position.getX(), position.getY(), diameter, diameter);
        }
    }
}
