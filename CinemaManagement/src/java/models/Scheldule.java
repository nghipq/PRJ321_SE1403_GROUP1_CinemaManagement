/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Scheldule {
    private int scheId;
    private int fId;
    private int sesId;
    private int fmId;
    private int status;
    private int rId;
    private Date sDate;

    public Scheldule() {
    }

    public Scheldule(int scheId, int fId, int sesId, int fmId, int status, int rId, Date sDate) {
        this.scheId = scheId;
        this.fId = fId;
        this.sesId = sesId;
        this.fmId = fmId;
        this.status = status;
        this.rId = rId;
        this.sDate = sDate;
    }

    public int getScheId() {
        return scheId;
    }

    public void setScheId(int scheId) {
        this.scheId = scheId;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public int getSesId() {
        return sesId;
    }

    public void setSesId(int sesId) {
        this.sesId = sesId;
    }

    public int getFmId() {
        return fmId;
    }

    public void setFmId(int fmId) {
        this.fmId = fmId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    

}
