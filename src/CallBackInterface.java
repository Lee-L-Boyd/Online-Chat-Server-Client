import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CallBackInterface extends Remote{
	public void refreshFriends(String username, String username2) throws RemoteException;
}
