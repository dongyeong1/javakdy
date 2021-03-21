package javagit3;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.security.auth.x500.X500Principal;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.Button23;

public class TicTacToc implements ActionListener {

private Random random=new Random();
private JFrame frame=new JFrame();	
private JPanel titlePanel=new JPanel();
private JPanel buttonPanel=new JPanel();
private JLabel titleLabel=new JLabel();
JButton[] buttons = new JButton[9];
boolean p1Turn=false; //true이면p1의순서->x의순서
JButton button2= new JButton("restart"); 

public static void main(String[] args) {
	new TicTacToc();
}

public TicTacToc() {
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(800,800);
	
	titleLabel.setBackground(new Color(25,25,25));
	titleLabel.setForeground(new Color(25,255,0));//글자색
	titleLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,75));
	titleLabel.setHorizontalAlignment(JLabel.CENTER);
	titleLabel.setText("tic-tac-toe");
	titleLabel.setOpaque(true);//불투명으로해야 배경색이보임
	
	titlePanel.add(titleLabel);
	
	buttonPanel.setLayout(new GridLayout(3,3));
	buttonPanel.setBackground(new Color(150,150,150));
	for(int i =0; i<9; i++) {
		buttons[i]=new JButton();
		buttons[i].setOpaque(true);
		buttons[i].setFocusable(false);
		buttons[i].setFont(new Font(Font.SANS_SERIF,Font.BOLD,120));
		buttons[i].addActionListener(this);
		buttons[i].setBackground(Color.DARK_GRAY);
		buttonPanel.add(buttons[i]);
	}
	frame.add(titleLabel,BorderLayout.NORTH);
	frame.add(buttonPanel,BorderLayout.CENTER);
	frame.add(button2,BorderLayout.SOUTH);
	
	button2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			titleLabel.setText("tic-tac-toe");
			for(int i=0; i<buttons.length; i++) {
				buttons[i].setText("");
				buttons[i].setEnabled(true);
				buttons[i].setBackground(Color.DARK_GRAY);
				
			}
			
			
			
			
			firstTurn1();
		}
	});
	
	frame.setVisible(true);
	
	firstTurn();
}

private void firstTurn1() {
	if(random.nextInt(2)==0) {
		p1Turn=true;
		titleLabel.setText("x turn");
	}else {
		p1Turn=false;
		titleLabel.setText("o turn");
	}
}

private void firstTurn() {
	
	try {
		Thread.sleep(3000);//2초뒤에 밑에것 실행
	} catch (Exception e) {
		
	}
	
	if(random.nextInt(2)==0) {
		p1Turn=true;
		titleLabel.setText("x turn");
	}else {
		p1Turn=false;
		titleLabel.setText("o turn");
	}
}
@Override
public void actionPerformed(ActionEvent e) {
for (int i=0; i<buttons.length; i++) {
	if(e.getSource()==buttons[i]) {
		if(buttons[i].getText().equals("")) {
			if(p1Turn) {
				buttons[i].setForeground(Color.red);
				buttons[i].setText("x");
				p1Turn=false;
				titleLabel.setText("o turn");
			}else {
				buttons[i].setForeground(Color.black);
				buttons[i].setText("o");
				p1Turn=true;
				titleLabel.setText("x turn");
			}
			check();
		}
		System.out.println(i+"index");
	}
}
	
}
private void check() {
	while(true) {
	for(int i=0; i<3; i++) {
		if(buttons[i].getText().equals("")||buttons[i].getText().equals("o")) {
		}else if(buttons[i].getText()==buttons[i+3].getText()&&buttons[i].getText()==buttons[i+6].getText()){
			xwins(i, i+3, i+6);
			break;
		}
	}
	for(int i=0; i<7; i+=3) {
		if(buttons[i].getText().equals("")||buttons[i].getText().equals("o")) {
			
		}else if(buttons[i].getText()==buttons[i+1].getText()&&buttons[i].getText()==buttons[i+2].getText()) {
			xwins(i, i+1, i+2);
			break;
		}
	}
	for(int i =0; i<9; i++) {
		if(buttons[i].getText().equals("")||buttons[i].getText().equals("o")) {
			
		}else if(buttons[i].getText()==buttons[i+4].getText()&&buttons[i].getText()==buttons[i+8].getText()) {
			xwins(i, i+4, i+8);
			break;
		}
	}
	for(int i=2; i<7; i++ ) {
		if(buttons[i].getText().equals("")||buttons[i].getText().equals("o")) {
			
		}else if(buttons[i].getText()==buttons[i+2].getText()&&buttons[i].getText()==buttons[i+4].getText()) {
			xwins(i, i+2, i+4);
			break;
		}
		
	}
	
	
	for(int i=0; i<3; i++) {
		if(buttons[i].getText().equals("")||buttons[i].getText().equals("x")) {
		}else if(buttons[i].getText()==buttons[i+3].getText()&&buttons[i].getText()==buttons[i+6].getText()){
			ywins(i, i+3, i+6);
			break;
		}
	}
	for(int i=0; i<7; i+=3) {
		if(buttons[i].getText().equals("")||buttons[i].getText().equals("x")) {
			
		}else if(buttons[i].getText()==buttons[i+1].getText()&&buttons[i].getText()==buttons[i+2].getText()) {
			ywins(i, i+1, i+2);
			break;
		}
	}
	for(int i =0; i<9; i++) {
		if(buttons[i].getText().equals("")||buttons[i].getText().equals("x")) {
			
		}else if(buttons[i].getText()==buttons[i+4].getText()&&buttons[i].getText()==buttons[i+8].getText()) {
			ywins(i, i+4, i+8);
			break;
		}
	}
	for(int i=2; i<7; i++ ) {
		if(buttons[i].getText().equals("")||buttons[i].getText().equals("x")) {
			
		}else if(buttons[i].getText()==buttons[i+2].getText()&&buttons[i].getText()==buttons[i+4].getText()) {
			ywins(i, i+2, i+4);
			break;
		}
		
	}
	break;
	}
	
	
	
	
	
	
	
//	ywins(0,4,8);
}

private void xwins(int a,int b,int c) {
	buttons[a].setBackground(Color.green);
	buttons[b].setBackground(Color.green);
	buttons[c].setBackground(Color.green);
	
	for(int i=0; i<buttons.length; i++) {
		buttons[i].setEnabled(false);
	}
	titleLabel.setText("x wins!!");
}
private void ywins(int a,int b,int c) {
	buttons[a].setBackground(Color.green);
	buttons[b].setBackground(Color.green);
	buttons[c].setBackground(Color.green);
	for(int i=0; i<buttons.length; i++) {
		buttons[i].setEnabled(false);
	}
	titleLabel.setText("o wins!!");
}
}
