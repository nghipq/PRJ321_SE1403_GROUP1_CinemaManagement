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
public class Bill {

    //declare variable
    private int bId;
    private int cusId;
    private int sId;
    private Date dateBuy;
    private long total;
    private String name;
    private String phone;
    private int status;

    /**
     * constructor
     */
    public Bill() {
    }

    /**
     * constructor
     *
     * @param bId
     * @param cusId
     * @param sId
     * @param dateBuy
     * @param total
     * @param name
     * @param phone
     * @param status
     */
    public Bill(int bId, int cusId, int sId, Date dateBuy, long total, String name, String phone, int status) {
        this.bId = bId;
        this.cusId = cusId;
        this.sId = sId;
        this.dateBuy = dateBuy;
        this.total = total;
        this.name = name;
        this.phone = phone;
        this.status = status;
    }

    /**
     * get Id method
     *
     * @return
     */
    public int getbId() {
        return bId;
    }

    /**
     * set Id method
     *
     * @param bId
     */
    public void setbId(int bId) {
        this.bId = bId;
    }

    /**
     * get CusId method
     *
     * @return
     */
    public int getCusId() {
        return cusId;
    }

    /**
     * set CusId method
     *
     * @param cusId
     */
    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    /**
     * get sId method
     *
     * @return
     */
    public int getsId() {
        return sId;
    }

    /**
     * setsId method
     *
     * @param sId
     */
    public void setsId(int sId) {
        this.sId = sId;
    }

    /**
     * getDateBuy method
     *
     * @return
     */
    public Date getDateBuy() {
        return dateBuy;
    }

    /**
     * setDateBuy method
     *
     * @param dateBuy
     */
    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    /**
     * getTotal method
     *
     * @return
     */
    public long getTotal() {
        return total;
    }

    /**
     * setTotal method
     *
     * @param total
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * getName method
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setName method
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getPhone method
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * setPhone method
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * getStatus method
     *
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * setStatus method
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

}
