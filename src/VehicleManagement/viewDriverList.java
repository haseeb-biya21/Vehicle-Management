package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class viewDriverList extends JFrame {

	private JPanel contentPane;
	Connection connection;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewDriverList frame = new viewDriverList();
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
	public viewDriverList() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setSize(1400, 500);
		setTitle("Driver List");
		JPanel pan1= new JPanel();
		JPanel pan2= new JPanel();
		JLabel list =new JLabel("Driver List");
		
		pan1.add(list);
		try
		{
			
			connection = DBConnection.getDBConnection();
			if(connection ==  null)
			{
				JOptionPane.showMessageDialog(null, "Error Connecting Database");
			}
			else
			{
				
				String Query ="SELECT * FROM driver";
				ResultSet rs;
				PreparedStatement pst=null;
				Statement st = connection.prepareStatement(Query);
				rs=st.executeQuery(Query);
				ImageIcon format,image;
				Image img,newImage;
				DefaultTableModel model1 = new DefaultTableModel(new String[]{"Driver id","Driver Name","gender","Address","Phoneno","Experience","DOB","Date of joining","Car number","image"},0);
				
				
				
				
				
				//table.getColumnModel().getColumn(4).setCellRenderer(ImageIcon.class);
				
				
			
			
			
				 
				
			    	while(rs.next())
			        {
			            String col1 = rs.getString("Driver_id");
			            String col2 = rs.getString("Driver_name");
			            String col3 = rs.getString("Gender");
			            String col4 = rs.getString("Address");                
			            String col5 = rs.getString("Phoneno");
			            String col6 = rs.getString("Experience");
			            String col7 = rs.getString("DOB");
			            String col8 = rs.getString("Date_of_joining");
			            String col9 = rs.getString("car_number");
			            byte[]imagedata= rs.getBytes("d_image");
			            
			            format = new ImageIcon(imagedata);
			            img = format.getImage();
			            newImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			            image = new ImageIcon(newImage);
			            		//String col18 = col18

			           // mod.addRow(new Object[]{xx, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), newIconImage, rs.getString(25), rs.getString(26), rs.getString(27)});

			            model1.addRow(new Object[]{col1, col2, col3,col4,col5,col6,col7,col8,col9,image});


			        }
			    	 JTable table = new JTable( model1 )
				        {
				            //  Returning the Class of each column will allow different
				            //  renderers to be used based on Class
				            public Class getColumnClass(int column)
				            {
				                if(column == 9)
				                	return ImageIcon.class;
								return Object.class;
				            }
				        };
				table.setModel(model1);
				table.setPreferredScrollableViewportSize(table.getPreferredSize());
		        JScrollPane scrollPane = new JScrollPane( table );
		        scrollPane.setBounds(10, 30, 1300, 1900);
		        add( scrollPane );
		       table.setRowHeight(100);
			
				
				
				
			}
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		add(pan1,BorderLayout.NORTH);
		add(pan2, BorderLayout.SOUTH);
		setVisible(true);
	}

}
