public class Point {
    private int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void displaceX(int dx) {
        this.x += dx;
    }
    public void displaceY(int dy) {
        this.y += dy;
    }
}
