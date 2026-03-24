import java.awt.*;
import javax.swing.*;

public class Game extends JPanel {
    private static int rightScore = 0, leftScore = 0;

    // Getters and incrementers for the game scores
    public static int getRightScore() {
        return rightScore;
    }
    public static int getLeftScore() {
        return leftScore;
    }
    public static void incrementRightScore() {
        rightScore++;
    }
    public static void incrementLeftScore() {
        leftScore++;
    }

    // Resets scores to 0
    public static void resetScores() {
        rightScore = 0;
        leftScore = 0;
    }

    // Overrides the paintComponent method to draw the scores onto the screen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString(String.valueOf(leftScore), Display.getFrameWidth() / 4, 100);
        g.drawString(String.valueOf(rightScore), Display.getFrameWidth() * 3 / 4, 100);
    }
}
