package com.kodnest.mycart;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class factoryprovider {
//    singletone design pattern
    private static SessionFactory factory;
    
    public static SessionFactory getfaFactory(){
        try{
            if(factory==null){
                factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return factory;
    }
}