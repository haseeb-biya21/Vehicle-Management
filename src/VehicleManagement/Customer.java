package vehicleManagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;

public class Customer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
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
	public Customer() throws IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 453);
		setTitle("Customer Panel");
		setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu mnBookings = new JMenu("Bookings");
		menuBar.add(mnBookings);
		
		JMenuItem mntmIndividual = new JMenuItem("New Booking");
		mnBookings.add(mntmIndividual);
		
		mntmIndividual.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new booking().setVisible(true);
				
			}
		});
		
		JMenu mnViewCars = new JMenu("View cars");
		menuBar.add(mnViewCars);
		
		
		JMenuItem mntmShowCars = new JMenuItem("View Cars details");
		mnViewCars.add(mntmShowCars);
		
		mntmShowCars.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new ViewCarsDetails().setVisible(true);
				
			}
		});
		JMenu mnViewBookingDetails = new JMenu("View Booking Details");
		menuBar.add(mnViewBookingDetails);
		
		JMenuItem mntmIndividual_1 = new JMenuItem("Individual Rent");
		mnViewBookingDetails.add(mntmIndividual_1);
		mntmIndividual_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new viewcustbooking().setVisible(true);
				
			}
		});
		
		JMenu mnOthers = new JMenu("Others");
		menuBar.add(mnOthers);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnOthers.add(mntmLogout);
		getContentPane().setLayout(null);
		ImageIcon img = null ;
		JButton btnBookACar = new JButton("Book a Car");

btnBookACar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new booking().setVisible(true);
				
			}
		});
		btnBookACar.setBounds(10, 11, 140, 41);
		try {
			Image image= ImageIO.read(new File("C:\\Users\\hazup\\Desktop\\Actions-contact-new-icon.png"));
			image.getScaledInstance(btnBookACar.getWidth(),btnBookACar.getHeight(), Image.SCALE_SMOOTH);
			
			img =new ImageIcon(image);
			btnBookACar.setIcon(img);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	
		getContentPane().add(btnBookACar);
		
		JButton btnNewButton = new JButton("View Cars");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\hazup\\Desktop\\Travel-BMV-icon.png"));
		btnNewButton.setBounds(160, 11, 148, 41);
		
btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new viewCarList().setVisible(true);
				
			}
		});
		
			
		
		
		getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		
		
		
		label.setBounds(0, 53, 635, 350);
		getContentPane().add(label);
		ImageIcon MyImage = new ImageIcon("C:\\Users\\hazup\\Desktop\\cars\\Live-Wallpaper-1.jpeg");
		Image img1 = MyImage.getImage();
		Image newimg = img1.getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newimg);
		label.setIcon(image);
		mntmLogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				loginform l=new loginform();
				l.setVisible(true);
				
				setVisible(false);
				dispose();
			
			}
		});
		setVisible(true);
	}
	
}
