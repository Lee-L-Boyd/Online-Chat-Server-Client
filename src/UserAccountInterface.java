import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/*
public interface UserAccountInterface extends Remote {
	public void deleteFriend2(String username) throws RemoteException;
	public void sendMessage(String username1, String newMessage) throws RemoteException;
	public void recvMessage(String username1, Message newMessage) throws RemoteException;
	public ArrayList<String> getFriends() throws RemoteException;
	public void deactivate() throws RemoteException;
	public void activate() throws RemoteException;
	public void deleteFriend(String username) throws RemoteException;
	public void addFriend(String username) throws RemoteException;
	public ArrayList<String> getInvited() throws RemoteException;
	public void acceptInvite(String username) throws RemoteException;
	public void showGroups() throws RemoteException;
	public void joinGroup(String groupName) throws RemoteException;
	public void leaveGroup(String groupName) throws RemoteException;
	public void sendGroupMessage(String groupName, String message) throws RemoteException;
	public ArrayList<Comment> readGroupMessages(String groupName) throws RemoteException;
	public void showFriends() throws RemoteException;
	public String getProf() throws RemoteException;
	public String getGradYear() throws RemoteException;
	public String getName() throws RemoteException;
	public String getCity() throws RemoteException;
	public String getCollege() throws RemoteException;
	public String getUsername() throws RemoteException;
	public String getPassword() throws RemoteException;
	public void setProf(String prof) throws RemoteException;
	public void setGradYear(String gradYear) throws RemoteException;
	public void setName(String name) throws RemoteException;
	public void setCity(String city) throws RemoteException;
	public void setCollege(String college) throws RemoteException;
	//public void setUsername(String username) throws RemoteException;
	public void setPassword(String password) throws RemoteException;
	public void addThisUserToInviteList(String requesting) throws RemoteException;
	public void tooString() throws RemoteException;
	public Messages getMessages(String username) throws RemoteException;
	public ArrayList<String> getInviting() throws RemoteException;
}
*/

public interface UserAccountInterface extends Remote {
	public void unsetStar(String username) throws RemoteException;
	public void deleteFriend2(String username) throws RemoteException;
	public void sendMessage(String username1, String newMessage) throws RemoteException;
	public void recvMessage(String username1, Message newMessage) throws RemoteException;
	public ArrayList<String> getFriends() throws RemoteException;
	public void deactivate() throws RemoteException;
	public void activate() throws RemoteException;
	public void deleteFriend(String username) throws RemoteException;
	public void addFriend(String username) throws RemoteException;
	public ArrayList<String> getInvited() throws RemoteException;
	public void acceptInvite(String username) throws RemoteException;
	public void showGroups() throws RemoteException;
	public void joinGroup(String groupName) throws RemoteException;
	public void leaveGroup(String groupName) throws RemoteException;
	public void sendGroupMessage(String groupName, String message) throws RemoteException;
//	public ArrayList<String> readGroupMessages(String groupName) throws RemoteException;
	public void showFriends() throws RemoteException;
	public String getProf() throws RemoteException;
	public String getGradYear() throws RemoteException;
	public String getName() throws RemoteException;
	public String getCity() throws RemoteException;
	public String getCollege() throws RemoteException;
	public String getUsername() throws RemoteException;
	public String getPassword() throws RemoteException;
	public void setProf(String prof) throws RemoteException;
	public void setGradYear(String gradYear) throws RemoteException;
	public void setName(String name) throws RemoteException;
	public void setCity(String city) throws RemoteException;
	public void setCollege(String college) throws RemoteException;
	//public void setUsername(String username) throws RemoteException;
	public void setPassword(String password) throws RemoteException;
	public void addThisUserToInviteList(String requesting) throws RemoteException;
	public void tooString() throws RemoteException;
	public Messages getMessages(String username) throws RemoteException;
	public ArrayList<String> getInviting() throws RemoteException;
	public boolean testIfMessagesExist(String outUsername, String username) throws RemoteException;
}
