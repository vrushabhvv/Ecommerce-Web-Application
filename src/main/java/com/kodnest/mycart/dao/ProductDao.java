/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kodnest.mycart.dao;

import com.kodnest.mycart.entities.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Vrushabh
 */
public class ProductDao {
     private SessionFactory factory;

    public ProductDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    public boolean saveProduct(Product prod ){
        boolean f=false;
        try{
        Session session=this.factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(prod);
        
        tx.commit();
        session.close();
        f=true;
        

        }
        catch(Exception e){
            e.printStackTrace();
        }
         return f;
        }
    
    //get all products
    public List<Product> getAllProducts(){
        Session s=this.factory.openSession();
         Query query = s.createQuery("from Product");
         List <Product> list= query.list();
         return list;
    }
    
    
    
    
    
    
    
    public List<Product> getAllProductsById(int cid){
        Session s=this.factory.openSession();
         Query query = s.createQuery("from Product as p where p.category.category_id=: id");//we have reference of category in product entity class ,we have to go into that class whose refernce is there
         query.setParameter("id", cid);
         List <Product> list= query.list();
         return list;
    }
    
}
