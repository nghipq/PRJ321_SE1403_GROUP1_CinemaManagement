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

    // create variable
    private int uId;
    private String username;
    private String password;
    private String confirmpass;
    private int nId;
    private int gender;
    private Date birthday;
    private String email;
    private String address;
    private String phone;
    private Date regisDate;
    private int premission;

    /**
     * create Constructor
     *
     * @param uId
     * @param username
     * @param password
     * @param nId
     * @param gender
     * @param birthday
     * @param email
     * @param address
     * @param phone
     * @param regisDate
     * @param premission
     */
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

    /**
     * create empty Constructor
     */
    public User() {

    }

    /**
     * Get uId
     *
     * @return
     */
    public int getuId() {
        return uId;
    }

    /**
     * Set uId
     *
     * @param uId:int
     */
    public void setuId(int uId) {
        this.uId = uId;
    }

    /**
     * Get uId
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username
     *
     * @param username: String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get Password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get Confirmpass
     *
     * @return
     */
    public String getConfirmpass() {
        return confirmpass;
    }

    /**
     * Set Confirmpass
     *
     * @param confirmpass:String
     */
    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    /**
     * Set password
     *
     * @param password:String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get nId
     *
     * @return
     */
    public int getnId() {
        return nId;
    }

    /**
     * Set nIt
     *
     * @param nId:int
     */
    public void setnId(int nId) {
        this.nId = nId;
    }

    /**
     * Get Gender
     *
     * @return
     */
    public int getGender() {
        return gender;
    }

    /**
     * Set Gender
     *
     * @param gender:int
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * Get Birthday
     *
     * @return
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * set Birthday
     *
     * @param birthday:date
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Get Email
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * set Email
     *
     * @param email:String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get Address
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * set Address
     *
     * @param address:address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get Phone
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * set Phone
     *
     * @param phone:String
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get RegisDate
     *
     * @return
     */
    public Date getRegisDate() {
        return regisDate;
    }

    /**
     * set RegisDate
     *
     * @param regisDate:Date
     */
    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    /**
     * Get Premission
     *
     * @return
     */
    public int getPremission() {
        return premission;
    }

    /**
     * set premission
     *
     * @param premission:int
     */
    public void setPremission(int premission) {
        this.premission = premission;
    }

}
