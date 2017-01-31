package Serverpkg;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import DAO.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MIDO
 */
public interface Friendable extends Remote {
        ArrayList<User> getOnnlineFriends(User member) throws RemoteException;
        ArrayList<User> getOfflineFriends(User member) throws RemoteException;
        ArrayList<User> getPendings(User member) throws RemoteException;

}
