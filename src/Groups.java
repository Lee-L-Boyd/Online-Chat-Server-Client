import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.ArrayList;


public class Groups extends JFrame {

	private JPanel contentPane;
	private JTextField makegroup;
	public String username;
	public ChatServerServantInterface myServer;
	public Registry reg;
	public DefaultListModel<String> DLM4;
	public JList allgroupslist,mygroupslist;
	public JList list;
	public JTextArea addmsg,chatareagroup;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Groups frame = new Groups();
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
	
	public void setuserrname(String username)
	{
		this.username=username;
	}
	public String getusername()
	{
		return username;
	}
	

	public Groups() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
				main.setVisible(true);
				Groups.this.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBack.setBackground(SystemColor.control);
		btnBack.setBounds(352, 11, 72, 23);
		contentPane.add(btnBack);
		
		mygroupslist = new JList();
		mygroupslist.setBorder(new LineBorder(new Color(0, 0, 0)));
		mygroupslist.setBounds(112, 44, 87, 90);
		contentPane.add(mygroupslist);
		
		JButton joingroupbutton = new JButton("JOIN");
		joingroupbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				try{
					reg = LocateRegistry.getRegistry("localhost",1204);
					String selected = (String)allgroupslist.getSelectedValue().toString();
					UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
					UserGroupInterface testUserGroup = (UserGroupInterface) reg.lookup ("group"+selected);
					testUserGroup.addUser(username);
					System.out.println(username);
					
					}
				
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				
			}
		});
		joingroupbutton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		joingroupbutton.setBackground(SystemColor.control);
		joingroupbutton.setBounds(20, 175, 72, 23);
		contentPane.add(joingroupbutton);
		
		makegroup = new JTextField();
		makegroup.setBounds(246, 43, 86, 20);
		contentPane.add(makegroup);
		makegroup.setColumns(10);
		
		JButton makegroupbutton = new JButton("NEW");
		makegroupbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					reg= LocateRegistry.getRegistry("localhost",1204);
			    	myServer=(ChatServerServantInterface) reg.lookup("chat");
			    	myServer.makeGroup(makegroup.getText(), username);
			    	myServer.addGroupToRegistry(makegroup.getText());
			    	makegroup.setText("");
			    	
			    	
			    	
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		makegroupbutton.setBackground(SystemColor.controlHighlight);
		makegroupbutton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		makegroupbutton.setBounds(352, 42, 72, 23);
		contentPane.add(makegroupbutton);
		
		JButton mygroups = new JButton("MY GROUPS");
		mygroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					reg = LocateRegistry.getRegistry("localhost",1204);
					myServer=(ChatServerServantInterface) reg.lookup("chat");
					ArrayList<String> testGroups = new ArrayList<String>();
			    	testGroups=myServer.getGroupsOfUser(username);
					
			    	String invitearray[] = new String[testGroups.size()];
					invitearray=testGroups.toArray(invitearray);
					 DLM4 = new DefaultListModel();
					
			/*		for(int i=0;i<arrlst.size();i++)
					{
						System.out.println(arrlst.get(i));
					}
					*/
					for(String s:testGroups)
					{
						System.out.println(s);
				//		listmodel.addElement(s);
					//	list = new JList();
						
						DLM4.addElement(s);
					}
					
					mygroupslist.setModel(DLM4);
					//	testUserGroup.deleteUser(username);
					
				
					
			//		JOptionPane.showMessageDialog(null, selected+ " deleted !!!",null,JOptionPane.INFORMATION_MESSAGE);
					
					}
				
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				
				
			}
		});
		mygroups.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mygroups.setBackground(SystemColor.control);
		mygroups.setBounds(106, 11, 99, 23);
		contentPane.add(mygroups);
		
		JButton leave = new JButton("LEAVE");
		leave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					reg = LocateRegistry.getRegistry("localhost",1204);
					String selected = (String)allgroupslist.getSelectedValue().toString();
					UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
					UserGroupInterface testUserGroup = (UserGroupInterface) reg.lookup ("group"+selected);
					testUserGroup.deleteUser(username);
					
					JOptionPane.showMessageDialog(null, selected+ " deleted !!!",null,JOptionPane.INFORMATION_MESSAGE);
					
					}
				
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
			}
		});
		leave.setBackground(SystemColor.control);
		leave.setFont(new Font("Tahoma", Font.PLAIN, 11));
		leave.setBounds(325, 227, 99, 23);
		contentPane.add(leave);
		
		JButton members = new JButton("MEMBERS");
		members.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					reg= LocateRegistry.getRegistry("localhost",1204);
			    	myServer=(ChatServerServantInterface) reg.lookup("chat");
			    	String selected = (String)allgroupslist.getSelectedValue().toString();
			    	UserGroupInterface testUserGroup = (UserGroupInterface) reg.lookup ("group"+selected);
				ArrayList<String> testGroups = new ArrayList<String>();
				testGroups = testUserGroup.getUsers();
				String invitearray[] = new String[testGroups.size()];
				invitearray=testGroups.toArray(invitearray);
				 DLM4 = new DefaultListModel();
		    	for(String name1 : testGroups){
		    	System.out.println("User names in "+selected+" : " + name1);
		    	DLM4.addElement(name1);
		    	}
				list.setModel(DLM4);
		    	
		    	
				}
				catch(Exception e2)
				
				{
					e2.printStackTrace();
				}
			}
		});
		members.setFont(new Font("Tahoma", Font.PLAIN, 11));
		members.setBackground(SystemColor.control);
		members.setBounds(112, 227, 87, 23);
		contentPane.add(members);
		
		 chatareagroup = new JTextArea();
		 chatareagroup.setLineWrap(true);
		chatareagroup.setBorder(new LineBorder(new Color(0, 0, 0)));
		chatareagroup.setEditable(false);
		chatareagroup.setBounds(215, 74, 209, 90);
		contentPane.add(chatareagroup);
		
		addmsg = new JTextArea();
		addmsg.setBorder(new LineBorder(new Color(0, 0, 0)));
		addmsg.setBounds(283, 175, 141, 38);
		contentPane.add(addmsg);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					reg= LocateRegistry.getRegistry("localhost",1204);
			    	myServer=(ChatServerServantInterface) reg.lookup("chat");
			    	String selected = (String)allgroupslist.getSelectedValue().toString();
			    	UserGroupInterface testUserGroup = (UserGroupInterface) reg.lookup ("group"+selected);
			    	String msg= addmsg.getText();
			    	Date date=new Date();
			    	testUserGroup.addComment(username, msg +date);
			    	addmsg.setText("");
			    	
				}
				catch(Exception e2)
				
				{
					e2.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdd.setBackground(SystemColor.control);
		btnAdd.setBounds(215, 175, 60, 36);
		contentPane.add(btnAdd);
		
		JButton btnMessages = new JButton("MESSAGES");
		btnMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					reg= LocateRegistry.getRegistry("localhost",1204);
			    	myServer=(ChatServerServantInterface) reg.lookup("chat");
			    	String selected = (String)allgroupslist.getSelectedValue().toString();
			    	UserGroupInterface testUserGroup = (UserGroupInterface) reg.lookup ("group"+selected);
			   // 	testUserGroup.addComment(username, "hello first comment");
			    	chatareagroup.setText("");
			    	ArrayList<Comment> testComments = testUserGroup.getComments();
			    	for(Comment comment : testComments){
			    	//	System.out.println(comment.getComment() + ", " + comment.getUsername());
			    		chatareagroup.append((String)comment.getComment() + ", " + comment.getUsername()+ "\n");
			    	}
				}
				catch(Exception e2)
				
				{
					e2.printStackTrace();
				}
			}
		});
		btnMessages.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMessages.setBackground(SystemColor.control);
		btnMessages.setBounds(226, 227, 89, 23);
		contentPane.add(btnMessages);
		
		list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list.setBounds(112, 145, 87, 71);
		contentPane.add(list);
		
		allgroupslist = new JList();
		allgroupslist.setBorder(new LineBorder(new Color(0, 0, 0)));
		allgroupslist.setBackground(new Color(255, 255, 255));
		allgroupslist.setBounds(20, 45, 72, 119);
		contentPane.add(allgroupslist);
		
		JButton btnViewGroups = new JButton("ALL GROUPS");
		btnViewGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					reg= LocateRegistry.getRegistry("localhost",1204);
			    	myServer=(ChatServerServantInterface) reg.lookup("chat");
				ArrayList<String> testGroups = new ArrayList<String>();
		    	testGroups=myServer.getAllGroups();
		    	String invitearray[] = new String[testGroups.size()];
				invitearray=testGroups.toArray(invitearray);
				 DLM4 = new DefaultListModel();
				
		/*		for(int i=0;i<arrlst.size();i++)
				{
					System.out.println(arrlst.get(i));
				}
				*/
				for(String s:testGroups)
				{
					System.out.println(s);
			//		listmodel.addElement(s);
				//	list = new JList();
					
					DLM4.addElement(s);
				}
				
				allgroupslist.setModel(DLM4);
		    	
		    	
				}
				catch(Exception e2)
				
				{
					e2.printStackTrace();
				}
			}
		});
		btnViewGroups.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnViewGroups.setBackground(SystemColor.control);
		btnViewGroups.setBounds(0, 11, 99, 23);
		contentPane.add(btnViewGroups);
	}

}
