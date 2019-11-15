import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface UserGroupInterface extends Remote{
	public Boolean verifyGroupMember(String username) throws RemoteException;
	public ArrayList<String> getUsers() throws RemoteException;
	public boolean addComment(String username, String rawComment) throws RemoteException;
	public ArrayList<Comment> getComments() throws RemoteException;
	public void addUser(String username) throws RemoteException;
	public void deleteUser(String username) throws RemoteException;
	public String tooString() throws RemoteException;
}

