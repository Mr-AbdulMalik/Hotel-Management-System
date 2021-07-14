package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class SearchRoom implements ActionListener{
	
	JFrame frame = new JFrame("Room Info");
	JTable t1;
	JButton b1, b2, b3;
	JTextField tf;
	
	SearchRoom(){
		
		JLabel Eid = new JLabel("ROOM NO");
		Eid.setBounds(0,80,140,20);
		Eid.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(Eid);
		
		JLabel name = new JLabel("AVAILABLE");
		name.setBounds(140,80,140,20);
		name.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(name);
		
		JLabel age = new JLabel("PRICE");
		age.setBounds(280,80,140,20);
		age.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(age);
		
		JLabel gender = new JLabel("STATUS");
		gender.setBounds(420,80,140,20);
		gender.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(gender);
		
		JLabel job = new JLabel("BED TYPE");
		job.setBounds(560,80,140,20);
		job.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(job);
		
		JLabel search = new JLabel("Enter Room No.");
		search.setBounds(200,10,200,15);
		search.setFont(new Font("sans-serif",Font.BOLD,14));
		frame.add(search);
		tf = new JTextField();
		tf.setFont(new Font("sans-serif",Font.BOLD,16));
		tf.setBackground(Color.WHITE);
		tf.setBounds(200,30,250,35);
		frame.add(tf);
		
		JButton b3 = new JButton("SEARCH");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(500,25,150,40);
		b3.addActionListener(this);
		frame.add(b3);
		
		t1 = new JTable();
		t1.setBounds(0,105,700,500);
		t1.setFont(new Font("serif",Font.PLAIN,18));
		frame.add(t1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(700,105,500,500);
		frame.add(l1);
		
		b2 = new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(700,25,150,40);
		b2.addActionListener(this);
		frame.add(b2);
		
		frame.setLayout(null);
		frame.setBounds(170,150,1200,590);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("SEARCH")) {
			try {
				String roomNo = tf.getText();
				int roomNoo = Integer.parseInt(roomNo);
				Conn c = new Conn();
				PreparedStatement stmt = c.c.prepareStatement("select * from room where RoomNo = ?");
				stmt.setInt(1, roomNoo);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					rs = stmt.executeQuery();
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				}
				else {
					t1.setModel(DbUtils.resultSetToTableModel(rs));
					JOptionPane.showMessageDialog(null, "Room Not Found!");
				}
				c.c.close();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		else if(ae.getActionCommand().equals("BACK")) {
			 new Reception();
			 frame.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new SearchRoom();
	}

}
