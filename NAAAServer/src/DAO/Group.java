/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author adelz
 */
public class Group {

    private int id;
    private String name;
    private User groupCreator;
    private String creatorUnique;
    private List<User> listUsers;

    public String getCreatorUnique() {
        return creatorUnique;
    }

    public void setCreatorUnique(String creatorUnique) {
        this.creatorUnique = creatorUnique;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getgroupCreator() {
        return groupCreator;
    }

    public void setgroupCreator(User user) {
        this.groupCreator = user;
    }

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }
}
