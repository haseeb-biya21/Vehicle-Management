package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class showbookingDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showbookingDetails frame = new showbookingDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public showbookingDetails() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
	setTitle("Show Booking Details");
		
		setSize(1000, 500);
		
	
	JPanel pan1= new JPanel();
	JLabel list =new JLabel("Booking Detail");
	JTable employeelist = new JTable();
	pan1.add(list);
	
	pan1.add(employeelist);
	
	
	try
	{
		Connection connection;
		connection = DBConnection.getDBConnection();
		if(connection ==  null)
		{
			JOptionPane.showMessageDialog(null, "Error Connecting Database");
		}
		else
		{
			
			String Query ="SELECT * from booking_details.customer_booking JOIN customer.customer_details "
					+ "ON booking_details.customer_booking.b_id=customer.customer_details.b_id";
			ResultSet rs;
			PreparedStatement pst=null;
			Statement st = connection.prepareStatement(Query);
			rs=st.executeQuery(Query);
			employeelist.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		
	}catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, e);
	}
	add(new JScrollPane(employeelist));
	add(pan1,BorderLayout.NORTH);
	setVisible(true);
	}

}
