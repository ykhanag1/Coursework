


/*public class AI extends Paddle {
   
	private static final long serialVersionUID = 1L;
	private static final int GAME_HEIGHT = 800; 
	private static final int GAME_WIDTH = 1200; 
	static final int PADDLE_HEIGHT = 80;
	public Ball ball;
	public AI ai;
   //private int x, y, width, height;
    private int speed = 5;
    int id;

    public AI(int x, int y, int width, int height, int id, Ball ball) { 
        super(x, y, width, height, 3, ball);  
        this.x = x; 
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
        this.ball = ball;
    }
    

    @Override
    public void move() {
    	
    	if (ball.y < y) {
        	setYDirection(-speed);
            super.move();
        } else if (ball.y > y + height) {
        	 // Move down
            setYDirection(speed); 
            super.move();
        } else {
        	// Don't move
            setYDirection(0);
        }
        y = y + yVelocity;
    	
    	
    	
    	
    	
    	if (getY() + PADDLE_HEIGHT / 2 < ball.getY()) {
            setYDirection(speed);
        } else {
            setYDirection(-speed);
        }
    	
    	
    	
    	
    	
    	
    	
    	
    	  
    	  
    	 
    	int ballY = (int) ball.getY();
    	int ballHeight = (int) ball.getHeight();
    	int aiY = (int) getY();
    	int aiHeight = (int) getHeight();
        
    	 if (intersects(this)) {
    	        if (ballY + ballHeight / 2 < aiY + aiHeight / 2) {
    	            y -= speed;
    	        } else {
    	            y += speed;
    	        }
    	    }
        
    	 if (y < 0) {
    	        // Set y position to 0 if the paddle is at the top of the screen
    	        y = 0;
    	    } else if (y + height > GAME_HEIGHT) {
    	        // Set y position to the bottom of the screen if the paddle is at the bottom
    	        y = GAME_HEIGHT - height;
    	        y += yVelocity;
    	    }
    	 
    	}
    public void update() {
    	if (ball.getX() < GAME_WIDTH / 2) {
    	      int y = (int) (Math.random() * (GAME_HEIGHT - PADDLE_HEIGHT));
    	      //setYDirection(y); 
    	      move();
    	    } 
    	     if(y < 0) {
    	    	// Set y position to 0 if the paddle is at the top of the screen
    	            y = 0;
    	     } else if (y + height > GAME_HEIGHT) {
    	    	// Set y position to the bottom of the screen if the paddle is at the bottom
    	            y = GAME_HEIGHT - height;
    	     }
    	
    	
    	else {
    	      if (getY() + PADDLE_HEIGHT / 2 < ball.getY()) {
    	        setYDirection((int) (getY() + 1));
    	        move();
    	      } else {
    	        setYDirection((int) (getY() - 1));
    	        move();
    	      }
    	    }
    }
    
}*/

package PongGame;

public class AI extends Paddle {

	
	
	private static final long serialVersionUID = 1L;
	//private static final int PADDLE_HEIGHT = 0;
	private static final int PADDLE_HEIGHT = 80; 
	Ball ball; 

	public AI(int x, int y, int width, int height, Ball ball) {
		super(x, y, width, height, 2, ball);  
		this.ball = ball; 
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public void move() {
        if (ball.y < y) {
        	setYDirection(-speed);
            super.move();
        } else if (ball.y > y + height) {
        	 // Move down
            setYDirection(speed); 
            super.move();
        } else {
        	// Don't move
            setYDirection(0);
        }
        y = y + yVelocity;
        x = x + xVelocity;
  
    	}
    
	public void update() {
    	if (ball.getX() < GAME_WIDTH / 2) {
    	      int y = (int) (Math.random() * (GAME_HEIGHT - PADDLE_HEIGHT)); 
    	      setYDirection(y); 
    	      super.move();
    	    } 
    	     if(y < 0) {
    	    	// Set y position to 0 if the paddle is at the top of the screen
    	            y = 0;
    	     } else if (y + height > GAME_HEIGHT) {
    	    	// Set y position to the bottom of the screen if the paddle is at the bottom
    	            y = GAME_HEIGHT - height;
    	     }
    	
    	
    	else {
    	      if (getY() + PADDLE_HEIGHT / 2 < ball.getY()) {
    	        setYDirection((int) (getY() + 1));
    	        super.move();
    	      } else {
    	        setYDirection((int) (getY() - 1));
    	        super.move();
    	      }
    	    }
    }

}
