/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandlerpkg;

import DAO.Request;
import DAO.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import oracle.jdbc.OraclePreparedStatement;

/**
 *
 * @author adelz
 */
public class DBUserHandler {

    int rows;
    DBHandler dBHandler;

    public DBUserHandler() {
        dBHandler = new DBHandler();
        rows = 0;
    }

    public boolean addUser(User user) {
        try {

            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("insert into \"USER\" (FIRST_NAME,LAST_NAME,PASSWORD,EMAIL,GENDER,MOBILE,BIRTHDATE,CITY,COUNTRY,BIO,STATUS,ISOFFLINE,PIC_URL) values('" + user.getfirstName()+ "','" + user.getlastName()+ "','" + user.getPassword() + "','" + user.getMail() + "','" + user.getGender() + "','" + user.getMobile() + "'," + "TO_DATE('" + user.getBirthDate() + "','yyyy/mm/dd')" + ",'" + user.getCity() + "','" + user.getCountry() + "','" + user.getBio() + "','" + user.getStatus() + "','" + user.isOffline() + "','" + user.getPicPath() + "')", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));

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

    public boolean deleteUser(User user) {
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("delete from \"USER\" where ID=" + user.getId() + "", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
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

    public boolean updateUser(User user) {
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("update \"USER\" set FIRST_NAME='" + user.getfirstName()+ "',LAST_NAME='" + user.getlastName()+ "',PASSWORD='" + user.getPassword() + "',EMAIL='" + user.getMail() + "',GENDER='" + user.getGender() + "',MOBILE='" + user.getMobile() + "',BIRTHDATE=" + "TO_DATE('" + user.getBirthDate() + "','yyyy/mm/dd')" + ",CITY='" + user.getCity() + "',COUNTRY='" + user.getCountry() + "',BIO='" + user.getBio() + "',STATUS='" + user.getStatus() + "',OFFLINE='" + user.isOffline() + "',PIC_URL='" + user.getPicPath() + "' where ID='" + user.getId() + "'", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
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

    public List<User> getAllUSERS() {
        User user;
        List<User> listUSERS = null;
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("select * from \"USER\"", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
            while (dBHandler.getResultSet().next()) {
                user = new User();
                user.setId(dBHandler.getResultSet().getInt(1));
                user.setfirstName(dBHandler.getResultSet().getString(2));
                user.setlastName(dBHandler.getResultSet().getString(3));
                user.setPassword(dBHandler.getResultSet().getString(4));
                user.setMail(dBHandler.getResultSet().getString(5));
                user.setGender(dBHandler.getResultSet().getString(6));
                user.setMobile(dBHandler.getResultSet().getInt(7));
                user.setBirthDate(dBHandler.getResultSet().getDate(8));
                user.setCity(dBHandler.getResultSet().getString(9));
                user.setCountry(dBHandler.getResultSet().getString(10));
                user.setBio(dBHandler.getResultSet().getString(11));
                user.setStatus(dBHandler.getResultSet().getString(12));
                user.setOffline(dBHandler.getResultSet().getInt(13));
                user.setPicPath(dBHandler.getResultSet().getString(14));
                listUSERS.add(user);
            }
            return listUSERS;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return listUSERS;
        }
    }

    public User getSingleUser(int id) {
        User user = null;
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("select * from \"USER\" where ID=" + id + "", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
            while (dBHandler.getResultSet().next()) {
                user = new User();
                user.setId(dBHandler.getResultSet().getInt(1));
                user.setfirstName(dBHandler.getResultSet().getString(2));
                user.setlastName(dBHandler.getResultSet().getString(3));
                user.setPassword(dBHandler.getResultSet().getString(4));
                user.setMail(dBHandler.getResultSet().getString(5));
                user.setGender(dBHandler.getResultSet().getString(6));
                user.setMobile(dBHandler.getResultSet().getInt(7));
                user.setBirthDate(dBHandler.getResultSet().getDate(8));
                user.setCity(dBHandler.getResultSet().getString(9));
                user.setCountry(dBHandler.getResultSet().getString(10));
                user.setBio(dBHandler.getResultSet().getString(11));
                user.setStatus(dBHandler.getResultSet().getString(12));
                user.setOffline(dBHandler.getResultSet().getInt(13));
                user.setPicPath(dBHandler.getResultSet().getString(14));

            }
            return user;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return user;
        }
    }

    public User getSingleUser(String mail) {
        User user = null;
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("select * from \"USER\" where EMAIL='" + mail + "'", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
            while (dBHandler.getResultSet().next()) {
                user = new User();
                user.setId(dBHandler.getResultSet().getInt(1));
                user.setfirstName(dBHandler.getResultSet().getString(2));
                user.setlastName(dBHandler.getResultSet().getString(3));
                user.setPassword(dBHandler.getResultSet().getString(4));
                user.setMail(dBHandler.getResultSet().getString(5));
                user.setGender(dBHandler.getResultSet().getString(6));
                user.setMobile(dBHandler.getResultSet().getInt(7));
                user.setBirthDate(dBHandler.getResultSet().getDate(8));
                user.setCity(dBHandler.getResultSet().getString(9));
                user.setCountry(dBHandler.getResultSet().getString(10));
                user.setBio(dBHandler.getResultSet().getString(11));
                user.setStatus(dBHandler.getResultSet().getString(12));
                user.setOffline(dBHandler.getResultSet().getInt(13));
                user.setPicPath(dBHandler.getResultSet().getString(14));
                
            }
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return user;
        }
    }
}
