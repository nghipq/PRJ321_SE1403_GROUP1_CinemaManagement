/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author GF63 8RD
 */
public class Staff {
    private int sId;
    private int levelStaff;
    private String CMND;

    public Staff(int sId, int levelStaff, String CMND) {
        this.sId = sId;
        this.levelStaff = levelStaff;
        this.CMND = CMND;
    }

    public Staff() {
       
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getLevelStaff() {
        return levelStaff;
    }

    public void setLevelStaff(int levelStaff) {
        this.levelStaff = levelStaff;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }
    
    
    
}
