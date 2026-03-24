public class Project2Runner {
    
    /*
     * Name: Evan Sinelnikov
     * Student ID: 501355381
     * 
     ******** Project Description ********
     * 
     * Describe in plain English the overall program/program in a paragraph or 2.
     * 
     * The purpose of this program is to recreate the game of Pong in the Java language.
     * Pong is a game that has 2 paddles on either side of the screen and needs
     * two people to play. The goal is to bounce the ball onto the opposite player's side,
     * getting points. To achieve this, the program will need many classes. The point class is 
     * a simple (x, y) coordinate that simplifies the position of each element. The Paddle class
     * holds the attributes of the paddles like position and length. The Ball class contains 
     * the attributes of the ball. The Ball and Paddle class need to have nested shape classes 
     * like Rectangle Circle to display each efficiently and The Physics class handles
     * the collisions between the paddles and the ball. The Display class holds the JPanel
     * and display the movement and GUI elements. There also needs to be a Menu class 
     * to hold the title and options, with it allowing the user to start, quit, and choose singleplayer.
     * The Game class holds the score and the means to print it on the screen.
     * Finally, the Project2Runner class calls the Display class to initialize the game
     * with the instructions being on the main menu.
     * 
     ******** Swing Requirement ********
     * 
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 3 unique components. Be clear to identify in what
     * files and the lines number (just the starting line is fine) that the
     * components are defined on.
     * 
     * The program has two JFrames, one on line 19 of Menu.java and one on line 34 of Display.java.
     * The Menu JFrame has all of the swing components, which are JButtons, JLabels, and a JRadioButton.
     * There are two JButtons, the start button on line 41 and the exit button on line 49.
     * These buttons trigger starting the game and exiting respectively.
     * There are four JLabels, the title label on line 34, instruction1 label on line 64, 
     * instruction1 label on line 71, and the winner label on line 81.
     * These labels build the text on the UI.
     * There is one JRadioButton, which is the singlePlayerButton on line 57.
     * This lets the user choose between singleplayer (a wall on the left) or multiplayer.
     * 
     ******** 2D Graphics Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 1 JPanel used for drawing something. Be clear to
     * identify in what files and the line numbers that this panel is defined on.
     * 
     * The program's display class extends the JPanel class, which is defined on line 11 
     * and added to frame on line 39 of Display.java. This class overrides the JPanel's paint 
     * method to paint the paddles, ball, and score on line 88. The Paddle, Ball, and Game classes
     * all extend JPanel aswell, each overriding the paintComponent method to paint their respective 
     * elements through a draw method within each class. For Paddle.java, paintComponent is on line 42
     * and draw is on line 49. For Ball.java, paintComponent is on line 39 and draw is on line 46.
     * For Game.java, paintComponent is on line 29.
     * 
     ******** Event Listener Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least one ActionListener, and there is additionally at least
     * one MouseListener or KeyListener. Be clear to identify in what file
     * and the line numbers that these listeners are defined in.
     * 
     * There are 4 ActionListeners in this program, with 3 being in Menu and 1 being in Display.
     * The three in Menu.java are on lines 90, 95, and 96, with the first two listening to the start
     * and exit buttons, doing the respective actions when pressed. The third listener listens to
     * the singlePlayerButton and changes a boolean when selected. The one in Display.java is
     * implemented by the GameLoop class on line 97 and updates the physics and panel using
     * the actionPerformed method on line 106, which is activated by a Timer in the Display class.
     * There is also a KeyListener in Display that is implemented by the Input class on line 113.
     * This adds a KeyListener to the frame and updates the position of the paddles using the 
     * KeyPressed and KeyReleased methods on lines 127 and 138.
     */

    public static void main(String[] args) {
        new Menu();
    }
}
