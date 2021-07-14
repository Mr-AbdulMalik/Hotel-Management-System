package hotel.management.system;
import java.sql.*;
public class ConnectToDB {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		String f1, f2, query;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			if(!con.isClosed()) {
				query = "SELECT * FROM login";
				System.out.println("successfully connected");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) {
					f1 = rs.getString(1);
					f2 = rs.getString(2);
					System.out.println(f1+" : "+f2);
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			con.close();
			System.out.println("Dissconnected!");
		}
		

	}

}
