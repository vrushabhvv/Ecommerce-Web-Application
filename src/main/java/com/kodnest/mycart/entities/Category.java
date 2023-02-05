/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kodnest.mycart.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    private String category_Title;
    private String category_Description;
//    here also we can create object,this is another way otherwise we can create in main method
    @OneToMany(mappedBy = "category")
    //use mapped by to say hey category you dont create any extra column it will taken care by category column of product class
    private List<Product> products=new ArrayList<>();

    public Category(int category_id, String category_Title, String category_Description) {
        this.category_id = category_id;
        this.category_Title = category_Title;
        this.category_Description = category_Description;
    }

    public Category(String category_Title, String category_Description,List<Product> products) {
        this.category_Title = category_Title;
        this.category_Description = category_Description;
        this.products=products;
    }
    

    public Category() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_Title() {
        return category_Title;
    }

    public void setCategory_Title(String category_Title) {
        this.category_Title = category_Title;
    }

    public String getCategory_Description() {
        return category_Description;
    }

    public void setCategory_Description(String category_Description) {
        this.category_Description = category_Description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    
    @Override
    public String toString() {
        return "Category{" + "category_id=" + category_id + ", category_Title=" + category_Title + ", category_Description=" + category_Description + '}';
    }

  
    
    
    
    
    
    
    
    
    

    
    
    
    
}
