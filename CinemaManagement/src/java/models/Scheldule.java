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
public class Scheldule {

    // create variable
    private int scheId;
    private int fId;
    private int sesId;
    private int fmId;
    private int status;
    private int rId;
    private Date sDate;

    /**
     * create empty Constructor
     */
    public Scheldule() {
    }

    /**
     * create Constructor
     *
     * @param scheId
     * @param fId
     * @param sesId
     * @param fmId
     * @param status
     * @param rId
     * @param sDate
     */
    public Scheldule(int scheId, int fId, int sesId, int fmId, int status, int rId, Date sDate) {
        this.scheId = scheId;
        this.fId = fId;
        this.sesId = sesId;
        this.fmId = fmId;
        this.status = status;
        this.rId = rId;
        this.sDate = sDate;
    }

    /**
     * get ScheId
     *
     * @return
     */
    public int getScheId() {
        return scheId;
    }

    /**
     * set scheId
     *
     * @param scheId:int
     */
    public void setScheId(int scheId) {
        this.scheId = scheId;
    }

    /**
     * get fId
     *
     * @return
     */
    public int getfId() {
        return fId;
    }

    /**
     * set fId
     *
     * @param fId:int
     */
    public void setfId(int fId) {
        this.fId = fId;
    }

    /**
     * get sesId
     *
     * @return
     */
    public int getSesId() {
        return sesId;
    }

    /**
     * set sesId
     *
     * @param sesId:int
     */
    public void setSesId(int sesId) {
        this.sesId = sesId;
    }

    /**
     * get FmId
     *
     * @return
     */
    public int getFmId() {
        return fmId;
    }

    /**
     * set FmId
     *
     * @param fmId:int
     */
    public void setFmId(int fmId) {
        this.fmId = fmId;
    }

    /**
     * get Status
     *
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * set Status
     *
     * @param status:int
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * get rId
     *
     * @return
     */
    public int getrId() {
        return rId;
    }

    /**
     * set rId
     *
     * @param rId:int
     */
    public void setrId(int rId) {
        this.rId = rId;
    }

    /**
     * get sDate
     *
     * @return
     */
    public Date getsDate() {
        return sDate;
    }

    /**
     * set sDate
     *
     * @param sDate:date
     */
    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

}
