/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datdh.dto;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Categories implements Serializable{

    public Categories(int id, String categoriesName) {
        this.id = id;
        this.categoriesName = categoriesName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }

    @Override
    public String toString() {
        return "Categories{" + "id=" + id + ", categoriesName=" + categoriesName + '}';
    }

    public Categories() {
    }
    private int id;
    private String categoriesName;
}
