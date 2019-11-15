import java.io.Serializable;
import java.util.Date;


public class Comment implements Serializable {
	String username;
	String comment;
	Date date;
	
	Comment(String name, String comment){
		username=name;
		this.comment=comment;
		this.date = new Date();
	}
	public String getComment(){
		return comment;
	}
	public String getUsername(){
		return username;
	}
	public Date getDate(){
		return date;
	}
}
