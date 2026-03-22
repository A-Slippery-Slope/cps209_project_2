public class Physics {
    private Paddle leftPaddle, rightPaddle;
    private Ball ball;
    private int ballSpeedX, ballSpeedY, leftPaddleSpeed, rightPaddleSpeed;
    
    public Physics(Paddle leftPaddle, Paddle rightPaddle, Ball ball) {
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
        this.ball = ball;

        ballSpeedX = 10;
        ballSpeedY = 10;
        leftPaddleSpeed = 0;
        rightPaddleSpeed = 0;
    }

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

    public void setLeftPaddleSpeed(int speed) {
        leftPaddleSpeed = speed;
    }
    public void setRightPaddleSpeed(int speed) {
        rightPaddleSpeed = speed;
    }

    private void reset() {
        ball.setPosition(Display.getBallDefault());
        ballSpeedX = 10;
        ballSpeedY = 10;

        leftPaddle.setPosition(Display.getLeftPaddleDefault());
        rightPaddle.setPosition(Display.getRightPaddleDefault());
    }
}
