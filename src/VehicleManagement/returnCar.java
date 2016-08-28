package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.SystemColor;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JComboBox;

public class returnCar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField Total_payment;
	private JTextField takeno;
	private JTextField bankname;
	private JTextField date;
	private String carno;
	private String customername;
	private String booking_id;
	private String reference_no;
	private String payment_id;
	private JPanel panel_4;
	private JPanel panel_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnCar frame = new returnCar();
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
	public returnCar() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 486);
		getContentPane().setLayout(null);;
		contentPane = new JPanel();
		Color myColor = Color.decode("#03A9F4");
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Return Procedure", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 11, 644, 436);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(294, 26, 124, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		JLabel lblEnterTheBooking = new JLabel("Enter the Booking id :");
		lblEnterTheBooking.setBounds(152, 29, 132, 14);
		panel_2.add(lblEnterTheBooking);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(428, 25, 89, 23);
		panel_2.add(btnSearch);
		
		JLabel lblStep = new JLabel("Step 1");
		lblStep.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\arrow-forward-icon.png"));
		lblStep.setOpaque(true);
		lblStep.setBackground(myColor);
		lblStep.setForeground(Color.WHITE);
		lblStep.setBounds(152, 393, 89, 32);
		panel_2.add(lblStep);
		
		JLabel lblStep_1 = new JLabel("Step 2");
		lblStep_1.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\arrow-forward-icon.png"));
		lblStep_1.setOpaque(true);
		lblStep_1.setBackground(myColor);
		lblStep_1.setEnabled(false);
		lblStep_1.setBounds(251, 393, 82, 32);
		panel_2.add(lblStep_1);
		
		JLabel lblStep_2 = new JLabel("Step 3");
		lblStep_2.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\arrow-forward-icon.png"));
		lblStep_2.setOpaque(true);
		lblStep_2.setBackground(myColor);
		lblStep_2.setEnabled(false);
		lblStep_2.setBounds(345, 393, 89, 32);
		panel_2.add(lblStep_2);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(76, 57, 507, 325);
		panel_2.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Customer Booking Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 51, 46, 14);
		panel_1.add(lblName);
		
		JLabel customername = new JLabel("");
		customername.setBounds(123, 51, 101, 14);
		panel_1.add(customername);
		
		JLabel lblNewLabel = new JLabel("Start Date");
		lblNewLabel.setBounds(10, 87, 72, 14);
		panel_1.add(lblNewLabel);
		
		JLabel Start_date = new JLabel("");
		Start_date.setBounds(123, 87, 101, 14);
		panel_1.add(Start_date);
		
		JLabel lblBookingDate = new JLabel("Booking Date :");
		lblBookingDate.setBounds(10, 162, 103, 14);
		panel_1.add(lblBookingDate);
		
		JLabel booking_date = new JLabel("");
		booking_date.setBounds(123, 162, 101, 14);
		panel_1.add(booking_date);
		
		JLabel lblVehicleName = new JLabel("Vehicle Name :");
		lblVehicleName.setBounds(10, 187, 103, 14);
		panel_1.add(lblVehicleName);
		
		JLabel lblCarNo = new JLabel("Car No: ");
		lblCarNo.setBounds(10, 230, 46, 14);
		panel_1.add(lblCarNo);
		
		JLabel lblRent = new JLabel("Rent :");
		lblRent.setBounds(10, 255, 46, 14);
		panel_1.add(lblRent);
		
		JLabel vehiclename = new JLabel("");
		vehiclename.setBounds(123, 187, 101, 14);
		panel_1.add(vehiclename);
		
		JLabel car_no = new JLabel("");
		car_no.setBounds(123, 230, 101, 14);
		panel_1.add(car_no);
		
		JLabel rent = new JLabel("");
		rent.setBounds(123, 255, 101, 14);
		panel_1.add(rent);
		
	
		
		JButton btnProceedToPayment = new JButton("Proceed to Payment");
		btnProceedToPayment.setBounds(347, 296, 150, 23);
		panel_1.add(btnProceedToPayment);
		
		JLabel fuelexp = new JLabel("");
		fuelexp.setBounds(365, 11, 132, 14);
		panel_1.add(fuelexp);
		
		JLabel lblTotalPayment = new JLabel("Total Payment :");
		lblTotalPayment.setBounds(265, 271, 90, 14);
		panel_1.add(lblTotalPayment);
		
		Total_payment = new JTextField();
		Total_payment.setForeground(Color.BLACK);
		Total_payment.setBounds(363, 265, 101, 20);
		panel_1.add(Total_payment);
		Total_payment.setColumns(10);
		
		JLabel lblDriverName = new JLabel("Driver Name:");
		lblDriverName.setBounds(265, 162, 90, 14);
		panel_1.add(lblDriverName);
		
		JLabel Driver_name = new JLabel("");
		Driver_name.setBounds(381, 162, 79, 14);
		panel_1.add(Driver_name);
		
		
		JLabel lblEndDate = new JLabel("End Date :");
		lblEndDate.setBounds(10, 132, 79, 14);
		panel_1.add(lblEndDate);
		
		JLabel enddate = new JLabel("");
		enddate.setBounds(123, 135, 101, 14);
		panel_1.add(enddate);
		btnProceedToPayment.setVisible(false);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				if(id.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter a Name to Search");
				}
				else
				{
					Connection connection;
					connection = DBConnection.getDBConnection();
					try
					{
						String fuel = null,Rent = null,start_date=null,end_date=null,paid=null;
						Date start = null,end = null;
						String Query = "SELECT b_id,customer_name,start_date,end_date,booking_date,vehicle_name,car_number,Driver_name,rent,paid FROM booking where b_id='"+id+"'";
						ResultSet rs;
						PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query);
						rs=st.executeQuery();
						if(rs.next())
						{
							booking_id = rs.getString("b_id");
							String name=rs.getString("customer_name");
							customername.setText(name);
							returnCar.this.customername = rs.getString("customer_name");
							start_date=rs.getString("start_date");
							start=rs.getDate("start_date");
							paid = rs.getString("paid");
							Start_date.setText(start_date);
							end_date=rs.getString("end_date");
							enddate.setText(end_date);
							end = rs.getDate("end_date");
							String bookingdate=rs.getString("Booking_date");
							booking_date.setText(bookingdate);
							String vehicle=rs.getString("vehicle_name");
							vehiclename.setText(vehicle);
							String carno=rs.getString("car_number");
							car_no.setText(carno);
							returnCar.this.carno = rs.getString("car_number");
							 Rent=rs.getString("rent");
							rent.setText(Rent);
						
							String driver=rs.getString("Driver_name");
							Driver_name.setText(driver);
							
							
							
							
							
						}
						
						else if(!rs.next())
						{
							JOptionPane.showMessageDialog(null, "No booking with Entered Name");
						}
						if(paid.equals("paid"))
						{
							btnProceedToPayment.setVisible(false);
							Total_payment.setText("Paid");
							
						}
						else
						{
							btnProceedToPayment.setVisible(true);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
						Date date = new Date();
						String todaydate = sdf.format(date);
						
						if(date.equals(end))
						{
							int year = date.getYear();
							int month = date.getMonth();
							int day = date.getDate();
							int dayelpase = end.getDate()-start.getDate();
							double rent = Double.parseDouble(Rent);
							double totalrent = (rent*dayelpase);
							String total = Double.toString(totalrent);
							Total_payment.disable();
							Total_payment.setText(total);
						}
						else if(date.after(end))
						{
							int year = date.getYear();
							int month = date.getMonth();
							int day = date.getDate();
							
							int dayelpase = end.getDate()-start.getDate();
							int charges=500;
							int chargeperiod = date.getDate()-end.getDate();
							double rent = Double.parseDouble(Rent);
							double totalrent = (rent*dayelpase)+(chargeperiod*charges);
							String total = Double.toString(totalrent);
							Total_payment.disable();
							Total_payment.setText(total);
							
						}else if(date.before(end))
						{
							int year = date.getYear();
							int month = date.getMonth();
							int day = date.getDate();
							
							int startday = start.getDate();
							
							
							int diffday=day-startday;
							
							System.out.println(diffday);
							double rent = Double.parseDouble(Rent);
							Double totalrent =diffday*rent;
							
							String total = Double.toString(totalrent);
						
							//Total_payment.setText(Rent);
							
							Total_payment.disable();
							Total_payment.setText(total);
						
							
						}
						
						
						
						
						}
					}catch(Exception e1)
					{
						//JOptionPane.showMessageDialog(null, "");
					}
				}
			}
		});
		btnProceedToPayment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_4 = new JPanel();
				panel_4.setBorder(new TitledBorder(null, "Payment Procedure", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_4.setBounds(10, 11, 648, 420);
				getContentPane().add(panel_4);
				panel_4.setLayout(null);
				Color myColor = Color.decode("#03A9F4");
				panel_5 = new JPanel();
				panel_5.setBounds(10, 22, 632, 344);
				panel_4.add(panel_5);
				panel_5.setLayout(null);
				
				JLabel lblPayment = new JLabel("Payment ");
				lblPayment.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\payment-icon.png"));
				lblPayment.setFont(new Font("Andalus", Font.BOLD, 18));
				lblPayment.setForeground(Color.BLUE);
				lblPayment.setBounds(238, 22, 153, 48);
				panel_5.add(lblPayment);
				
				JLabel lblNewLabel = new JLabel("Customer Name :");
				lblNewLabel.setBounds(25, 87, 100, 14);
				panel_5.add(lblNewLabel);
				
				JLabel customer_name = new JLabel("");
				customer_name.setBounds(125, 87, 111, 14);
				panel_5.add(customer_name);
				customer_name.setText(returnCar.this.customername);
				JLabel lblCarNo = new JLabel("Car no :");
				lblCarNo.setBounds(25, 125, 46, 14);
				panel_5.add(lblCarNo);
				
				JLabel car_no = new JLabel("");
				car_no.setBounds(125, 125, 100, 14);
				panel_5.add(car_no);
				car_no.setText(carno);
				JLabel lblBookingId = new JLabel("Booking id :");
				lblBookingId.setBounds(25, 165, 83, 14);
				panel_5.add(lblBookingId);
				
				JLabel booking_id = new JLabel("");
				booking_id.setBounds(125, 165, 75, 14);
				panel_5.add(booking_id);
				booking_id.setText(returnCar.this.booking_id);
				JLabel lblTotalAmount = new JLabel("Total Amount :");
				lblTotalAmount.setBounds(25, 209, 83, 14);
				panel_5.add(lblTotalAmount);
				
				JLabel lblPaymentType = new JLabel("Payment Type :");
				lblPaymentType.setBounds(360, 87, 94, 14);
				panel_5.add(lblPaymentType);
				String[] paytype ={"Select Payment Type ","Cash","Cheque","DD"};
				JComboBox payment_type = new JComboBox(paytype);
				payment_type.setBounds(459, 84, 94, 20);
				panel_5.add(payment_type);
				JLabel lblDdNo = new JLabel("DD no:");
				lblDdNo.setBounds(360, 142, 75, 14);
				panel_5.add(lblDdNo);
				payment_type.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(payment_type.getSelectedItem().equals("Cheque"))
						
						{
							bankname.setEnabled(true);
							takeno.setEnabled(true);
							lblDdNo.setText("Cheque No:");
							
						}
						else if(payment_type.getSelectedItem().equals("DD"))
						{
							bankname.setEnabled(true);
							takeno.setEnabled(true);
							lblDdNo.setText("DD No:");
							
						}
						else
						{
							bankname.setEnabled(false);
							takeno.setEnabled(false);
						}
						
					}
				});
				
				
				
				takeno = new JTextField();
				takeno.setEnabled(false);
				takeno.setBounds(459, 139, 122, 20);
				panel_5.add(takeno);
				takeno.setColumns(10);
				
				JLabel lblDate = new JLabel("Date :");
				lblDate.setBounds(360, 251, 75, 14);
				panel_5.add(lblDate);
				
				JLabel lblBankName = new JLabel("Bank Name :");
				lblBankName.setBounds(360, 209, 94, 14);
				panel_5.add(lblBankName);
				
				bankname = new JTextField();
				bankname.setEnabled(false);
				bankname.setBounds(459, 206, 122, 20);
				panel_5.add(bankname);
				bankname.setColumns(10);
				Date dateofPay = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dateofpay = sdf.format(dateofPay);
				
				date = new JTextField();
				date.setEnabled(false);
				date.setBounds(459, 248, 122, 20);
				panel_5.add(date);
				date.setColumns(10);
				date.setText(dateofpay);
				JButton btnPay = new JButton("Pay");
				btnPay.setBounds(441, 310, 89, 23);
				panel_5.add(btnPay);
				
				
				JLabel amount = new JLabel("");
				amount.setBounds(125, 209, 111, 14);
				panel_5.add(amount);
				amount.setText(Total_payment.getText());
				JLabel lblStep = new JLabel("Step 1");
				lblStep.setEnabled(false);
				lblStep.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\arrow-forward-icon.png"));
				lblStep.setOpaque(true);
				
				lblStep.setBackground(myColor);
				lblStep.setForeground(Color.WHITE);
				lblStep.setBounds(149, 377, 89, 32);
				panel_4.add(lblStep);
				
				JLabel lblStep_1 = new JLabel("Step 2");
				lblStep_1.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\arrow-forward-icon.png"));
				lblStep_1.setOpaque(true);
				lblStep_1.setBackground(myColor);
				lblStep_1.setEnabled(true);
				lblStep_1.setBounds(248, 377, 82, 32);
				panel_4.add(lblStep_1);
				
				JLabel lblStep_2 = new JLabel("Step 3");
				lblStep_2.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\arrow-forward-icon.png"));
				lblStep_2.setOpaque(true);
				lblStep_2.setBackground(myColor);
				lblStep_2.setEnabled(false);
				lblStep_2.setBounds(345, 377, 89, 32);
				panel_4.add(lblStep_2);
				
				btnPay.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						
						Random no = new Random();
						int number;
						int min=1000,max=1000000;
						
						number=no.nextInt(max-min+1)+min;
						
						String reference=Integer.toString(number);
						if(payment_type.getSelectedItem().equals("Cash"))
						{
							try
							{
								Connection connection;
								connection = DBConnection.getDBConnection();
								String Query= "INSERT INTO payment(payment_type,Reference_no,booking_id,cheque_dd_no,bank_name,amount,payment_date) VALUES(?,?,?,?,?,?,?)";
								PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query,Statement.RETURN_GENERATED_KEYS);
								st.setString(1, payment_type.getSelectedItem().toString());
								st.setString(2, reference);
								st.setString(3,returnCar.this.booking_id );
								st.setString(4, takeno.getText());
								st.setString(5, bankname.getText());
								st.setString(6, Total_payment.getText());
								st.setString(7, date.getText());
								System.out.println(Query);
								st.executeUpdate();
								
								ResultSet rs;
								System.out.println(Query);
								rs=st.getGeneratedKeys();
								String last_inserted_id=null;
								if(rs.next())
				                {
				                    payment_id = rs.getString(1);
				                }
								reference_no=reference;
								JOptionPane.showMessageDialog(null, "Payment Done");
								
								String Query1="UPDATE booking set paid='paid' where b_id='"+returnCar.this.booking_id+"'";
								PreparedStatement st1 = (PreparedStatement) connection.prepareStatement(Query1);
								st1.executeUpdate();
								String Query2="UPDATE cars set Status='not rented',b_id='0' where car_no='"+carno+"'";
								PreparedStatement st2 = (PreparedStatement) connection.prepareStatement(Query2);
								st2.executeUpdate();
								generatepdf();
								
							}catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, e);
							}
						}
						else if(payment_type.getSelectedItem().equals("Cheque")||payment_type.getSelectedItem().equals("DD"))
						{
							try
							{
								Connection connection;
								connection = DBConnection.getDBConnection();
								String Query= "INSERT INTO payment(payment_type,Reference_no,booking_id,cheque_dd_no,bank_name,amount,payment_date) VALUES(?,?,?,?,?,?,?)";
								PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query,Statement.RETURN_GENERATED_KEYS);
								st.setString(1, payment_type.getSelectedItem().toString());
								st.setString(2, reference);
								st.setString(3,returnCar.this.booking_id );
								st.setString(4, "none");
								st.setString(5, "none");
								st.setString(6, Total_payment.getText());
								st.setString(7, date.getText());
								System.out.println(Query);
								st.executeUpdate();
								
								ResultSet rs;
								System.out.println(Query);
								rs=st.getGeneratedKeys();
								String last_inserted_id=null;
								if(rs.next())
				                {
				                    payment_id = rs.getString(1);
				                }
								reference_no=reference;
								JOptionPane.showMessageDialog(null, "Payment Done");
								
								String Query1="UPDATE booking set paid='paid' where b_id='"+returnCar.this.booking_id+"'";
								PreparedStatement st1 = (PreparedStatement) connection.prepareStatement(Query1);
								st1.executeUpdate();
								String Query2="UPDATE cars set Status='not rented',b_id='0' where car_no='"+carno+"'";
								PreparedStatement st2 = (PreparedStatement) connection.prepareStatement(Query2);
								st2.executeUpdate();
								generatepdf();
								
							}catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, e);
							}
						}
						else if(payment_type.getSelectedItem().equals("Select Payment Type "))
						{
							JOptionPane.showMessageDialog(null, "Please Select payment type");
							
						}
						
						
					}
				});
				
			}
		});
		
	
		
	}

	private void generatepdf() {
		panel_4.setVisible(false);
		panel_5.setVisible(false);
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Payment Procedure", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 11, 648, 420);
		getContentPane().add(panel_6);
		Color myColor = Color.decode("#03A9F4");
		String[] paytype ={"Select Payment Type ","Cash","Cheque","DD"};
		Date dateofPay = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateofpay = sdf.format(dateofPay);
		panel_6.setLayout(null);
		JLabel lblStep = new JLabel("Step 1");
		lblStep.setBounds(149, 377, 89, 32);
		lblStep.setEnabled(false);
		lblStep.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\arrow-forward-icon.png"));
		lblStep.setOpaque(true);
		
		lblStep.setBackground(myColor);
		lblStep.setForeground(Color.WHITE);
		panel_6.add(lblStep);
		
		JLabel lblStep_1 = new JLabel("Step 2");
		lblStep_1.setBounds(248, 377, 82, 32);
		lblStep_1.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\arrow-forward-icon.png"));
		lblStep_1.setOpaque(true);
		lblStep_1.setBackground(myColor);
		lblStep_1.setEnabled(false);
		panel_6.add(lblStep_1);
		
		JLabel lblStep_2 = new JLabel("Step 3");
		lblStep_2.setBounds(345, 377, 89, 32);
		lblStep_2.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\arrow-forward-icon.png"));
		lblStep_2.setOpaque(true);
		lblStep_2.setBackground(myColor);
		panel_6.add(lblStep_2);
		
		JLabel lblPaymentConfirmation = new JLabel("Payment Confirmation ");
		lblPaymentConfirmation.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\success-icon.png"));
		lblPaymentConfirmation.setFont(new Font("Andalus", Font.PLAIN, 36));
		lblPaymentConfirmation.setBounds(82, 45, 492, 104);
		panel_6.add(lblPaymentConfirmation);
		
		JLabel lblYourPaymentHas = new JLabel("Your Payment Has been Confirmed.");
		lblYourPaymentHas.setBounds(84, 179, 220, 14);
		panel_6.add(lblYourPaymentHas);
		
		JLabel lblPaymentId = new JLabel("Payment  id :");
		lblPaymentId.setBounds(82, 211, 94, 14);
		panel_6.add(lblPaymentId);
		
		JLabel lblReferenceTransactionNumber = new JLabel("Reference Transaction Number :");
		lblReferenceTransactionNumber.setBounds(82, 236, 212, 14);
		panel_6.add(lblReferenceTransactionNumber);
		
		JLabel lblTotalAmount = new JLabel("Total Amount :");
		lblTotalAmount.setBounds(82, 261, 94, 14);
		panel_6.add(lblTotalAmount);
		
		JButton btnPaymentSlip = new JButton("Payment Slip");
		btnPaymentSlip.setBounds(177, 316, 127, 23);
		panel_6.add(btnPaymentSlip);
		
		JLabel lblPleaseKeepThe = new JLabel("Please keep the Reference number for further Use.");
		lblPleaseKeepThe.setBounds(82, 287, 341, 14);
		panel_6.add(lblPleaseKeepThe);
		
		JLabel payment_id = new JLabel("");
		payment_id.setFont(new Font("Tahoma", Font.BOLD, 13));
		payment_id.setBounds(304, 211, 143, 14);
		panel_6.add(payment_id);
		payment_id.setText(returnCar.this.payment_id);
		
		JLabel reference_no = new JLabel("");
		reference_no.setFont(new Font("Tahoma", Font.BOLD, 13));
		reference_no.setBounds(304, 236, 143, 14);
		panel_6.add(reference_no);
		reference_no.setText(returnCar.this.reference_no);
		JLabel total_amount_paid = new JLabel("");
		total_amount_paid.setFont(new Font("Tahoma", Font.BOLD, 13));
		total_amount_paid.setBounds(304, 261, 143, 14);
		panel_6.add(total_amount_paid);
		total_amount_paid.setText(Total_payment.getText());
		panel_6.setVisible(true);
		
		btnPaymentSlip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String paymentid=null,referenceno=null,carno=null,date = null;
				try
				{
					Connection connection;
					ResultSet rs;
					connection =DBConnection.getDBConnection();
					String Query ="SELECT * FROM payment where pay_id='"+returnCar.this.payment_id+"'";
					
					PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query);
					rs=st.executeQuery();
					
					while(rs.next())
					{
						paymentid = rs.getString("pay_id");
						referenceno = rs.getString("Reference_no");
						date = rs.getString("payment_date");
					}
				
				
				String Filename ="payment Slip_"+returnCar.this.payment_id;
				com.itextpdf.text.Document document = new com.itextpdf.text.Document();
				PdfWriter.getInstance(document, new FileOutputStream(Filename+".pdf"));
				document.open();
				document.add(new Paragraph("Vehicle Management System Payment Slip",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.BLACK)));
				document.add(new Paragraph("----------------------------------------------------------------------------------------"));
				//document.add(new Paragraph("Rent Information"));
				PdfPTable Table = new PdfPTable(2);
				PdfPCell cell = new PdfPCell(new Paragraph("Payment Information")); 
				cell.setColspan(4);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setBackgroundColor(BaseColor.GREEN);
				Table.addCell(cell);
				Table.addCell("Booking No");
				Table.addCell(returnCar.this.booking_id);
				Table.addCell("booking date");
				Table.addCell(date);
				Table.addCell("Payment id");
				Table.addCell(returnCar.this.payment_id);
				Table.addCell("payment Reference no");
				Table.addCell(referenceno);
				Table.addCell("Customer Name");
				Table.addCell(returnCar.this.customername);
				Table.addCell("Total Amount");
				Table.addCell(Total_payment.getText());
				Table.addCell("car number");
				Table.addCell(returnCar.this.carno);
				Table.addCell("Status");
				Table.addCell("paid");
				document.add(Table);
				document.add(new Paragraph("----------------------------------------------------------------------"));
				document.add(new Paragraph("1.Please Bring this Slip on Return Date \n2.Extra Charges Will be Taken if found in Damaged Condition"));
				document.close();
				//JOptionPane.showMessageDialog(null, "RecordSaved");
				
				try
				{
				Desktop.getDesktop().open(new File("C:\\Users\\hazup\\workspace\\vehicleManagement\\"+Filename+".pdf"));	
				
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}

			
		});
		
	}
}
