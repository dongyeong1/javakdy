package dongproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class slotFrame extends JFrame implements ActionListener{
	SlotLabel slotLabel;
	SlotLabel2 slotLabel2;
	SlotLabel3 slotLabel3;
	JLabel slotlabel;
	JPanel panelleft;
	JPanel panelright;
	JPanel panel;
	JPanel imgPanel;
	JPanel csPanel;
	JPanel centerPanel;
	JPanel btnPanel;
	JPanel moneyPanel;
	JTextField field;
	JButton moneybtn;
	JButton talkbtn;
	JButton moneyquetionbtn;
	JButton startbtn1;	
	JButton stopbtn1;	
	JButton resetbtn;
	
	
	JTextField ikurafield;
	
	
	Integer su=0;
	Integer su1=0;
	String x2="";
	String x1="";
	String x3="";
	
	int battingmoney=0;
	int count=0;
	
	Thread ex;
	Thread ex1;
	Thread ex2;
	
	
	
	
	
	public slotFrame() {
		slotLabel=new SlotLabel();
		slotLabel2=new SlotLabel2();
		slotLabel3=new SlotLabel3();
		setSize(700,700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		ex=new Thread(slotLabel,"������");
		ex1=new Thread(slotLabel2,"������");
		ex2=new Thread(slotLabel3,"������");
		
		
		//panel
		panel=new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.black);
		panelleft=new JPanel();
		panelright=new JPanel();
		panelleft.setBackground(Color.blue);
		panelright.setBackground(Color.blue);
		//slotlabel
		slotlabel=new JLabel("Slot machine");
		slotlabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,50));
		slotlabel.setBackground(Color.red);
		slotlabel.setOpaque(true);
		slotlabel.setHorizontalAlignment(JLabel.CENTER);//�߾�����
		//center panel->moneypanel
		moneyPanel=new JPanel();
		moneyPanel.setBackground(Color.black);
		field =new JTextField("1000��",15);
		moneybtn = new JButton("�����ϱ�");
		moneybtn.setPreferredSize(new Dimension(200, 24));
		moneyPanel.add(moneybtn);
		moneyPanel.add(field);
		moneybtn.addActionListener(e->new information());
		//center panel-> imgpanel
		imgPanel=new JPanel();
		imgPanel.setLayout(new GridLayout(0,3));
		imgPanel.add(slotLabel);
		imgPanel.add(slotLabel2);
		imgPanel.add(slotLabel3);
		imgPanel.setBackground(Color.black);
		
		
		
		//center panel->cspanel
		csPanel=new JPanel();
		csPanel.setBackground(Color.black);
		talkbtn=new JButton("��뼳��");
		moneyquetionbtn=new JButton("���ñݾ�");
		resetbtn=new JButton("reset");
		resetbtn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		
		talkbtn.addActionListener(e->new talk());
		moneyquetionbtn.addActionListener(e->new information2());

		resetbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==resetbtn) {
				slotLabel.setIcon(null);
				slotLabel2.setIcon(null);
				slotLabel3.setIcon(null);
				ex=new Thread(slotLabel,"������");
				ex1=new Thread(slotLabel2,"������");
				ex2=new Thread(slotLabel3,"������");

				ex.start();
				ex1.start();
				ex2.start();
		
			
				}
			}
		});
		csPanel.add(talkbtn);
		csPanel.add(moneyquetionbtn);
		
		
		
		//centerpanel
		centerPanel=new JPanel();
		centerPanel.setBackground(Color.black);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(moneyPanel,BorderLayout.NORTH);
		centerPanel.add(imgPanel,BorderLayout.CENTER);
		centerPanel.add(csPanel,BorderLayout.SOUTH);
		
		//btnpanel
		btnPanel=new JPanel();
		btnPanel.setLayout(new GridLayout(0,3));
		startbtn1=new JButton("start");
		startbtn1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		stopbtn1=new JButton("stop");
		stopbtn1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		
		
		startbtn1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
					ex.start();
					ex2.start();
					ex1.start();				
			}
		});
			
		stopbtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ex.interrupt();
				ex1.interrupt();
				ex2.interrupt();
				
					if(slotLabel.x==slotLabel2.x&&slotLabel.x==slotLabel3.x) {
						if(slotLabel.x==1) {
							JOptionPane.showMessageDialog(null,"777����!! 100���÷");
							String q1=field.getText();
							String q2=q1.substring(0, q1.length()-1);
							int w =Integer.valueOf(q2);
							String v3=(battingmoney*100+w)+"��";
							field.setText(v3);
							
						}else {
							JOptionPane.showMessageDialog(null,"����!! 10���÷");
							String e1=field.getText();
							String e2=e1.substring(0, e1.length()-1);
							int k=Integer.valueOf(e2);
							String b3=(battingmoney*10+k)+"��";
							field.setText(b3);
						}
					}else if(slotLabel.x==slotLabel2.x||slotLabel.x==slotLabel3.x||slotLabel2.x==slotLabel3.x) {
						JOptionPane.showMessageDialog(null,"�ƽ��� 3���÷");
						String t1=field.getText();
						String t2=t1.substring(0, t1.length()-1);
						int l =Integer.valueOf(t2);
						String m3=(battingmoney*3+l)+"��";
						field.setText(m3);
			
					}else {
						JOptionPane.showMessageDialog(null,"��");
					}
					battingmoney=0;
				}
			
			
		});
		
		
		
		
		
		btnPanel.add(startbtn1);
		btnPanel.add(stopbtn1);
		btnPanel.add(resetbtn);
		
		btnPanel.setPreferredSize(new Dimension(50	,50));

		
		
		
		
		
		
		
		
		
		add(panel);
		panel.add(slotlabel,BorderLayout.NORTH);
		panel.add(panelleft,BorderLayout.WEST);
		panel.add(panelright,BorderLayout.EAST);
		
		panel.add(centerPanel,BorderLayout.CENTER);
		panel.add(btnPanel,BorderLayout.SOUTH);
		setVisible(true);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	class talk extends JFrame{
		JPanel panel11;
		JButton startbtns;
		public talk(){
			panel11=new JPanel();
			setSize(500,300);
			setLocationRelativeTo(null);
			JLabel talkLabel = new JLabel();
			JLabel talkLabel2 = new JLabel();
			JLabel talkLabel3 = new JLabel();
			JLabel talkLabel4 = new JLabel();
			JLabel talkLabel5 = new JLabel();
			talkLabel.setText("1.�����ݾ��� �����ϸ� �����ݾ��� ������ ���ϴ� �ݾ��� �����մϴ�");
			talkLabel2.setText("2.���ñݾ��� �����մϴ� ");	
			talkLabel3.setText("-�׸�2����ġ:3�� -�׸�3����ġ:10�� -777:100��");
			talkLabel4.setText("3.start��ư�� ���� �귿�� ���ư��� stop��ư������");
			talkLabel5.setText("4.�ѹ����ϰ������ ���ñݾ״ٽ� ������ reset��ư ������");
			startbtns=new JButton("���о����ϴ�");
			
			startbtns.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					dispose();
				}
			});
			panel11.add(talkLabel);
			panel11.add(talkLabel2);
			panel11.add(talkLabel3);
			panel11.add(talkLabel4);
			panel11.add(talkLabel5);
			this.add(panel11,BorderLayout.CENTER);
			
			this.add(startbtns,BorderLayout.SOUTH);
			setVisible(true);
		}
	}
	
	
	
	
	class information2 extends JFrame{
		JLabel ikuralabel1;
		JTextField ikurafield1;
		JButton ikurabtn1;
		
		
		public information2() {
			setSize(300,200);
			setLocationRelativeTo(null);
			ikuralabel1=new JLabel("�� �����ҷ���?");
			ikuralabel1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
			ikuralabel1.setHorizontalAlignment(JLabel.CENTER);
			
			ikurafield1 = new JTextField(20);
			
			ikurabtn1 = new JButton("�����ϱ�");
			
			ikurabtn1.addActionListener(e->{
				ss2();
				dispose();
			});
			
			add(ikuralabel1,BorderLayout.NORTH);
			add(ikurafield1,BorderLayout.CENTER);
			add(ikurabtn1,BorderLayout.SOUTH);
			setVisible(true);
	}
		public void ss2() {
			String y1=field.getText();
			String y2=y1.substring(0, y1.length()-1);
			int s =Integer.valueOf(y2);M
			int s1=Integer.valueOf(ikurafield1.getText());
			String y3=(s-s1)+"��";
			if(s<s1) {
				JOptionPane.showMessageDialog(null,"�ݾ��̺����մϴ�");
			}else {
				field.setText(y3);
				battingmoney=s1;
			}
		}
	}
	
	class information extends JFrame{
		JLabel ikuralabel;
		
		JButton ikurabtn;
		
		
		public information() {
			setSize(300,200);
			setLocationRelativeTo(null);
			ikuralabel=new JLabel("�� �����ҷ���?");
			ikuralabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
			ikuralabel.setHorizontalAlignment(JLabel.CENTER);
			
			ikurafield = new JTextField("",20);
			
			ikurabtn = new JButton("�����ϱ�");
			
			ikurabtn.addActionListener(e->{
				ss();
				dispose();
			});
			
			add(ikuralabel,BorderLayout.NORTH);
			add(ikurafield,BorderLayout.CENTER);
			add(ikurabtn,BorderLayout.SOUTH);
			setVisible(true);
		}
		
		
	}
	public void ss() {
		
		x2 =field.getText();
		x3=ikurafield.getText();
		String x4=x2.substring(0, x2.length()-1);
		su=Integer.parseInt(x4);
		su1=Integer.parseInt(x3);
		String x5=su+su1+"��";
		field.setText(x5);
	}
	
}

public class FinalSlot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new slotFrame();
	}

}
