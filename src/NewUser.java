import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class NewUser extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
//	private JFrame frame;
	private JTextField name;
	private JTextField profession;
	private JTextField city;
	private JTextField company;
	private JTextField college;
	private JTextField year;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	/*	String name1="Lee";
		String prof="Computer Scientist";
		String city="San Antonio";
		String company="UTSA CS Dept";
		String college="UTSA";
		String gradYear="2020";
		String password="pw";
		String username="un";
		*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewUser() {
		setMinimumSize(new Dimension(600, 400));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	/*	frame = new JFrame();
		frame.setBounds(100, 100, 592, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	*/	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignUpHere = new JLabel("Sign Up..New User!!!");
		lblSignUpHere.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSignUpHere.setBounds(138, 22, 163, 20);
	//	frame.getContentPane().add(lblSignUpHere);
		contentPane.add(lblSignUpHere);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(114, 85, 46, 14);
	//	frame.getContentPane().add(lblName);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(225, 83, 86, 20);
		//frame.getContentPane().add(name);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblProfession = new JLabel("Profession:");
		lblProfession.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProfession.setBounds(114, 116, 61, 14);
	//	frame.getContentPane().add(lblProfession);
		contentPane.add(lblProfession);
		
		profession = new JTextField();
		profession.setColumns(10);
		profession.setBounds(225, 114, 86, 20);
	//	frame.getContentPane().add(profession);
		contentPane.add(profession);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(225, 145, 86, 20);
	//	frame.getContentPane().add(city);
		contentPane.add(city);
		
		company = new JTextField();
		company.setBorder(null);
		company.setBackground(SystemColor.control);
		company.setColumns(10);
		company.setBounds(39, 318, 86, 20);
	//	frame.getContentPane().add(company);
		contentPane.add(company);
		
		college = new JTextField();
		college.setColumns(10);
		college.setBounds(225, 176, 86, 20);
	//	frame.getContentPane().add(college);
		contentPane.add(college);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(225, 216, 86, 20);
	//	frame.getContentPane().add(year);
		contentPane.add(year);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCity.setBounds(114, 147, 61, 14);
	//	frame.getContentPane().add(lblCity);
		contentPane.add(lblCity);
		
		JLabel lblCollege = new JLabel("College:");
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCollege.setBounds(114, 178, 61, 14);
	//	frame.getContentPane().add(lblCollege);
		contentPane.add(lblCollege);
		
		JLabel lblGraduationYear = new JLabel("Graduation year:");
		lblGraduationYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGraduationYear.setBounds(114, 219, 101, 14);
	//	frame.getContentPane().add(lblGraduationYear);
		contentPane.add(lblGraduationYear);
		
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(114, 265, 72, 14);
	//	frame.getContentPane().add(lblUsername);
		contentPane.add(lblUsername);
		
		username = new JTextField();
		username.setBounds(196, 262, 86, 20);
	//	frame.getContentPane().add(username);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(303, 265, 66, 14);
		contentPane.add(lblPassword);
	//	frame.getContentPane().add(lblPassword);
		
		password = new JTextField();
		password.setBounds(369, 262, 86, 20);
	//	frame.getContentPane().add(password);
		contentPane.add(password);
		password.setColumns(10);
		
		
		JButton btnCreateAccount = new JButton("CREATE ACCOUNT");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				   try {
					Registry reg= LocateRegistry.getRegistry("localhost",1204);
					ChatServerServantInterface myServer=(ChatServerServantInterface) reg.lookup("chat");
			//		myServer.test("myStrin");
				String	name1=name.getText();
				String prof = profession.getText();
				String city1=city.getText();
				String company1=company.getText();
				String college1=college.getText();
				String gradYear=year.getText();
				String username1=username.getText();
				String password1=password.getText();
			//	System.out.println(name1);
				
				//	System.out.println(myServer.getNewAccount(name1, prof, city1, company1, college1, gradYear, password1, username1));
					boolean result=myServer.getNewAccount(name1, prof, city1, company1, college1, gradYear, password1, username1);
					if(result==true)
					{
						myServer.Login(username1);
					//	UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username1);
					//	System.out.println(	testUserPass.getCity());
						
						JOptionPane.showMessageDialog(null, "        New User Created !!!",null,JOptionPane.INFORMATION_MESSAGE);
						ClientLogin client = new ClientLogin();
						client.setVisible(true);
						NewUser.this.setVisible(false);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "        Username already exist..try other name  !!!",null,JOptionPane.INFORMATION_MESSAGE);
						username.setText("");
						password.setText("");;
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			//	NewUser frame=new NewUser();
			//	frame.setVisible(false);
				
				
				
				
			}
		});
		btnCreateAccount.setBackground(SystemColor.control);
		btnCreateAccount.setBorder(new LineBorder(new Color(51, 153, 255)));
		btnCreateAccount.setBounds(253, 303, 134, 23);
	//	frame.getContentPane().add(btnCreateAccount);
		contentPane.add(btnCreateAccount);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/sign_in.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(311, 11, 255, 243);
	//	frame.getContentPane().add(label);
		contentPane.add(label);
	}

}
