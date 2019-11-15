import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Message implements Serializable {
	Date date;
	String message;
	Message(String message){
		this.message = message;
		date = new Date();
	}
	public String getMessage()
	{
		return message;
	}
}
