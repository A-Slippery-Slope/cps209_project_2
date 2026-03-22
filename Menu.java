import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel {
    private JButton startButton, exitButton;
    private static JFrame frame;

    public Menu() {
        frame = new JFrame("Pong Game");
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        frame.add(this);
        frame.setVisible(true);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(50, 50, 50, 50);

        startButton = new JButton("Start Game");
        exitButton = new JButton("Exit");
        startButton.setBackground(Color.BLACK);
        exitButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        exitButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(100, 30));
        exitButton.setPreferredSize(new Dimension(100, 30));

        add(startButton, gbc);
        add(exitButton, gbc);

        startButton.addActionListener(e -> {
            frame.setVisible(false);
            new Display();
        });

        exitButton.addActionListener(e -> System.exit(0));
    }
    
}
