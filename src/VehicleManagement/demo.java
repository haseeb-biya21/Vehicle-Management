package vehicleManagement;
import java.awt.*;

import javax.swing.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.*;
import java.sql.SQLException;

public class demo extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6;
	Container cont;
 demo()
 {
                    cont = getContentPane();
                    cont.setLayout(null);
                    addWindowListener(new myWindowAdapter());
	  getContentPane().setBackground(Color.black);

	
	JLabel j1=new JLabel("\nAIKTC POLICE TRAFFIC\n");
	cont.add(j1);
	j1.setForeground(Color.red);
	j1.setFont(j1.getFont().deriveFont(60.0f));
	j1.setBounds(300,40,2000,100);

	b1=new JButton("HOME");
	cont.add(b1);
	b1.setBounds(100,150,90,30);
	b1.addActionListener(this);

	b2=new JButton("LAWS");
	cont.add(b2);
	b2.setBounds(170,150,90,30);
	b2.addActionListener(this);

	b3=new JButton("SIGN-IN");
	cont.add(b3);
	b3.setBounds(240,150,100,30);
	b3.addActionListener(this);

	b4=new JButton("CONTACT");
	cont.add(b4);
	b4.setBounds(330,150,100,30);
	b4.addActionListener(this);

	b5=new JButton("MULCT");
	cont.add(b5);
	b5.setBounds(420,150,90,30);
	b5.addActionListener(this);
	
	b6=new JButton("FEEDBACK");
	cont.add(b6);
	b6.setBounds(500,150,120,30);
	b6.addActionListener(this);

	ImageIcon image = new ImageIcon("/home/aynas/Desktop/1439245544KTC.jpg");
	JLabel imageLabel = new JLabel(image);
	imageLabel.setBounds(0, 0, 1366,768);
	imageLabel.setVisible(true);
	add(imageLabel);
}

public static void main(String g[])
{
 demo stu=new demo();
 stu.setSize(new Dimension(1366,768));
 stu.setTitle("WELCOME TO AIKTC POLICE TRAFFIC");
 stu.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
	demo stu=new demo();
	stu.setSize(1366,768);
	stu.setVisible(true);
}

if(ae.getSource()==b2)
{
	login stu=new login();
	stu.setSize(1200,600);
	stu.setVisible(true);
}


if(ae.getSource()==b3)
{
	 signup1 stu=new signup1();
 	stu.setSize(new Dimension(1200,600));
 	stu.setVisible(true);
}

if(ae.getSource()==b4)
{
	 contact stu=new contact();
	 stu.setSize(1200,600);
 	 stu.setVisible(true);
}

if(ae.getSource()==b5)
{
	about stu=new about();
 	stu.setSize(1200,600);
	 stu.setVisible(true);
}

if(ae.getSource()==b6)
{
	  feedback stu=new feedback();
  	 stu.setSize(1200,600);
	 stu.setVisible(true);
}

}
}




class myWindowAdapter extends WindowAdapter
{
	 public void windowClosing(WindowEvent we)
 {
  System.exit(0);
 }
}

class login extends JFrame 
{
   
  Container cont;

 login()
 {
       cont = getContentPane();
       cont.setLayout(null);
       getContentPane().setBackground(Color.black);
   
                  JLabel j1=new JLabel("SOME IMPORTANT PROVISIONS OF LAWS\n");
                      JLabel j2=new JLabel("Section 4 - Age Limit for obtaining driving licence:\n");
                      JLabel j3=new JLabel("\t\t -> Other Motor Vehiles-Below 18 years\n");
                      JLabel j4=new JLabel("\t\t -> Transport Vehicle-20 years\n");
                      JLabel j5=new JLabel("Section 3 - It is an offence to drive a vehicle without licence\n");
                      JLabel j6=new JLabel("Section  5 - Driving without a driving licence have to pay fine upto Rs.500/ ");
                      
	cont.add(j1);
	cont.add(j2);
	cont.add(j3);
	cont.add(j4);
    cont.add(j5);
    cont.add(j6);
    
	j1.setForeground(Color.red);
	j1.setFont(j1.getFont().deriveFont(20.0f));
	j1.setBounds(50,10,850,80);
	
	j2.setForeground(Color.white);
	j2.setFont(j2.getFont().deriveFont(12.0f));
	j2.setBounds(50,60,850,80);
	
		j3.setForeground(Color.white);
	j3.setFont(j3.getFont().deriveFont(12.0f));
	j3.setBounds(50,110,850,80);

		j4.setForeground(Color.white);
	j4.setFont(j4.getFont().deriveFont(12.0f));
	j4.setBounds(50,160,850,80);
	
		j5.setForeground(Color.white);
	j5.setFont(j5.getFont().deriveFont(12.0f));
	j5.setBounds(50,210,850,80);
	
		j6.setForeground(Color.white);
	j6.setFont(j6.getFont().deriveFont(12.0f));
	j6.setBounds(50,260,850,80);
	
  
}
public static void main(String args[])
{
 login stu=new login();
 stu.setSize(1200,600);
 stu.setVisible(true);
}
}

 class signup1 extends JFrame implements ActionListener
{
   String msg;
  JButton b1;
  JTextField t1,t2,t3,t4,t5,t6;
TextArea t7;
  Container cont;
  Choice id,age;
  Checkbox ck1,ck2;
  CheckboxGroup cbg;
  
 signup1()
 {
       cont = getContentPane();
       cont.setLayout(null);
   getContentPane().setBackground(Color.white);
   getContentPane().setForeground(Color.red);
    
  


   JLabel l1=new JLabel("Name:");
   l1.setForeground(Color.red);
   JLabel l2=new JLabel("age:");
   l2.setForeground(Color.red);
   JLabel l3=new JLabel("Gender:");
   l3.setForeground(Color.red);
   JLabel l4=new JLabel("Address:");
   l4.setForeground(Color.red);
   JLabel l5=new  JLabel("VType:");
   l5.setForeground(Color.red);
   JLabel l6=new JLabel("Contact no:");
   l6.setForeground(Color.red);
   JLabel l7=new JLabel("Veh no:");
   l7.setForeground(Color.red);
   JLabel l8=new JLabel("License no:");
   l8.setForeground(Color.red);
      JLabel l9=new JLabel("VDate:");
      l9.setForeground(Color.red);
       JLabel l10=new JLabel("VPlace:");
       l10.setForeground(Color.red);

  cont.add(l1);
  cont.add(l2);
  cont.add(l3);
  cont.add(l4);
  cont.add(l5);
  cont. add(l6);
  cont. add(l7);
   cont. add(l8);
   cont. add(l9);
   cont.add(l10);
  l1.setBounds(25,65,90,20);
  l2.setBounds(25,90,90,20);
  l3.setBounds(25,120,90,20);
  l4.setBounds(25,185,90,20);
  l5.setBounds(25,260,90,20);
  l6.setBounds(25,290,90,20);
  l7.setBounds(25,330,90,20);
  l8.setBounds(25,370,90,20);
  l9.setBounds(25,410,90,20);
  l10.setBounds(25,450,90,20);


  t1=new JTextField();
 cont.add(t1);
 t1.setBounds(120,65,250,20);

 t2=new JTextField();
t2.setBounds(120,290,100,20);
cont. add(t2);

 t3=new JTextField();
t3.setBounds(120,330,100,20);
cont. add(t3);

 t4=new JTextField();
t4.setBounds(120,370,100,20);
cont. add(t4);

 t5=new JTextField();
t5.setBounds(120,410,100,20);
cont. add(t5);

 t6=new JTextField();
t6.setBounds(120,450,100,20);
cont. add(t6);

t7=new TextArea("",180,90,TextArea.SCROLLBARS_VERTICAL_ONLY);
add(t7);
 t7.setBounds(120,185,170,60);
 
 cbg=new CheckboxGroup();
ck1=new Checkbox("Male",false,cbg);
 
ck2=new Checkbox("Female",false,cbg);
 cont.add(ck1);
 cont.add(ck2);
 ck1.setBounds(120,120,50,20);
 ck2.setBounds(170,120,60,20);
 age=new Choice();
add(age);
age.setBounds(120,90,50,20);
  age.add("18");
  age.add("19");
  age.add("20");
  age.add("21");
  age.add("22");

id=new Choice();
add(id);
id.setBounds(120,260,100,20);
id.add("SPEEDING");
  id.add("FAIL TO STOP");
  id.add("NO HELMET");
  id.add("LANE CHANGES");
  id.add("NO LICENSE");
  id.add("UNDERAGE");

  b1=new JButton("SUBMIT");
 cont.add(b1);
 b1.setBackground(Color.white);
 b1.setBounds(120,500,100,30);
 b1.addActionListener(this);
 
 
}


public static void main(String g[])
{
 signup1 stu=new signup1();
 stu.setSize(new Dimension(1200,600));
 stu.setTitle("WELCOME TO AIKTC POLICE TRAFFIC");
 stu.setVisible(true);
}


public void actionPerformed(ActionEvent ae)
{
	if((t1.getText()).equals("")||(t2.getText()).equals(""))
			{
				
			
JOptionPane.showMessageDialog(null,"please fill all your details Passwords doesnot match");									
			}
else
{ 
			Connection connection ;
			connection = DBConnection.getDBConnection();
			if(connection == null)
			{
				JOptionPane.showMessageDialog(null, "Error Connecting Database");
			}
			else
			{
				String Query = "INSERT INTO user(u_name,age,gender,address,vtype,contact_no,vehicle_no,license_no,vDate,Vplace) VALUES(?,?,?,?,?,?,?,?,?,?)";
				
				try {
					PreparedStatement st = (PreparedStatement) connection.prepareStatement(Query);
					st.setString(1, t1.getText());
					st.setString(2, age.getSelectedItem().toString());
					st.setString(3, cbg.getSelectedCheckbox().getLabel());
					st.setString(4, t7.getText());
					st.setString(5, id.getSelectedItem().toString());
					st.setString(6, t2.getText());
					st.setString(7, t3.getText());
					st.setString(8, t4.getText());
					st.setString(9, t5.getText());
					st.setString(10, t6.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Saved");
					Admin4 admn3=new Admin4();
	                  admn3.setSize(1200,600);
	                  admn3.setVisible(true);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
			}
		
}

	
}
}


class Admin4 extends JFrame implements ActionListener
{

JMenuBar bar= new JMenuBar();
JMenuItem it1,it2;

Admin4()
{
Container cont=getContentPane();
cont.setLayout(null);
getContentPane().setBackground(Color.black);

JMenu file = new JMenu ("File");
it1 = new JMenuItem("New");
it2 = new JMenuItem("Exit");
file.add(it1);
file.add(it2);

it1.addActionListener(this);
it2.addActionListener(this);

bar.add(file);
setJMenuBar(bar);

JLabel lb1=new JLabel("Customer details saved:");
cont.add(lb1);
lb1.setForeground(Color.red);
lb1.setFont(lb1.getFont().deriveFont(14.0f));
lb1.setBounds(20,30,300,20);

JLabel j1=new JLabel("DETAILS SAVED SUCCESSFULLY!!");
cont.add(j1);
j1.setForeground(Color.red);
j1.setFont(j1.getFont().deriveFont(20.0f));
j1.setBounds(10,50,600,50);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==it1)
{
signup1 stu=new signup1();
 stu.setSize(new Dimension(1200,600));
 stu.setTitle("WELCOME TO AIKTC POLICE TRAFFIC");
 stu.setVisible(true);

if(ae.getSource()==it2)
System.exit(0);
}
}
}

 class about extends JFrame 
{
   
  Container cont;

 about()
 {
       cont = getContentPane();
       cont.setLayout(null);
       getContentPane().setBackground(Color.black);
   
                  JLabel j1=new JLabel("TRAFFIC MULCTS\n");
                      JLabel j2=new JLabel("1. Red Light Jumping:\t\t\t\t500\n");
                      JLabel j3=new JLabel("2. Drink driving:\t\t\t\t2000\n");
                      JLabel j4=new JLabel("3. Jumping Signals\t\t\t\t100\n");
                      JLabel j5=new JLabel("4. No License:\t\t\t\t300\n");
                      JLabel j6=new JLabel("5. No Helmet or Seatbelt:\t\t\t\t100\n");
                      JLabel j7=new JLabel("6. No Documents:\t\t\t\t100\n");
                      JLabel j8=new JLabel("7. Wrong Parking:\t\t\t\t100\n");
                      JLabel j9=new JLabel("8. Tinted Glass:\t\t\t\t100\n");
                      JLabel j10=new JLabel("9. Triple Riding:\t\t\t\t200\n");
                      JLabel j11=new JLabel("10.  Over Speeding:\t\t\t\t500\n");
	cont.add(j1);
	cont.add(j2);
	cont.add(j3);
	cont.add(j4);
    cont.add(j5);
    cont.add(j6);
    cont.add(j7);
    cont.add(j8);
    cont.add(j9);
    cont.add(j10);
    cont.add(j11);
    
	j1.setForeground(Color.red);
	j1.setFont(j1.getFont().deriveFont(20.0f));
	j1.setBounds(50,10,850,80);
	
	j2.setForeground(Color.white);
	j2.setFont(j2.getFont().deriveFont(14.0f));
	j2.setBounds(50,60,850,80);
	
		j3.setForeground(Color.white);
	j3.setFont(j3.getFont().deriveFont(14.0f));
	j3.setBounds(50,110,850,80);

		j4.setForeground(Color.white);
	j4.setFont(j4.getFont().deriveFont(14.0f));
	j4.setBounds(50,160,850,80);
	
		j5.setForeground(Color.white);
	j5.setFont(j5.getFont().deriveFont(14.0f));
	j5.setBounds(50,210,850,80);
	
		j6.setForeground(Color.white);
	j6.setFont(j6.getFont().deriveFont(14.0f));
	j6.setBounds(50,260,850,80);
	
		j7.setForeground(Color.white);
	j7.setFont(j7.getFont().deriveFont(14.0f));
	j7.setBounds(50,310,850,80);
	
		j8.setForeground(Color.white);
	j8.setFont(j8.getFont().deriveFont(14.0f));
	j8.setBounds(50,360,850,80);
	
		j9.setForeground(Color.white);
	j9.setFont(j9.getFont().deriveFont(14.0f));
	j9.setBounds(50,410,850,80);
	
		j10.setForeground(Color.white);
	j10.setFont(j10.getFont().deriveFont(14.0f));
	j10.setBounds(50,460,850,80);
	
		j11.setForeground(Color.white);
	j11.setFont(j11.getFont().deriveFont(14.0f));
	j11.setBounds(50,510,850,80);

}
public static void main(String args[])
{
 about stu=new about();
 stu.setSize(1366,768);
 stu.setVisible(true);
}
}


 class feedback extends JFrame implements ActionListener
{
    JButton b1;
   JTextField jft1,jft2;
  Container cont;

 feedback()
 {
       cont = getContentPane();
       cont.setLayout(null);
             getContentPane().setBackground(Color.black);

	JLabel jl1=new JLabel("Your Name:");
 	cont.add(jl1);
 	jl1.setForeground(Color.red);
	jl1.setBounds(20,30,100,20);

	jft1=new JTextField();
	cont.add(jft1);
	jft1.setBounds(100,30,200,30);

	JLabel jl2=new JLabel("Your Email:");
	cont.add(jl2);
	jl2.setForeground(Color.red);
	jl2.setBounds(20,80,100,20);

	jft2=new JTextField();
	cont.add(jft2);
	jft2.setBounds(100,80,200,30);

	JLabel jl4=new JLabel("Message:");
	cont.add(jl4);
	jl4.setForeground(Color.red);
	jl4.setBounds(25,185,90,20);
	

	TextArea t3=new TextArea("",100,500,TextArea.SCROLLBARS_VERTICAL_ONLY);
	add(t3);
 	t3.setBounds(120,185,170,60);

	 b1=new JButton("post");
	 cont.add(b1);
	b1.setBackground(Color.white);
	b1.setBounds(120,350,100,30);
	 b1.addActionListener(this);
   
         }
public static void main(String args[])
{
 feedback stu=new feedback();
 stu.setSize(1366,768);
 stu.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
	if((jft1.getText()).equals("")||(jft2.getText()).equals(""))
			{
				
			
JOptionPane.showMessageDialog(cont,"please fill all your details","Passwords doesnot match",JOptionPane.ERROR_MESSAGE);									
			}
else
{ 
	Admin5 admn3=new Admin5();
                  admn3.setSize(1200,600);
                  admn3.setVisible(true);
}

	
}
}


class Admin5 extends JFrame implements ActionListener
{

JMenuBar bar= new JMenuBar();
JMenuItem it1,it2;

Admin5()
{
Container cont=getContentPane();
cont.setLayout(null);
getContentPane().setBackground(Color.black);

JMenu file = new JMenu ("File");
it1 = new JMenuItem("New");
it2 = new JMenuItem("Exit");
file.add(it1);
file.add(it2);

it1.addActionListener(this);
it2.addActionListener(this);

bar.add(file);
setJMenuBar(bar);

JLabel lb1=new JLabel("Customer feedback saved:");
cont.add(lb1);
lb1.setForeground(Color.red);
lb1.setFont(lb1.getFont().deriveFont(12.0f));
lb1.setBounds(20,30,300,20);

JLabel j1=new JLabel(" THANKYOU FOR YOUR FEEDBACK!!");
cont.add(j1);
j1.setForeground(Color.red);
j1.setFont(j1.getFont().deriveFont(20.0f));
j1.setBounds(10,50,600,50);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==it1)
{
feedback stu=new feedback();
 stu.setSize(1200,600);
 stu.setVisible(true);

if(ae.getSource()==it2)
System.exit(0);
}
}
}

 class contact extends JFrame 
{
   
  Container cont;

 contact()
 {
       cont = getContentPane();
       cont.setLayout(null);
       getContentPane().setBackground(Color.black);
   
                  JLabel j1=new JLabel(" AIKTC POLICE TRAFFIC");
	cont.add(j1);
	j1.setForeground(Color.red);
	j1.setFont(j1.getFont().deriveFont(30.0f));
	j1.setBounds(50,10,850,80);

	JLabel j2=new JLabel(" TRAFFIC HELPLINE:");
	cont.add(j2);
	j2.setForeground(Color.white);
	j2.setFont(j1.getFont().deriveFont(12.0f));
	j2.setBounds(20,100,200,80);

	JLabel j3=new JLabel(" 080-25588444/555");
	cont.add(j3);
	j3.setForeground(Color.white);
	j3.setFont(j1.getFont().deriveFont(12.0f));
	j3.setBounds(50,120,180,80);

	JLabel j4=new JLabel(" 080-22943030/3131");
	cont.add(j4);
	j4.setForeground(Color.white);
	j4.setFont(j1.getFont().deriveFont(12.0f));
	j4.setBounds(50,140,250,80);
	
	JLabel j5=new JLabel("AMBULANCE:");
	cont.add(j5);
	j5.setForeground(Color.white);
	j5.setFont(j1.getFont().deriveFont(12.0f));
	j5.setBounds(20,200,200,80);

	JLabel j6=new JLabel("TOLL FREE-105711");
	cont.add(j6);
	j6.setForeground(Color.white);
	j6.setFont(j1.getFont().deriveFont(12.0f));
	j6.setBounds(50,220,200,80);

	JLabel j7=new JLabel("TOLL FREE-108/1062");
	cont.add(j7);
	j7.setForeground(Color.white);
	j7.setFont(j1.getFont().deriveFont(12.0f));
	j7.setBounds(50,240,250,80);




	
	

  
}
public static void main(String args[])
{
 contact stu=new contact();
 stu.setSize(1200,600);
 stu.setVisible(true);
}
}







