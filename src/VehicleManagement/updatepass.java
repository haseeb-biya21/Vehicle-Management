package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Statement;
import javax.swing.JPasswordField;

public class updatepass extends JFrame {
	private JTextField inputuser;
	private JTextField olduser;
	private JPasswordField inputpass;
	private JPasswordField confirmpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatepass frame = new updatepass();
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
	public updatepass() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewUsername = new JLabel("New Username :");
		lblNewUsername.setBounds(59, 82, 111, 14);
		getContentPane().add(lblNewUsername);
		
		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setBounds(59, 132, 111, 14);
		getContentPane().add(lblNewPassword);
		
		inputuser = new JTextField();
		inputuser.setBounds(180, 79, 134, 20);
		getContentPane().add(inputuser);
		inputuser.setColumns(10);
		
		JLabel lblOldUsername = new JLabel("Old Username: ");
		lblOldUsername.setBounds(59, 46, 111, 14);
		getContentPane().add(lblOldUsername);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setBounds(59, 171, 124, 14);
		getContentPane().add(lblConfirmPassword);
		
		inputpass = new JPasswordField();
		inputpass.setBounds(180, 129, 134, 20);
		getContentPane().add(inputpass);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(180, 168, 134, 20);
		getContentPane().add(confirmpass);
		olduser = new JTextField();
		olduser.setBounds(180, 43, 134, 20);
		getContentPane().add(olduser);
		olduser.setColumns(10);
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connection;
					connection=DBConnection.getDBConnection();
					if(connection==null)
					{
						JOptionPane.showMessageDialog(null, "Error Connecting Database");
					}
					else
					{
						String oldusername = olduser.getText();
						
						String inputusername = inputuser.getText();
						String inputpassword = inputpass.getText();
						String confirmpassword = confirmpass.getText();
						
						if(inputpassword.equals(confirmpassword))
						{
						String Query = "UPDATE admin_user set uname='"+inputusername+"',upass='"+inputpassword+"' where uname='"+oldusername+"'";
						Statement st =connection.createStatement();
						st.executeUpdate(Query);
						JOptionPane.showMessageDialog(null, "Username and password Updated");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "password doesnt match");
						}
						
						
						
					}
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnUpdate.setBounds(180, 213, 89, 23);
		getContentPane().add(btnUpdate);
		
		
		
	
		
	}
}
