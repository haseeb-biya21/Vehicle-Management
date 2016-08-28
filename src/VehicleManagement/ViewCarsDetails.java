package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ViewCarsDetails extends JFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCarsDetails frame = new ViewCarsDetails();
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
	public ViewCarsDetails() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 1000);
		getContentPane().setLayout(null);
		
		//JScrollPane scrollPane = new JScrollPane();
		
		//getContentPane().add(scrollPane);
		
		table = new JTable();
		
		
		
		
		
		try
		{
			Connection conn1;
			conn1 = DBConnection.getDBConnection();
			Connection conn2tax;
			conn2tax = DBConnection_taxi.getDBConnection();
			if(conn1 ==  null || conn2tax == null)
			{
				JOptionPane.showMessageDialog(null, "Error Connecting Database");
			}
			else
			{
				
				
				
				ImageIcon format = null;
				String Query ="SELECT V_model,v_Company,car_no,Use_as,v_image,Sitting_capacity,Type,rent"
						+ " FROM taxi.ftaxi UNION "
						+ "SELECT V_model,v_Company,car_no,Use_as,v_image,Sitting_capacity,Type,rent "
						+ "FROM individual_rent.findividual";
				ResultSet rs;
				PreparedStatement pst=null;
				Statement st = conn1.prepareStatement(Query);
				rs=st.executeQuery(Query);
				
				
				DefaultTableModel model1 = new DefaultTableModel(new String[]{"Vehicle Name","Vehicle Company","Car number","Use_as","Sitting Capacity","Type","Rent","image"},0);
				
				
				
				
				
				//table.getColumnModel().getColumn(4).setCellRenderer(ImageIcon.class);
				
				
			
			
			
				 
				Image img= null;
				Image newImage=null;
				ImageIcon image = null;
			    	while(rs.next())
			        {
			            String col1 = rs.getString("V_model");
			            String col2 = rs.getString("v_Company");
			            String col3 = rs.getString("car_no");
			            String col4 = rs.getString("Use_as");                
			            String col5 = rs.getString("Sitting_capacity");
			            String col6 = rs.getString("Type");
			            String col7 = rs.getString("rent");
			            byte[]imagedata= rs.getBytes("v_image");
			            
			            format = new ImageIcon(imagedata);
			            img = format.getImage();
			            newImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			            image = new ImageIcon(newImage);
			            		//String col18 = col18

			           // mod.addRow(new Object[]{xx, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), newIconImage, rs.getString(25), rs.getString(26), rs.getString(27)});

			            model1.addRow(new Object[]{col1, col2, col3,col4,col5,col6,col7,image});


			        }
			    	 JTable table = new JTable( model1 )
				        {
				            //  Returning the Class of each column will allow different
				            //  renderers to be used based on Class
				            public Class getColumnClass(int column)
				            {
				                if(column == 7)
				                	return ImageIcon.class;
								return Object.class;
				            }
				        };
				table.setModel(model1);
				table.setPreferredScrollableViewportSize(table.getPreferredSize());
				JScrollPane scrollPane = new JScrollPane( table );
		        scrollPane.setBounds(10, 11, 1300, 1900);
		        getContentPane().add( scrollPane );
		       table.setRowHeight(100);
		        
			}
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		 
	}
}
