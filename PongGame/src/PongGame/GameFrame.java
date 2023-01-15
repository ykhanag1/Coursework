package PongGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JFrame;


public class GameFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	AI ai;
	Paddle human;
	Ball ball;
	GamePanel panel;
	

	
	GameFrame(){
		//panel = new GamePanel(ball, ai, human);
		
		ball = new Ball(50, 50, 10, 25);
		ai = new AI(1350, 1250, 150, 50, ball);
		human = new Paddle(50, 20, 20, 50, 1, ball);
		panel = new GamePanel(ai, human, ball);
		this.add(panel);
		this.setTitle("Pong!!!"); 
		this.setResizable(false); 
		//panel.setBackground(Color.white); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); 
		this.pack();
		this.setLocationRelativeTo(null); 
		
	}
	public void GamePanel(Ball ball, AI ai, Paddle human) {
		  this.ball = ball;
		  ai.move();
		  ball.move(ai, human); 
		  this.ai = ai;
		  this.human = human;
		  
		   
		}

}
