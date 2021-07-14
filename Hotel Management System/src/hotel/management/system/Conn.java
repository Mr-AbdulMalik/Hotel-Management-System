package hotel.management.system;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conn {
	
	Connection c;
	Statement s;
	
	public Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///projecthms","root","");
			s = c.createStatement();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Database Connection Failed!");
		}
	}

	public static void main(String[] args) {
		new Conn();

	}

}
