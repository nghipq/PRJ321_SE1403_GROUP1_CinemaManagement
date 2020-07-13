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

    private int sesId;
    private Time startTime;
    private Time endTime;

    public Session(int sesId, Time startTime, Time endTime) {
        this.sesId = sesId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Session() {
    }

    public int getSesId() {
        return sesId;
    }

    public void setSesId(int sesId) {
        this.sesId = sesId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    

}
