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
     * and display the movement and GUI elements. There also needs to be a Game and Menu class 
     * to represent the different screens the program can be on Finally, the Project2Runner class
     * calls the Display class to initialize the game.
     * 
     ******** Swing Requirement ********
     * 
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 3 unique components. Be clear to identify in what
     * files and the lines number (just the starting line is fine) that the
     * components are defined on.
     * 
     * 
     * 
     ******** 2D Graphics Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 1 JPanel used for drawing something. Be clear to
     * identify in what files and the line numbers that this panel is defined on.
     * 
     * 
     * 
     ******** Event Listener Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least one ActionListener, and there is additionally at least
     * one MouseListener or ActionListener. Be clear to identify in what file
     * and the line numbers that these listeners are defined in.
     */

     public static void main(String[] args) {
        new Menu();
    }
}
