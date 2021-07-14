package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class ManagerInfo implements ActionListener{
	
	JFrame frame = new JFrame("Manager Info");
	JTable t1;
	JButton b1, b2;
	
	ManagerInfo(){
		
		JLabel Eid = new JLabel("EMPLOYEE ID");
		Eid.setBounds(0,10,140,30);
		Eid.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(Eid);
		
		JLabel name = new JLabel("NAME");
		name.setBounds(140,10,140,30);
		name.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(name);
		
		JLabel age = new JLabel("AGE");
		age.setBounds(280,10,140,30);
		age.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(age);
		
		JLabel gender = new JLabel("GENDER");
		gender.setBounds(420,10,140,30);
		gender.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(gender);
		
		JLabel job = new JLabel("POST");
		job.setBounds(560,10,140,30);
		job.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(job);
		
		JLabel salary = new JLabel("SALARY");
		salary.setBounds(700,10,140,30);
		salary.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(salary);
		
		JLabel phone = new JLabel("PHONE NO");
		phone.setBounds(840,10,140,30);
		phone.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(phone);
		
		JLabel aadhar = new JLabel("AADHAR NO");
		aadhar.setBounds(980,10,140,30);
		aadhar.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(aadhar);
		
		JLabel email = new JLabel("EMAIL");
		email.setBounds(1120,10,140,30);
		email.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(email);
		
		JLabel address = new JLabel("ADDRESS");
		address.setBounds(1260,10,140,30);
		address.setFont(new Font("sans-serif",Font.BOLD,16));
		frame.add(address);
		
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
		b2.setBounds(750,580,200,40);
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
				String str = "select * from employee where job='Manager'";
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
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
		new ManagerInfo();
	}

}
