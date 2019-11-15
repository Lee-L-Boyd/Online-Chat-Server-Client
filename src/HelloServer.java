  /**
   * Server program for the "Hello, world!" example.
   * @param argv The command line arguments which are ignored.
   */
   import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.security.*;
public class HelloServer{
  public static void main (String[] argv) throws ClassNotFoundException {
	//  System.out.println(this.getProtectionDomain().getCodeSource().toString());
	//  Class cls = Class.forName("HelloServer");
	  
	 // System.out.println(cls.getProtectionDomain().getCodeSource().getLocation().toString());
    try {
    //  Naming.rebind ("Hello", new Hello ("Hello, world!"));
    	Registry reg= LocateRegistry.createRegistry(1204);
    //	reg.bind("Hello", new Hello ("Hello, world!"));
    	ChatServerServant myServer = new ChatServerServant(reg);
    reg.rebind("chat", myServer);
      System.out.println ("Hello Server is ready.");
    } catch (Exception e) {
      System.out.println ("Hello Server failed: " + e);
    }
  }
  }
