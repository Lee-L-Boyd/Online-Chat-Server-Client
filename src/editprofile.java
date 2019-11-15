import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class editprofile extends JFrame {

	private JPanel contentPane;
	public static JTextField name;
	public static JTextField profession;
	public static JTextField city;
	public static JTextField company;
	public static JTextField college;
	public static JTextField year;
	public static String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editprofile frame = new editprofile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setusername(String username)
	{
		this.username=username;
		System.out.println(username);
		
	}
	public String getusername()
	{
		return username;
	}
	/**
	 * Create the frame.
	 */
	public editprofile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditYourProfile = new JLabel("Edit your Profile");
		lblEditYourProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEditYourProfile.setBounds(148, 22, 142, 29);
		contentPane.add(lblEditYourProfile);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(108, 70, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblProfession = new JLabel("Profession:");
		lblProfession.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProfession.setBounds(108, 109, 66, 14);
		contentPane.add(lblProfession);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCity.setBounds(108, 134, 46, 14);
		contentPane.add(lblCity);
		
		JLabel lblCompany = new JLabel("College:");
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompany.setBounds(108, 159, 66, 14);
		contentPane.add(lblCompany);
		
		JLabel lblCollege = new JLabel("");
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCollege.setBounds(108, 175, 46, 14);
		contentPane.add(lblCollege);
		
		JLabel lblGraduationYear = new JLabel("Graduation Year:");
		lblGraduationYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGraduationYear.setBounds(108, 190, 98, 14);
		contentPane.add(lblGraduationYear);
		
		name = new JTextField();
		name.setBounds(220, 68, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		profession = new JTextField();
		profession.setColumns(10);
		profession.setBounds(220, 99, 86, 20);
		contentPane.add(profession);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(220, 126, 86, 20);
		contentPane.add(city);
		
		company = new JTextField();
		company.setBorder(null);
		company.setBackground(SystemColor.control);
		company.setColumns(10);
		company.setBounds(317, 265, 86, 20);
		contentPane.add(company);
		
		college = new JTextField();
		college.setBackground(SystemColor.text);
		college.setColumns(10);
		college.setBounds(220, 157, 86, 20);
		contentPane.add(college);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(220, 188, 86, 20);
		contentPane.add(year);
		
		JButton btnNewButton = new JButton("EDIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		Registry reg;
		try {
			reg = LocateRegistry.getRegistry("localhost",1204);
			UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
			testUserPass.setName(name.getText());
		//	System.out.println(testUserPass.getName());
			testUserPass.setCity(city.getText());
			testUserPass.setCollege(college.getText());
			testUserPass.setGradYear(year.getText());
			testUserPass.setProf(profession.getText());
			JOptionPane.showMessageDialog(null, "        Account has been updated !!!",null,JOptionPane.INFORMATION_MESSAGE);
			
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
				
			}
		});
		btnNewButton.setBorder(new LineBorder(SystemColor.textHighlight));
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setBounds(161, 242, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
				editprofile.this.setVisible(false);
				main.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(10, 11, 74, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/edit_user.png")).getImage();
		label.setIcon(new ImageIcon(img1));
		label.setBounds(326, 71, 182, 185);
		contentPane.add(label);
	}

}
