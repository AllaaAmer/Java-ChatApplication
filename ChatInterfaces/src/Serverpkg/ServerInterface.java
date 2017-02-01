/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverpkg;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author alaa
 */
public interface ServerInterface extends Remote {

    Chatable getChatable() throws RemoteException;

    Updatable getUpdate() throws RemoteException;

    Blockable getBolcable() throws RemoteException;

    Categorable getCatrgorable() throws RemoteException;

    Groupable getGroupable() throws RemoteException;

    HelloServer getHelloServer() throws RemoteException;

    Notificationable getNotificationable() throws RemoteException;

    Requestable getRequestable() throws RemoteException;

}
