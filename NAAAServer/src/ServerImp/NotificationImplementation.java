/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerImp;

import DAO.Notification;
import DAO.User;
import DBHandlerpkg.DBNotificationHandler;
import Serverpkg.Blockable;
import Serverpkg.Notificationable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author MIDO
 */
public class NotificationImplementation  extends UnicastRemoteObject implements Notificationable {
    DBNotificationHandler notificationHandler;
    public NotificationImplementation() throws RemoteException{
            DBNotificationHandler notificationHandler=new DBNotificationHandler();

    }
    

    @Override
    public List<Notification> getNotification(User user) throws RemoteException {
        return notificationHandler.getNotificationForUser(user);
    }

    @Override
    public boolean sendNotification(User user, Notification n) throws RemoteException {
        try{
        //notificationHandler.
        }
        catch(Exception ex){
            ex.printStackTrace();
            return  false;
        }
        return true;
    }

    @Override
    public boolean removeNotification(User user, Notification n) throws RemoteException {
          try{
                notificationHandler.deleteNotification(n);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return  false;
        }
        return true;
    }
    
}
