package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class RoomInfo implements ActionListener{
	
	JFrame frame = new JFrame("Room Info");
	JTable t1;
	JButton b1, b2, b3;
	JTextField tf;
	JComboBox<String> cb1;
	
	RoomInfo(){
		
		JLabel Eid = new JLabel("ROOM NO");
		Eid.setBounds(0,10,140,30);
		Eid.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(Eid);
		
		JLabel name = new JLabel("AVAILABLE");
		name.setBounds(140,10,140,30);
		name.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(name);
		
		JLabel age = new JLabel("PRICE");
		age.setBounds(280,10,140,30);
		age.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(age);
		
		JLabel gender = new JLabel("STATUS");
		gender.setBounds(420,10,140,30);
		gender.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(gender);
		
		JLabel job = new JLabel("BED TYPE");
		job.setBounds(560,10,140,30);
		job.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(job);
		
		JLabel search = new JLabel("AVAILABLITY");
		search.setBounds(750,550,200,30);
		search.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(search);
		String str1[] = {"Available","Occupied"};
		cb1 = new JComboBox<>(str1);
		cb1.setFont(new Font("sans-serif",Font.BOLD,14));
		cb1.setBackground(Color.WHITE);
		cb1.setBounds(750,580,200,30);
		frame.add(cb1);
		
		JButton b3 = new JButton("SEARCH");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(990,580,150,40);
		b3.addActionListener(this);
		frame.add(b3);
		
		t1 = new JTable();
		t1.setBounds(0,40,700,500);
		t1.setFont(new Font("serif",Font.PLAIN,16));
		frame.add(t1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(700,40,500,500);
		frame.add(l1);
		
		JButton b1 = new JButton("LOAD DATA");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(120,580,200,40);
		b1.addActionListener(this);
		frame.add(b1);
		
		JButton b2 = new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(380,580,200,40);
		b2.addActionListener(this);
		frame.add(b2);
		
		frame.setLayout(null);
		frame.setBounds(170,150,1200,700);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("LOAD DATA")) {
			try {
				Conn c = new Conn();
				String str = "select * from room";
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		else if(ae.getActionCommand().equals("SEARCH")) {
			try {
				String Available = (String) cb1.getSelectedItem();
				Conn c = new Conn();
				PreparedStatement stmt = c.c.prepareStatement("select * from room where Available = '"+Available+"'");
				ResultSet rs = stmt.executeQuery();
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				c.c.close();
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		else if(ae.getActionCommand().equals("BACK")) {
			 new Reception();
			 frame.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new RoomInfo();
	}

}
