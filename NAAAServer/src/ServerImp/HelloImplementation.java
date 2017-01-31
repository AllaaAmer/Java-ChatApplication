/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerImp;

import DAO.User;
import Serverpkg.HelloServer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**q
 *
 * @author adelz
 */
public class HelloImplementation extends UnicastRemoteObject implements HelloServer{

    public HelloImplementation() throws RemoteException{
    }

    @Override
    public boolean signUp(User user) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean signIn(User user) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean signOut(User user) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
