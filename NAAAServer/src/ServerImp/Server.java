/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerImp;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author adelz
 */
public class Server {
     public static void main(String[] args) {
        
        new Server();
    }

    public Server() {
        try {
            
            HelloImplementation obj = new HelloImplementation();
            Registry reg = LocateRegistry.createRegistry(5050);
            reg.rebind("MVCChat", obj);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
