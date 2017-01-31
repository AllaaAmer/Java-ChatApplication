/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandlerpkg;

import DAO.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nour
 */
public class DBGroupHandler {

    int rows;
    DBHandler dBHandler;

    public DBGroupHandler() {
        dBHandler = new DBHandler();
        rows = 0;
    }

    public int addGroup(Group newGroup) {

        try {
            String creatorUnique = newGroup.getName() + newGroup.getgroupCreator().getfirstName()+ newGroup.getgroupCreator().getId();
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("Insert into \"GROUP\" (NAME,CREATOR,CREATORUNIQUE) values('" + newGroup.getName() + "' ," + newGroup.getgroupCreator().getId() + ",'" + creatorUnique + "')"));

            rows = dBHandler.getPreparedStatement().executeUpdate();

            if (rows != 0) {
                return rows;
            } else {
                return -1;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int deleteGroup(Group group) {
        try {

            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("Delete from \"GROUP\" where ID="+group.getId()+""));
            rows = dBHandler.getPreparedStatement().executeUpdate();
            if (rows != 0) {
                return rows;
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int updateGroup(Group group) {
        try {
            String creatorUnique = group.getName() + group.getgroupCreator().getfirstName()+ group.getgroupCreator().getId();
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("Update \"GROUP\" set NAME='"+group.getName()+"',CREATOR="+group.getgroupCreator().getId()+",CREATORUNIQUE='"+creatorUnique+"' where ID="+group.getId()+""));
            rows = dBHandler.getPreparedStatement().executeUpdate();
            if (rows != 0) {
                return rows;
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBGroupHandler.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public Group getSingleGroup(Group group) {
        Group result = null;
        DBUserHandler u = new DBUserHandler();
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("Select * from \"GROUP\" Where ID="+group.getId()+""));
            dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
            while (dBHandler.getResultSet().next()) {
                result.setId(dBHandler.getResultSet().getInt("ID"));
                result.setName(dBHandler.getResultSet().getString("NAME"));
                result.setgroupCreator(u.getSingleUser(dBHandler.getResultSet().getInt("CREATOR")));
                result.setCreatorUnique(dBHandler.getResultSet().getString("CREATORUNIQUE"));
            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return result;
        }
    }

    public Group getSingleGroup(String creatorUnique) {
        Group result = null;
        DBUserHandler u = new DBUserHandler();
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("Select * from \"GROUP\" Where CREATORUNIQUE='"+creatorUnique+"'"));
            dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
            while (dBHandler.getResultSet().next()) {
                result=new Group();
                result.setId(dBHandler.getResultSet().getInt("ID"));
                result.setName(dBHandler.getResultSet().getString("NAME"));
                result.setgroupCreator(u.getSingleUser(dBHandler.getResultSet().getInt("CREATOR")));
                result.setCreatorUnique(dBHandler.getResultSet().getString("CREATORUNIQUE"));
            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return result;
        }
    }

    public List<Group> getAllGroups() {
        Group group = null;
        ArrayList<Group> listGroups = new ArrayList<>();
        DBUserHandler u = new DBUserHandler();
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("select * from \"GROUP\"", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
            while (dBHandler.getResultSet().next()) {
                group = new Group();
                group.setId(dBHandler.getResultSet().getInt("ID"));
                group.setName(dBHandler.getResultSet().getString("NAME"));
                group.setgroupCreator(u.getSingleUser(dBHandler.getResultSet().getInt("CREATOR")));
                group.setCreatorUnique(dBHandler.getResultSet().getString("CREATORUNIQUE"));
                listGroups.add(group);
            }
            return listGroups;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return listGroups;
        }
    }

    public int addUsersOfGroup(Group group) {
        int count = 0;
        try {
            for (int i = 0; i < group.getListUsers().size(); i++) {
                dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("insert into \"GROUP_USERS\" values (" + group.getId() + "," + group.getListUsers().get(i).getId() + ")", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));

                count += dBHandler.getPreparedStatement().executeUpdate();
            }

            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return count;
        }
    }
}
