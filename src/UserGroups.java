import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
/*

public class UserGroups implements Serializable {
	static Hashtable<String, UserGroup> userGroups; //hashed based on username - no two usernames should be same!!
	UserGroups(){
		userGroups=new Hashtable<String, UserGroup>();
	}
	public Boolean checkIfGroupName(String groupName){
		return false; //this should return false if the groupname already exists
	}
	public synchronized void addGroup(UserGroup newGroup){ //this should make sure there is no one with same username before adding
		if (!checkIfGroupName(newGroup.groupName)){
			//add group to list
		}
	}
	public synchronized void deleteGroup(String groupName){ //remove from hashtable
		
	}
	public static ArrayList<Comment> getComments(String groupName){
		return userGroups.get(groupName).getComments();
	}
	public UserGroup findGroup(String groupname){
		if (userGroups.get(groupname).groupName == groupname){
			return userGroups.get(groupname);
		}
		else return null;
	}
}
*/

public class UserGroups implements Serializable{
	Hashtable<String, UserGroup> userGroups; //hashed based on username - no two usernames should be same!!
	UserGroups(){
		userGroups=new Hashtable<String, UserGroup>();
	}
	public Boolean checkIfGroupName(String groupName){
			return (userGroups.containsKey(groupName));
	}
	public synchronized boolean addGroup(UserGroup newGroup){ //this should make sure there is no one with same username before adding
		System.out.println("in groups.addGroup");
		if (!checkIfGroupName(newGroup.groupName)){
			//add group to list
			System.out.println("group name did not exist");
			this.userGroups.put(newGroup.groupName, newGroup);
			return true;
		}
		else{
			return false;
		}
	}
	public synchronized void deleteGroup(String groupName){ //remove from hashtable
		
	}
	/*public static ArrayList<Comment> getComments(String groupName){
		return userGroups.get(groupName).getComments();
	}*/
	public UserGroup findGroup(String groupname){
			return userGroups.get(groupname);
	}
	public ArrayList<String> getAllGroups(){
		System.out.println("getting all groups");
		ArrayList<String> returnArray = new ArrayList<String>();
		Set<String> keys = userGroups.keySet();
        for(String key: keys){
        	System.out.println(key);
           returnArray.add(key);
        }
        return returnArray;
	}
}
