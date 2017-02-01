/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllerpkg;

import Clientpkg.ClientInterface;
import Serverpkg.Requestable;
import java.util.List;
import DAO.*;
import Modelpkg.ClientModel;
import Serverpkg.ServerInterface;
import Viewpkg.ViewController;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nour
 */
public class Controller{

    ClientModel model;
    ViewController controller;
    ServerInterface server;

    public Controller(ViewController controller) {
        try {
            model=new ClientModel(this);
        } catch (RemoteException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.controller = controller;
    }
    public boolean connectToServer(ConfigurationInfo info)
    {
        try {
            Registry reg=LocateRegistry.getRegistry(info.getIp(),info.getPort());
            server=(ServerInterface)reg.lookup("ChatService");
            server.getHelloServer().register((ClientInterface) model);
            return true;
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    public boolean SignUp(User newUser)
    {
        try {
            return server.getHelloServer().signUp(newUser);
        } catch (RemoteException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
            
            
    public void close()
    {
        try {
            server.getHelloServer().unRegister((ClientInterface)model);
        } catch (RemoteException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
