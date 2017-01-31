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
public interface Requestable extends Remote{
     List<Request> getRequests(User user) throws RemoteException;
     boolean addRequest(Request request) throws RemoteException; //We don't need to add ClientInterface as Request itself holds From and To
     boolean acceptRequest(Request request) throws RemoteException;
     boolean cancelRequest(Request request) throws RemoteException;
}
