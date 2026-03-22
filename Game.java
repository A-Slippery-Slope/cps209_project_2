public class Game {
    private int rightScore = 0, leftScore = 0;

    public Game() {
        
    }

    public int getRightScore() {
        return rightScore;
    }
    public int getLeftScore() {
        return leftScore;
    }
    public void incrementRightScore() {
        rightScore++;
    }
    public void incrementLeftScore() {
        leftScore++;
    }
}
