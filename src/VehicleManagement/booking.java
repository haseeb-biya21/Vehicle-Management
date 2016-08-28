package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.acl.LastOwnerException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.collection.PdfTargetDictionary;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;

import javax.swing.JTextArea;
import javax.swing.JButton;

import org.jdom.Document;

public class booking extends JFrame {
	private JTextField vehicleno;
	private JTextField inputcustomername;
	private JTextField customerphone;
	private JTextField rent;
	private JTextField bdate;
	private JTextField type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booking frame = new booking();
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
	public booking() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("New Booking");
		setBounds(100, 100, 710, 417);
		getContentPane().setLayout(null);
		
		JLabel lblSelectVehicle = new JLabel("Select Vehicle :");
		lblSelectVehicle.setBounds(361, 31, 90, 14);
		getContentPane().add(lblSelectVehicle);
		
	
		
		JLabel lblCarNumber = new JLabel("Car Number :");
		lblCarNumber.setBounds(361, 176, 76, 14);
		getContentPane().add(lblCarNumber);
		
		vehicleno = new JTextField();
		vehicleno.setBounds(461, 173, 123, 20);
		getContentPane().add(vehicleno);
		vehicleno.setColumns(10);
		
		vehicleno.disable();
		JLabel lblStartDate = new JLabel("Start Date :");
		lblStartDate.setBounds(10, 207, 122, 14);
		getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date :");
		lblEndDate.setBounds(10, 245, 122, 14);
		getContentPane().add(lblEndDate);
		
		JDateChooser startdate = new JDateChooser();
		startdate.setBounds(142, 207, 124, 20);
		getContentPane().add(startdate);
		startdate.setDateFormatString("yyyy-M-dd");
		
		JDateChooser enddate = new JDateChooser();
		enddate.setBounds(142, 239, 124, 20);
		getContentPane().add(enddate);
		
		enddate.setDateFormatString("yyyy-M-dd");
		String [] fuel ={"","Covered By Customer","Covered By Company"};
		
		JLabel lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setBounds(10, 31, 123, 14);
		getContentPane().add(lblCustomerName);
		
		inputcustomername = new JTextField();
		inputcustomername.setBounds(143, 28, 123, 20);
		getContentPane().add(inputcustomername);
		inputcustomername.setColumns(10);
		
		JLabel lblCustomerAddress = new JLabel("Customer Address :");
		lblCustomerAddress.setBounds(10, 68, 134, 30);
		getContentPane().add(lblCustomerAddress);
		
		JTextArea customeradd = new JTextArea();
		customeradd.setBounds(143, 68, 123, 46);
		getContentPane().add(customeradd);
		
		JLabel lblPhoneNo = new JLabel("Phone No :");
		lblPhoneNo.setBounds(10, 158, 123, 14);
		getContentPane().add(lblPhoneNo);
		
		customerphone = new JTextField();
		customerphone.setBounds(142, 155, 124, 20);
		getContentPane().add(customerphone);
		customerphone.setColumns(10);
		
		JLabel lblRent = new JLabel("Rent :");
		lblRent.setBounds(361, 239, 46, 14);
		getContentPane().add(lblRent);
		
		rent = new JTextField();
		rent.setBounds(461, 242, 123, 20);
		getContentPane().add(rent);
		rent.setColumns(10);
		rent.disable();
		
		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(361, 213, 46, 14);
		getContentPane().add(lblType);
		
		JButton btnBook = new JButton("Book");
		btnBook.setBounds(270, 320, 89, 23);
		getContentPane().add(btnBook);
		
		JLabel lblBookingDate = new JLabel("Booking Date :");
		lblBookingDate.setBounds(361, 126, 106, 14);
		getContentPane().add(lblBookingDate);
		
		bdate = new JTextField();
		bdate.setBounds(460, 123, 124, 20);
		getContentPane().add(bdate);
		bdate.setColumns(10);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String join = sdf.format(new Date());
		bdate.setText(join);
		bdate.disable();
		String[] select ={"Select"};
		JComboBox selectvehicle = new JComboBox(select);
		selectvehicle.setBounds(461, 28, 90, 20);
		getContentPane().add(selectvehicle);
		
		type = new JTextField();
		type.setBounds(461, 211, 123, 20);
		getContentPane().add(type);
		type.setColumns(10);
		type.disable();
		try{
			Connection connection;
			connection =DBConnection.getDBConnection();
			String Query = "SELECT * FROM cars where Status='not rented'";
			Statement st = (Statement) connection.prepareStatement(Query);
			ResultSet rs;
			rs=st.executeQuery(Query);
			
			while(rs.next())
			{
				String name = rs.getString("V_model");
				selectvehicle.addItem(name);
			}
			
		}catch(Exception e)
		{
			
		}
		
		selectvehicle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				connection =DBConnection.getDBConnection();
				try
				{
					String cartype = (String) selectvehicle.getSelectedItem();
					String Query ="SELECT * FROM cars WHERE V_model='"+cartype+"'";
					Statement st = (Statement) connection.prepareStatement(Query);
					ResultSet rs;
					rs=st.executeQuery(Query);
					
					while(rs.next())
					{
						String carno = rs.getString("car_no");
						vehicleno.setText(carno);
						String capacity= rs.getString("Sitting_Capacity");
						type.setText(capacity);
						String Rent = rs.getString("rent");
						rent.setText(Rent);
						
						
					}
					
					
					
				}catch(Exception e1)
				{
					
				}
					
			
				
			}
		});
		
		btnBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				connection =DBConnection.getDBConnection();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dt1,dt2;
				Date date = new Date();
				dt1=enddate.getDate();
				dt2 =startdate.getDate();
				if((dt1.before(dt2))||((dt1.before(date))&&(dt2.before(date))))
				{
					JOptionPane.showMessageDialog(null, "please Check the date you entered");
				}
				else
				{
				String end = sdf.format(enddate.getDate());
				String start = sdf.format(startdate.getDate());
				
				
				
				
				
				try
				{
					if(inputcustomername.getText().isEmpty()||customeradd.getText().isEmpty() ||customerphone.getText().isEmpty() 
							|| selectvehicle.getSelectedItem().equals("Select"))
					{
						JOptionPane.showMessageDialog(null, "please Enter Required Fields");
					}
					else
					{
						String Query2 ="SELECT Driver_name FROM cars WHERE car_no='"+vehicleno.getText()+"'";
						PreparedStatement st2 = (PreparedStatement) connection.prepareStatement(Query2);
						ResultSet rs1 = st2.executeQuery();
						String drive=null;
						Random no = new Random();
						int number;
						int min=1000,max=1000000;
						
						number=no.nextInt(max-min+1)+min;
						
						String reference=Integer.toString(number);
						while(rs1.next())
						{
							drive = rs1.getString("Driver_name");
						}
						int num;
						String paid="notpaid";
					String Query ="INSERT INTO booking(customer_name,cust_add,cust_phone,start_date,end_date,booking_date,vehicle_name,car_number,Type,rent,paid,Driver_name,reference_id) VALUES('"+inputcustomername.getText()+"','"+customeradd.getText()+"','"+customerphone.getText()+"',"
							+ "'"+start+"','"+end+"','"+bdate.getText()+"','"+(String)selectvehicle.getSelectedItem()+"','"+vehicleno.getText()+"','"+type.getText()+"','"+rent.getText()+"','not paid','"+drive+"','"+number+"')";
					System.out.println(Query);
					//String Query ="INSERT INTO driver(Driver_name,Gender,Address,Phoneno,Experience,DOB,Date_of_joining,d_image,car_number) VALUES(?,?,?,?,?,?,?,?,?)";
					PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query,Statement.RETURN_GENERATED_KEYS);
					//st.setString(1, inputcustomername.getText());
					//st.setString(2, customeradd.getText());
					//st.setString(3, customerphone.getText());
					//st.setString(4, datestart);
					//st.setString(5, dateend);
					//st.setString(6, bdate.getText());
					//st.setString(7, (String)selectvehicle.getSelectedItem());
					//st.setString(8, (String)fuelExpense.getSelectedItem());
					//st.setString(9, vehicleno.getText());
					//st.setString(10, type.getText());
					//st.setString(11, rent.getText());
					
					System.out.println(Query);
					ResultSet rs;
						st.executeUpdate();
					rs=st.getGeneratedKeys();
					String last_inserted_id=null;
					if(rs.next())
	                {
	                    last_inserted_id = rs.getString(1);
	                }
					
					try
					{
						String Query1 ="UPDATE cars set Status='rented',b_id='"+last_inserted_id+"' where car_no='"+vehicleno.getText()+"'";
						System.out.println(Query1);
						PreparedStatement st1 = (PreparedStatement) connection.prepareStatement(Query1);
						st1.executeUpdate();
						//System.out.println(Query1);
					}catch(Exception e2)
					{
						JOptionPane.showMessageDialog(null, e2);
					}
					JOptionPane.showMessageDialog(null, "Record Saved");
					try
					{
						Connection conn;
						conn = DBConnection_booking.getDBConnection();
						String Query1 ="INSERT INTO customer_booking(b_id,vehicle_name,car_number,Type,rent,paid,Driver_name,reference_id) VALUES('"+last_inserted_id+"','"+(String)selectvehicle.getSelectedItem()+"','"+vehicleno.getText()+"','"+type.getText()+"','"+rent.getText()+"','not paid','"+drive+"','"+number+"')";
						//System.out.println(Query);
						//String Query ="INSERT INTO driver(Driver_name,Gender,Address,Phoneno,Experience,DOB,Date_of_joining,d_image,car_number) VALUES(?,?,?,?,?,?,?,?,?)";
						PreparedStatement st1 = (PreparedStatement) conn.prepareStatement(Query1);
						st1.executeUpdate();
						
						
						
						
						
						
					}catch(Exception e1)
					{
						
					}
					Connection conn1;
					conn1 = DBConnection_customer.getDBConnection();
					String Query3 ="INSERT INTO customer_details(b_id,customer_name,cust_add,cust_phone,start_date,end_date,booking_date) VALUES('"+last_inserted_id+"','"+inputcustomername.getText()+"','"+customeradd.getText()+"','"+customerphone.getText()+"',"
							+ "'"+start+"','"+end+"','"+bdate.getText()+"')";
					//String Query ="INSERT INTO driver(Driver_name,Gender,Address,Phoneno,Experience,DOB,Date_of_joining,d_image,car_number) VALUES(?,?,?,?,?,?,?,?,?)";
					PreparedStatement st5 = (PreparedStatement) conn1.prepareStatement(Query3);
					System.out.println(Query3);
					st5.executeUpdate();
					new getPDF(last_inserted_id,number).setVisible(true);
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
class getPDF extends JFrame
{
	public getPDF(String last_inserted_id,int number) throws FileNotFoundException, DocumentException {
		JFrame frame = new JFrame();
	
		frame.setSize(600, 600);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JLabel lbl = new JLabel("Your Booking is done");
		JButton pdf = new JButton("View Booking Slip");
		pdf.setPreferredSize(new Dimension(200,30));
		
		pan1.add(lbl);
		pan2.add(pdf);
		String reference=Integer.toString(number);
		pdf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String bookid=null,cust_name=null,start_date=null,end_date=null,booking_date=null,vehicle_name=null,fuelexpense=null,carno=null,type=null,Rent=null;
				try
				{
					Connection connection;
					ResultSet rs;
					connection =DBConnection.getDBConnection();
					String Query ="SELECT * FROM booking where b_id='"+last_inserted_id+"'";
					
					PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query);
					rs=st.executeQuery();
					
					while(rs.next())
					{
						bookid=rs.getString("b_id");
						cust_name=rs.getString("customer_name");
						start_date=rs.getString("start_date");
						end_date=rs.getString("end_date");
						booking_date=rs.getString("booking_date");
						vehicle_name=rs.getString("vehicle_name");
						
						carno=rs.getString("car_number");
						Rent=rs.getString("rent");
						type=rs.getString("Type");
					}
				
				
				String Filename ="Trip Number_"+last_inserted_id;
				com.itextpdf.text.Document document = new com.itextpdf.text.Document();
				PdfWriter.getInstance(document, new FileOutputStream(Filename+".pdf"));
				document.open();
				document.add(new Paragraph("Vehicle Management System booking Slip",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.BLACK)));
				document.add(new Paragraph("----------------------------------------------------------------------------------------"));
				//document.add(new Paragraph("Rent Information"));
				PdfPTable Table = new PdfPTable(2);
				PdfPCell cell = new PdfPCell(new Paragraph("Rent Information")); 
				cell.setColspan(4);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setBackgroundColor(BaseColor.GREEN);
				Table.addCell(cell);
				Table.addCell("Booking No");
				Table.addCell(bookid);
				Table.addCell("booking date");
				Table.addCell(booking_date);
				Table.addCell("Booking reference no");
				Table.addCell(reference);
				Table.addCell("start date");
				Table.addCell(start_date);
				Table.addCell("Customer Name");
				Table.addCell(cust_name);
				Table.addCell("Vehicle name");
				Table.addCell(vehicle_name);
				Table.addCell("end date");
				Table.addCell(end_date);
				
				Table.addCell("car number");
				Table.addCell(carno);
				Table.addCell("Type");
				Table.addCell(type);
				Table.addCell("Rent per day");
				Table.addCell(Rent);
				document.add(Table);
				document.add(new Paragraph("----------------------------------------------------------------------"));
				document.add(new Paragraph("1.Please Bring this Slip on Return Date \n2.Extra Charges Will be Taken if found in Damaged Condition"));
				document.close();
				//JOptionPane.showMessageDialog(null, "RecordSaved");
				Desktop.getDesktop().open(new File("C:\\Users\\hazup\\workspace\\vehicleManagement\\"+Filename+".pdf"));
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		frame.add(pan1,BorderLayout.NORTH);
		frame.add(pan2,BorderLayout.SOUTH);
		frame.setVisible(true);
		
		
	}
}
