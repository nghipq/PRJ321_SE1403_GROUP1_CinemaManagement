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
public class Bill {
    private int bId;
    private int cusId;
    private int sId;
    private Date dateBuy;
    private long total;
    private String name;
    private String phone;
    private int status;

    public Bill() {
    }

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

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
