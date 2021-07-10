package dongproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotLabel extends JLabel implements Runnable {
	ImageIcon img;
	Image img1;
	Image imgchange;
	ImageIcon seven;
	
	ImageIcon img2;
	Image img12;
	Image imgchange2;
	ImageIcon subak;
	
	ImageIcon img3;
	Image img13;
	Image imgchange3;
	ImageIcon lemon;
	
	ImageIcon img4;
	Image img14;
	Image imgchange4;
	ImageIcon cherry; 
	
	ImageIcon img5;
	Image img15;
	Image imgchange5;
	ImageIcon orange;
	
	ImageIcon img6;
	Image img16;
	Image imgchange6;
	ImageIcon banana;
	ImageIcon xxIcon;
	int x=0;
//	slotFrame sFrame;
	 public SlotLabel() {
//		sFrame=new slotFrame();
		 img =new ImageIcon(getClass().getClassLoader().getResource("슬롯머신7.png"));
//		 img =new ImageIcon("C:\\Users\\김동영\\Desktop\\슬롯머신7.png");
			img1=img.getImage();
			imgchange=img1.getScaledInstance(250, 330, Image.SCALE_SMOOTH);
			img2 =new ImageIcon(getClass().getClassLoader().getResource("수박.png"));
			img12=img2.getImage();
			imgchange2=img12.getScaledInstance(250,330, Image.SCALE_SMOOTH);
			img3 =new ImageIcon(getClass().getClassLoader().getResource("레몬.png"));
			img13=img3.getImage();
			imgchange3=img13.getScaledInstance(250, 330, Image.SCALE_SMOOTH);
			img4 =new ImageIcon(getClass().getClassLoader().getResource("체리.png"));
			img14=img4.getImage();
			imgchange4=img14.getScaledInstance(250, 330, Image.SCALE_SMOOTH);
			img5 =new ImageIcon(getClass().getClassLoader().getResource("오렌지.png"));
			img15=img5.getImage();
			imgchange5=img15.getScaledInstance(250, 330, Image.SCALE_SMOOTH);
			img6 =new ImageIcon(getClass().getClassLoader().getResource("바나나.png"));
			img16=img6.getImage();
			imgchange6=img16.getScaledInstance(250, 330, Image.SCALE_SMOOTH);
			seven=new ImageIcon(imgchange);
			subak=new ImageIcon(imgchange2);
			lemon=new ImageIcon(imgchange3);
			cherry=new ImageIcon(imgchange4);
			orange=new ImageIcon(imgchange5);
			banana=new ImageIcon(imgchange6);
			
	}
	
	@Override
	public void run() {
		try {
			while(true) {
			Random random=new Random();
			x=random.nextInt(6)+1;
			if(x==1) {
				this.setIcon(seven);
			}else if(x==2) {
				setIcon(subak);
			}else if(x==3) {
				setIcon(lemon);
			}else if(x==4) {
				setIcon(cherry);
			}else if(x==5) {
				setIcon(orange);
			}else if(x==6) {
				setIcon(banana);
			}
			Thread.sleep(10);
			}
		}catch (Exception e) {
			
		}
		

	
		
		
		
	}

	


}
