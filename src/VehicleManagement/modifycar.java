package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class modifycar extends JFrame {
	private JTextField inputname;
	private JTextField inputcar;
	private JTextField filepath;
	String s;
	private JPanel contentPane;
	private JTextField rent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifycar frame = new modifycar();
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
	public modifycar() {
		setBounds(100, 100, 689, 418);
		setTitle("Modify Car");
		getContentPane().setLayout(null);
		
		JLabel name = new JLabel("Name");
		name.setBounds(10, 10, 49, 50);
		getContentPane().add(name);
		
		inputname = new JTextField();
		inputname.setBounds(93, 20, 135, 31);
		getContentPane().add(inputname);
		inputname.setColumns(10);
		
		JLabel lblRent = new JLabel("Rent");
		lblRent.setBounds(10, 201, 46, 14);
		getContentPane().add(lblRent);
		
		rent = new JTextField();
		rent.setBounds(95, 198, 133, 20);
		getContentPane().add(rent);
		rent.setColumns(10);
		
		
		JLabel lblcarno = new JLabel("Car no");
		lblcarno.setBounds(10, 85, 73, 50);
		getContentPane().add(lblcarno);
		
		inputcar = new JTextField();
		inputcar.setBounds(93, 91, 135, 39);
		getContentPane().add(inputcar);
		inputcar.setColumns(10);
		
		JLabel lbluseas = new JLabel("Use as");
		lbluseas.setBounds(10, 261, 73, 50);
		getContentPane().add(lbluseas);
		JLabel display = new JLabel("");
		display.setBounds(381, 20, 200, 206);
		getContentPane().add(display);
		String[] Useas ={"Select","Individual Rent","Taxi"};
		JComboBox useascombo = new JComboBox(Useas);
		useascombo.setBounds(110, 276, 100, 20);
		getContentPane().add(useascombo);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String V_model = inputname.getText();
				if(V_model.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter a Name to Search");
				}
				else
				{
					Connection connection;
					connection = DBConnection.getDBConnection();
					try
					{
						String Query = "SELECT * FROM cars where V_model='"+V_model+"'";
						ResultSet rs;
						PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query);
						rs=st.executeQuery();
						if(rs.next())
						{
							
							String phone=rs.getString("car_no");
							inputcar.setText(phone);
							String Rent=rs.getString("rent");
							rent.setText(Rent);
							String exprience=rs.getString("Use_as");
							useascombo.setSelectedItem(exprience);
							byte[] img = rs.getBytes("v_image");
							ImageIcon image = new ImageIcon(img);
							
							Image myimg =image.getImage().getScaledInstance(display.getWidth(), display.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon newimg = new ImageIcon(myimg);
							
							display.setIcon(newimg);
							
						}
						else if(!rs.next())
						{
							JOptionPane.showMessageDialog(null, "No Car Found with Entered Name");
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
				
				if(inputname.getText().isEmpty() || inputcar.getText().isEmpty() || rent.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter the Required Field");
				}
				else
				{
					Connection connection;
					connection=DBConnection.getDBConnection();
					String name = inputname.getText();
					String phone = inputcar.getText();
					String experience = (String) useascombo.getSelectedItem();
					String Rent = rent.getText();
					if(!filepath.getText().isEmpty())
					{
						try
						{
							InputStream is;
							is = new FileInputStream(new File(s));
							String Query ="UPDATE cars set V_model=(?),car_no=(?),Use_as=(?),d_image=(?),rent=(?) where V_model='"+inputname.getText()+"'";
							PreparedStatement st =(PreparedStatement) connection.prepareStatement(Query);
							
							st.setString(1, inputname.getText());
							st.setString(2, inputcar.getText());
							st.setString(3, (String)useascombo.getSelectedItem());
							st.setBlob(4, is);
							st.setString(5, rent.getText());
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
							
							String Query ="UPDATE cars set V_model=(?),car_no=(?),Use_as=(?),rent=(?) where V_model='"+inputname.getText()+"'";
							PreparedStatement st =(PreparedStatement) connection.prepareStatement(Query);
							
							st.setString(1, inputname.getText());
							st.setString(2, inputcar.getText());
							st.setString(3, (String)useascombo.getSelectedItem());
							st.setString(4, rent.getText());
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
					JOptionPane.showMessageDialog(null, "Please Enter Car Name");
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
						String Query ="DELETE FROM cars where V_model='"+name+"'";
						PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Car Deleted");
					}catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
					
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
