package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import java.awt.Choice;

import javax.swing.JFileChooser;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import org.jdatepicker.util.JDatePickerUtil;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class AddDriver extends JFrame {
	private JTextField input_name;
	private JTextField input_phone;
	private JTextField date_of_join;
	private JTextField filepath;
	private JTextField input_carno;
	private JTable table;
	String s;
	/**
	 * @wbp.nonvisual location=108,339
	 */
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDriver frame = new AddDriver();
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
	public AddDriver() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 470);
		setTitle("Add Driver");
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 28, 46, 14);
		getContentPane().add(lblName);
		
		input_name = new JTextField();
		input_name.setBounds(87, 25, 125, 23);
		getContentPane().add(input_name);
		input_name.setColumns(10);
		
		JLabel Gender = new JLabel("Gender:");
		Gender.setBounds(10, 66, 46, 14);
		getContentPane().add(Gender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(87, 62, 64, 23);
		rdbtnMale.setActionCommand("Male");
		getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(153, 62, 73, 23);
		rdbtnFemale.setActionCommand("Female");
		getContentPane().add(rdbtnFemale);
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(rdbtnFemale);
		group.add(rdbtnMale);
		JLabel Address = new JLabel("Address: ");
		Address.setBounds(10, 107, 67, 14);
		getContentPane().add(Address);
		
		JTextArea input_address = new JTextArea();
		input_address.setBounds(87, 102, 125, 80);
		getContentPane().add(input_address);
		
		JLabel lblNewLabel = new JLabel("Phone no");
		lblNewLabel.setBounds(10, 211, 67, 14);
		getContentPane().add(lblNewLabel);
		
		input_phone = new JTextField();
		input_phone.setBounds(87, 208, 125, 29);
		getContentPane().add(input_phone);
		input_phone.setColumns(10);
		
		JLabel lblExperience = new JLabel("Experience: ");
		lblExperience.setBounds(10, 259, 73, 14);
		getContentPane().add(lblExperience);
		String[] experience ={"Select","No experience","less than 1 year","1-2years","2-3 years","3-4years","above 5","above 10year"};
		JComboBox experiencecom = new JComboBox(experience);
		experiencecom.setBounds(87, 256, 100, 20);
		getContentPane().add(experiencecom);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(10, 301, 46, 14);
		getContentPane().add(lblDob);
		
		JLabel lblDateOfJoin = new JLabel("Date of Join");
		lblDateOfJoin.setBounds(10, 350, 73, 14);
		getContentPane().add(lblDateOfJoin);
		
		date_of_join = new JTextField();
		date_of_join.setBounds(87, 347, 125, 29);
		getContentPane().add(date_of_join);
		date_of_join.setColumns(10);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String join = sdf.format(new Date());
		
		date_of_join.setText(join);
		
		
		JLabel label = new JLabel("");
		label.setBounds(267, 11, 125, 120);
		getContentPane().add(label);
		
		JButton btnChooseImage = new JButton("Choose Image");
		btnChooseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser file = new JFileChooser();
				file.showOpenDialog(null);
				File f = file.getSelectedFile();
				String Filename = f.getAbsolutePath();
				filepath.setText(Filename);
				s=Filename;
				try
				{
					ImageIcon MyImage = new ImageIcon(Filename);
					Image img = MyImage.getImage();
					Image newimg = img.getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon image = new ImageIcon(newimg);
					label.setIcon(image);
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnChooseImage.setBounds(267, 180, 125, 23);
		getContentPane().add(btnChooseImage);
		
		filepath = new JTextField();
		filepath.setBounds(267, 149, 200, 20);
		getContentPane().add(filepath);
		filepath.setColumns(10);
		
		JLabel lblSelectComapany = new JLabel("Select Company :");
		lblSelectComapany.setBounds(506, 28, 119, 14);
		getContentPane().add(lblSelectComapany);
		
		JComboBox selectComp = new JComboBox();
		selectComp.setBounds(635, 26, 119, 20);
		getContentPane().add(selectComp);
		
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
				selectComp.addItem(name);
			}
			
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
	
		
		JButton btnShowAvailableCars = new JButton("Show Available cars");
		btnShowAvailableCars.setBounds(858, 66, 170, 23);
		getContentPane().add(btnShowAvailableCars);
		
		JLabel lblCarNumber = new JLabel("Car Number");
		lblCarNumber.setBounds(516, 107, 90, 14);
		getContentPane().add(lblCarNumber);
		
		input_carno = new JTextField();
		input_carno.setBounds(616, 104, 113, 20);
		getContentPane().add(input_carno);
		input_carno.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(257, 383, 89, 23);
		getContentPane().add(btnSubmit);
		
		JDateChooser inputdateChooser = new JDateChooser();
		inputdateChooser.setBounds(87, 301, 125, 20);
		getContentPane().add(inputdateChooser);
		
		
		btnShowAvailableCars.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connection;
					connection = DBConnection.getDBConnection();
				String carname=(String) selectComp.getSelectedItem();
				String Query ="SELECT * FROM cars where Driver_name='' and v_Company ='"+carname+"'";
			
				ResultSet rs;
				PreparedStatement pst=null;
				Statement st = connection.prepareStatement(Query);
				rs=st.executeQuery(Query);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(516, 153, 700, 200);
				getContentPane().add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						int i = table.getSelectedRow();
						String carno = (table.getModel().getValueAt(i, 3).toString());
						String Query ="SELECT car_no FROM cars where car_no ='"+carno+"'";
						try {
							Statement st =connection.prepareStatement(Query);
							ResultSet rs=null;
							rs=st.executeQuery(Query);
							if(rs.next())
							{
								String carnumber=rs.getString("car_no");
								input_carno.setText(carnumber);
								
							}
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
					}
				});
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			
				
			}
		});
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Connection connection;
				connection = DBConnection.getDBConnection();
				
				
				
				if(input_name.getText().isEmpty() || group.getSelection().getActionCommand().isEmpty() ||
						input_address.getText().isEmpty() || input_phone.getText().isEmpty() || date_of_join.getText().isEmpty()
						||input_carno.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				}
				else
				{
				String Query ="INSERT INTO driver(Driver_name,Gender,Address,Phoneno,Experience,DOB,Date_of_joining,d_image,car_number) VALUES(?,?,?,?,?,?,?,?,?)";
				//String Query = "INSERT INTO cars(V_model,v_Company,car_no,Use_as,v_image,Sitting_capacity,Engine_type,Type,Variants,Make_year,rent) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
				//String name = input_name.getText();
				//String gender = group.getSelection().getActionCommand();
				//String Address = input_address.getText();
				//String Phoneno =input_phone.getText();
				//String experience = (String) experiencecom.getSelectedItem();
				Date dob = inputdateChooser.getDate();
				String date =DateFormat.getDateInstance().format(dob);
				//String joindate = date_of_join.getText();
				//String carno = input_carno.getText();
				
				try {
					InputStream is;
					is = new FileInputStream(new File(s));
					PreparedStatement st =(PreparedStatement) connection.prepareStatement(Query);
					st.setString(1, input_name.getText());
					st.setString(2, group.getSelection().getActionCommand());
					st.setString(3, input_address.getText());
					st.setString(4, input_phone.getText());
					st.setString(5, (String) experiencecom.getSelectedItem());
					st.setString(6, date);
					st.setString(7, date_of_join.getText());
					st.setBlob(8,is);
					st.setString(9, input_carno.getText());
					st.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Driver Added");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				String query1 ="UPDATE cars set Driver_name='"+input_name.getText()+"' where car_no='"+input_carno.getText()+"'";
				System.out.println(query1);
				try {
					Statement st = connection.prepareStatement(query1);
					st.executeUpdate(query1);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				input_address.setText("");
				input_carno.setText("");
				input_name.setText("");
				input_phone.setText("");
				group.clearSelection();
				label.setText("");
				filepath.setText("");
				experiencecom.setSelectedIndex(0);
				
				}
			}
		});	
		
	}

}
