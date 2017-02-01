package Serverpkg;

import Clientpkg.ClientInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
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
public interface HelloServer extends Remote {
    boolean register(ClientInterface clientRef)throws RemoteException;

    boolean signUp(User user) throws RemoteException;

    User signIn(User user) throws RemoteException;

    boolean signOut(User user) throws RemoteException;
    boolean unRegister(ClientInterface clientRef)throws RemoteException;

}
