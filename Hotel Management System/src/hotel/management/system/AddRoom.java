package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRoom implements ActionListener{
	
	JFrame frame = new JFrame("Add Rooms");
	JTextField t1,t2;
	JComboBox<String> cb1,cb2,cb3;
	JButton b1,b2;
	
	AddRoom(){
		
		JLabel name = new JLabel("ROOM NUMBER");
		name.setFont(new Font("sans-serif",Font.BOLD,17));
		name.setBounds(60,30,180,30);
		frame.add(name);
		t1 = new JTextField();
		t1.setBounds(250,30,200,30);
		t1.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		frame.add(t1);
		
		JLabel available = new JLabel("AVAILABLE");
		available.setFont(new Font("sans-serif",Font.BOLD,17));
		available.setBounds(60,80,180,30);
		frame.add(available);
		String str1[] = {"Available","Occupied"};
		cb1 = new JComboBox<>(str1);
		cb1.setFont(new Font("sans-serif",Font.BOLD,14));
		cb1.setBackground(Color.WHITE);
		cb1.setBounds(250,80,200,30);
		frame.add(cb1);
		
		JLabel status = new JLabel("CLEANING STATUS");
		status.setFont(new Font("sans-serif",Font.BOLD,17));
		status.setBounds(60,130,180,30);
		frame.add(status);
		String str2[] = {"Cleaned","Dirty"};
		cb2 = new JComboBox<>(str2);
		cb2.setFont(new Font("sans-serif",Font.BOLD,14));
		cb2.setBackground(Color.WHITE);
		cb2.setBounds(250,130,200,30);
		frame.add(cb2);
		
		JLabel price = new JLabel("PRICE");
		price.setFont(new Font("sans-serif",Font.BOLD,17));
		price.setBounds(60,180,180,30);
		frame.add(price);
		t2 = new JTextField();
		t2.setBounds(250,180,200,30);
		t2.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		frame.add(t2);
		
		JLabel type = new JLabel("BED TYPE");
		type.setFont(new Font("sans-serif",Font.BOLD,17));
		type.setBounds(60,230,180,30);
		frame.add(type);
		String str3[] = {"Single Bed","Double Bed"};
		cb3 = new JComboBox<>(str3);
		cb3.setFont(new Font("sans-serif",Font.BOLD,14));
		cb3.setBackground(Color.WHITE);
		cb3.setBounds(250,230,200,30);
		frame.add(cb3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(500,0,500,500);
		frame.add(l1);
		
		JButton b1 = new JButton("ADD ROOM");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(70,330,170,40);
		b1.addActionListener(this);
		frame.add(b1);
		
		JButton b2 = new JButton("CANCEL");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(270,330,170,40);
		b2.addActionListener(this);
		frame.add(b2);
		
		frame.setBounds(300,180,950,450);
		//frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true); 
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand().equals("ADD ROOM")) {

			try {
				String rn = t1.getText();
				int RoomNo = Integer.parseInt(rn);
				String prc = t2.getText();
				int Price = Integer.parseInt(prc);
			
				String Available = (String) cb1.getSelectedItem();
				String CStatus = (String) cb2.getSelectedItem();
				String BType = (String) cb3.getSelectedItem();
				
				Conn cn = new Conn();
				PreparedStatement stmt;
				try {
					stmt = cn.c.prepareStatement("insert into room values(?,?,?,?,?)");
					stmt.setInt(1, RoomNo);
					stmt.setString(2, Available);
					stmt.setInt(3, Price);
					stmt.setString(4, CStatus);
					stmt.setString(5, BType);
					stmt.executeUpdate();
					cn.c.close();
					JOptionPane.showMessageDialog(null, "New Room Added Successfully.");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
		}
		else if(ae.getActionCommand().equals("CANCEL")) {
			frame.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new AddRoom();
	}

}
