/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandlerpkg;

import DAO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alaa
 */
public class DBCategoryHandler {

    DBHandler dBHandler;
    DBUserHandler dBUserHandler;
    int rows;

    public DBCategoryHandler() {
        dBHandler = new DBHandler();
        dBUserHandler = new DBUserHandler();
        rows = 0;
    }

    public Category getCategoryForUser(User user) {
        Category retrievedCategory = null;
        try {
            String selectAllQuery = new String("select * from \"CATEGORY\" where CREATOR=" + user.getId());
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement(selectAllQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
            while (dBHandler.getResultSet().next()) {
                retrievedCategory = new Category();
                retrievedCategory.setId(dBHandler.getResultSet().getInt("ID"));
                retrievedCategory.setName(dBHandler.getResultSet().getString("NAME"));
                User tempUser = new User();
                tempUser.setId(dBHandler.getResultSet().getInt("CREATOR"));
                retrievedCategory.setCategoryCreator(tempUser);
                retrievedCategory.setCreatorUnique(dBHandler.getResultSet().getString("CREATORUNIQUE"));
            }
            return retrievedCategory;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return retrievedCategory;
        }

    }

    public Category getCategoryForUser(String creatorUnique) {
        Category retrievedCategory = null;
        try {
            String selectAllQuery = new String("select * from \"CATEGORY\" where CREATORUNIQUE='" + creatorUnique + "'");
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement(selectAllQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
            while (dBHandler.getResultSet().next()) {

                retrievedCategory = new Category();
                retrievedCategory.setId(dBHandler.getResultSet().getInt("ID"));
                retrievedCategory.setName(dBHandler.getResultSet().getString("NAME"));
                User user = new User();
                user.setId(dBHandler.getResultSet().getInt("CREATOR"));
                retrievedCategory.setCategoryCreator(user);
                retrievedCategory.setCreatorUnique(dBHandler.getResultSet().getString("CREATORUNIQUE"));
            }
            return retrievedCategory;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return retrievedCategory;
        }
    }

    public int deleteCategory(Category category) {
        int count = 0;
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("Delete from  \"CATEGORY\"  Where ID = " + category.getId() + "", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            count = dBHandler.getPreparedStatement().executeUpdate();
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return count;
        }

    }

    public int updateCategory(Category category) {

        int count = 0;
        try {
            String creatorUnique = category.getName() + category.getCategoryCreator().getfirstName() + category.getCategoryCreator().getId();
            String query = "update \"CATEGORY\" set NAME='" + category.getName() + "' , CREATOR='" + category.getCategoryCreator().getId() + "',CREATORUNIQUE='" + creatorUnique + "' where ID=" + category.getId() + "";
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));

            count = dBHandler.getPreparedStatement().executeUpdate();
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return count;
        }
    }

    public int addCategory(Category category) {
        int count = 0;
        try {
            String creatorUnique = category.getName() + category.getCategoryCreator().getfirstName()+ category.getCategoryCreator().getId();
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("insert into \"CATEGORY\"(NAME,CREATOR,CREATORUNIQUE) values ('" + category.getName() + "'," + category.getCategoryCreator().getId() + ",'" + creatorUnique + "')", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));

            count = dBHandler.getPreparedStatement().executeUpdate();
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return count;
        }
    }

    public List<Category> getAllCategories() {
        Category category;
        ArrayList<Category> listCategories = new ArrayList<>();
        try {
            dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("select * from \"CATEGORY\"", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            dBHandler.setResultSet(dBHandler.getPreparedStatement().executeQuery());
            while (dBHandler.getResultSet().next()) {
                category = new Category();
                category.setId(dBHandler.getResultSet().getInt(1));
                category.setName(dBHandler.getResultSet().getString(2));
                category.setCategoryCreator(dBUserHandler.getSingleUser(dBHandler.getResultSet().getInt(3)));
                listCategories.add(category);
            }
            return listCategories;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return listCategories;
        }
    }

    public int addUsersOfCategory(Category category) {
        int count = 0;
        try {
            for (int i = 0; i < category.getCategoryMembers().size(); i++) {
                dBHandler.setPreparedStatement(dBHandler.getConnection().prepareStatement("insert into \"CATEGORY_USERS\" values (" + category.getId() + "," + category.getCategoryMembers().get(i).getId() + ")", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));

                count += dBHandler.getPreparedStatement().executeUpdate();
            }

            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return count;
        }
    }
}
