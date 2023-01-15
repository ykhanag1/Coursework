package PongGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
	
	
	private static final long serialVersionUID = 1L;
	static int GAME_WIDTH = 1400; 
	static  int GAME_HEIGHT = 800;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 80;
	 public static final int PADDLE_X_OFFSET = 50;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score score;
	AI ai; 
	Paddle human;
	
	
	public GamePanel(AI ai, Paddle human, Ball ball) { 
		newPaddles();
		newBall();
		this.human = human;
		this.ball = ball;
		this.ai = ai;
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true); 
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		paddle1 = new Paddle(PADDLE_X_OFFSET, GAME_HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, 1, ball);
        ai = new AI(GAME_WIDTH - PADDLE_X_OFFSET - PADDLE_WIDTH, GAME_HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, ball);
        //paddle2 = new Paddle(GAME_WIDTH - PADDLE_X_OFFSET - PADDLE_WIDTH, GAME_HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, 2, ball);
		
		gameThread = new Thread(this); 
		gameThread.start();
		
		
	}
	
	public void newBall() {
		//random = new Random();
		ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2) ,
				(GAME_HEIGHT / 2 ) - (BALL_DIAMETER / 2), 
				BALL_DIAMETER, BALL_DIAMETER);
		
	}
	public void newPaddles() {
		paddle1 = new Paddle(0, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1, ball);
		paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2, ball);
	}
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0 ,0 ,this);
		//update(g);  
	}
	public void draw(Graphics g) {
		// Draw the ball
		ball.draw(g);
		
		// Cast this to an AI object and call the move method on the AI object
        if (paddle2 instanceof AI) {
            AI ai = (AI) paddle2;
            ai.move();
        }
  
		
		super.paint(g);
        score.draw(g);
        ball.draw(g);
        paddle1.draw(g);
        if (paddle2.id == 2) {
            ai.draw(g);
        } else {
            paddle2.draw(g);
        }
		
	}
	public void move(Paddle human, Paddle ai) {
		ball.move(human, ai);
	    human.move();
	    ai.move();
		

	}
	public void checkCollision() {
		
		// Check if the ball collides with the left or right wall
	    if (ball.x + ball.width >= GAME_WIDTH || ball.x <= 0) {
	        // Reverse the x velocity of the ball
	        ball.xVelocity *= -1;
	    }

	    // Check if the ball collides with the top or bottom wall
	    if (ball.y + ball.height >= GAME_HEIGHT || ball.y <= 0) {
	        // Reverse the y velocity of the ball
	        ball.yVelocity *= -1;
	    }

	    // Check if the ball collides with the human paddle
	    if (ball.x + ball.width >= paddle1.getX() && ball.y + ball.height >= paddle1.getY() && ball.y <= paddle1.getY() + paddle1.getHeight()) {
	        // Reverse the x velocity of the ball
	        ball.xVelocity *= -1;
	        // Calculate the new y velocity based on the angle at which the ball hits the paddle
	        double deltaY = ball.y - (paddle1.getY() + paddle1.getHeight() / 2);
	        ball.yVelocity = (int) (deltaY * 0.35);
	    }

	    // Check if the ball collides with the AI paddle
	    if (ball.x <= paddle2.getX() + paddle2.getWidth() && ball.y + ball.height >= paddle2.getY() && ball.y <= paddle2.getY() + paddle2.getHeight()) {
	        // Reverse the x velocity of the ball if it is moving towards the AI paddle
	        if (ball.xVelocity > 0) {
	            ball.xVelocity *= -1;
	        }
	     // Calculate the new y velocity based on the angle at which the ball hits the paddle
	     double deltaY = ball.y - (paddle2.getY() + paddle2.getHeight() / 2);
	     ball.yVelocity = (int) (deltaY * 0.35);
	     }
	     }
		
	
	public void run() {
		//Game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			
			if(delta >= 1) {
				move(human, ai);
				checkCollision();
				repaint();
				delta--;
				
			}
		}
		
	}
	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
		
	}
	
	
	

}
