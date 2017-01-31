/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverpkg;

import DAO.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Nour
 */
public interface Groupable extends Remote {

    boolean createGroup(User creator,ArrayList<User> members) throws RemoteException;

    boolean deleteGroup(Group group) throws RemoteException;

    boolean leaveGroup(User leavingUser ,Group group) throws RemoteException;

    boolean addUserToGroup(User newUser ,Group group) throws RemoteException;

    boolean sendGroupMessage(Message message,Group group) throws RemoteException;
    
    ArrayList<Group> getGroups(User member) throws RemoteException;

}
