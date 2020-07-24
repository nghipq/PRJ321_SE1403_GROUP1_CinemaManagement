/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Group 1
 */
public class Customer {

    //declare variable
    private int cusId;
    private int levelAcount;
    private long totalPrice;
    private Time totalTime;

    /**
     * constructor
     *
     * @param cusId
     * @param levelAcount
     * @param totalPrice
     * @param totalTime
     */
    public Customer(int cusId, int levelAcount, long totalPrice, Time totalTime) {
        this.cusId = cusId;
        this.levelAcount = levelAcount;
        this.totalPrice = totalPrice;
        this.totalTime = totalTime;
    }

    /**
     * constructor
     */
    public Customer() {

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
     * get LevelAcount method
     *
     * @return
     */
    public int getLevelAcount() {
        return levelAcount;
    }

    /**
     * set LevelAcount method
     *
     * @param levelAcount
     */
    public void setLevelAcount(int levelAcount) {
        this.levelAcount = levelAcount;
    }

    /**
     * get TotalPrice method
     *
     * @return
     */
    public long getTotalPrice() {
        return totalPrice;
    }

    /**
     * set TotalPrice method
     *
     * @param totalPrice
     */
    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * get totalTime method
     *
     * @return
     */
    public Time getTotalTime() {
        return totalTime;
    }

    /**
     * set totalTime method
     *
     * @param totalTime
     */
    public void setTotalTime(Time totalTime) {
        this.totalTime = totalTime;
    }

}
