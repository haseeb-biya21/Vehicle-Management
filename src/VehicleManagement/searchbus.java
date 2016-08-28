package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
public class searchbus extends JFrame{

	public searchbus() {
		JFrame frame = new JFrame("Search Vehicle");
		frame.setSize(600, 600);
		JPanel pan1= new JPanel();
		JPanel pan2= new JPanel();
		JLabel list =new JLabel("Enter A Stop");
		JTextField inputsearch = new JTextField();
		inputsearch.setPreferredSize(new Dimension(200,30));
		JButton search = new JButton("Search");
		search.setSize(150,50);
		JLabel lbl = new JLabel();
		JTable employeelist = new JTable();
		pan1.add(list);
		pan1.add(inputsearch);
		pan1.add(search);
		pan1.add(employeelist);
		pan2.add(lbl);
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					Connection connection;
					connection = DBConnection.getDBConnection();
					if(connection ==  null)
					{
						JOptionPane.showMessageDialog(null, "Error Connecting Database");
					}
					else
					{
						if(inputsearch.getText().isEmpty())
						{
						JOptionPane.showMessageDialog(null, "Please Enter a Stop");	
						}
						else
						{
						String Query ="SELECT * FROM bus_ROute where Stops LIKE'"+inputsearch.getText()+"%' OR Destination LIKE'"+inputsearch.getText()+"%'";
						System.out.println(Query);
						ResultSet rs;
						PreparedStatement pst=null;
						Statement st = connection.prepareStatement(Query);
						rs=st.executeQuery(Query);
						employeelist.setModel(DbUtils.resultSetToTableModel(rs));
						
						}
						
						
					
						
					}
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			
			}
		});
		frame.add(new JScrollPane(employeelist));
		frame.add(pan1,BorderLayout.NORTH);
		frame.add(pan2,BorderLayout.SOUTH);
		frame.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new searchbus();
	}

}
