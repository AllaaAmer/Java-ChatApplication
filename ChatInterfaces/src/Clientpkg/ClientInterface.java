/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientpkg;

import DAO.Message;
import DAO.User;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author alaa
 */
public interface ClientInterface extends Remote{
    
    boolean userStatuesChange(User user) throws RemoteException;
    boolean recieve (Message msg , User user) throws RemoteException;
    boolean openChat (ClientInterface client ) throws RemoteException;
    boolean closeChat (ClientInterface client ) throws RemoteException;
    User getUser () throws RemoteException;
    void setUser (User user) throws RemoteException;
}
