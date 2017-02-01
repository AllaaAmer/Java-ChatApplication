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
public class Category {
    private int id;
    private User categoryCreator;
    private String creatorUnique;
    private String name;
    private List<User> categoryMembers;

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

    public User getCategoryCreator() {
        return categoryCreator;
    }

    public void setCategoryCreator(User categoryCreator) {
        this.categoryCreator = categoryCreator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  public List<User> getCategoryMembers() {
        return categoryMembers;
    }

    public void setCategoryMembers(List<User> categoryMembers) {
        this.categoryMembers = categoryMembers;
    }
    
}
