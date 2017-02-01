/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerImp;

import Clientpkg.ClientInterface;
import DAO.User;
import DBHandlerpkg.*;
import Serverpkg.HelloServer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**q
 *
 * @author adelz
 */
public class HelloImplementation extends UnicastRemoteObject implements HelloServer{
DBUserHandler dBUserHandler;
    public HelloImplementation() throws RemoteException{
        dBUserHandler=new DBUserHandler();
    }

    @Override
    public boolean signUp(User user) throws RemoteException {
        
        if(!dBUserHandler.checkUserExistance(user)){
          return (dBUserHandler.addUser(user));
        }
        else
            return false;
    }

    @Override
    public User signIn(User user) throws RemoteException {
        return dBUserHandler.getSingleUser(user.getMail());
    }

    @Override
    public boolean signOut(User user) throws RemoteException {
        user.setOffline(0);
         return (dBUserHandler.updateUser(user));
    }

    @Override
    public boolean register(ClientInterface clientRef) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean unRegister(ClientInterface clientRef) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
