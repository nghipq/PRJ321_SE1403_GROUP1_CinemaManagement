/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Admin
 */
public class Scheldule {

    private int fId;
    private int sesId;
    private int fmId;

    public Scheldule(int fId, int sesId, int fmId) {
        this.fId = fId;
        this.sesId = sesId;
        this.fmId = fmId;
    }

    public Scheldule() {
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

}
