import java.util.*;
import java.util.Hashtable;


public class UserAccounts {
	//public static ArrayList<AcctInfo> UserAccts;
	Hashtable<String, UserAccount> UserAccts; //hashed based on username - no two usernames should be same!!
	UserAccounts(){
		UserAccts=new Hashtable<String, UserAccount>();
	}
	public synchronized void activate(String username){ //this should change the active variable to true
		
	}
	public synchronized boolean addAccount(UserAccount newAcct){ //this should make sure there is no one with same username before adding
		if(!UserAccts.containsKey(newAcct.getUsername())){
			UserAccts.put(newAcct.getUsername(), newAcct);
		System.out.println("That is not already a username");
			return true;
		}
			else {
				return false;
			}
	}
	public synchronized void deleteAccount(){ //remove from hashtable
		
	}
	public boolean findAUser(String username){
		
		if (!UserAccts.isEmpty()){
			return (UserAccts.get(username).username.equals(username));
		}
		else
			return false;
	}
	public UserAccount login(String username){
		//if (UserAccts.get(username).username == username){
			return UserAccts.get(username);
		
		//else return null;
	}
}
