package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee implements ActionListener{
	
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JRadioButton r1,r2;
	JComboBox<String> cb;
	JFrame f = new JFrame("Add Employee Details");
	JButton b1, b2;
	
	AddEmployee(){
		
		JLabel name = new JLabel("NAME");
		name.setFont(new Font("sans-serif",Font.BOLD,17));
		name.setBounds(60,30,120,30);
		f.add(name);
		t1 = new JTextField();
		t1.setBounds(200,30,300,30);
		t1.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		f.add(t1);
		
		JLabel age = new JLabel("AGE");
		age.setFont(new Font("sans-serif",Font.BOLD,17));
		age.setBounds(60,80,120,30);
		f.add(age);
		t2 = new JTextField();
		t2.setBounds(200,80,300,30);
		t2.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		f.add(t2);
		
		JLabel gender = new JLabel("GENDER");
		gender.setFont(new Font("sans-serif",Font.BOLD,17));
		gender.setBounds(60,130,120,30);
		f.add(gender);
		r1 = new JRadioButton("Male");    
		r2 = new JRadioButton("Female");    
		r1.setBounds(200,130,100,30);
		r1.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		r2.setBounds(320,130,100,30);
		r2.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		f.add(r1);
		f.add(r2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JLabel job = new JLabel("JOB");
		job.setFont(new Font("sans-serif",Font.BOLD,17));
		job.setBounds(60,180,120,30);
		f.add(job);
		
		String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountent","Chef"};
		cb = new JComboBox<>(str);
		cb.setFont(new Font("sans-serif",Font.BOLD,14));
		cb.setBackground(Color.WHITE);
		cb.setBounds(200,180,300,30);
		f.add(cb);
		
		JLabel salary = new JLabel("SALARY");
		salary.setFont(new Font("sans-serif",Font.BOLD,17));
		salary.setBounds(60,230,120,30);
		f.add(salary);
		t3 = new JTextField();
		t3.setBounds(200,230,300,30);
		t3.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		f.add(t3);
		
		JLabel phone = new JLabel("PHONE");
		phone.setFont(new Font("sans-serif",Font.BOLD,17));
		phone.setBounds(60,280,120,30);
		f.add(phone);
		t4 = new JTextField();
		t4.setBounds(200,280,300,30);
		t4.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		f.add(t4);
		
		JLabel aadhar = new JLabel("AADHAR");
		aadhar.setFont(new Font("sans-serif",Font.BOLD,17));
		aadhar.setBounds(60,330,120,30);
		f.add(aadhar);
		t5 = new JTextField();
		t5.setBounds(200,330,300,30);
		t5.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		f.add(t5);
		
		JLabel email = new JLabel("EMAIL");
		email.setFont(new Font("sans-serif",Font.BOLD,17));
		email.setBounds(60,380,120,30);
		f.add(email);
		t6 = new JTextField();
		t6.setBounds(200,380,300,30);
		t6.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		f.add(t6);
		
		JLabel address = new JLabel("ADDRESS");
		address.setFont(new Font("sans-serif",Font.BOLD,17));
		address.setBounds(60,430,120,30);
		f.add(address);
		t7 = new JTextField();
		t7.setBounds(200,430,300,30);
		t7.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		f.add(t7);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/AddEmployee.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(600,50,300,300);
		f.add(l1);
		
		b1 = new JButton("ADD EMPLOYEE");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(575,400,150,40);
		b1.addActionListener(this);
		f.add(b1);
		
		b2 = new JButton("CANCEL");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(775,400,150,40);
		b2.addActionListener(this);
		f.add(b2);
		
		
		f.setLayout(null);
		f.setBounds(280,180,1000,530);
		//f.getContentPane().setBackground(Color.WHITE);
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				String name = t1.getText();
				String age = t2.getText();
				String salary = t3.getText();
				int salaryy = Integer.parseInt(salary);
				String phone = t4.getText();
				String aadhar = t5.getText();
				String email = t6.getText();
				String address = t7.getText();
				String gender = null;
				if(r1.isSelected()) {
					gender = "Male";
				}
				else if(r2.isSelected()) {
					gender = "Female";
				}
				String job = (String) cb.getSelectedItem();
			
				Conn cn = new Conn();
				PreparedStatement stmt;
				try {
					stmt = cn.c.prepareStatement("insert into employee(name,age,gender,job,salary,phone,aadhar,email,address) values(?,?,?,?,?,?,?,?,?)");
					stmt.setString(1, name);
					stmt.setString(2, age);
					stmt.setString(3, gender);
					stmt.setString(4, job);
					stmt.setInt(5, salaryy);
					stmt.setString(6, phone);
					stmt.setString(7, aadhar);
					stmt.setString(8, email);
					stmt.setString(9, address);
					stmt.executeUpdate();
					cn.c.close();
					JOptionPane.showMessageDialog(null, "New Employee Added Successfully.");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		else if(ae.getSource()==b2) {
			f.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new AddEmployee();
	}

}
