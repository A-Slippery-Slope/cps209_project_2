import java.awt.*;
import javax.swing.*;

public class Menu {
    private JButton startButton, exitButton;
    private JLabel title, instructions1, instructions2, winner;
    private JRadioButton singlePlayerButton;
    private static boolean singlePlayer = false;
    private static JFrame frame;

    /*
        Constructor for the Menu class that initializes the frame and its components.
        The frame uses a GridBagLayout to center everything.
        The buttons are to start and exit.
        The labels are to display the title, instructions, and winner after a game.
        The radio button is to select singleplayer, making the left player a wall.
    */
    public Menu() {
        frame = new JFrame("Pong Game");
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Center everything
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 20, 20, 20);

        // Title
        gbc.gridy = 0;
        title = new JLabel("PONG");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 100));
        frame.add(title, gbc);

        // Start button
        gbc.gridy = 1;
        startButton = new JButton("Start Game");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(150, 40));
        frame.add(startButton, gbc);

        // Exit button
        gbc.gridy = 2;
        exitButton = new JButton("Exit");
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.setPreferredSize(new Dimension(150, 40));
        frame.add(exitButton, gbc);

        // Singleplayer choice
        gbc.gridy = 3;
        singlePlayerButton = new JRadioButton("Single Player");
        singlePlayerButton.setBackground(Color.BLACK);
        singlePlayerButton.setForeground(Color.WHITE);
        frame.add(singlePlayerButton, gbc);

        // Instructions
        gbc.gridy = 4;
        instructions1 = new JLabel("Instructions: Use W and S keys to move the left paddle, and UP and DOWN arrow keys to move the right paddle.");
        instructions1.setForeground(Color.WHITE);
        instructions1.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(instructions1, gbc);

        // Additional instructions
        gbc.gridy = 5;
        instructions2 = new JLabel("Get 11 points to win! Press ESC to exit the game at any time.");
        instructions2.setForeground(Color.WHITE);
        instructions2.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(instructions2, gbc);

        // Winner (if exists)
        if (Game.getLeftScore() > 10 || Game.getRightScore() > 10) {
            String winnerStr = Game.getLeftScore() > 10 ? "Left Player Wins!" : "Right Player Wins!";

            gbc.gridy = 6;
            winner = new JLabel(winnerStr);
            winner.setForeground(Color.WHITE);
            winner.setFont(new Font("Arial", Font.BOLD, 50));
            frame.add(winner, gbc);

            Game.resetScores();
        }

        // Adds actionListeners to the buttons and radio button
        startButton.addActionListener(e -> {
            frame.setVisible(false);
            frame.dispose();
            new Display();
        });
        exitButton.addActionListener(e -> System.exit(0));
        singlePlayerButton.addActionListener(e -> singlePlayer = singlePlayerButton.isSelected());

        frame.setVisible(true);
    }

    // Returns if singleplayer was selected
    public static boolean isSinglePlayer() {
        return singlePlayer;
    }
}
