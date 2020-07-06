/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author GF63 8RD
 */
public class User {
    private int uId;
    private String username;
    private String password;
    private int nId;
    private int gender;
    private Date birthday;
    private String email;
    private String address;
    private String phone;
    private Date regisDate;
    private int premission;


    public User(int uId, String username, String password, int nId, int gender, Date birthday, String email, String address, String phone, Date regisDate, int premission) {
        this.uId = uId;
        this.username = username;
        this.password = password;
        this.nId = nId;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.regisDate = regisDate;
        this.premission = premission;
    }
    
    public User() {

    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    public int getPremission() {
        return premission;
    }

    public void setPremission(int premission) {
        this.premission = premission;
    }

}
