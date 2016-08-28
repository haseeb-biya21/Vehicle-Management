package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Font;
import javax.swing.SwingConstants;

public class viewcustbooking extends JFrame {

	private JPanel contentPane;
	private JTextField bookingid;
	private JLabel lblEnterReferenceNo;
	private JTextField reference;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewcustbooking frame = new viewcustbooking();
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
	public viewcustbooking() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Enter booking id");
		label.setBounds(59, 6, 103, 34);
		contentPane.add(label);
		
		bookingid = new JTextField();
		bookingid.setBounds(227, 11, 200, 25);
		contentPane.add(bookingid);
		bookingid.setColumns(10);
		
		lblEnterReferenceNo = new JLabel("Enter Booking reference no ");
		lblEnterReferenceNo.setBounds(59, 41, 120, 34);
		contentPane.add(lblEnterReferenceNo);
		
		reference = new JTextField();
		reference.setBounds(227, 42, 200, 25);
		contentPane.add(reference);
		reference.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "booking details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(53, 86, 546, 329);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 22, 534, 296);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Name");
		lblNewLabel.setBounds(10, 11, 105, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("customer Address");
		lblNewLabel_1.setBounds(10, 59, 126, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Start date");
		lblNewLabel_2.setBounds(10, 97, 105, 19);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("End date");
		lblNewLabel_3.setBounds(10, 137, 134, 19);
		panel.add(lblNewLabel_3);
		
		JLabel lblBookingDate = new JLabel("Booking date");
		lblBookingDate.setBounds(10, 167, 105, 19);
		panel.add(lblBookingDate);
		
		JLabel lblVehicle = new JLabel("Vehicle Name");
		lblVehicle.setBounds(10, 210, 105, 19);
		panel.add(lblVehicle);
		
		JLabel lblCarNumber = new JLabel("Car number");
		lblCarNumber.setBounds(296, 10, 105, 33);
		panel.add(lblCarNumber);
		
		JLabel lblRent = new JLabel("rent per day");
		lblRent.setBounds(296, 66, 69, 27);
		panel.add(lblRent);
		
		JLabel customername = new JLabel("");
		customername.setBounds(123, 11, 126, 27);
		panel.add(customername);
		
		JLabel customeradd = new JLabel("");
		customeradd.setBounds(123, 59, 126, 27);
		panel.add(customeradd);
		
		JLabel startdate = new JLabel("");
		startdate.setBounds(125, 92, 124, 27);
		panel.add(startdate);
		
		JLabel enddate = new JLabel("");
		enddate.setBounds(123, 137, 109, 19);
		panel.add(enddate);
		
		JLabel bookingdate = new JLabel("");
		bookingdate.setBounds(123, 162, 109, 27);
		panel.add(bookingdate);
		
		JLabel vehiclename = new JLabel("");
		vehiclename.setBounds(123, 202, 117, 33);
		panel.add(vehiclename);
		
		JLabel carnumber = new JLabel("");
		carnumber.setBounds(398, 11, 126, 27);
		panel.add(carnumber);
		
		JLabel rent = new JLabel("");
		rent.setBounds(398, 66, 126, 27);
		panel.add(rent);
		
		JLabel status = new JLabel("");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setFont(new Font("Monotype Corsiva", Font.BOLD, 33));
		status.setBounds(229, 189, 277, 71);
		panel.add(status);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(451, 41, 89, 23);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bookingid.getText().isEmpty()|| reference.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				}
				else
				{
				try
				{
					String bookid=null,cust_name=null,cust_add=null,status_paid=null,start_date=null,end_date=null,booking_date=null,vehicle_name=null,fuelexpense=null,carno=null,type=null,Rent=null;
					Connection connection;
					ResultSet rs;
					connection =DBConnection.getDBConnection();
					String Query ="SELECT * FROM booking where b_id='"+bookingid.getText()+"' and reference_id='"+reference.getText()+"'";
					
					PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query);
					rs=st.executeQuery();
					
					if(rs.next())
					{
						
								
								cust_name=rs.getString("customer_name");
								customername.setText(cust_name);
								cust_add=rs.getString("cust_add");
								status_paid=rs.getString("paid");
								status.setText(status_paid);
								customeradd.setText(cust_add);
								start_date=rs.getString("start_date");
								startdate.setText(start_date);
								end_date=rs.getString("end_date");
								enddate.setText(end_date);
								booking_date=rs.getString("booking_date");
								bookingdate.setText(booking_date);
								vehicle_name=rs.getString("vehicle_name");
								vehiclename.setText(vehicle_name);
								
								carno=rs.getString("car_number");
								carnumber.setText(carno);
								Rent=rs.getString("rent");
								rent.setText(Rent);
								//reference=rs.getString("reference_id");
	
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No booking Details Please Check credentails");
					}
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				}
			}
		});
	}
}
