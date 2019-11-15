import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JSpinner;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.AbstractListModel;


public class ViewFriends extends JFrame {

	private JPanel contentPane;
	private JTextField friend;
	private JTextField deletefriend;
	public static String username;
	public static JTextArea textArea;
//	private JList<String> list;
	public JList list;
	public JList list_1;
	public JTextArea addmsg;
	public JTextArea chatarea;
//	private DefaultListModel<String> listmodel= new DefaultListModel<String>();
	public DefaultListModel<String> DLM;
	
	public static JTextField name2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFriends frame = new ViewFriends();
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
	//	System.out.println(username);
		
	}
	public String getusername()
	{
		return username;
	}
	 /*
	public void refreshfriends(String username)
	{
			
		Registry reg;
		try {
			reg = LocateRegistry.getRegistry("localhost",1204);
			UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
			Messages testMessages = testUserPass.getMessages(username);
		//	if(testMessages.setStar()
			{
			for(Message myMessage : testMessages.getMessages()){
			//	if(myMessage.)
			    //		System.out.println(myMessage.getMessage());
			    		
			    	//	chatarea.append((String)myMessage.getMessage()+ "\n");
			    	
			}
			
			
		} catch (RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	*/
	
/*	public void setarrayfriends(String[] friends)
	{
		for(String s:friends){
			System.out.println(s);
		}
		
	//	list_1 = new JList();
	//	DefaultListModel<String> DLM1 = new DefaultListModel();
		
		
	}*/
	/**
	 * Create the frame.
	 */
	public ViewFriends() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewFriends = new JLabel("FRIENDS");
		lblViewFriends.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblViewFriends.setBounds(48, 45, 172, 20);
		contentPane.add(lblViewFriends);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
				main.setVisible(true);
				ViewFriends.this.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBack.setBackground(SystemColor.control);
		btnBack.setBounds(10, 11, 70, 23);
		contentPane.add(btnBack);
		
		chatarea = new JTextArea();
		chatarea.setLineWrap(true);
		chatarea.setEditable(false);
		chatarea.setBorder(new LineBorder(new Color(0, 0, 0)));
		chatarea.setBounds(333, 66, 288, 153);
		contentPane.add(chatarea);
		
		addmsg = new JTextArea();
		addmsg.setBorder(new LineBorder(new Color(0, 0, 0)));
		addmsg.setBounds(333, 230, 288, 95);
		contentPane.add(addmsg);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registry reg;
				try {
					reg = LocateRegistry.getRegistry("localhost",1204);
					UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
			//	System.out.println(testUserPass.getUsername());
					String msg= addmsg.getText();
				//	System.out.println(msg);
				//	String testmessage="testMessage here";
					Date date = new Date();
				//	System.out.println(date);
					String selected1 = (String)list_1.getSelectedValue().toString();
					if(selected1.startsWith("*"))
					{
						selected1=selected1.substring(1);
						
					}
			    	testUserPass.sendMessage(selected1,	testUserPass.getUsername() + " " +date + ":    " +msg);
			    	addmsg.setText("");
		/*	    	Messages testMessages = testUserPass.getMessages(selected1);
			    	for(Message myMessage : testMessages.getMessages()){
			    		System.out.println(myMessage.getMessage());
			    	}*/
				/*	String user= friend.getText();
				//	Syste
			//		System.out.println(testUserPass.getName());
			//		System.out.println((friend.getText()));
					testUserPass.addFriend(friend.getText());
					friend.setText("");
				//	System.out.println(friend.getText());				
				//	ViewFriends view = new ViewFriends();
				//	view.setusername(username);
				//	view.setVisible(true);
				*/
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNewButton.setBounds(157, 264, 164, 60);
		contentPane.add(btnNewButton);
		
		friend = new JTextField();
		friend.setBounds(450, 12, 86, 20);
		contentPane.add(friend);
		friend.setColumns(10);
		
		JLabel lblAddFriend = new JLabel("Add Friend:");
		lblAddFriend.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddFriend.setBounds(370, 14, 70, 14);
		contentPane.add(lblAddFriend);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registry reg;
				try {
					reg = LocateRegistry.getRegistry("localhost",1204);
					UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
				//	String user= friend.getText();
				//	Syste
			//		System.out.println(testUserPass.getName());
			//		System.out.println((friend.getText()));
					testUserPass.addFriend(friend.getText());
					friend.setText("");
				//	System.out.println(friend.getText());				
				//	ViewFriends view = new ViewFriends();
				//	view.setusername(username);
				//	view.setVisible(true);
				
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdd.setBackground(SystemColor.control);
		btnAdd.setBounds(546, 7, 77, 23);
		contentPane.add(btnAdd);
		
		JLabel lblDeleteFriend = new JLabel("Delete Friend:");
		lblDeleteFriend.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDeleteFriend.setBounds(370, 41, 86, 14);
		contentPane.add(lblDeleteFriend);
		
		deletefriend = new JTextField();
		deletefriend.setColumns(10);
		deletefriend.setBounds(450, 39, 86, 20);
		contentPane.add(deletefriend);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registry reg;
				try {
					reg = LocateRegistry.getRegistry("localhost",1204);
					UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
					System.out.println(deletefriend.getText());	
					testUserPass.deleteFriend2(deletefriend.getText());
					
					String friend1=deletefriend.getText().toString();
					
					deletefriend.setText("");
					JOptionPane.showMessageDialog(null, friend1+ " deleted !!!",null,JOptionPane.INFORMATION_MESSAGE);
								
				//	ViewFriends view = new ViewFriends();
				//	view.setusername(username);
				//	view.setVisible(true);
				
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDelete.setBackground(SystemColor.menu);
		btnDelete.setBounds(546, 38, 77, 23);
		contentPane.add(btnDelete);
		
		list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(178, 79, 117, 106);
		contentPane.add(list);
		
		JButton btnNewButton_1 = new JButton("VIEW REQUEST");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registry reg;
				try {
					reg = LocateRegistry.getRegistry("localhost",1204);
					UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
					ArrayList<String> arrlst = new ArrayList<String>(); 
					arrlst=testUserPass.getInviting();
					String invitearray[] = new String[arrlst.size()];
					invitearray=arrlst.toArray(invitearray);
					 DLM = new DefaultListModel();
					
			/*		for(int i=0;i<arrlst.size();i++)
					{
						System.out.println(arrlst.get(i));
					}
					*/
					for(String s:invitearray)
					{
						System.out.println(s);
				//		listmodel.addElement(s);
					//	list = new JList();
						
						DLM.addElement(s);
					}
					
					list.setModel(DLM);
					
				//	 list = new JList<String>(invitearray);
					
				//	String[] name = {"maanak"};
					
				//	list.setSelectedIndex(0);
				//	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					
					
			/*		SpinnerModel model1 = new SpinnerListModel(invitearray);
					JSpinner spinner = new JSpinner(model1);
					spinner.setBounds(176, 45, 119, 106);
					contentPane.add(spinner);*/
				//	testUserPass.
				//	testUserPass.deleteFriend(friend.getText());
				//	System.out.println(friend.getText());				
				//	ViewFriends view = new ViewFriends();
				//	view.setusername(username);
				//	view.setVisible(true);
				
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setBounds(178, 46, 117, 23);
		contentPane.add(btnNewButton_1);
		
		
	/*	JSpinner spinner = new JSpinner();
		spinner.setBounds(176, 45, 119, 106);
		contentPane.add(spinner);
	*/	
		JButton btnAccept = new JButton("ACCEPT");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registry reg;
				try{
				reg = LocateRegistry.getRegistry("localhost",1204);
				UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
				String selected = (String)list.getSelectedValue().toString();
			//	System.out.println(selected);
				testUserPass.acceptInvite(selected);
				
				JOptionPane.showMessageDialog(null, selected+"'s Friend request accepted !!!",null,JOptionPane.INFORMATION_MESSAGE);
				
				int index = list.getSelectedIndex();
				System.out.println(index);
				if(index!=-1)
				{
				//	list.setVisible(false);
					DLM.remove(index);
				//	list.remove(index);
					
					
				}
			/*	if(index>0)
				{
					DLM.removeElementAt(index);
				}
			*/	
				ArrayList<String> arrlst1 = new ArrayList<String>(); 
				arrlst1= testUserPass.getFriends();
			//	arrlst1= testUserPass.getInviting();
				
		/*		for(int i=0;i<arrlst1.size();i++)
				{
					System.out.println(arrlst1.get(i));
				} */
		//		System.out.println(arrlst1.get(0));
				String[] arrfriend= new String[arrlst1.size()];
				arrfriend=arrlst1.toArray(arrfriend);
				for(String s:arrfriend)
				{
		//			System.out.println(s);
				}
				
				
		//		testUserPass.acceptInvite(username);
				}
				catch(RemoteException e2){
					e2.printStackTrace();
					
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAccept.setBackground(SystemColor.control);
		btnAccept.setBounds(157, 196, 77, 23);
		contentPane.add(btnAccept);
		
		JButton btnNewButton_2 = new JButton("REJECT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = list.getSelectedIndex();
				System.out.println(index);
				if(index!=-1)
				{
					DLM.remove(index);
					JOptionPane.showMessageDialog(null, "        Friend request deleted !!!",null,JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.setBounds(246, 196, 77, 23);
		contentPane.add(btnNewButton_2);
		
		list_1 = new JList();
		list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_1.setBounds(10, 76, 137, 209);
		contentPane.add(list_1);
		
		JButton viewfriends = new JButton("VIEW FRIENDS");
		viewfriends.setFont(new Font("Tahoma", Font.PLAIN, 11));
		viewfriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Registry reg;
				try{
				reg = LocateRegistry.getRegistry("localhost",1204);
				UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
			//	String selected = (String)list.getSelectedValue().toString();
			//	System.out.println(selected);
			//	testUserPass.acceptInvite(selected);
				
			//	JOptionPane.showMessageDialog(null, "        Friend request accepted !!!",null,JOptionPane.INFORMATION_MESSAGE);
				
				
				ArrayList<String> arrlst1 = new ArrayList<String>(); 
				arrlst1= testUserPass.getFriends();
			//	arrlst1= testUserPass.getInviting();
				
		/*		for(int i=0;i<arrlst1.size();i++)
				{
					System.out.println(arrlst1.get(i));
				} */
		//		System.out.println(arrlst1.get(0));
				String[] arrfriend= new String[arrlst1.size()];
				System.out.println(arrlst1.size());
				DefaultListModel<String> DLM1 = new DefaultListModel();
				arrfriend=arrlst1.toArray(arrfriend);
				if(arrlst1.isEmpty())
					
				{
					DLM1.addElement("");
					list_1.setModel(DLM1);
				}
				else 
				{
				for(String s:arrfriend)
				{	
					if(testUserPass.testIfMessagesExist(s,username))
					{
						if(testUserPass.getMessages(s).getStar())
						{
							DLM1.addElement("*"+s);
							System.out.println("Added to friends star    "+ s);
						}

						else
						{
							DLM1.addElement(s);
							System.out.println("Added to friends"+ s);
						}
					
					}
					else
					{
						DLM1.addElement(s);
						System.out.println("Added to friends"+ s);
					}
					
					
				list_1.setModel(DLM1);
				
				
		//		testUserPass.acceptInvite(username);
				}
				}
				}
				catch(RemoteException e2){
					e2.printStackTrace();
					
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		viewfriends.setBackground(SystemColor.control);
		viewfriends.setBounds(10, 296, 128, 23);
		contentPane.add(viewfriends);
		
		JButton ViewMessages = new JButton("VIEW MESSAGES");
		ViewMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registry reg;
				try {
					reg = LocateRegistry.getRegistry("localhost",1204);
					UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
			//	System.out.println(testUserPass.getUsername());
					//String msg= addmsg.getText();
				//	System.out.println(msg);
				//	String testmessage="testMessage here";
				//	Date date = new Date();
				//	System.out.println(date);
					String selected1 = (String)list_1.getSelectedValue().toString();
					
			    //	testUserPass.sendMessage(selected1,	date +"    " +msg);
			    //	addmsg.setText("");
					chatarea.setText("");
					if(selected1.startsWith("*"))
					{
						selected1=selected1.substring(1);
						
					}
			    	Messages testMessages = testUserPass.getMessages(selected1);
			    	
			    	for(Message myMessage : testMessages.getMessages()){
			    //		System.out.println(myMessage.getMessage());
			    		
			    		chatarea.append((String)myMessage.getMessage()+ "\n");
			    	//	testMessages.unsetStar();
		    			
			    	}
			    //	if(username.equals(testMessages.getstarname()))
			    			
			    	CallBackInterface myCallBack=(CallBackInterface) reg.lookup("cb"+username);
					System.out.println("Calling callback");
					myCallBack.refreshFriends(username, selected1);
			    //	testUserPass.unsetStar(selected1);
			    //	testMessages.unsetStar();
			    			
			    //	System.out.println(username + selected1);
			    //	chatarea.setText("");
				/*	String user= friend.getText();
				//	Syste
			//		System.out.println(testUserPass.getName());
			//		System.out.println((friend.getText()));
					testUserPass.addFriend(friend.getText());
					friend.setText("");
				//	System.out.println(friend.getText());				
				//	ViewFriends view = new ViewFriends();
				//	view.setusername(username);
				//	view.setVisible(true);
				*/
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		ViewMessages.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ViewMessages.setBackground(SystemColor.control);
		ViewMessages.setBounds(163, 230, 145, 23);
		contentPane.add(ViewMessages);
		
		name2 = new JTextField();
		name2.setFont(new Font("Arial Unicode MS", Font.BOLD, 14));
		name2.setBorder(null);
		name2.setEditable(false);
		name2.setBounds(160, 12, 65, 20);
		contentPane.add(name2);
		name2.setColumns(10);
		
		JLabel lblFriends = new JLabel("FRIENDS");
		lblFriends.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFriends.setBounds(230, 15, 65, 14);
		contentPane.add(lblFriends);
		
		
		
		
	}
}
