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
 * @author GF63 8RD
 */
public class Customer {
    private int cusId;
    private int levelAcount;
    private long totalPrice;
    private Time totalTime;

    public Customer(int cusId, int levelAcount, long totalPrice, Time totalTime) {
        this.cusId = cusId;
        this.levelAcount = levelAcount;
        this.totalPrice = totalPrice;
        this.totalTime = totalTime;
    }

    public Customer() {
        
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public int getLevelAcount() {
        return levelAcount;
    }

    public void setLevelAcount(int levelAcount) {
        this.levelAcount = levelAcount;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Time getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Time totalTime) {
        this.totalTime = totalTime;
    }
    
    
    
}
