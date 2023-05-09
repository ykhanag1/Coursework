package PongGame;

import java.awt.*;
//import java.awt.event.*;
import java.util.*;
//import javax.swing.*;

public class Ball extends Rectangle{

	private static final long serialVersionUID = 1L;
	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2; 
	static final int GAME_WIDTH = 1400;
	static final int GAME_HEIGHT = 600;
	
	//
	Ball(int x, int y, int width, int height){
		super(x, y, width, height);
		random = new Random();
	    int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0)
			randomXDirection --;
		setXDirection(randomXDirection * initialSpeed); 
		
		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0)
			randomYDirection --;
		setYDirection(randomYDirection * initialSpeed);
		
	}
	
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
		
	}
	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}
	public void move(Paddle human, Paddle ai) {
		// Update the ball's position
	    x += xVelocity;
	    y += yVelocity;

	    // Check if the ball collides with the left or right wall
	    if (x + width >= GAME_WIDTH || x <= 0) {
	        // Reverse the x velocity of the ball
	        xVelocity *= -1;
	    }

	    // Check if the ball collides with the top or bottom wall
	    if (y + height >= GAME_HEIGHT || y <= 0) {
	        // Reverse the y velocity of the ball
	        yVelocity *= -1;
	    }

	    // Check if the ball collides with the human paddle
	    if (x + width >= human.getX() && y + height >= human.getY() && y <= human.getY() + human.getHeight()) {
	        // Reverse the x velocity of the ball
	        xVelocity *= -1;
	        // Calculate the new y velocity based on the angle at which the ball hits the paddle
	        double deltaY = y - (human.getY() + human.getHeight() / 2);
	        yVelocity = (int) (deltaY * 0.35);
	    }

	    // Check if the ball collides with the AI paddle
	    if (x <= ai.getX() + ai.getWidth() && y + height >= ai.getY() && y <= ai.getY() + ai.getHeight()) {
	        // Reverse the x velocity of the ball if it moving towards the AI Paddle
	    	if (xVelocity > 0) {
	    		xVelocity *= -1;
	    		}
	        // Calculate the new y velocity based on the angle at which the ball hits the paddle
	        double deltaY = y - (ai.getY() + ai.getHeight() / 2);
	        yVelocity = (int) (deltaY * 0.35);
	    }
		
	   
	    }
	    
	
	void update() {
		 x += xVelocity;
	     y += yVelocity; 
		
	}
	public void collision(Paddle paddle) {
	    // Check if the ball is colliding with the paddle
	    if (x > paddle.x && x < paddle.x + paddle.width && y > paddle.y && y < paddle.y + paddle.height) {
	        // Calculate the new dx and dy values based on the position of the ball relative to the paddle
	        xVelocity = -xVelocity;
	        yVelocity = (int) ((y - (paddle.y + paddle.height / 2)) * 0.35);
	    }
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x, y, height, width); 
	}

	
	

}
