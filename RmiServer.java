import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*; 

public class RmiServer
    extends    UnicastRemoteObject
    implements RmiServerIntf
{
    public static String MESSAGE = "Hello World";
 
    public RmiServer() throws RemoteException {
        super(0);    // required to avoid the 'rmic' step, see below
    }
 
    public String getMessage() {
        return MESSAGE;
    }

    public void setMessage(String msg) {
        MESSAGE = msg;
    }
 
    public static void main(String args[]) throws Exception {
        System.out.println("RMI server started");

        System.out.println((java.net.InetAddress.getLocalHost()).toString());
 
        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099); 
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }
 
        //Instantiate RmiServer
        RmiServer obj = new RmiServer();
 
        // Bind this object instance to the name "RmiServer"
        Naming.rebind("//10.2.19.6/RmiServer", obj);
        System.out.println("PeerServer bound in registry");
    }
}