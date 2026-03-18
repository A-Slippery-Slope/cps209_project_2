public class Physics {
    private Paddle leftPaddle, rightPaddle;
    private Ball ball;
    private int ballSpeedX = 5, ballSpeedY = 5, paddleSpeed = 5;
    
    public Physics(Paddle leftPaddle, Paddle rightPaddle, Ball ball) {
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
        this.ball = ball;
    }

    public void update() {
        if (checkPaddleCollision()) {
            ballSpeedX = -ballSpeedX;
            ballSpeedY = -ballSpeedY;
        }
        if (checkVerticalCollision()) { ballSpeedY = -ballSpeedY; }
        if (checkHorizontalCollision()) {

        }

        ball.moveX(ballSpeedX);
        ball.moveY(ballSpeedY);
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

        return (ballX < leftPaddleX + leftPaddleWidth && ballX + ballDiameter > leftPaddleX &&
                ballY < leftPaddleY + leftPaddleHeight && ballY + ballDiameter > leftPaddleY) ||
               (ballX < rightPaddleX + rightPaddleWidth && ballX + ballDiameter > rightPaddleX &&
                ballY < rightPaddleY + rightPaddleHeight && ballY + ballDiameter > rightPaddleY);
    }
    private boolean checkVerticalCollision() {
        int ballY = ball.getPosition().getY();
        int ballDiameter = ball.getDiameter();
        return ballY <= 0 || ballY + ballDiameter >= Display.HEIGHT;
    }
    private boolean checkHorizontalCollision() {
        int ballX = ball.getPosition().getX();
        int ballDiameter = ball.getDiameter();
        return ballX <= 0 || ballX + ballDiameter >= Display.WIDTH;
    }
}
