package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JMenuBar mb;
	JMenu m1, m2;
	JMenuItem l1,l2,l3,l4;
	
	Dashboard(){
		mb = new JMenuBar();
		mb.setBackground(Color.DARK_GRAY);
		add(mb);
		
		m1 = new JMenu("HOTELL MANAGEMENT");
		m1.setForeground(Color.WHITE);
		mb.add(m1);
		
		m2 = new JMenu("ADMIN");
		m2.setForeground(Color.RED);
		mb.add(m2);
		
		l1 = new JMenuItem("RECEPTION");
		l1.addActionListener(this);
		m1.add(l1);
		
		l2 = new JMenuItem("ADD EMPLOYEE");
		l2.addActionListener(this);
		m2.add(l2);
		
		l3 = new JMenuItem("ADD ROOMS");
		l3.addActionListener(this);
		m2.add(l3);
		
		l4 = new JMenuItem("ADD DRIVERS");
		l4.addActionListener(this);
		m2.add(l4);
		
		JButton b2 = new JButton("LOG OUT");
		b2.setBackground(Color.DARK_GRAY);
		b2.setForeground(Color.WHITE);
		b2.setBounds(1430,10,60,20);
		b2.setBorder(null);
		b2.addActionListener(this);
		add(b2);
		
		mb.setBounds(0, 0, 1610, 40);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(0,30,1610,1000);
		add(l1);
		
		JLabel l2 = new JLabel("ABDUL MALIK WELCOMES YOU");
		l2.setBounds(410,10,1100,80);
		l2.setFont(new Font("sans-serif",Font.BOLD,45));
		l2.setForeground(Color.WHITE);
		l1.add(l2);
		
		setLayout(null);
		setBounds(0, 0, 1600, 1000);
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee();
		}
		else if(ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRoom();
		}
		else if(ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDriver();
		}
		else if(ae.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}
		else if(ae.getActionCommand().equals("LOG OUT")) {
			new Login().setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dashboard();
	}

}
