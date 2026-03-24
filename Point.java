public class Point {
    private int x, y;

    // Constructor for the Point class, initializes the x and y coordinates of the point
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters for the x and y coordinates of the point
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    // Methods to displace the point in the x and y directions
    public void displaceX(int dx) {
        this.x += dx;
    }
    public void displaceY(int dy) {
        this.y += dy;
    }
}