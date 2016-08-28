package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class addCaradmin extends JFrame {

	private JPanel contentPane;
	String s;
	int flag=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCaradmin frame = new addCaradmin();
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
	public addCaradmin() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();

		setTitle("Add Car");
		setSize(900, 900);
		
		
		JPanel pan1 = new JPanel(new GridBagLayout());	
		JPanel pan2 = new JPanel(new GridBagLayout());
		JLabel carModel = new JLabel("Car Model: ");
		JLabel Company = new JLabel("Company: ");
		JLabel Carno = new JLabel("Car No: ");
		JLabel Makeyear = new JLabel("Make Year: ");
		JLabel useas = new JLabel("Use As: ");
		JLabel sitting = new JLabel("sitting Capacity: ");
		JLabel Enginetype = new JLabel("Engine Capacity: ");
		JLabel Type = new JLabel("Type: ");
		JLabel Variant = new JLabel("Variants: ");
		JLabel rent = new JLabel("Rent: ");
		JLabel UploadImg = new JLabel("Image: ");
		JLabel imglabel = new JLabel();
		imglabel.setPreferredSize(new Dimension(250,250));
		String[] uses ={"Select","taxi","Individual Rent"};
		String[] Sitting ={"Select Type","2 Seater","5 Seater","7 seater","8 seater","15 seater","24 seater","32 seater"};
		
		String[] typeselect ={"Select","AC","NON-AC"};
		String[] varient ={"Select","Base Model","Economic Model"};
		JTextField carmodel = new JTextField();
		carmodel.setPreferredSize(new Dimension(200,30));
		
		
		
		JTextField carnumber = new JTextField();
		carnumber.setPreferredSize(new Dimension(200,30));
		
		JTextField img1 = new JTextField();
		img1.setPreferredSize(new Dimension(200,30));
		JTextField makeyear = new JTextField();
		makeyear.setPreferredSize(new Dimension(200,30));
		
		
		JTextField EngineCapacity = new JTextField();
		EngineCapacity.setPreferredSize(new Dimension(200,30));
		
		
		JTextField Rent = new JTextField();
		Rent.setPreferredSize(new Dimension(200,30));
		
		JComboBox selectCompany= new JComboBox();
		
		JComboBox Useas= new JComboBox(uses);
		
		JComboBox capacity= new JComboBox(Sitting);
		JComboBox type= new JComboBox(typeselect);
		JComboBox variant= new JComboBox(varient);
		
		JButton imgchoose = new JButton("Choose Image");
		

		GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 30, 20, 10);
        
        JButton save = new JButton("Save");
        
        c.gridx=0;
        c.gridy=0;
        pan1.add(carModel,c);
        
        c.gridx=1;
        c.gridy=0;
        pan1.add(carmodel,c);
        
        
        
        c.gridx=0;
        c.gridy=1;
        pan1.add(Company,c);
        
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
			
		}
        c.gridx=1;
        c.gridy=1;
        pan1.add(selectCompany,c);
        
        
        c.gridx=0;
        c.gridy=2;
        pan1.add(Carno,c);
        
        
        c.gridx=1;
        c.gridy=2;
        pan1.add(carnumber,c);
        
        
        
        
        c.gridx=0;
        c.gridy=3;
        pan1.add(Makeyear,c);
        
        c.gridx=1;
        c.gridy=3;
        pan1.add(makeyear,c);
        
        
        
        c.gridx=0;
        c.gridy=4;
        pan1.add(useas,c);
        
        
        c.gridx=1;
        c.gridy=4;
        pan1.add(Useas,c);
        
        c.gridx=0;
        c.gridy=5;
        pan1.add(UploadImg,c);
        
        c.gridx=1;
        c.gridy=7;
        pan1.add(imglabel,c);
        
        c.gridx=1;
        c.gridy=5;
        pan1.add(img1,c);
        
        c.gridx=1;
        c.gridy=6;
        pan1.add(imgchoose,c);
        
        
        c.gridx=0;
        c.gridy=0;
        pan2.add(sitting,c);
        c.gridx=1;
        c.gridy=0;
        pan2.add(capacity,c);
        
        c.gridx=0;
        c.gridy=1;
        pan2.add(Enginetype,c);
        c.gridx=1;
        c.gridy=1;
        pan2.add(EngineCapacity,c);
        c.gridx=0;
        c.gridy=2;
        pan2.add(Type,c);
        c.gridx=1;
        c.gridy=2;
        pan2.add(type,c);
        
        c.gridx=0;
        c.gridy=3;
        pan2.add(Variant,c);
        c.gridx=1;
        c.gridy=3;
        pan2.add(variant,c);
        c.gridx=0;
        c.gridy=4;
        pan2.add(rent,c);
        c.gridx=1;
        c.gridy=4;
        pan2.add(Rent,c);
        c.gridx=0;
        c.gridy=5;
        pan2.add(save,c);
        
        
        imgchoose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser choose = new JFileChooser();
				choose.showOpenDialog(null);
				File f = choose.getSelectedFile();
				String filename = f.getAbsolutePath();
				
				img1.setText(filename);
				
				ImageIcon Myimg = new ImageIcon(filename);
				Image img = Myimg.getImage();
				Image newImg = img.getScaledInstance(imglabel.getWidth(),imglabel.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon finalimg = new ImageIcon(newImg);
				
				imglabel.setIcon(finalimg);
				s=filename;
				
			}
		});
        
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Connection connection;
					connection = DBConnection.getDBConnection();
					String Query = "INSERT INTO cars(V_model,v_Company,car_no,Use_as,v_image,Sitting_capacity,Engine_type,Type,Variants,Make_year,rent,Status,b_id,Driver_name) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement st =connection.prepareStatement(Query,Statement.RETURN_GENERATED_KEYS);
					InputStream is = new FileInputStream(new File(s));
					st.setString(1,carmodel.getText() );
					st.setString(2, (String) selectCompany.getSelectedItem());
					st.setString(3,carnumber.getText() );
					st.setString(4, (String) Useas.getSelectedItem());
					st.setBlob(5,is);
					st.setString(6,(String) capacity.getSelectedItem() );
					st.setString(7, EngineCapacity.getText());
					st.setString(8, (String) type.getSelectedItem());
					st.setString(9, (String) variant.getSelectedItem());
					st.setString(10, makeyear.getText());
					st.setString(11, Rent.getText());
					st.setString(12, "not rented");
					st.setString(13, "0");
					st.setString(14, "");
					ResultSet rs;
					st.executeUpdate();
				rs=st.getGeneratedKeys();
				String last_inserted_id=null;
				if(rs.next())
                {
                    last_inserted_id = rs.getString(1);
                }
					
					
					
					if(Useas.getSelectedItem().equals("taxi"))
					{
						Connection conn;
						conn = DBConnection_taxi.getDBConnection();
						String Query1 = "INSERT INTO ftaxi(vehicle_id,V_model,v_Company,car_no,Use_as,v_image,Sitting_capacity,Engine_type,Type,Variants,Make_year,rent,Status,b_id,Driver_name) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement st1 =conn.prepareStatement(Query1);
						InputStream is1 = new FileInputStream(new File(s));
						st1.setString(1,last_inserted_id );
						st1.setString(2,carmodel.getText() );
						st1.setString(3, (String) selectCompany.getSelectedItem());
						st1.setString(4,carnumber.getText() );
						st1.setString(5, (String) Useas.getSelectedItem());
						st1.setBlob(6,is1);
						st1.setString(7,(String) capacity.getSelectedItem() );
						st1.setString(8, EngineCapacity.getText());
						st1.setString(9, (String) type.getSelectedItem());
						st1.setString(10, (String) variant.getSelectedItem());
						st1.setString(11, makeyear.getText());
						st1.setString(12, Rent.getText());
						st1.setString(13, "not rented");
						st1.setString(14, "0");
						st1.setString(15, "");
						st1.executeUpdate();
						
					}
					else if(Useas.getSelectedItem().equals("Individual Rent"))
					{
						Connection conn;
						conn = DBConnection_individual.getDBConnection();
						String Query1 = "INSERT INTO findividual(vehicle_id,V_model,v_Company,car_no,Use_as,v_image,Sitting_capacity,Engine_type,Type,Variants,Make_year,rent,Status,b_id,Driver_name) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement st1 =conn.prepareStatement(Query1);
						InputStream is1 = new FileInputStream(new File(s));
						st1.setString(1,last_inserted_id );
						st1.setString(2,carmodel.getText() );
						st1.setString(3, (String) selectCompany.getSelectedItem());
						st1.setString(4,carnumber.getText() );
						st1.setString(5, (String) Useas.getSelectedItem());
						st1.setBlob(6,is1);
						st1.setString(7,(String) capacity.getSelectedItem() );
						st1.setString(8, EngineCapacity.getText());
						st1.setString(9, (String) type.getSelectedItem());
						st1.setString(10, (String) variant.getSelectedItem());
						st1.setString(11, makeyear.getText());
						st1.setString(12, Rent.getText());
						st1.setString(13, "not rented");
						st1.setString(14, "0");
						st1.setString(15, "");
						st1.executeUpdate();
						
					}
					
					
					JOptionPane.showMessageDialog(null, "Vehicle Added");
					
					 
					
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
		});
		
		
		
		add(pan1, BorderLayout.WEST);
		add(pan2 , BorderLayout.CENTER);
		setVisible(true);
	}

}
