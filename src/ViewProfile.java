import java.awt.BorderLayout;
import java.awt.EventQueue;

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


public class ViewProfile extends JFrame {

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
					ViewProfile frame = new ViewProfile();
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
	public ViewProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourProfile = new JLabel("Your Profile");
		lblYourProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYourProfile.setBounds(167, 25, 120, 27);
		contentPane.add(lblYourProfile);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(95, 61, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblProfession = new JLabel("Profession:");
		lblProfession.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProfession.setBounds(95, 86, 75, 14);
		contentPane.add(lblProfession);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCity.setBounds(95, 111, 75, 14);
		contentPane.add(lblCity);
		
		JLabel lblCompany = new JLabel("");
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompany.setBounds(95, 136, 75, 14);
		contentPane.add(lblCompany);
		
		JLabel lblCollege = new JLabel("College:");
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCollege.setBounds(95, 142, 75, 14);
		contentPane.add(lblCollege);
		
		JLabel lblGraduationYear = new JLabel("Graduation year:");
		lblGraduationYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGraduationYear.setBounds(95, 186, 97, 14);
		contentPane.add(lblGraduationYear);
		
		name = new JTextField();
		name.setBorder(new LineBorder(SystemColor.desktop));
		name.setEditable(false);
		name.setBounds(201, 59, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		profession = new JTextField();
		profession.setBorder(new LineBorder(SystemColor.desktop));
		profession.setEditable(false);
		profession.setColumns(10);
		profession.setBounds(201, 84, 86, 20);
		contentPane.add(profession);
		
		city = new JTextField();
		city.setBorder(new LineBorder(SystemColor.desktop));
		city.setEditable(false);
		city.setColumns(10);
		city.setBounds(201, 109, 86, 20);
		contentPane.add(city);
		
		company = new JTextField();
		company.setBorder(null);
		company.setEditable(false);
		company.setColumns(10);
		company.setBounds(325, 230, 86, 20);
		contentPane.add(company);
		
		college = new JTextField();
		college.setBorder(new LineBorder(SystemColor.desktop));
		college.setEditable(false);
		college.setColumns(10);
		college.setBounds(201, 140, 86, 20);
		contentPane.add(college);
		
		year = new JTextField();
		year.setBorder(new LineBorder(SystemColor.desktop));
		year.setEditable(false);
		year.setColumns(10);
		year.setBounds(201, 184, 86, 20);
		contentPane.add(year);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Click OK to logout!!!");
				
				ViewProfile.this.setVisible(false);
			//	view.dispose();
			}
		});
		btnNewButton_1.setBounds(335, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
				ViewProfile.this.setVisible(false);
				main.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(22, 11, 75, 23);
		contentPane.add(btnNewButton_2);
	}

}
