/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandlerpkg;

import DAO.*;
import java.sql.*;
import java.util.List;

/**
 *
 * @author adelz
 */
public class DBRequestHandler {

    int rows;
    DBHandler dBHandler;

    public DBRequestHandler() {
        dBHandler = new DBHandler();
        rows = 0;
    }

    public boolean addRequest(Request request) {
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("insert into REQUEST(FROM_USER,TO_USER) values('" + request.getFromUser().getId() + "','" + request.getToUser().getId() + "')", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
        rows = dBHandler.getPreparedStatement().executeUpdate();
        if (rows != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cancelRequest(Request request) {
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("delete from REQUEST where ID=" + request.getId() + "", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
        rows = dBHandler.getPreparedStatement().executeUpdate();
        if (rows != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean acceptRequest(Request request) {
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("delete from REQUEST where ID=" + request.getId() + "", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
        rows = dBHandler.getPreparedStatement().executeUpdate();
        if (rows != 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Request> getRequests(User user) {
        Request req;
        DBUserHandler u = new DBUserHandler();
        List<Request> listRequest = null;
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("select * from REQUEST where ID=" + user.getId() + "", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
        dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
        while (dBHandler.getResultSet().next()) {
            req = new Request();
            req.setId(dBHandler.getResultSet().getInt("ID"));
            
            req.setFromUser(u.getSingleUser(dBHandler.getResultSet().getInt("FROM_USER")));
            req.setToUser(u.getSingleUser(dBHandler.getResultSet().getInt("TO_USER")));
            listRequest.add(req);
        }
        return listRequest;
    }

    public Request getSingleRequests(User user1, User user2) {
        Request req = null;
        DBUserHandler u = new DBUserHandler();
        dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("select * from REQUEST where FROM_USER=" + user1.getId() + " AND TO_USER=" + user2.getId() + "", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
        dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
        while (dBHandler.getResultSet().next()) {
            req = new Request();
            req.setId(dBHandler.getResultSet().getInt("ID"));
            req.setFromUser(u.getSingleUser(dBHandler.getResultSet().getInt("FROM_USER")));
            req.setToUser(u.getSingleUser(dBHandler.getResultSet().getInt("TO_USER")));
        }
        return req;
    }

}
