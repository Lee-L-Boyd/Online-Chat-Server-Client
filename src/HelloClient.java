 /**
   * Client program for the "Hello, world!" example.
   * @param argv The command line arguments which are ignored.
   */
   import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
  public class HelloClient{

  public static void main (String[] argv) {
		String name="Lee";
		String prof="Computer Scientist";
		String city="San Antonio";
		String company="UTSA CS Dept";
		String college="UTSA";
		String gradYear="2020";
		String password="pw";
		String username="un";
    try {
      //HelloInterface hello = (HelloInterface) Naming.lookup ("//localhost/Hello");
    	Registry reg= LocateRegistry.getRegistry("localhost",1204);
    	ChatServerServantInterface myServer=(ChatServerServantInterface) reg.lookup("chat");
    	//reg= LocateRegistry.createRegistry(1204);
		
		//ChatServerServant myServer = new ChatServerServant(reg);
    //	myServer.test("myStrin");
    //	UserAccount testAccount = new UserAccount(name, prof, city, company, college, gradYear, password, username);
    //	System.out.println(testAccount.getProf());
    //	UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("un");
    	System.out.println(myServer.getNewAccount(name, prof, city, company, college, gradYear, password, username));
	//	myServer.findUser(username);
	//	testUserPass.addFriend("un");
		//String username2=username+"2";
		//myServer.findUser(username2);
		//myServer.getNewAccount(testAccount);
		
    //	UserAccountInterface testUserPass = (UserAccountInterface) reg.lookup ("userun");
    	
   // 	testUserPass.setProf("Artist");
    	System.out.println(myServer.getNewAccount(name, prof, city, company, college, gradYear, password, username));
    	
    	
    	//UserAccountInterface testUserPass2 = (UserAccountInterface) reg.lookup ("userun2");
//		System.out.println(testUserPass.getProf());
		//testUserPass2.setProf("Artist");
		//System.out.println(testUserPass2.getProf());
     // Hello hello = (Hello) Naming.lookup("//localhost/Hello");
     // System.out.println (hello.say());
     // System.out.println (hello.say());
    } catch (Exception e) {
      System.out.println ("HelloClient exception: " + e);
    }
  }
  }