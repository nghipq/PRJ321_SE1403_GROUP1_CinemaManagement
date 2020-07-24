/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Time;

/**
 *
 * @author Admin
 */
public class Session {

    // create variable
    private int sesId;
    private Time startTime;
    private Time endTime;

    /**
     * create Constructor
     *
     * @param sesId
     * @param startTime
     * @param endTime
     */
    public Session(int sesId, Time startTime, Time endTime) {
        this.sesId = sesId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * create empty Constructor
     */
    public Session() {
    }

    /**
     * get SesId
     *
     * @return
     */
    public int getSesId() {
        return sesId;
    }

    /**
     * set SesId
     *
     * @param sesId: int
     */
    public void setSesId(int sesId) {
        this.sesId = sesId;
    }

    /**
     * get StartTime
     *
     * @return
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * set StartTime
     *
     * @param startTime:Time
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * get EndTime
     *
     * @return
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * set EndTime
     *
     * @param endTime: Time
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

}
