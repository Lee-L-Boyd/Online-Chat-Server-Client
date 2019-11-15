import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class CallBack extends UnicastRemoteObject implements CallBackInterface{
	//JButton testButton;
	Registry reg;
	ChatServerServantInterface myServer;
	protected CallBack() throws RemoteException {
		reg= LocateRegistry.getRegistry("localhost",1204);
		try {
			myServer=(ChatServerServantInterface) reg.lookup("chat");
				
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	public void refreshFriends(String username,String username2){
		try {
			//myServer.findAUser(username);
			UserAccountInterface myUser = (UserAccountInterface) reg.lookup("user"+username);
			myUser.unsetStar(username2);
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}