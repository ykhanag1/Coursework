package PongGame;

/*package PongGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {
	
	
	private static final long serialVersionUID = 1L;
	int id;
	int yVelocity;
	int xVelocity;
	int speed = 25;
	Ball ball;
	 
	 static final int GAME_WIDTH = 1400;
	 static final int GAME_HEIGHT = 800;
	
	
	
	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id, Ball ball) { 
		super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		this.id = id;
		this.ball = ball;
		this.x = x;
		this.y = y;
	}
	
	//public Paddle(int x, int y, int width, int height, int id, Ball ball) {
		// TODO Auto-generated constructor stub 
	//}

	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(-speed);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(speed);
				move();
			}
			break;
		
		}
	}
	public void keyReleased(KeyEvent e) {
		
		switch (id) {
        case 1:
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
                setYDirection(0);
            }
            break;
        case 2:
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                setYDirection(0);
            }
            break;
    }
		
		
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(0);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(0);
				move();
			}
			break;
		case 2:	
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(0);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(0);
				move();
			}
			break;
		}
	}
	public void setYDirection(int yVelocity) {
		this.yVelocity = yVelocity; 
	}
	public int getYDirection() {
		return yVelocity;
	}
	public void move() {
		y = y + yVelocity;
		if (y < 0) {
            y = 0;
        } else if (y + height > GAME_HEIGHT) {
            y = GAME_HEIGHT - height;
        }
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
	    g.fillRect(x, y, width, height);
		
		if(id == 1) 
			g.setColor(Color.blue); 
		else 
			g.setColor(Color.red);
		g.fillRect(x, y, width, height);
 		
	}
	
	

}*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {
    
    private static final long serialVersionUID = 1L;
    int id;
    int yVelocity;
    int xVelocity;
    int speed = 15;
    Ball ball;
    static final int GAME_WIDTH = 1200;
    static final int GAME_HEIGHT = 600;
    static final int PADDLE_WIDTH = 30;
    static final int PADDLE_HEIGHT = 100;

    Paddle(int x, int y, int id, Ball ball) { 
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
        this.ball = ball;
        this.x = x;
        this.y = y;
    }

    public void setYDirection(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getYDirection() {
        return yVelocity;
    }

    public void move() {
        if (y + height/2 < ball.y) {
            yVelocity = speed;
        } else if (y + height/2 > ball.y) {
            yVelocity = -speed;
        }
        y = y + yVelocity;

        // Make sure the paddle doesn't go out of bounds
        if (y < 0) {
            y = 0;
        } else if (y + height > GAME_HEIGHT) {
            y = GAME_HEIGHT - height;
        }
    }
    
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(-speed);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(speed);
				move();
			}
			break;
		
		}
	}
	public void keyReleased(KeyEvent e) {
		
		switch (id) {
        case 1:
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
                setYDirection(0);
            }
            break;
        case 2:
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                setYDirection(0);
            }
            break;
		}
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);

        if (id == 1) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.red);
        }
        g.fillRect(x, y, width, height);
    }
}
