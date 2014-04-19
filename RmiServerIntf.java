import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface RmiServerIntf extends Remote {
    public String getMessage() throws RemoteException;
    public void   setMessage(String msg) throws RemoteException;
}