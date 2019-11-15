import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class UserGroup extends UnicastRemoteObject implements UserGroupInterface, Serializable{
	String groupName;
	ArrayList <String> usernames; //This keeps a list of usernames rather than RORs for now
	ArrayList <Comment> comments;
	UserGroup(String groupname, String username) throws RemoteException{
		groupName = groupname;//check for uniqueness
		usernames = new ArrayList<String>();
		usernames.add(username);
		comments = new ArrayList<Comment>();
	}
	public ArrayList<String> getUsers(){
		return usernames;
	}
	public Boolean verifyGroupMember(String username){ //check usernames for this username
		for (String user : usernames){
			if(user.equals(username)){
				return true;//should return if this username is a member
			}
		}
		return false;
	}
	public synchronized boolean addComment(String username, String rawComment){ //add a comment
		if(verifyGroupMember(username)){
			Comment newComment = new Comment(username,rawComment); //add this comment to list of comments
			comments.add(newComment);
			return true;
		}
		else{
			System.out.println(username + " not in the group, and cannot make a comment");
			return false;
		}
	}
	public synchronized ArrayList<Comment> getComments(){
		return comments;
	}
	public synchronized void addUser(String username){
		if(!verifyGroupMember(username)){
			//add the member to group here
			usernames.add(username);
		}
		else{
			System.out.println("That user is already a member!");
		}
	}
	public synchronized void deleteUser(String username){
		if(verifyGroupMember(username)){
			//delete the member to group here
			int x = 0;
			ArrayList<Integer> stack = new ArrayList<Integer>();
			for(String user : usernames){
				if (user.equals(username)){
					stack.add(x);
				}
				x++;
			}
			for (int deleteMe : stack){
				usernames.remove(deleteMe);
			}
		}
		else{
			System.out.println("That user was not in the group");
		}
	}
	public String tooString(){
		String allComments = ""; //allComments should store all comments - likely implements with for each loop on comments
		return allComments;
	}
	
}
