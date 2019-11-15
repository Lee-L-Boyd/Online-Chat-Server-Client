import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;


public class ChatServerServant extends UnicastRemoteObject implements ChatServerServantInterface, Serializable{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	Registry reg;
	static UserAccounts allAccounts;
	static UserGroups allGroups;
	protected ChatServerServant(Registry reg) throws RemoteException{
		// clientList = Collections.synchronizedList(new ArrayList<clientIF>());
		//reg= LocateRegistry.createRegistry(1204);
		this.reg=reg;
		allAccounts =new UserAccounts();
		allGroups = new UserGroups();
		//allGroups.addGroup(new UserGroup("testtesttest", "test"));
		
	}
	public void getNewAccount(UserAccount myInfo){
		allAccounts.addAccount(myInfo);
	}
	public boolean getNewAccount(String name, String prof, String city, String company, String college, String gradYear, String password, String username){
		try {
			return allAccounts.addAccount(new UserAccount(name, prof,city,company,college,gradYear,password,username));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public void test(String teset){
		System.out.println(teset);
	}
	public void login(UserAccount myLogin){
		allAccounts.activate(myLogin.username);
	}
	public void creatGroup(String username){
		
	}
	/*private UserAccount findUser(String username){
		return allAccounts.findUser(username)
	}*/
	
	public boolean findAUser(String username){
		return allAccounts.findAUser(username);
	}
	
	public void Login(String username){
		try {
			
			
		      reg.rebind ("user"+username, allAccounts.login(username));
		      System.out.println ("User user"+username+" added to registry.");
		    } catch (Exception e) {
		      System.out.println ("Registry add failed for User user"+username + e);
		    }
	}
	private void findGroup(String groupname){
		try {
		      Naming.rebind ("group"+groupname, allGroups.findGroup(groupname));
		      System.out.println ("Group added to registry.");
		    } catch (Exception e) {
		      System.out.println ("Registry add failed: " + e);
		    }
	}
	public boolean makeGroup(String groupname, String username){
		try {
			System.out.println("In makegroup");
			return allGroups.addGroup(new UserGroup(groupname, username));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<String> getGroupsOfUser(String username){
		ArrayList<String> groups = new ArrayList<String>();
		UserGroup group;
		Enumeration<UserGroup> e = allGroups.userGroups.elements();
		while(e.hasMoreElements()){
			group = e.nextElement();
			if(group.verifyGroupMember(username)){
				groups.add(group.groupName);
			}
		}
		return groups;	
	}
	
	public ArrayList<String> getAllGroups(){
		return this.allGroups.getAllGroups();
	}
	public void addGroupToRegistry(String groupname){
		try {
		      reg.rebind ("group"+groupname, allGroups.findGroup(groupname));
		      System.out.println ("Group group"+groupname+" added to registry.");
		    } catch (Exception e) {
		      System.out.println ("Registry add failed for Group group"+groupname + e);
		    }
	}
}
