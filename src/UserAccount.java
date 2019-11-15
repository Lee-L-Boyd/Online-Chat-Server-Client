import java.io.Serializable;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class UserAccount extends UnicastRemoteObject implements UserAccountInterface, Serializable{
	private final Object inviteSync;
	ChatServerServantInterface myServer;
	Registry reg;
	String name;
	String prof;
	String city;
	String company;
	String college;
	String gradYear;
	String password;
	String username;
	boolean active;
	ArrayList<String> invited;
	ArrayList<String> inviting;
	ArrayList<String> groups;
	ArrayList<String> friends;
	ArrayList<Messages> messages;
	protected UserAccount() throws RemoteException{
		active=true;
		inviteSync=new Object();
		try {
			reg= LocateRegistry.createRegistry(1204);
			
			
			myServer=(ChatServerServantInterface)reg.lookup("chat");
			
		
		
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected UserAccount(String name, String prof, String city, String company, String college, String gradYear, String password, String username) throws RemoteException{
		inviteSync = new Object();
		this.name=name;
		this.prof=prof;
		this.city=city;
		this.company=company;
		this.college=college;
		this.gradYear=gradYear;
		this.password=password;
		this.username=username;
		active=true;
		inviting=new ArrayList<String>();
		invited=new ArrayList<String>();
		friends=new ArrayList<String>();
		messages = new ArrayList<Messages>();
	}

	public ArrayList<String> getInviting(){
		return inviting;
	}
	public String getPassword(){
		return password;
	}
	public void deactivate(){
		active = false;
	}
	public void activate(){
		active = true;
	}
	public String getName(){
		return name;
	}
	public String getCity(){
		return city;
	}
	public String getCollege(){
		return college;
	}
	public String getGradYear(){
		return gradYear;
	}
	public String getProf(){
		return prof;
	}
	public String getUsername(){
		return username;
	}
	public void setPassword(String password){
		this.password=password;
	}

	public void setName(String name){
		this.name=name;
	}
	public void setCity(String city){
		this.city=city;
	}
	public void setCollege(String college){
		this.college=college;
	}
	public void setGradYear(String gradYear){
		this.gradYear=gradYear;
	}
	public void setProf(String prof){
		this.prof=prof;
	}
	/*public void setUsername(String username){
		this.username=username;
	}*/
	public synchronized void sendMessage(String outUsername, String message){
			System.out.println("Sending message " + message);
			boolean foundMatch=false;
			if(ChatServerServant.allAccounts.findAUser(outUsername)){
				Message newMessage = new Message(message);
				int x=0;
				int y=0;
				for (Messages myMessages : this.messages){
					if((myMessages.getUsername1().equals(this.username) && myMessages.getUsername2().equals(outUsername)) || (myMessages.getUsername2().equals(this.username) && myMessages.getUsername1().equals(outUsername))){
						System.out.println("found a match");
						foundMatch=true;
					//	myMessages.addMessage(newMessage);
						y=x;			
					}
					x++;
				}
				if(foundMatch){
					System.out.println("found match on sender side");
					this.messages.get(y).addMessage(newMessage);
				}
				else{
					System.out.println("Adding new messages between "+ this.username + " and " + outUsername);
					messages.add(new Messages(this.username, outUsername, newMessage));
					
				}
				ChatServerServant.allAccounts.login(outUsername).recvMessage(this.username, newMessage);
				System.out.println("Message added on both ends");
				return;
			}
			else{
				System.out.println("That user does not exist");
				return;
			}
	}
	public synchronized void recvMessage(String inUsername, Message newMessage){
		System.out.println( this.username + " is rcving a message from" + inUsername);
		boolean foundMatch=false;
		int x=0;
		int y=0;
		for (Messages myMessages : this.messages){
			if((myMessages.getUsername1().equals(this.username) && myMessages.getUsername2().equals(inUsername)) || (myMessages.getUsername2().equals(this.username) && myMessages.getUsername1().equals(inUsername))){
				System.out.println("found a match");
				foundMatch=true;
				//myMessages.addMessage(newMessage);
				y=x;			
			}
			x++;
		}
		if(foundMatch){
			this.messages.get(y).addMessage(newMessage);
			this.messages.get(y).setStar(this.username);
			System.out.println("setting start");
		}
		else{
			messages.add(new Messages(this.username, inUsername, newMessage));
			this.messages.get(y).setStar(this.username);
			System.out.println("setting start");
			System.out.println("Adding new messages between "+ this.username + " and " + inUsername);
		}
		
	}
	public synchronized void deleteFriend2(String username){
		System.out.println("deleting "+username+" from "+this.username+"'s friend list");
		boolean found = false;
		ArrayList<Integer> stack=new ArrayList<Integer>();
		int x=0;
		for (String friend : this.friends){
			 if(friend.equals(username)){
				// synchronized(inviteSync){
					// this.inviting.remove(x);
				// }
				 stack.add(x);
				 found=true;
			 }
			 x++;
		 }
		for(int deleteMe : stack){
				this.friends.remove(deleteMe);
				System.out.println("deleting "+username);
		}
		return;
	}
	public synchronized void deleteFriend(String username){
		System.out.println("deleting "+username+" from "+this.username+"'s friend list");
		boolean found = false;
		ArrayList<Integer> stack=new ArrayList<Integer>();
		int x=0;
		for (String friend : this.friends){
			 if(friend.equals(username)){
				// synchronized(inviteSync){
					// this.inviting.remove(x);
				// }
				 stack.add(x);
				 found=true;
			 }
			 x++;
		 }
		for(int deleteMe : stack){
				this.friends.remove(deleteMe);
				System.out.println("deleting "+username);
		}
		ChatServerServant.allAccounts.login(username).deleteFriend2(this.username);
		return;
	}
	public synchronized void addFriend(String username){//this should be used when they accept an invitation or someone accepts their invitation
		System.out.println(this.username+" is sending a friend request to "+username);
		//try {
			/*
			UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("user"+username);
			*/
			UserAccount testUserPass=ChatServerServant.allAccounts.login(username);
			//testUserPass.tooString();
			testUserPass.addThisUserToInviteList(this.username);
		
	//	} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}
	
	public void unsetStar(String username){
		int x =0;
		int y=0;
		for (Messages myMessages : this.messages){
			if((myMessages.getUsername1().equals(this.username) && myMessages.getUsername2().equals(username)) || (myMessages.getUsername2().equals(this.username) && myMessages.getUsername1().equals(username))){
				y=x;
			}
			x++;
		}
		messages.get(y).unsetStar();
	}
	private boolean isFriend(String myFriend){
		System.out.println("checking friendship");
		 for (String friend : this.friends){
			 if(myFriend.equals(friend)){
				 return true;
			 }
		 }
		 return false;
	}
	public void tooString(){
		System.out.println("I am a string representation of " + this.username);
		System.out.println("My first friend request is " + this.inviting.get(0));
	}
	public synchronized void addThisUserToInviteList(String requesting){
		if(!this.isFriend(requesting)){
			System.out.println(this.username+" is getting a friend request from "+requesting);
			synchronized(inviteSync){
				inviting.add(requesting);
			}
		}
		else{
		//	System.out.println(requesting + " is already a friend.");
			JOptionPane.showMessageDialog(null, requesting+ " is already a friend !!!",null,JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	public synchronized ArrayList<String> getInvited(){
		return invited;
	}
	
	public boolean testIfMessagesExist(String outUsername, String username){
		if(ChatServerServant.allAccounts.findAUser(username)){
			for (Messages myMessages : this.messages){
				if((myMessages.getUsername1().equals(this.username) && myMessages.getUsername2().equals(outUsername)) || (myMessages.getUsername1().equals(outUsername) && myMessages.getUsername2().equals(username))){
						return true;
				}
			}
		}
		return false;
	}
	public Messages getMessages(String username){
		boolean foundMatch=false;
		for (Messages myMessages : this.messages){
			System.out.println("un="+this.username);
			System.out.println("inun="+username);			
			
			System.out.println("un1="+myMessages.username1);
			System.out.println("un2="+myMessages.username2);
			if((myMessages.getUsername1().equals(this.username) && myMessages.getUsername2().equals(username)) || (myMessages.getUsername2().equals(this.username) && myMessages.getUsername1().equals(username))){
				System.out.println("found a match");
				foundMatch=true;
				
				return myMessages;
			}
		}
		if(!foundMatch){
			System.out.println("didn't find a match");
			return null;
		}
		else{
			return null;
		}
	}
	public synchronized void acceptInvite(String username){
		System.out.println("accepting invite from "+username);
		int x=0;
		boolean found=false;
		ArrayList<Integer> stack = new ArrayList<Integer>();
		System.out.println("checking invite list");
		for (String inviting : this.inviting){
			 if(inviting.equals(username)){
				// synchronized(inviteSync){
					// this.inviting.remove(x);
				// }
				 stack.add(x);
				 found=true;
			 }
			 x++;
		 }
		if(found){
			for(int deleteMe : stack){
				synchronized(inviteSync){
					System.out.println("deleting" +inviting.get(deleteMe) +"from "+this.username+"'s invite list");
					this.inviting.remove(deleteMe);
				}
			}
			friends.add(username);
			ChatServerServant.allAccounts.login(username).friends.add(this.username);
		}
		else{
			System.out.println("That person has not invited you to be friends.");
		}
		
	}
	public void showGroups(){
		
	}
	public void joinGroup(String groupName){
		
	}
	public void leaveGroup(String groupName){
		
	}
	public void sendGroupMessage(String groupName, String message){
		
	}
	public ArrayList<String> readGroupMessages(String groupName){
		return new ArrayList<String>();
			//	UserGroups.getComments(groupName);
	}
	
	public void showFriends(){
		
	}
	public ArrayList<String> getFriends(){
		return this.friends;
	}
	//public getMessages
	
/*	public ArrayList<String> readGroupMessages(String groupName)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}
