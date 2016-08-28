package vehicleManagement;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

public class loginform extends JFrame{

   
    public loginform() {
        
  
       
    	  JFrame frame = new JFrame("Vehicle Management System");
    	  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          JPanel jp1 = new JPanel();
          jp1.setLayout(new BorderLayout());
          jp1.setBackground(Color.BLUE);
          JLabel jl = new JLabel("Login Panel",SwingConstants.CENTER);
          jl.setFont(new Font("Courier New",Font.BOLD,50));
          jl.setForeground(Color.WHITE);
          
          JPanel pan1 = new JPanel();
          pan1.setLayout(new BorderLayout());
          pan1.setBackground(Color.BLUE);
          JLabel j2 = new JLabel("HAM Copyright",SwingConstants.CENTER);
          j2.setFont(new Font("Courier New",Font.ITALIC,30));
          j2.setForeground(Color.WHITE);
          
          
          JPanel pan2 = new JPanel(new GridBagLayout());
          JLabel user = new JLabel("Username");
          JLabel pass = new JLabel("Password");
          JTextField username = new JTextField();
          username.setPreferredSize(new Dimension(200,30));
          JPasswordField password = new JPasswordField();
          password.setPreferredSize(new Dimension(200,30));
          JButton submit = new JButton("Login");
          String[] logtyp = {"Select login Type","Admin","Customer"};
          JComboBox type = new JComboBox(logtyp);
          JLabel lbl = new JLabel("Login type :");
          //JButton logcust = new JButton("log in as admin");
          JButton register = new JButton("New registration");
          GridBagConstraints c = new GridBagConstraints();
          c.insets = new Insets(0, 30, 20, 10);
          
          c.gridx =4;
          c.gridy=8;
          pan2.add(register,c);
          
          c.gridx =4;
          c.gridy=3;
          pan2.add(username,c);
          c.gridx =4;
          c.gridy=5;
          pan2.add(submit,c);
          c.gridx =4;
          c.gridy=4;
          pan2.add(password,c);
          c.gridx =0;
          c.gridy=3;
          pan2.add(user,c);
          c.gridx =0;
          c.gridy=2;
          pan2.add(lbl,c);
          c.gridx =4;
          c.gridy=2;
          pan2.add(type,c);
          c.gridx =0;
          c.gridy=4;
          pan2.add(pass,c);
          
          jp1.add(jl);
          
          pan1.add(j2,BorderLayout.SOUTH);
          
          frame.add(pan2);
          frame.add(jp1,BorderLayout.NORTH);
          frame.add(pan1,BorderLayout.SOUTH);
          frame.setSize(600, 600);
          frame.setVisible(true);
          
          submit.addActionListener(new ActionListener() {
  			
  			@Override
  			public void actionPerformed(ActionEvent arg0) {
  				String inputuser = username.getText();
  				String inputpass = password.getText();
  				
  				try
				{
  					if(type.getSelectedItem().equals("Admin"))
  					{
  						String user=null,pass=null;
  						Connection connection;
  						connection = DBConnection.getDBConnection();
  						String Query = "SELECT * FROM admin_user where uname='"+inputuser+"' and upass='"+inputpass+"'";
  						
  						PreparedStatement  st = (PreparedStatement) connection.prepareStatement(Query);
  						ResultSet rs;
  						rs=st.executeQuery();
  						
  						while(rs.next())
  						{
  							user = rs.getString("uname");
  							pass= rs.getString("upass");
  						}
  						if(user.equals(inputuser) && pass.equals(inputpass))
  						{
  							new AdminPanel();
  							frame.setVisible(false);
  							frame.dispose();
  							
  						}
  						else
  						{
  							JOptionPane.showMessageDialog(null, " Invalid Credentials");
  						}
  						
  					}else if(type.getSelectedItem().equals("Customer"))
  					{
  						String user=null,pass=null;
  						Connection connection;
  						connection = DBConnection.getDBConnection();
  						String Query = "SELECT * FROM users where name='"+inputuser+"' and pass='"+inputpass+"'";
  						
  						PreparedStatement  st = (PreparedStatement) connection.prepareStatement(Query);
  						ResultSet rs;
  						rs=st.executeQuery();
  						
  						while(rs.next())
  						{
  							user = rs.getString("name");
  							pass= rs.getString("pass");
  						}
  						if(user.equals(inputuser) && pass.equals(inputpass))
  						{
  							new Customer().setVisible(true);
  							frame.setVisible(false);
  							frame.dispose();
  							
  						}
  						else
  						{
  							JOptionPane.showMessageDialog(null, " Invalid Credentials");
  						}
  					}
  					else
  					{
  						JOptionPane.showMessageDialog(null, "Please Select Login Type");
  					}
  					
					
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Invalid Crendentials");
				}
  				
  			}
  		});
       
        register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
				userRegistration ur= new userRegistration();
				  ur.setVisible(true);
				
			}
		});
      
    }
    
    public static void main(String args[])
    {
        
     new loginform();
 
    }
    
}

