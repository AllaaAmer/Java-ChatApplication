/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerImp;

import DAO.Block;
import DAO.User;
import DBHandlerpkg.DBBlockHandler;
import Serverpkg.Blockable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MIDO
 */
public class BlockImplementation  extends UnicastRemoteObject implements Blockable{
    DBBlockHandler blockHandler;
    public BlockImplementation() throws RemoteException {
         blockHandler=new DBBlockHandler();
    }

    
    @Override
    public List<User> getUsersIBlocked(User user) throws RemoteException {
         ArrayList<User> blockedList=new ArrayList<>();
         blockedList=blockHandler.selectBlockedUsers(user);
         return blockedList;
    }

    @Override
    public List<User> getUsersBlockedMe(User user) throws RemoteException {
         ArrayList<User> blockersList=new ArrayList<>();
         blockersList=blockHandler.selectBlockers(user);
         return blockersList;
    }

    @Override
    public boolean addBlock(Block block) throws RemoteException {
        try{
        blockHandler.createBlock(block);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return  false;
        }
        return true;
    }

    @Override
    public boolean removeBlock(Block block) throws RemoteException {
         try{
        blockHandler.deleteBlock(block);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return  false;
        }
        return true;
    }
    
}
