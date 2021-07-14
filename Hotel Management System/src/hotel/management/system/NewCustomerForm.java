package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewCustomerForm implements ActionListener{
	
	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	Choice c;
	JComboBox<String> cb;
	JFrame f = new JFrame("New Customer Form");
	JButton b1, b2, b3;
	
	NewCustomerForm(){
		
		JLabel id = new JLabel("ID");
		id.setFont(new Font("sans-serif",Font.BOLD,14));
		id.setBounds(60,30,120,30);
		f.add(id);
		cb = new JComboBox<>(new String[] {"Passport","Voter-Id Card","Driving License","Aadhar Card"});
		cb.setBounds(200,30,200,30);
		cb.setFont(new Font("sarif",Font.BOLD,14));
		cb.setBackground(Color.WHITE);
		f.add(cb);
		
		JLabel number = new JLabel("ID NUMBER");
		number.setFont(new Font("sans-serif",Font.BOLD,14));
		number.setBounds(60,130,120,30);
		f.add(number);
		t1 = new JTextField();
		t1.setBounds(200,130,200,30);
		t1.setFont(new Font("sarif",Font.BOLD,14));
		f.add(t1);
		
		JLabel name = new JLabel("NAME");
		name.setFont(new Font("sans-serif",Font.BOLD,14));
		name.setBounds(60,80,120,30);
		f.add(name);
		t2 = new JTextField();
		t2.setBounds(200,80,200,30);
		t2.setFont(new Font("sarif",Font.BOLD,14));
		f.add(t2);
		
		JLabel gender = new JLabel("GENDER");
		gender.setFont(new Font("sans-serif",Font.BOLD,14));
		gender.setBounds(60,180,120,30);
		f.add(gender);
		r1 = new JRadioButton("Male");    
		r2 = new JRadioButton("Female");    
		r1.setBounds(200,180,80,30);
		r1.setBackground(Color.WHITE);
		r1.setFont(new Font("sarif",Font.BOLD,15));
		r2.setBounds(300,180,80,30);
		r2.setBackground(Color.WHITE);
		r2.setFont(new Font("sarif",Font.BOLD,15));
		f.add(r1);
		f.add(r2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JLabel job = new JLabel("COUNTRY");
		job.setFont(new Font("sans-serif",Font.BOLD,14));
		job.setBounds(60,230,120,30);
		f.add(job);
		t3 = new JTextField();
		t3.setText("IND");
		t3.setFont(new Font("sarif",Font.BOLD,14));
		t3.setBounds(200,230,200,30);
		f.add(t3);
		
		JLabel salary = new JLabel("ALLOCATED ROOM NUMBER");
		salary.setFont(new Font("sans-serif",Font.BOLD,14));
		salary.setBounds(60,280,220,30);
		f.add(salary);
		
		c = new Choice();
		try {
			Conn C = new Conn();
			String stmt = "SELECT * FROM room WHERE Available='Available'";
			ResultSet rs = C.s.executeQuery(stmt);
			while(rs.next())
				c.add(rs.getString("RoomNo"));
			C.c.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		c.setFont(new Font("sans-serif",Font.BOLD,14));
		c.setBackground(Color.WHITE);
		c.setBounds(280,280,150,50);
		f.add(c);
		
		JLabel phone = new JLabel("BED TYPE");
		phone.setFont(new Font("sans-serif",Font.BOLD,14));
		phone.setBounds(60,330,120,30);
		f.add(phone);
		t6 = new JTextField();
		t6.setEditable(false);
		t6.setBounds(200,330,200,30);
		t6.setFont(new Font("sarif",Font.BOLD,14));
		f.add(t6);
		Icon icon = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/refresh.png"));
		b3 = new JButton(icon);
		b3.setBounds(410,330,30,30);
		b3.setBackground(Color.WHITE);
		b3.addActionListener(this);
		f.add(b3);

		JLabel Cin = new JLabel("CHECKED IN");
		Cin.setFont(new Font("sans-serif",Font.BOLD,14));
		Cin.setBounds(60,380,120,30);
		f.add(Cin);
		t4 = new JTextField();
		t4.setBounds(200,380,200,30);
		t4.setFont(new Font("sarif",Font.BOLD,14));
		f.add(t4);
		
		JLabel deposit = new JLabel("DEPOSIT");
		deposit.setFont(new Font("sans-serif",Font.BOLD,14));
		deposit.setBounds(60,430,120,30);
		f.add(deposit);
		t5 = new JTextField();
		t5.setBounds(200,430,200,30);
		t5.setFont(new Font("sarif",Font.BOLD,14));
		f.add(t5);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300, 460, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(430,40,300,460);
		f.add(l1);
		
		b1 = new JButton("ADD CUSTOMER");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(60,500,150,30);
		b1.addActionListener(this);
		f.add(b1);
		
		b2 = new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(250,500,150,30);
		b2.addActionListener(this);
		f.add(b2);
		
		
		f.setLayout(null);
		f.setBounds(350,180,800,600);
		f.getContentPane().setBackground(Color.WHITE);
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				String id = (String) cb.getSelectedItem();
				String IdNumber = t1.getText();
				String name= t2.getText();
				String country = t3.getText();
				String checkedIn = t4.getText();
				String deposit = t5.getText();
				String gender = null;
				if(r1.isSelected()) {
					gender = "Male";
				}
				else if(r2.isSelected()) {
					gender = "Female";
				}
				String allocatedRoom = (String) c.getSelectedItem();
				int AR = Integer.parseInt(allocatedRoom);
			
				Conn cn = new Conn();
				PreparedStatement stmt,stmt1;
				try {
					stmt = cn.c.prepareStatement("insert into customer(id,id_no,name,gender,country,allocatedRooom,checkedIn,deposit) values(?,?,?,?,?,?,?,?)");
					stmt.setString(1, id);
					stmt.setString(2, IdNumber);
					stmt.setString(3, name);
					stmt.setString(4, gender);
					stmt.setString(5, country);
					stmt.setInt(6, AR);
					stmt.setString(7, checkedIn);
					stmt.setString(8, deposit);
					stmt.executeUpdate();
					stmt1 = cn.c.prepareStatement("UPDATE `room` SET `Available` = 'Occupied' WHERE `room`.`RoomNo` = ?");
					stmt1.setInt(1, AR);
					stmt1.executeUpdate();
					cn.c.close();
					JOptionPane.showMessageDialog(null, "New Customer Added Successfully.");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		else if(ae.getSource()==b2) {
			new Reception();
			f.setVisible(false);
		}
		else if(ae.getSource()==b3) {
			try {
				Conn C = new Conn();
				PreparedStatement st = C.c.prepareStatement("select BedType from room where RoomNo=?");
				String ar = (String) c.getSelectedItem();
				int room = Integer.parseInt(ar);
				st.setInt(1, room);
				ResultSet rs = st.executeQuery();
				rs.next();
				t6.setText(rs.getString("BedType"));
				C.c.close();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

	public static void main(String[] args) {	
		new NewCustomerForm();
	}

}
