package javagit3;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{
		private JTextField textField;
		private JPanel panel;
		private JButton[] numButtons;
		private JButton addButton,suButton,mulButton,divButton,decButton,equButton,delButton,cirButton,negButton;
		private Font myFont= new Font(Font.SANS_SERIF,Font.BOLD,30);
		

	
	private double num1;
	private double num2;
	private double result;
	private String operate;
	
		public Calculator() {
			this.setTitle("ciculator");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(420, 550);
			this.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(50, 25, 300, 50);
			textField.setEditable(false);
			textField.setFont(myFont);
			
			panel =new JPanel();
			panel.setBounds(50, 100, 300, 300);
			panel.setLayout(new GridLayout(4, 4, 10, 10));
			
			numButtons=new JButton[10];
			for(int i=0; i< numButtons.length; i++) {
				numButtons[i]=new JButton(String.valueOf(i));
				numButtons[i].setFont(myFont);
				numButtons[i].setFocusable(false);
				numButtons[i].addActionListener(this);
			}
			
			addButton = new JButton("+");
			addButton.setFocusable(false);
			addButton.addActionListener(this);
			suButton= new JButton("-");
			suButton.setFocusable(false);
			suButton.addActionListener(this);
			mulButton = new JButton("*");
			mulButton.setFocusable(false);
			mulButton.addActionListener(this);
			divButton = new JButton("/");
			divButton.setFocusable(false);
			divButton.addActionListener(this);
			decButton = new JButton(".");
			decButton.setFocusable(false);
			decButton.addActionListener(this);
			equButton = new JButton("=");
			equButton.setFocusable(false);
			equButton.addActionListener(this);
			delButton = new JButton("DELETE");
			delButton.setFocusable(false);
			decButton.addActionListener(this);
			delButton.setBounds(150, 430, 100, 50);
			cirButton = new JButton("clear");
			cirButton.setFocusable(false);
			cirButton.addActionListener(this);
			cirButton.setBounds(250, 430, 100, 50);
			negButton = new JButton("(-)");
			negButton.setFocusable(false);
			negButton.addActionListener(this);
			negButton.setBounds(50, 430, 100, 50);
			
			panel.add(numButtons[1]);
			panel.add(numButtons[2]);
			panel.add(numButtons[3]);
			panel.add(addButton);
			
			panel.add(numButtons[4]);
			panel.add(numButtons[5]);
			panel.add(numButtons[6]);
			panel.add(suButton);
			
			panel.add(numButtons[7]);
			panel.add(numButtons[8]);
			panel.add(numButtons[9]);
			panel.add(mulButton);
			
			panel.add(decButton);
			panel.add(numButtons[0]);
			panel.add(equButton);
			panel.add(divButton);
			
			
			this.add(textField);
			this.add(panel);
			this.add(negButton);
			this.add(cirButton);
			this.add(delButton);
			
			this.setResizable(false);
			this.setLocationRelativeTo(null);//frame이 화면중앙에 나타나도록함
			this.setVisible(true);
		}
		
		
		
		
		
		public static void main(String[] args) {
			JFrame calculatorFrame = new Calculator();
		}





		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i=0; i<numButtons.length; i++) {
				if(e.getSource()==numButtons[i]) {
					System.out.println(i+"버튼이 클릭되었습니다.");
					String str = textField.getText();
					textField.setText(str.concat(String.valueOf(i)));
					break;
				}
			}
			if(e.getSource()==decButton) {
				String str = textField.getText();
				textField.setText(str.concat("."));
				System.out.println("decmal버튼이 클릭됨");
			}else if(e.getSource()==addButton ||e.getSource()==suButton
					||e.getSource()==mulButton ||e.getSource()==divButton) {
				System.out.println(((JButton)(e.getSource())).getText()+"버튼이 클릭됨");
				String str= textField.getText();
				num1= Double.parseDouble(str);
				operate = ((JButton)(e.getSource())).getText();
				textField.setText("");
			}else if(e.getSource() == equButton) {
				System.out.println("= 버튼이 클릭됨");
				String str = textField.getText();
				num2=Double.parseDouble(str);
				switch (operate) {
				case "+":
					result=num1+num2;
					break;
				case "-":
					result=num1-num2;
					break;	
				case "*":
					result=num1*num2;
					break;
				case "/":
					result=num1/num2;
					break;
				default:
					
				}
				textField.setText(String.valueOf(result));
			}else if(e.getSource() ==cirButton) {
				textField.setText("");
				System.out.println("clear버튼 클릭됨");
			}else if(e.getSource()==delButton) {
				String str = textField.getText();
				if(textField.getText().length()>0) {
				textField.setText(str.substring(0,str.length()-1));
				}
				System.out.println("delete버튼클릭댐");
			}else if(e.getSource()==negButton) {
				System.out.println("마이너스 버튼이 클릭됨");
				String str = textField.getText();
				double temp = Double.parseDouble(str);
				temp = temp*-1;
				textField.setText(String.valueOf(temp));
			}
		}
	
}
