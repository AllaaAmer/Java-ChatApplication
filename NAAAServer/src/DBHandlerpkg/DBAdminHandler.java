/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandlerpkg;

import DAO.Admin;
import DAO.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MIDO
 */
public class DBAdminHandler {
    int rows;
    DBHandler dBHandler;
    
    public DBAdminHandler(){
     dBHandler = new DBHandler();
        rows = 0;
    }
    
     public boolean addAdmin(Admin admin) {
        try {

            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("insert into \"ADMIN\" (USER_NAME,PASSWORD) values('" + admin.getUserName()+ "','" + admin.getPassword()+ "')", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));

            rows = dBHandler.getPreparedStatement().executeUpdate();
            if (rows != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
      public boolean deleteAdmin(Admin admin) {
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("delete from \"ADMIN\" where ID=" + admin.getId() + "", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            rows = dBHandler.getPreparedStatement().executeUpdate();
            if (rows != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
      }
        public Admin getAdmin(String userName) {
        Admin admin = null;
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("select * from \"ADMIN\" where USER_NAME=" + userName + "", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
            while (dBHandler.getResultSet().next()) {
                admin = new Admin();
                admin.setId(dBHandler.getResultSet().getInt(1));
                admin.setUserName(dBHandler.getResultSet().getString(2));
                admin.setPassword(dBHandler.getResultSet().getString(3));
               
            }
            return admin;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return admin;
        }
    }
    }
      
      

