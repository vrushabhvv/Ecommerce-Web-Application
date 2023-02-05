/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kodnest.mycart.dao;

import com.kodnest.mycart.entities.Category;
import com.kodnest.mycart.entities.Product;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Vrushabh
 */
public class CategoryDao {
    private SessionFactory factory;

    public CategoryDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    
    public int saveCategory(Category cat ){
        
        Session session= this.factory.openSession();
        Transaction tx = session.beginTransaction();
        int catId1= (int)session.save(cat);
        tx.commit();
        session.close();
        return catId1;
        
        
//        use of create dao is ,we can maitain layer of the project very well if we are using jdbc for this i have to only dao class
    }
        

          



//extract categories to show in category section of add product on admin
          
          public List<Category> getCategories() {
              Session s=this.factory.openSession();
              Query query = s.createQuery("from Category");
              List list = query.list();
              s.close();
              return list;
              
          }


          public Category getCategoryById(int cid){
              Category cat=null;
              try{
              Session session=this.factory.openSession();
              cat=session.get(Category.class,cid);
              session.close();
              }
              catch(Exception e){
                  e.printStackTrace();
              }
              
              return cat;
          } 
          
          



    
}
