import java.rmi.*;
import java.util.ArrayList;

public interface ChatServerServantInterface extends Remote{
//	public void getNewAccount(UserAccount myInfo) throws RemoteException;
	public boolean getNewAccount(String name, String prof, String city, String company, String college, String gradYear, String password, String username) throws RemoteException;
	public void login(UserAccount myLogin) throws RemoteException;
	public void creatGroup(String username)throws RemoteException;
	void Login(String username) throws RemoteException;
	boolean findAUser(String username) throws RemoteException;
	public void test(String teset) throws RemoteException;
	public boolean makeGroup(String groupname, String username) throws RemoteException;
	public ArrayList<String> getAllGroups() throws RemoteException;
	public void addGroupToRegistry(String groupname) throws RemoteException;
	public ArrayList<String> getGroupsOfUser(String username) throws RemoteException;
}
