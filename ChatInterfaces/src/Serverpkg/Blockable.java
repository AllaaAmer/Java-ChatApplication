/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverpkg;

import DAO.*;
import java.rmi.*;
import java.util.List;

/**
 *
 * @author adelz
 */
public interface Blockable extends Remote{
    List<User> getUsersIBlocked(User user) throws RemoteException;
    List<User> getUsersBlockedMe(User user) throws RemoteException;
    boolean addBlock(Block block) throws RemoteException;
    boolean removeBlock(Block block) throws RemoteException;
}
