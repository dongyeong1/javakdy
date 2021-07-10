package javagit3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements KeyListener{
	
	Ball ball;
	GameBoard board;
	Raquet raquet1;
	Raquet raquet2;
	JLabel leftnumber;
	JLabel rightnumber;
	int count1;
	int count2;
	
	public GameBoard() {
		
		setLayout(null);
		this.setBackground(Color.black);
		setFocusable(true);
		addKeyListener(this);
		ball=new Ball(this, Color.white);
		count1=0;
		count2=0;
		
		raquet1=new Raquet(this, 10	, 150, Color.blue);
		raquet2=new Raquet(this, 550, 150, Color.red);
		leftnumber =new JLabel(count1+"");
		rightnumber= new JLabel(count2+"");
		leftnumber.setForeground(Color.white);
		leftnumber.setFont(leftnumber.getFont().deriveFont(60.0f));
		rightnumber.setFont(rightnumber.getFont().deriveFont(60.0f));
		rightnumber.setForeground(Color.white);
		leftnumber.setBounds(250, 0, 100, 100);
		rightnumber.setBounds(318,0,100,100);
		add(rightnumber);
		add(leftnumber);
		
		
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		raquet1.keyPressed(e);
		raquet2.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		raquet1.keyReleased(e);
		raquet2.keyReleased(e);
	}
	
	public void move() {
		ball.move();
		raquet1.move();
		raquet2.move();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		
		ball.draw(g2d);
		raquet1.draw(g2d);
		raquet2.draw(g2d);
		g.setColor(Color.white);
		g.drawLine(300, 0, 300, 400);
		
	}
	
	public static void main(String[] args) {
		JFrame frame =new JFrame("pingpong °ÔÀÓ");
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameBoard game= new GameBoard();
		
		frame.add(game);
		frame.setVisible(true);
		while(true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

	}

}

class Ball{
	private static final int RADIUS =10;
	int x=0;
	int y=0;
	int xspeed =1;
	int yspeed =1;
	private GameBoard game;
	Color color;
	
	public Ball (GameBoard game, Color color) {
		this.game=game;
		this.color=color;
	}
	
	public void move() {
		if(x+xspeed==0) {
			game.count2++;
			game.rightnumber.setText(game.count2+"");
			if(game.count2==5) {
				JOptionPane.showMessageDialog(null,"2p½Â¸®");
				try {
					Thread.sleep(9999999);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		if(x+xspeed==game.getWidth()-2*RADIUS) {
			game.count1++;
			game.leftnumber.setText(game.count1+"");
			if(game.count1==5) {
				JOptionPane.showMessageDialog(null,"1p½Â¸®");
				try {
					Thread.sleep(9999999);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		if(x+xspeed<0) {
			xspeed=1;
			
		}
		if(x+xspeed>game.getWidth() -2*RADIUS) {
			xspeed=-1;
			
		}
		if(y+yspeed<0) {
			yspeed=1;
		}
		if(y+yspeed > game.getHeight()-2*RADIUS) {
			yspeed=-1;
		}
		if(collisionL()) {
			if(xspeed<0) {
				xspeed=Math.abs(xspeed);
			}
			
		}
		if(collisionR()) {
			if(xspeed>0) {
				xspeed=-Math.abs(xspeed);
			}
		}
		x=x+xspeed;
		y=y+yspeed;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval(x, y, 2*RADIUS, 2*RADIUS);
	}
	public Rectangle getbounds() {
		return new Rectangle(x,y,2*RADIUS,2*RADIUS);
	}
	
	public boolean collisionL() {
		return game.raquet1.getbounds().intersects(getbounds());
				
	}
	public boolean collisionR() {
		return game.raquet2.getbounds().intersects(getbounds());
	}
	
	
}

class Raquet{
	private static final int WIDTH =10;
	private static final int HEIGHT = 80;
	 int x=0;
	 int y=0;
	Color color;
	int xspeed =0;
	int yspeed =0;
	private GameBoard game;
	
	public Raquet(GameBoard game, int x, int y, Color color ) {
		this.game=game;
		this.x=x;
		this.y=y;
		this.color=color;
	
	}
	
	public void move() {
		if((y+yspeed>0)&& (y+yspeed<game.getHeight() -HEIGHT)) {
			y=y+yspeed;
		}
		
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void keyPressed(KeyEvent e) {
		if(x>100) {
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				yspeed=-2;
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				yspeed=2;
			}
		}
		if(x<100) {
			if(e.getKeyCode()==KeyEvent.VK_W) {
				yspeed=-2;
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				yspeed=2;
			}
		}
	}
	
	public void  keyReleased(KeyEvent e) {
		yspeed=0;
	}
	
	public Rectangle getbounds() {
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
}
