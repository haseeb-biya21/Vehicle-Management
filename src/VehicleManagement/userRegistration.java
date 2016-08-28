package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;

import java.sql.*;

public class userRegistration extends JFrame {
	public userRegistration(){
		JFrame frame = new JFrame("Vehicle Management System");
  	  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel jp1 = new JPanel();
        jp1.setLayout(new BorderLayout());
        jp1.setBackground(Color.BLUE);
        JLabel jl = new JLabel("User Registration",SwingConstants.CENTER);
        jl.setFont(new Font("Courier New",Font.BOLD,50));
        jl.setForeground(Color.WHITE);
        
        JPanel pan1 = new JPanel();
        pan1.setLayout(new BorderLayout());
        pan1.setBackground(Color.BLUE);
        JLabel j2 = new JLabel("Copyright",SwingConstants.CENTER);
        j2.setFont(new Font("Courier New",Font.ITALIC,30));
        j2.setForeground(Color.WHITE);
        
        
        JPanel pan2 = new JPanel(new GridBagLayout());
        JLabel user = new JLabel("New Username");
        JLabel pass = new JLabel("New Password");
        JLabel add = new JLabel("Address");
        JLabel city = new JLabel("City");
        JLabel state = new JLabel("State");
        JLabel Mobile = new JLabel("Mobile");
        JLabel email = new JLabel("Email");
        JTextField username = new JTextField();
        username.setPreferredSize(new Dimension(200,30));
        
        JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(200,30));
        JTextField address = new JTextField();
        address.setPreferredSize(new Dimension(200,30));
        JTextField City = new JTextField();
        City.setPreferredSize(new Dimension(200,30));
        JTextField State = new JTextField();
        State.setPreferredSize(new Dimension(200,30));
        JTextField mobile = new JTextField();
        mobile.setPreferredSize(new Dimension(200,30));
        JTextField Email = new JTextField();
        Email.setPreferredSize(new Dimension(200,30));
        JButton submit = new JButton("Register");
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 30, 20, 10);
       
        
        c.gridx =0;
        c.gridy=1;
        pan2.add(user,c);
        
        
        c.gridx =0;
        c.gridy=2;
        pan2.add(pass,c);
        
        
        c.gridx =0;
        c.gridy=3;
        pan2.add(add,c);
        
        
        c.gridx =0;
        c.gridy=4;
        pan2.add(city,c);
        
        c.gridx =0;
        c.gridy=5;
        pan2.add(state,c);
        c.gridx =0;
        c.gridy=6;
        pan2.add(Mobile,c);
        
        
        c.gridx =0;
        c.gridy=7;
        pan2.add(email,c);
        
        c.gridx =4;
        c.gridy=1;
        pan2.add(username,c); 
       
     
        c.gridx =4;
        c.gridy=2;
        pan2.add(password,c);
        
        c.gridx =4;
        c.gridy=3;
        pan2.add(address,c);
        c.gridx =4;
        c.gridy=4;
        pan2.add(City,c);
        
        
        c.gridx =4;
        c.gridy=5;
        pan2.add(State,c);
        c.gridx =4;
        c.gridy=6;
        pan2.add(mobile,c);
        
        c.gridx =4;
        c.gridy=7;
        pan2.add(Email,c);
        c.gridx =4;
        c.gridy=8;
        pan2.add(submit,c);
        
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
				
				try {
					Connection connection;
					connection=DBConnection.getDBConnection();
					if(connection==null)
					{
						JOptionPane.showMessageDialog(null, "Error Connecting Database");
					}
					else
					{
						
						String inputuser = username.getText();
						String inputpass = password.getText();
						String inputadd = address.getText();
						String inputcity = City.getText();
						String inputstate = State.getText();
						String inputmobile = mobile.getText();
						String inputemail = Email.getText();
						String Query = "INSERT INTO users (name,pass,add1,city,state,mobile,email) "
								+ "VALUES('"+inputuser+"','"+inputpass+"','"+inputadd+"','"+inputcity+"','"+inputstate+"','"+inputmobile+"','"+inputemail+"')";
						Statement st =connection.createStatement();
						st.executeUpdate(Query);
						
						
						JOptionPane.showMessageDialog(null, "User update Successfull");
						System.out.println(Query);
						new Customer().setVisible(true);
						frame.setVisible(false);
						frame.dispose();
					}
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
	}

	public static void main(String[] args) {
		new userRegistration();

	}

}
