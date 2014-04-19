import java.rmi.Naming;
import java.rmi.RemoteException;
 
public class RmiClient { 
    
    public static void main(String[] args) throws Exception {

        //System.setSecurityManager(new SecurityManager());
        
        try
        { 
            RmiServerIntf obj = (RmiServerIntf)Naming.lookup("//10.2.19.6/RmiServer");
            System.out.println(obj.getMessage());

            obj.setMessage("My test message !!!");
            System.out.println(obj.getMessage());
        }
        catch(Exception e) {
            System.out.println("RmiClient exception: " + e.getMessage());
            e.printStackTrace(); 
        }

    }
}