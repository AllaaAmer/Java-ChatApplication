/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import DAO.User;
import DBHandlerpkg.DBUserHandler;
import ServerImp.HelloImplementation;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adelz
 */
public class Test {
    public static void main(java.lang.String[] args) {
        
        try {
            User user = new User();
            user.setId(1);
            user.setfirstName("Adel");
            user.setlastName("Ahmed");
            user.setPassword("123");
            user.setMail("Adel@hotmdail");
            user.setGender("m");
            user.setMobile(0);
            //user.setBirthDate(new Date(93, 3, 15));
            user.setCity("0");
            user.setCountry("0");
            user.setBio("0");
            user.setStatus("0");
            //user.setOffline(0);
            user.setPicPath("0");
            HelloImplementation h=new HelloImplementation();
            DBHandlerpkg.DBUserHandler ddBUserHandler=new DBUserHandler();
            User temp=ddBUserHandler.getSingleUser("Adel@hotmail");
            System.out.println(h.signOut(temp));
        } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
