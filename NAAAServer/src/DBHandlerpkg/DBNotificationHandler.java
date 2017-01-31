/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandlerpkg;

import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alaa
 */
public class DBNotificationHandler extends DBHandler {

    int rows;
    DBHandler dBHandler;

    public DBNotificationHandler() {
        dBHandler = new DBHandler();
        rows = 0;
    }

    public int addNotification(Notification notification) {
        int count = 0;
        String unqieField = "Notification" + (getLastID() + 1) + notification.getUser().getId();
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("insert into \"NOTIFICATION\" (DATERECIEVED,CONTENT,USER_ID,UNIQUEFIELD) values (?,'" + notification.getContent() + "'," + notification.getUser().getId() + ",'" + unqieField + "')"));
        dBHandler.getPreparedStatement().setTimestamp(1, notification.getDate());
        count = dBHandler.getPreparedStatement().executeUpdate();
        if (count != 0) {
            return count;
        } else {
            return -1;
        }
    }

    public int deleteNotification(Notification notification) {
        int count = 0;
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("Delete \"NOTIFICATION\" Where ID = " + notification.getId() + ""));
        count = dBHandler.getPreparedStatement().executeUpdate();
        if (count != 0) {
            return count;
        } else {
            return -1;
        }
    }

    public int updateNotification(Notification notification) {
        int count = 0;
        String unqieField = "Notification" + (getLastID() + 1) + notification.getUser().getId();
        String query = "update \"NOTIFICATION\" set DATERECIEVED=" + "TO_TIMESTAMP('" + notification.getDate() + "','YYYY-MM-DD HH24:MI:SS.FF')" + ", CONTENT='" + notification.getContent() + "' , USER_ID=" + notification.getUser().getId() + ",UNIQUEFIELD='" + unqieField + "' where ID=" + notification.getId() + "";
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement(query));
        count = dBHandler.getPreparedStatement().executeUpdate();
        if (count != 0) {
            return count;
        } else {
            return -1;
        }
    }

    public ArrayList<Notification> getNotificationForUser(User user) {
        ArrayList<Notification> listNotifications = new ArrayList();
        DBUserHandler u = new DBUserHandler();
        Notification notification;
        String selectAllQuery = new String("select * from \"NOTIFICATION\" where USER_ID=" + user.getId() + "");
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement(selectAllQuery));
        dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
        while (dBHandler.getResultSet().next()) {
            notification = new Notification();
            notification.setId(dBHandler.getResultSet().getInt("ID"));
            notification.setDate(dBHandler.getResultSet().getTimestamp("DATERECIEVED"));
            notification.setContent(dBHandler.getResultSet().getString("CONTENT"));
            notification.setUser(u.getSingleUser(dBHandler.getResultSet().getInt("USER_ID")));
            notification.setUniqueField(dBHandler.getResultSet().getString("UNIQUEFIELD"));
            listNotifications.add(notification);
        }
        return listNotifications;
    }

    public Notification getNotificationForUser(String uniqueField) {
        DBUserHandler u = new DBUserHandler();
        Notification notification = null;
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("select * from \"NOTIFICATION\" where UNIQUEFIELD='" + uniqueField + "'"));
        dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
        while (dBHandler.getResultSet().next()) {
            notification = new Notification();
            notification.setId(dBHandler.getResultSet().getInt("ID"));
            notification.setDate(dBHandler.getResultSet().getTimestamp("DATERECIEVED"));
            notification.setContent(dBHandler.getResultSet().getString("CONTENT"));
            notification.setUser(u.getSingleUser(dBHandler.getResultSet().getInt("USER_ID")));
            notification.setUniqueField(dBHandler.getResultSet().getString("UNIQUEFIELD"));
        }
        return notification;
    }

    public int getLastID() {
        int lastID = 0;
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("select MAX(ID) from \"NOTIFICATION\""));
        dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
        while (dBHandler.getResultSet().next()) {
            lastID = dBHandler.getResultSet().getInt(1);
        }
        return lastID;
    }

    public ArrayList<Notification> getAllNotifications() {
        ArrayList<Notification> listNotifications = new ArrayList();
        DBUserHandler u = new DBUserHandler();
        Notification notification;
        String selectAllQuery = new String("select * from \"NOTIFICATION\"");
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement(selectAllQuery));
        dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
        while (dBHandler.getResultSet().next()) {
            notification = new Notification();
            notification.setId(dBHandler.getResultSet().getInt("ID"));
            notification.setDate(dBHandler.getResultSet().getTimestamp("DATERECIEVED"));
            notification.setContent(dBHandler.getResultSet().getString("CONTENT"));
            notification.setUser(u.getSingleUser(dBHandler.getResultSet().getInt("USER_ID")));
            notification.setUniqueField(dBHandler.getResultSet().getString("UNIQUEFIELD"));
            listNotifications.add(notification);
        }
        return listNotifications;
    }

}
