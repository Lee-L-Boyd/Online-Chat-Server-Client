import java.io.Serializable;
import java.util.ArrayList;


public class Messages implements Serializable {
	String username1;
	String username2;
	ArrayList<Message> messages;
	boolean star;
	String starname;
	Messages(String username1, String username2, Message message){
		System.out.println("Instantiating a new messages object");
		messages = new ArrayList<Message>();
		String temp;
		star = true;
		starname="nothing";
		
		
		/*
		 * if (Integer.parseInt(username2) < Integer.parseInt(username2) ){

			temp = username2;
			username2=username1;
			username1=temp;
		}*/
		this.username1=username1;
		this.username2=username2;
		messages.add(message);

	}

	public boolean getStar()
	{
		System.out.println(star);
		return star;
		
	}

	public void setStar(String username)
	{
		this.star=true;
		this.starname=username;
	//	System.out.println("set star output");


	}
	public String getstarname()
	{
		return starname;
	}

	public void unsetStar()
	{
		this.star=false;
		System.out.println(star);
		System.out.println(username1 + username2);
	}
	public synchronized void addMessage(Message message){
		//System.out.println("Adding a new messages object");
		messages.add(message);
		for(Message message1 : messages){
			System.out.println(message1.getMessage());
		}
	}
	public String getUsername1(){
		return username1;
	}
	public String getUsername2(){
		return username2;
	}
	public ArrayList<Message> getMessages() {
		this.unsetStar();
		return messages;
	}
}
