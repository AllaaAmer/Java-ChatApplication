/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverpkg;

import DAO.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author alaa
 */
public interface Notificationable extends Remote {
    
    List<Notification> getNotification(User user) throws RemoteException;
    boolean sendNotification (User user , Notification n) throws RemoteException;
    boolean removeNotification (User user , Notification n)throws RemoteException;
}
