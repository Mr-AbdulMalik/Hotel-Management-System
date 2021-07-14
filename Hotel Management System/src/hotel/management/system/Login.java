package hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel l1, l2, l3;
	JTextField t1;
	JPasswordField p1;
	JButton b1, b2;
	
	Login() {
		setLayout(null);
		
		l1 = new JLabel("Admin");
		l1.setBounds(405, 180, 100, 30);
		l1.setFont(new Font("serif",Font.BOLD,25));
		add(l1);
		
		l2 = new JLabel("Username");
		l2.setBounds(40, 40, 100, 30);
		l2.setFont(new Font("sans-serif",Font.BOLD,14));
		add(l2);
		
		l3 = new JLabel("Password");
		l3.setBounds(40, 80, 100, 30);
		l3.setFont(new Font("sans-serif",Font.BOLD,14));
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(150, 40, 150, 30);
		t1.setFont(new Font("serif",Font.BOLD,14));
		add(t1);
		
		p1 = new JPasswordField();
		p1.setBounds(150, 80, 150, 30);
		p1.setFont(new Font("serif",Font.BOLD,14));
		add(p1);
		
		b1 = new JButton("Login");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(40,160,125,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(175,160,125,30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(340,10,200,200);
		add(l1);
		
		getContentPane().setBackground(Color.WHITE);
		
		setBounds(450,250,600,300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			String username = t1.getText();
			String password = String.valueOf(p1.getPassword());
			
			String query = "SELECT * FROM login WHERE username='"+username+"' and password='"+password+"'";
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					new Dashboard().setVisible(true);
					this.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid! username or password.");
				}
			} catch (Exception e) {}
		}
		else if(ae.getSource()==b2) {
			System.exit(EXIT_ON_CLOSE);
		}
	}

	public static void main(String[] args) {
		new Login();
	}

}
