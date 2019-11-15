

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import javax.swing.JTextField;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	public static JTextField name;
	public static String username;
//	static String name1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public void setusername(String username)
	{
		this.username=username;
		System.out.println(username);
		
	}
	public String getusername()
	{
		return username;
	}
	
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(93, 22, 96, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnViewProfile = new JButton("VIEW PROFILE");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registry reg;
				try {
					reg = LocateRegistry.getRegistry("localhost",1204);
					UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
					//System.out.println(testUserPass.getName());
					ViewProfile view = new ViewProfile();
					view.name.setText(testUserPass.getName());
					view.profession.setText(testUserPass.getProf());
					view.city.setText(testUserPass.getCity());
					view.college.setText(testUserPass.getCollege());
					view.year.setText(testUserPass.getGradYear());
					
					
					MainMenu.this.setVisible(false);
					view.setVisible(true);
					
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
			
			
				
				
			}
		});
		btnViewProfile.setBackground(SystemColor.control);
		btnViewProfile.setBorder(new LineBorder(SystemColor.textHighlight));
		btnViewProfile.setBounds(93, 75, 118, 23);
		contentPane.add(btnViewProfile);
		
		JButton btnEditProfile = new JButton("EDIT PROFILE");
		btnEditProfile.setBackground(SystemColor.control);
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Registry reg;
			try {
				reg = LocateRegistry.getRegistry("localhost",1204);
				UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
				editprofile edit = new editprofile();
				edit.name.setText(testUserPass.getName());
				edit.profession.setText(testUserPass.getProf());
				edit.city.setText(testUserPass.getCity());
				edit.college.setText(testUserPass.getCollege());
				edit.year.setText(testUserPass.getGradYear());
				edit.setusername(username);
				edit.setVisible(true);
				MainMenu.this.setVisible(false);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		btnEditProfile.setBorder(new LineBorder(SystemColor.textHighlight));
		btnEditProfile.setBounds(263, 75, 109, 23);
		contentPane.add(btnEditProfile);
		
		JButton btnViewFriends = new JButton("VIEW FRIENDS");
		btnViewFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registry reg;
				try {
					reg = LocateRegistry.getRegistry("localhost",1204);
					UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
				//	System.out.println(testUserPass.getName());				
					ViewFriends view = new ViewFriends();
					view.setusername(username);
					view.name2.setText( testUserPass.getName()  );
					MainMenu.this.setVisible(false);
		/*			ArrayList<String> arrlst1 = new ArrayList<String>(); 
					arrlst1= testUserPass.getFriends();
					String[] arrfriend= new String[arrlst1.size()];
					arrfriend=arrlst1.toArray(arrfriend);
				//	view.setarrayfriends(arrfriend);
					
					for(String s:arrfriend)
					{
						System.out.println(s);
					}*/
					view.setVisible(true);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewFriends.setBackground(SystemColor.control);
		btnViewFriends.setBorder(new LineBorder(SystemColor.textHighlight));
		btnViewFriends.setBounds(93, 135, 118, 23);
		contentPane.add(btnViewFriends);
		
		JButton btnViewGroups = new JButton("VIEW GROUPS");
		btnViewGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registry reg;
				try {
					reg = LocateRegistry.getRegistry("localhost",1204);
					UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
				//	System.out.println(testUserPass.getName());				
					
					Groups group = new Groups();
					group.setuserrname(username);
					group.setVisible(true);
					MainMenu.this.setVisible(false);
			//		System.out.println(group.getusername());
		/*			ArrayList<String> arrlst1 = new ArrayList<String>(); 
					arrlst1= testUserPass.getFriends();
					String[] arrfriend= new String[arrlst1.size()];
					arrfriend=arrlst1.toArray(arrfriend);
				//	view.setarrayfriends(arrfriend);
					
					for(String s:arrfriend)
					{
						System.out.println(s);
					}*/
					
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
							}
		});
		btnViewGroups.setBackground(SystemColor.control);
		btnViewGroups.setBorder(new LineBorder(SystemColor.textHighlight));
		btnViewGroups.setBounds(264, 135, 109, 23);
		contentPane.add(btnViewGroups);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientLogin client = new ClientLogin();
				client.setVisible(true);
				MainMenu.this.setVisible(false);
				
			}
		});
		btnLogout.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLogout.setBounds(324, 11, 76, 23);
		contentPane.add(btnLogout);
		
		name = new JTextField();
	//	ClientLogin client = new ClientLogin();
		
		name.setBorder(null);
		name.setEditable(false);
		name.setOpaque(false);
		name.setFont(new Font("Tahoma", Font.PLAIN, 21));
		name.setBounds(185, 22, 129, 31);
		contentPane.add(name);
		name.setColumns(10);
	}

}
