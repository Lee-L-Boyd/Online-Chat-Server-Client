import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ClientLogin extends JFrame {

	private JFrame frame;
	private JTextField usernametext;
	private JTextField passwordtext;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton loginbutton;
	private JButton btnNewButton;
	String name;
	String name1;
	String prof;
	String city1;
	String college1,company1,gradYear,password1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientLogin frame = new ClientLogin();
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
	public ClientLogin() {
		setMinimumSize(new Dimension(600, 400));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	/*	frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	*/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernametext = new JTextField();
		usernametext.setBounds(312, 21, 86, 20);
	//	frame.getContentPane().add(usernametext);
		usernametext.setColumns(10);
		contentPane.add(usernametext);
	
		//Registry reg= LocateRegistry.getRegistry("localhost",1204);
		//UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup (username);
		
		JLabel lblSocialNetwork = new JLabel("Social Network");
		lblSocialNetwork.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblSocialNetwork.setForeground(Color.RED);
		lblSocialNetwork.setBounds(44, 14, 137, 32);
	//	frame.getContentPane().add(lblSocialNetwork);
		contentPane.add(lblSocialNetwork);
		
		passwordtext = new JTextField();
		passwordtext.setColumns(10);
		passwordtext.setBounds(312, 52, 86, 20);
	//	frame.getContentPane().add(passwordtext);
		contentPane.add(passwordtext);
		
		lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(235, 24, 67, 14);
	//	frame.getContentPane().add(lblUsername);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(235, 55, 67, 14);
	//	frame.getContentPane().add(lblPassword);
		contentPane.add(lblPassword);
		
		loginbutton = new JButton("Log In");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				String	username=usernametext.getText();
				System.out.println(username);
				Registry reg;
				try {
					
					reg = LocateRegistry.getRegistry("localhost",1204);
					ChatServerServantInterface myServer=(ChatServerServantInterface) reg.lookup("chat");
					
					boolean result= myServer.findAUser(username);
				//	boolean result=false;
					System.out.println(result);
					if(result==false)
					{
						JOptionPane.showMessageDialog(null, "        No such user exist !!!",null,JOptionPane.ERROR_MESSAGE);
					}
				//	{
					else
					{
					UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
					
					
				//	boolean result=myServer.getNewAccount(name1, prof, city1, company1, college1, gradYear, password1, "user"+username);
					
				//	String ror=String.valueOf(testUserPass);
				//	System.out.println(result);
				//	if(result==true)
				//	{
				//	System.out.println(testUserPass.getName());
		//			welcome = new JTextField();
					// name1=testUserPass.getName();
				//	 System.out.println(name1);
				//	welcome.setText(name1);
				//	 welcome.setText(String.valueOf(testUserPass.getName()));
				//	 welcome.setText(String.valueOf(name1));
					MainMenu mainmenu = new MainMenu();
					MainMenu.name.setText(testUserPass.getName());
				//	mainmenu.setusername("user" +username);
					mainmenu.setusername(username);
					ClientLogin.this.setVisible(false);
					mainmenu.setVisible(true);}
					CallBack testCB = new CallBack();
					try {
						reg.rebind ("cb"+username,testCB);
					} catch (AlreadyBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
				//	ViewProfile profile= new ViewProfile();
				//	profile.username
				//	else
			//	{
				//		JOptionPane.showMessageDialog(null, "        User Doesnot exist !!!",null,JOptionPane.ERROR_MESSAGE);
				//	}
			//	} 
				catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			//	MainMenu mainmenu = new MainMenu();
			//	MainMenu.name.setText(testUserPass.getName(););
			//	mainmenu.setVisible(true);
				
				
				
			}
		});
		loginbutton.setBorder(new LineBorder(Color.ORANGE));
		loginbutton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginbutton.setForeground(Color.BLACK);
		loginbutton.setBackground(SystemColor.control);
		loginbutton.setBounds(266, 116, 78, 20);
	//	frame.getContentPane().add(loginbutton);
		contentPane.add(loginbutton);
		
		btnNewButton = new JButton("New User? Click here to create an account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	frame.dispose();
				NewUser newuser = new NewUser();
				ClientLogin.this.setVisible(false);
				newuser.setVisible(true);
			//	user1 user=new user1();
			//	user.setVisible(true);
				
			}
		});
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(152, 235, 301, 23);
	//	frame.getContentPane().add(btnNewButton);
		contentPane.add(btnNewButton);
		
	//	 name = testUserPass.getName();
	}
}
