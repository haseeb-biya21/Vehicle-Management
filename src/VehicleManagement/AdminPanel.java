package vehicleManagement;

import java.io.File;
import java.lang.Thread.State;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
public class AdminPanel extends JFrame{
	
public AdminPanel()
{
	JFrame frame= new JFrame("Admin Panel");
	
	frame.setSize(600, 600);
	
	
	BufferedImage image=null;
	
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JMenuBar menubar = new JMenuBar();	
	
	
	
	
	JMenu Driver = new JMenu("Driver");
	menubar.add(Driver);
	JMenuItem addDriver = new JMenuItem("Add Driver");
	Driver.add(addDriver);
	JMenuItem DriverRecords = new JMenuItem("View Driver List");
	Driver.add(DriverRecords);
	JMenuItem modify = new JMenuItem("Modify");
	Driver.add(modify);
	
	addDriver.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddDriver().setVisible(true);
			
		}
	});
	DriverRecords.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new viewDriverList().setVisible(true);
			
		}
	});
	modify.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new modifyDriver().setVisible(true);
			
		}
	});
	
	JMenu Vehicle = new JMenu("Vehicle");
	menubar.add(Vehicle);
	JMenuItem addCarCompany = new JMenuItem("Add Car Company");
	Vehicle.add(addCarCompany);
	JMenuItem addCar = new JMenuItem("Add Car");
	Vehicle.add(addCar);
	JMenuItem modifyCar = new JMenuItem("Modify");
	Vehicle.add(modifyCar);
	
	
	modifyCar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new modifycar().setVisible(true);
			
		}
	});
	
	JMenuItem ViewCar = new JMenuItem("View Car Details");
	Vehicle.add(ViewCar);
	
	addCarCompany.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new addCompany().setVisible(true);
			
		}
	});
	ViewCar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new viewCarList().setVisible(true);
			
		}
	});
	addCar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new addCaradmin().setVisible(true);
			
		}
	});
	
	JMenu booking_query = new JMenu("Booking Query Or Return");
	menubar.add(booking_query);
	
	JMenuItem showbook = new JMenuItem("show Booking Detail");
	booking_query.add(showbook);
	showbook.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new showbookingDetails().setVisible(true);
			
		}
	});
	
	JMenuItem Return = new JMenuItem("Return Vehicle");
	booking_query.add(Return);
	Return.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new returnCar().setVisible(true);
			
		}
	});
	
	JMenu Others = new JMenu("Others");
	menubar.add(Others);
	
	JMenuItem changepass = new JMenuItem("change username and password");
	Others.add(changepass);
	JMenuItem Logout = new JMenuItem("logout");
	Others.add(Logout);
	changepass.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new updatepass().setVisible(true);
			
		}
	});
	frame.setJMenuBar(menubar);
	
	
	Logout.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			loginform l=new loginform();
			l.setVisible(true);
			frame.dispose();
			
			
		}
	});
	frame.pack();
	frame.setVisible(true);
	frame.setResizable(false);
}
	public static void main(String[] args) {
		new AdminPanel();

	}

}

class AddEmployee extends JFrame
{
		public AddEmployee() {
			JFrame frame= new JFrame("Add Employee");
			frame.setSize(1000, 600);
			frame.setResizable(false);
			frame.setVisible(true);
			JPanel pan2 = new JPanel(new GridBagLayout());
			JPanel pan3 = new JPanel(new GridBagLayout());
			JPanel pan4 = new JPanel(new GridBagLayout());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
			String join = sdf.format(new Date());
			String[] qualification ={"N/A","10","10+2"};
			String[] day ={"1","2","3","4","5","6","7","8","9","10"};
			
			String[] month ={"01","02","03","04","05","06","07","08"
					,"09","10","11","12"};
			String[] year ={"1985","1986","1987","1988"};
			  JLabel employeename = new JLabel("Name");
			  JLabel Gender = new JLabel("Gender");
			  JLabel Address = new JLabel("Address");
			  JLabel DOB= new JLabel("DOB");
			  JLabel Qualification = new JLabel("Qualification");
			  JLabel PhoneNo = new JLabel("Phone No:");
			  JLabel Username = new JLabel("Username");
			  JLabel Password = new JLabel("password");
			  JLabel DateofJoining = new JLabel("Date OF joining");
			  JComboBox combo = new JComboBox(qualification);
			  
			  JComboBox dateday = new JComboBox(day);
			  JComboBox datemonth = new JComboBox(month);
			  JComboBox dateyear = new JComboBox(year);
			  
			  JRadioButton male= new JRadioButton("Male");
			  male.setActionCommand("Male");
			  JRadioButton female= new JRadioButton("female");
			  female.setActionCommand("Female");
			  ButtonGroup group= new ButtonGroup();
			  group.add(male);
			  group.add(female);
			  JTextField Employeename = new JTextField();
		        Employeename.setPreferredSize(new Dimension(200,30));
		        JTextArea address= new JTextArea();
		        address.setPreferredSize(new Dimension(200,100));
		        
		        JTextField Phoneno = new JTextField();
		        Phoneno.setPreferredSize(new Dimension(200,30));
		        JTextField username = new JTextField();
		        username.setPreferredSize(new Dimension(200,30));
		        JPasswordField password = new JPasswordField();
		        password.setPreferredSize(new Dimension(200,30));
		        
		        JTextField date = new JTextField(join.toString());
		        date.setPreferredSize(new Dimension(200,30));
		        JButton submit = new JButton("Add");
			  GridBagConstraints c = new GridBagConstraints();
		        c.insets = new Insets(0, 10, 20, 0);
		       
		       
		        
		        GridBagConstraints c1 = new GridBagConstraints();
		        c1.insets = new Insets(5, 5, 5, 0);
		       
		        
		        
		        
		        c.gridx=0;
		        c.gridy=0;
		        pan2.add(employeename,c);
		        
		        c.gridx=1;
		        c.gridy=0;
		        pan2.add(Employeename,c);
		        
		        
		        
		        c.gridx=0;
		        c.gridy=1;
		        pan2.add(Gender,c);
		        
		        
		        c.gridx=0;
		        c.gridy=2;
		        pan2.add(Address,c);
		        c.gridx=1;
		        c.gridy=2;
		        pan2.add(address,c);
		        
		        c.gridx=0;
		        c.gridy=3;
		        pan2.add(DOB,c);
		        
		        c.gridx=1;
		        c.gridy=3;
		        pan2.add(dateday,c);
		        
		        c.gridx=2;
		        c.gridy=3;
		        pan2.add(datemonth,c);
		        
		        c.gridx=3;
		        c.gridy=3;
		        pan2.add(dateyear,c);
		        
		        
		        c.gridx=0;
		        c.gridy=4;
		        pan2.add(Qualification,c);
		        
		        c.gridx=1;
		        c.gridy=4;
		        pan2.add(combo,c);
		        
		        c.gridx=1;
		        c.gridy=1;
		        pan2.add(male,c);
		        c.gridx=2;
		        c.gridy=1;
		        pan2.add(female,c);
		        
		        c.gridx=0;
		        c.gridy=0;
		        pan3.add(PhoneNo,c);
		        c.gridx=0;
		        c.gridy=1;
		        pan3.add(Username,c);
		        c.gridx=0;
		        c.gridy=2;
		        pan3.add(Password,c);
		        c.gridx=0;
		        c.gridy=3;
		        pan3.add(DateofJoining,c);
		        
		        c.gridx=1;
		        c.gridy=0;
		        pan3.add(Phoneno,c);
		        c.gridx=1;
		        c.gridy=1;
		        pan3.add(username,c);
		        c.gridx=1;
		        c.gridy=2;
		        pan3.add(password,c);
		        c.gridx=1;
		        c.gridy=3;
		        pan3.add(date,c);
		        c.gridx=1;
		        c.gridy=4;
		        pan3.add(submit,c);
		        
		        frame.add(pan2);
		        
		        frame.add(pan3,BorderLayout.EAST);
		       
		        submit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
					
						Connection connection;
						connection = DBConnection.getDBConnection();
						if(connection == null)
						{
							JOptionPane.showMessageDialog(null, "Error Connection Database");
						}
						else
						{
							
							String empname=Employeename.getText();
							String empaddress=address.getText();
							String empusername=username.getText();
							String emppassword= password.getText();
							String dateofjoin=join;
							String day= (String) dateday.getSelectedItem();
							String month= (String) datemonth.getSelectedItem();
							String year= (String) dateyear.getSelectedItem();
							String empdob= day+"-"+month+"-"+year;
							String qualification=(String) combo.getSelectedItem();
							String phoneno=Phoneno.getText();
							
							
							
							String gender =group.getSelection().getActionCommand();
							
							String Query="INSERT INTO employee(Emp_name,Phoneno,Address,username,password,DOB,Date_of_joining,qualification,Gender) VALUES('"+empname+"','"+phoneno+"','"+empaddress+"','"+empusername+"',"
									+ "'"+emppassword+"','"+empdob+"','"+dateofjoin+"','"+qualification+"','"+gender+"')";
							try {
								Statement st = connection.createStatement();
								System.out.println(Query);
								st.executeUpdate(Query);
								JOptionPane.showMessageDialog(null, "Employee Added", "Employee info", JOptionPane.INFORMATION_MESSAGE);
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e);
							}
							
							
						}
						
						
					}
				});
		        
		}
		
}
class addCompany extends JFrame {
	
	public addCompany() {
		JFrame frame= new JFrame("Add Car Company");
		frame.setSize(500, 300);
		
		JPanel pan1 = new JPanel(new GridBagLayout());
		JComboBox selectCompany = new JComboBox();
		JLabel added = new JLabel("List of Added Company");
		JLabel newcompany = new JLabel("Type name of Company :");
		
		JTextField getname = new JTextField();
		JButton save = new JButton("Save");
		getname.setPreferredSize(new Dimension(200,30));
		
		 try 
			{
	        	Connection con;
	        	con=DBConnection.getDBConnection();
				String Query ="SELECT Car_name from car_brands";
				Statement st = (Statement) con.prepareStatement(Query);
				ResultSet rs=null;
				rs=st.executeQuery(Query);
				
				while(rs.next())
				{
					String name = rs.getString("Car_name");
					selectCompany.addItem(name);
				}
				
				
			}catch(Exception e )
			{
				JOptionPane.showMessageDialog(null, e);
			}
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 30, 20, 10);
		c.gridx=0;
		c.gridy=0;
		pan1.add(added,c);
		
		c.gridx=1;
		c.gridy=0;
		pan1.add(selectCompany,c);
		
		c.gridx=0;
		c.gridy=1;
		pan1.add(newcompany,c);
		
		c.gridx=1;
		c.gridy=1;
		pan1.add(getname,c);
		
		c.gridx=1;
		c.gridy=2;
		pan1.add(save,c);
		
		frame.add(pan1,BorderLayout.CENTER);
		frame.setVisible(true);
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String input = getname.getText();
				try
				{
					Connection con;
					con = DBConnection.getDBConnection();
					String Query ="Select * FROM car_brands where Car_name='"+input+"'";
					Statement st = con.prepareStatement(Query);
					ResultSet rs=null;
					rs=st.executeQuery(Query);
					
					if(rs.next()== true)
					{
						JOptionPane.showMessageDialog(null, "Company Name Already Exists");
					}
					else
					{
						String Query1 ="INSERT INTO car_brands(Car_name) VALUE('"+input+"')";
						Statement st1 = con.prepareStatement(Query1);
						
						st1.executeUpdate(Query1);
						
						JOptionPane.showMessageDialog(null, "Saved");
						
					}
					
					
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
		});
	}
	
}

