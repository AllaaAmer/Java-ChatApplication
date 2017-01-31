package DBHandlerpkg;

import DAO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MIDO
 */
public class DBFriendsHandler {

    int rows;
    ResultSet rs;
    ResultSet rs2;

    PreparedStatement pstCreate;
    PreparedStatement pstUpdate;
    PreparedStatement pstDelete;
    PreparedStatement pstSelectSingleFriend;
    PreparedStatement pstSelect;

    DBHandler dBHandler;

    public DBFriendsHandler() {
        dBHandler = new DBHandler();
        rows = 0;
        pstCreate = dBHandler.getConnection().prepareStatement("insert into \"FRIENDS\" (USER_1,USER_2) values( ? ,?)");
        pstUpdate = dBHandler.getConnection().prepareStatement("update  \"FRIENDS\" set USER_1=? ,USER_2=? where ID=?");
        pstDelete = dBHandler.getConnection().prepareStatement("delete from  \"FRIENDS\" where USER_1 =? and USER_2 =?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstSelect = dBHandler.getConnection().prepareStatement("select * from  \"FRIENDS\" where USER_1=? AND USER_2=? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstSelectSingleFriend = dBHandler.getConnection().prepareStatement("select * from  \"FRIENDS\" where USER_1=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    }

    public boolean addFriend(Friend friend) {

        try {

            User user1 = friend.getFirstUser();
            User user2 = friend.getSecondUser();
            pstCreate.setInt(1, user1.getId());
            pstCreate.setInt(2, (user2.getId()));

            pstCreate.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean updateFriend(Friend friend) {
        //int id;
        try {

            pstUpdate.setInt(3, (friend.getId()));
            pstUpdate.setInt(1, friend.getFirstUser().getId());
            pstUpdate.setInt(2, friend.getSecondUser().getId());

            pstUpdate.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }

    }

    public boolean deleteFriend(Friend friend) {
        try {
            User user1 = friend.getFirstUser();
            User user2 = friend.getSecondUser();
            pstDelete.setInt(1, user1.getId());
            pstDelete.setInt(2, user2.getId());

            pstDelete.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }

    }

    public List<Friend> selectFriends(Friend friend) {
        ArrayList<Friend> rowValues = new ArrayList();
        Friend fr;
        DBUserHandler u = new DBUserHandler();
        try {
            //User user1 = friend.getFirstUser();
            pstSelect.setInt(1, friend.getFirstUser().getId());
            pstSelect.setInt(2, friend.getSecondUser().getId());

            rs2 = pstSelect.executeQuery();

            while (rs2.next()) {
                fr = new Friend();
                fr.setFirstUser(u.getSingleUser(rs2.getInt(2)));
                fr.setSecondUser(u.getSingleUser(rs2.getInt(3)));
                rowValues.add(fr);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowValues;
    }
 public List<Friend> selectFriendsOfUser(Friend friend) {
        ArrayList<Friend> rowValues = new ArrayList();
        Friend fr;
        DBUserHandler u = new DBUserHandler();
        try {
            pstSelectSingleFriend.setInt(1, friend.getFirstUser().getId());

            rs2 = pstSelectSingleFriend.executeQuery();

            while (rs2.next()) {
                fr = new Friend();
                fr.setFirstUser(u.getSingleUser(rs2.getInt(2)));
                fr.setSecondUser(u.getSingleUser(rs2.getInt(3)));
                rowValues.add(fr);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowValues;
    }

}
