package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddDriver implements ActionListener{
	
	JFrame frame = new JFrame("Add Drivers");
	JTextField t1,t2,t3,t4,t5;
	JComboBox<String> cb1;
	JButton b1,b2;
	JRadioButton r1,r2;
	
	AddDriver(){
		
		JLabel name = new JLabel("NAME");
		name.setFont(new Font("sans-serif",Font.BOLD,17));
		name.setBounds(60,30,180,30);
		frame.add(name);
		t1 = new JTextField();
		t1.setBounds(250,30,200,30);
		t1.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		frame.add(t1);
		
		JLabel age = new JLabel("AGE");
		age.setFont(new Font("sans-serif",Font.BOLD,17));
		age.setBounds(60,80,180,30);
		frame.add(age);
		t2 = new JTextField();
		t2.setBounds(250,80,200,30);
		t2.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		frame.add(t2);

		JLabel gender = new JLabel("GENDER");
		gender.setFont(new Font("sans-serif",Font.BOLD,17));
		gender.setBounds(60,130,120,30);
		frame.add(gender);
		r1 = new JRadioButton("Male");    
		r2 = new JRadioButton("Female");    
		r1.setBounds(250,130,80,30);
		r1.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		r2.setBounds(340,130,80,30);
		r2.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		frame.add(r1);
		frame.add(r2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JLabel carC = new JLabel("CAR COMPANY");
		carC.setFont(new Font("sans-serif",Font.BOLD,17));
		carC.setBounds(60,180,180,30);
		frame.add(carC);
		t3 = new JTextField();
		t3.setBounds(250,180,200,30);
		t3.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		frame.add(t3);
		
		JLabel carM = new JLabel("CAR MODEL");
		carM.setFont(new Font("sans-serif",Font.BOLD,17));
		carM.setBounds(60,230,180,30);
		frame.add(carM);
		t4 = new JTextField();
		t4.setBounds(250,230,200,30);
		t4.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		frame.add(t4);
		
		JLabel available = new JLabel("AVAILABLE");
		available.setFont(new Font("sans-serif",Font.BOLD,17));
		available.setBounds(60,280,180,30);
		frame.add(available);
		String str1[] = {"Available","Occupied"};
		cb1 = new JComboBox<>(str1);
		cb1.setFont(new Font("sans-serif",Font.BOLD,14));
		cb1.setBackground(Color.WHITE);
		cb1.setBounds(250,280,200,30);
		frame.add(cb1);
		
		JLabel loc = new JLabel("LOCATION");
		loc.setFont(new Font("sans-serif",Font.BOLD,17));
		loc.setBounds(60,330,180,30);
		frame.add(loc);
		t5 = new JTextField();
		t5.setBounds(250,330,200,30);
		t5.setFont(new Font("sarif",Font.TRUETYPE_FONT,17));
		frame.add(t5);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(500,0,500,500);
		frame.add(l1);
		
		JButton b1 = new JButton("ADD DRIVER");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(70,390,170,40);
		b1.addActionListener(this);
		frame.add(b1);
		
		JButton b2 = new JButton("CANCEL");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(270,390,170,40);
		b2.addActionListener(this);
		frame.add(b2);
		
		frame.setBounds(300,180,950,500);
		//frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true); 
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand().equals("ADD DRIVER")) {

			try {
				String name = t1.getText();
				String age1 = t2.getText();
				int age = Integer.parseInt(age1);
				
				String gender = null;
				if(r1.isSelected()) {
					gender = "Male";
				}
				else if(r2.isSelected()) {
					gender = "Female";
				}
			
				String carCompany = t3.getText();
				String carModel = t4.getText();
				String location = t5.getText();
				String Available = (String) cb1.getSelectedItem();
				
				Conn cn = new Conn();
				PreparedStatement stmt;
				try {
					stmt = cn.c.prepareStatement("insert into driver(name,age,gender,car_company,car_model,available,location) values(?,?,?,?,?,?,?)");
					stmt.setString(1, name);
					stmt.setInt(2, age);
					stmt.setString(3, gender);
					stmt.setString(4, carCompany);
					stmt.setString(5, carModel);
					stmt.setString(6, Available);
					stmt.setString(7, location);
					stmt.executeUpdate();
					cn.c.close();
					JOptionPane.showMessageDialog(null, "New Driver Added Successfully.");
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
		new AddDriver();
	}

}
