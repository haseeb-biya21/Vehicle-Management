package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.JobAttributes.DialogType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class modifyDriver extends JFrame {
	private JTextField inputname;
	private JTextField inputphone;
	private JTextField filepath;
	String s;
	/**
	 * @wbp.nonvisual location=-19,229
	 */
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifyDriver frame = new modifyDriver();
					frame.setTitle("Driver Modification Panel");
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
	public modifyDriver() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 418);
		setTitle("Modify Driver");
		getContentPane().setLayout(null);
		
		JLabel name = new JLabel("Name");
		name.setBounds(10, 10, 49, 50);
		getContentPane().add(name);
		
		inputname = new JTextField();
		inputname.setBounds(93, 20, 135, 31);
		getContentPane().add(inputname);
		inputname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 60, 73, 50);
		getContentPane().add(lblAddress);
		
		JTextArea inputaddress = new JTextArea();
		inputaddress.setBounds(93, 73, 135, 74);
		getContentPane().add(inputaddress);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setBounds(10, 187, 73, 50);
		getContentPane().add(lblPhoneNo);
		
		inputphone = new JTextField();
		inputphone.setBounds(93, 193, 135, 39);
		getContentPane().add(inputphone);
		inputphone.setColumns(10);
		
		JLabel lblExperience = new JLabel("Experience");
		lblExperience.setBounds(10, 261, 73, 50);
		getContentPane().add(lblExperience);
		JLabel display = new JLabel("");
		display.setBounds(381, 20, 200, 206);
		getContentPane().add(display);
		String[] experience ={"Select","No experience","less than 1 year","1-2years","2-3 years","3-4years","above 5","above 10year"};
		JComboBox inputcombo = new JComboBox(experience);
		inputcombo.setBounds(110, 276, 100, 20);
		getContentPane().add(inputcombo);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = inputname.getText();
				if(name.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter a Name to Search");
				}
				else
				{
					Connection connection;
					connection = DBConnection.getDBConnection();
					try
					{
						String Query = "SELECT * FROM driver where Driver_name='"+name+"'";
						ResultSet rs;
						PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query);
						rs=st.executeQuery();
						if(rs.next())
						{
							String address=rs.getString("Address");
							inputaddress.setText(address);
							String phone=rs.getString("Phoneno");
							inputphone.setText(phone);
							String exprience=rs.getString("Experience");
							inputcombo.setSelectedItem(exprience);
							byte[] img = rs.getBytes("d_image");
							ImageIcon image = new ImageIcon(img);
							
							Image myimg =image.getImage().getScaledInstance(display.getWidth(), display.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon newimg = new ImageIcon(myimg);
							
							display.setIcon(newimg);
							
						}
						else if(!rs.next())
						{
							JOptionPane.showMessageDialog(null, "No user Found with Entered Name");
						}
						
						
					}catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		btnSearch.setBounds(237, 24, 89, 23);
		getContentPane().add(btnSearch);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(92, 330, 89, 23);
		getContentPane().add(btnUpdate);
		
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(inputaddress.getText().isEmpty() || inputphone.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter the Required Field");
				}
				else
				{
					Connection connection;
					connection=DBConnection.getDBConnection();
					String address = inputaddress.getText();
					String phone = inputphone.getText();
					String experience = (String) inputcombo.getSelectedItem();
					
					if(!filepath.getText().isEmpty())
					{
						try
						{
							InputStream is;
							is = new FileInputStream(new File(s));
							String Query ="UPDATE driver set Address=(?),Phoneno=(?),Experience=(?),d_image=(?) where Driver_name='"+inputname.getText()+"'";
							PreparedStatement st =(PreparedStatement) connection.prepareStatement(Query);
							
							st.setString(1, inputaddress.getText());
							st.setString(2, inputphone.getText());
							st.setString(3, (String)inputcombo.getSelectedItem());
							st.setBlob(4, is);
							st.executeUpdate();
							JOptionPane.showMessageDialog(null, "Updated");
							
						}catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, e1);
						}
					}else
					{
						try
						{
							
							String Query ="UPDATE driver set Address=(?),Phoneno=(?),Experience=(?) where Driver_name='"+inputname.getText()+"'";
							PreparedStatement st =(PreparedStatement) connection.prepareStatement(Query);
							
							st.setString(1, inputaddress.getText());
							st.setString(2, inputphone.getText());
							st.setString(3, (String)inputcombo.getSelectedItem());
							
							st.executeUpdate();
							JOptionPane.showMessageDialog(null, "Updated");
							
						}catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, e1);
						}
					}
					
				}
			}
		});
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(237, 330, 89, 23);
		getContentPane().add(btnDelete);
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name=inputname.getText();
				if(name.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter Driver Name");
				}
				else
				{
				 int select=JOptionPane.showConfirmDialog(null, "Are You sure ??");
				
				
				if(select == JOptionPane.YES_OPTION)
				{
					Connection connection;
					connection =DBConnection.getDBConnection();
					try
					{
						String Query ="DELETE FROM driver where Driver_name='"+name+"'";
						PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Driver Deleted");
					}catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
					
					}
					String Query ="UPDATE cars set Driver_name='none' where Driver_name='"+name+"'";
					PreparedStatement st;
					try {
						st = (PreparedStatement) connection.prepareStatement(Query);
						st.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				}
				
			}
		});
		
		filepath = new JTextField();
		filepath.setBounds(381, 250, 200, 27);
		getContentPane().add(filepath);
		filepath.setColumns(10);
		JButton btnNewButton = new JButton("Change Picture");
		btnNewButton.addActionListener(new ActionListener() {
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
					Image newimg = img.getScaledInstance(display.getWidth(),display.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon image = new ImageIcon(newimg);
					display.setIcon(image);
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnNewButton.setBounds(407, 288, 135, 23);
		getContentPane().add(btnNewButton);
		
		
		
	}
}
