/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kodnest.mycart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 *
 * @author Vrushabh
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10,name = "user_id")
    private int userId;
    
    @Column(length = 100,name = "user_name")
    private String userName;
    
    
    @Column(length = 100,name = "user_email",unique = true)
    private String useremail;
    
    @Column(length = 100,name = "user_password")
    private String userPassword;
    
    @Column(length = 12,name = "user_phone")
    private String userPhone;
    
    @Column(length = 1500,name = "user_pic")
    private String userPic;//we can make list to store multiple pic of user
    
    @Column(length = 1500,name = "user_address")
    private String userAddress;//we can make list to store multiple address of user
    
    @Column(length = 100,name="user_type")
    private String userType;

    //no need of creating with userid parameter ,here we are just demonstrating as user id is autoincremented

    public User(int userId, String userName, String useremail, String userPassword, String userPhone, String userPic, String userAddress,String userType) {
        this.userId = userId;
        this.userName = userName;
        this.useremail = useremail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userPic = userPic;
        this.userAddress = userAddress;
        this.userType=userType;
    }

    public User(String userName, String useremail, String userPassword, String userPhone, String userPic, String userAddress,String userType) {
        this.userName = userName;
        this.useremail = useremail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userPic = userPic;
        this.userAddress = userAddress;
        this.userType=userType;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", useremail=" + useremail + ", userPassword=" + userPassword + ", userPhone=" + userPhone + ", userPic=" + userPic + ", userAddress=" + userAddress + '}';
    }
    
    

   
    
    
    

}
