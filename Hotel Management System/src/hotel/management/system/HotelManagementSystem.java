package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class HotelManagementSystem extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	HotelManagementSystem() {
		setBounds(100,150,1366,565); //setBounds(300,300,400,400); = setSize(400,400); + setLocation(300,300);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(0,0,1368,568);
		add(l1);
		
		JLabel l2 = new JLabel("Hotel Management System");
		l2.setBounds(20,450,1000,70);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("serif",Font.PLAIN,50));
		l1.add(l2);
		
		JButton b1 = new JButton("NEXT");
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("serif",Font.BOLD,20));
		b1.setBounds(930,460,150,40);
		b1.addActionListener(this);
		l1.add(b1);
		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		while(true) {
			l2.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
			
			l2.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		new Login().setVisible(true);
		this.setVisible(false);
	}

	public static void main(String[] args) {
		new HotelManagementSystem();
	}

}
