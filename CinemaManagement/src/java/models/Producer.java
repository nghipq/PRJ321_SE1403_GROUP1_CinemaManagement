/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Group 1
 */
public class Producer {

    //declare variable
    private int prId;
    private String prName;
    private int nId;
    private String description;
    private Date birthday;
    private String address;
    private String phoneNumber;
    private String email;

    /**
     * constructor
     */
    public Producer() {

    }

    /**
     * constructor
     *
     * @param prId
     * @param prName
     * @param nId
     * @param description
     * @param birthday
     * @param address
     * @param phoneNumber
     * @param email
     */
    public Producer(int prId, String prName, int nId, String description, Date birthday, String address, String phoneNumber, String email) {
        this.prId = prId;
        this.prName = prName;
        this.nId = nId;
        this.description = description;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * get PrId method
     *
     * @return
     */
    public int getPrId() {
        return prId;
    }

    /**
     * set PrId method
     *
     * @param prId
     */
    public void setPrId(int prId) {
        this.prId = prId;
    }

    /**
     * get PrName method
     *
     * @return
     */
    public String getPrName() {
        return prName;
    }

    /**
     * set PrName method
     *
     * @param prName
     */
    public void setPrName(String prName) {
        this.prName = prName;
    }

    /**
     * get nId method
     *
     * @return
     */
    public int getnId() {
        return nId;
    }

    /**
     * set nId method
     *
     * @param nId
     */
    public void setnId(int nId) {
        this.nId = nId;
    }

    /**
     * get description method
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * set description method
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get Birthday method
     *
     * @return
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * set Birthday method
     *
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * get Address method
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * set Address method
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get PhoneNumber method
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * set PhoneNumber method
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * get Email method
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * set Email method
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
