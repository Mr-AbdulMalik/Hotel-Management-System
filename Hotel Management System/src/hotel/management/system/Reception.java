package hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Reception implements ActionListener{

	JFrame frame = new JFrame("Reception");
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	
	Reception(){
		JButton b1 = new JButton("NEW CUSTOMER FORM");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(60,30,200,30);
		b1.addActionListener(this);
		frame.add(b1);
		
		JButton b2 = new JButton("ROOM");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(60,70,200,30);
		b2.addActionListener(this);
		frame.add(b2);
		
		JButton b3 = new JButton("DEPARTMENT");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(60,110,200,30);
		b3.addActionListener(this);
		frame.add(b3);
		
		JButton b4 = new JButton("ALL EMPLOYEE INFO");
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setBounds(60,150,200,30);
		b4.addActionListener(this);
		frame.add(b4);
		
		JButton b5 = new JButton("CUSTOMER INFO");
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.setBounds(60,190,200,30);
		b5.addActionListener(this);
		frame.add(b5);
		
		JButton b6 = new JButton("MANAGER INFO");
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.setBounds(60,230,200,30);
		b6.addActionListener(this);
		frame.add(b6);
		
		JButton b7 = new JButton("CHECK OUT");
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.setBounds(60,270,200,30);
		b7.addActionListener(this);
		frame.add(b7);
		
		JButton b8 = new JButton("UPDATE CHECK STATUS");
		b8.setBackground(Color.BLACK);
		b8.setForeground(Color.WHITE);
		b8.setBounds(60,310,200,30);
		b8.addActionListener(this);
		frame.add(b8);
		
		JButton b9 = new JButton("UPDATE ROOM STATUS");
		b9.setBackground(Color.BLACK);
		b9.setForeground(Color.WHITE);
		b9.setBounds(60,350,200,30);
		b9.addActionListener(this);
		frame.add(b9);
		
		JButton b10 = new JButton("PICK UP SERVICE");
		b10.setBackground(Color.BLACK);
		b10.setForeground(Color.WHITE);
		b10.setBounds(60,390,200,30);
		b10.addActionListener(this);
		frame.add(b10);
		
		JButton b11 = new JButton("SEARCH ROOM");
		b11.setBackground(Color.BLACK);
		b11.setForeground(Color.WHITE); 
		b11.setBounds(60,430,200,30);
		b11.addActionListener(this);
		frame.add(b11);
		
		JButton b12 = new JButton("CLOSE");
		b12.setBackground(Color.BLACK);
		b12.setForeground(Color.WHITE);
		b12.setBounds(60,470,200,30);
		b12.addActionListener(this);
		frame.add(b12);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(300,30,500,470);
		frame.add(l1);
		
		frame.setLayout(null);
		frame.setBounds(340,180,850,580);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("NEW CUSTOMER FORM")) {
			new NewCustomerForm();
			frame.setVisible(false);
		}
		else if(ae.getActionCommand().equals("ROOM")) {
			new RoomInfo();
			frame.setVisible(false);
		}
		else if(ae.getActionCommand().equals("DEPARTMENT")) {
			JOptionPane.showMessageDialog(null, "clicked");
		}
		else if(ae.getActionCommand().equals("ALL EMPLOYEE INFO")) {
			new EmployeeInfo();
			frame.setVisible(false);
		}
		else if(ae.getActionCommand().equals("CUSTOMER INFO")) {
			new CustomerInfo();
			frame.setVisible(false);
		}
		else if(ae.getActionCommand().equals("MANAGER INFO")) {
			new ManagerInfo();
			frame.setVisible(false);
		}
		else if(ae.getActionCommand().equals("CHECK OUT")) {
			JOptionPane.showMessageDialog(null, "clicked");
		}
		else if(ae.getActionCommand().equals("UPDATE CHECK STATUS")) {
			JOptionPane.showMessageDialog(null, "clicked");
		}
		else if(ae.getActionCommand().equals("UPDATE ROOM STATUS")) {
			new UpdateRoomStatus();
			frame.setVisible(false);
		}
		else if(ae.getActionCommand().equals("PICK UP SERVICE")) {
			JOptionPane.showMessageDialog(null, "clicked");
		}
		else if(ae.getActionCommand().equals("SEARCH ROOM")) {
			new SearchRoom();
			frame.setVisible(false);
		}
		else if(ae.getActionCommand().equals("CLOSE")) {
			frame.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new Reception();
	}

}
