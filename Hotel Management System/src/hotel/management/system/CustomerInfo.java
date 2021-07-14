package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class CustomerInfo implements ActionListener{
	
	JFrame frame = new JFrame("Customer Info");
	JTable t1;
	JButton b1, b2, b3;
	JTextField tf;
	
	CustomerInfo(){
		
		JLabel Eid = new JLabel("CUSTOMER NO");
		Eid.setBounds(0,10,140,30);
		Eid.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(Eid);
		
		JLabel name = new JLabel("ID");
		name.setBounds(156,10,140,30);
		int d = 156;
		name.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(name);
		
		JLabel age = new JLabel("ID NUMBER");
		age.setBounds(d*2,10,140,30);
		age.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(age);
		
		JLabel gender = new JLabel("NAME");
		gender.setBounds(d*3,10,140,30);
		gender.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(gender);
		
		JLabel job = new JLabel("GENDER");
		job.setBounds(d*4,10,140,30);
		job.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(job);
		
		JLabel salary = new JLabel("COUNTRY");
		salary.setBounds(d*5,10,140,30);
		salary.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(salary);
		
		JLabel phone = new JLabel("ROOM NO");
		phone.setBounds(d*6,10,140,30);
		phone.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(phone);
		
		JLabel aadhar = new JLabel("CHECKED IN");
		aadhar.setBounds(d*7,10,140,30);
		aadhar.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(aadhar);
		
		JLabel email = new JLabel("DEPOSIT");
		email.setBounds(d*8,10,140,30);
		email.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(email);
		
		JLabel search = new JLabel("SEARCH BY ID");
		search.setBounds(1000,560,140,30);
		search.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(search);
		tf = new JTextField();
		tf.setBounds(1000,590,200,30);
		tf.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(tf);
		
		JButton b3 = new JButton("SEARCH");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(1215,580,150,40);
		b3.addActionListener(this);
		frame.add(b3);
		
		t1 = new JTable();
		t1.setBounds(0,40,1400,500);
		t1.setFont(new Font("serif",Font.PLAIN,16));
		frame.add(t1);
		
		JButton b1 = new JButton("LOAD DATA");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(450,580,200,40);
		b1.addActionListener(this);
		frame.add(b1);
		
		JButton b2 = new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(700,580,200,40);
		b2.addActionListener(this);
		frame.add(b2);
		
		frame.setLayout(null);
		frame.setBounds(70,150,1400,700);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("LOAD DATA")) {
			try {
				Conn c = new Conn();
				String str = "select * from customer";
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		else if(ae.getActionCommand().equals("SEARCH")) {
			try {
				String idd = tf.getText();
				int id = Integer.parseInt(idd);
				Conn c = new Conn();
				PreparedStatement stmt = c.c.prepareStatement("select * from customer where cus_no = ?");
				stmt.setInt(1, id);
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
		new CustomerInfo();
	}

}
