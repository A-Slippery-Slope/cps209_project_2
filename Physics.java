public class Physics {
    private Paddle leftPaddle, rightPaddle;
    private Ball ball;
    private int ballSpeedX, ballSpeedY, leftPaddleSpeed, rightPaddleSpeed;
    
    // Constructor for the Physics class, initializes the left and right paddles, the ball, and their speeds
    public Physics(Paddle leftPaddle, Paddle rightPaddle, Ball ball) {
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
        this.ball = ball;

        ballSpeedX = 10;
        ballSpeedY = 10;
        leftPaddleSpeed = 0;
        rightPaddleSpeed = 0;
    }

    /* 
        Updates the positions of the paddles and the ball based on their speeds and checks for collisions 
        Ensures that the ball bounces off the paddles (and doesn't get stuck) and the top and bottom of the screen, 
        and resets the game if the ball goes off the left or right side of the screen
    */
    public void update() {
        if (checkPaddleCollision()) { 
            ballSpeedX = -ballSpeedX;

            Point ballPos = ball.getPosition();
            int leftPaddleX = leftPaddle.getPosition().getX(), leftPaddleWidth = leftPaddle.getPaddleWidth();
            int rightPaddleX = rightPaddle.getPosition().getX();
            if (ballPos.getX() < Display.getFrameWidth() / 2) {
                ball.setPosition(new Point(leftPaddleX + leftPaddleWidth, ballPos.getY()));
            } 
            else {
                ball.setPosition(new Point(rightPaddleX - ball.getDiameter(), ballPos.getY()));
            }
        }
        if (checkVerticalCollision()) { ballSpeedY = -ballSpeedY; }
        if (checkHorizontalCollision()) { reset(); }

        ball.moveX(ballSpeedX);
        ball.moveY(ballSpeedY);

        leftPaddle.move(leftPaddleSpeed);
        rightPaddle.move(rightPaddleSpeed);
    }

    // Returns a boolean for each collision check, ensuring the ball is within bounds
    private boolean checkPaddleCollision() {
        int ballX = ball.getPosition().getX();
        int ballY = ball.getPosition().getY();
        int ballDiameter = ball.getDiameter();

        int leftPaddleX = leftPaddle.getPosition().getX();
        int leftPaddleY = leftPaddle.getPosition().getY();
        int leftPaddleWidth = leftPaddle.getPaddleWidth();
        int leftPaddleHeight = leftPaddle.getPaddleHeight();

        int rightPaddleX = rightPaddle.getPosition().getX();
        int rightPaddleY = rightPaddle.getPosition().getY();
        int rightPaddleWidth = rightPaddle.getPaddleWidth();
        int rightPaddleHeight = rightPaddle.getPaddleHeight();

        return (ballX <= leftPaddleX + leftPaddleWidth && ballX + ballDiameter >= leftPaddleX &&
                ballY <= leftPaddleY + leftPaddleHeight && ballY + ballDiameter >= leftPaddleY) ||
               (ballX <= rightPaddleX + rightPaddleWidth && ballX + ballDiameter >= rightPaddleX &&
                ballY <= rightPaddleY + rightPaddleHeight && ballY + ballDiameter >= rightPaddleY);
    }
    private boolean checkVerticalCollision() {
        int ballY = ball.getPosition().getY();
        int ballDiameter = ball.getDiameter();
        return ballY <= 0 || ballY + ballDiameter >= Display.getFrameHeight();
    }
    private boolean checkHorizontalCollision() {
        int ballX = ball.getPosition().getX();
        int ballDiameter = ball.getDiameter();
        return ballX <= 0 || ballX + ballDiameter >= Display.getFrameWidth();
    }

    // Setters for the paddle speeds
    public void setLeftPaddleSpeed(int speed) {
        leftPaddleSpeed = speed;
    }
    public void setRightPaddleSpeed(int speed) {
        rightPaddleSpeed = speed;
    }

    // Internal method to reset the position of the ball and paddles
    // Doesn't reset the left paddle if it is singleplayer
    private void reset() {
        if (ball.getPosition().getX() <= 0) { Game.incrementRightScore(); } 
        else { Game.incrementLeftScore(); }
        
        ball.setPosition(Display.getBallDefault());
        ballSpeedX = 10;
        ballSpeedY = 10;

        if (!Menu.isSinglePlayer()) leftPaddle.setPosition(Display.getLeftPaddleDefault());
        rightPaddle.setPosition(Display.getRightPaddleDefault());

        if (Game.getLeftScore() > 10 || Game.getRightScore() > 10) { Display.reset(); }
    }
}
