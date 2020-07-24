/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Group 1
 */
public class Staff {
    // create variable

    private int sId;
    private int levelStaff;
    private String CMND;

    /**
     * create Constructor
     *
     * @param sId
     * @param levelStaff
     * @param CMND
     */
    public Staff(int sId, int levelStaff, String CMND) {
        this.sId = sId;
        this.levelStaff = levelStaff;
        this.CMND = CMND;
    }

    /**
     * create empty Constructor
     */
    public Staff() {

    }

    /**
     * get sId
     *
     * @return
     */
    public int getsId() {
        return sId;
    }

    /**
     * set sId
     *
     * @param sId: int
     */
    public void setsId(int sId) {
        this.sId = sId;
    }

    /**
     * get LevelStaff
     *
     * @return
     */
    public int getLevelStaff() {
        return levelStaff;
    }

    /**
     * set levelStaff
     *
     * @param levelStaff:int
     */
    public void setLevelStaff(int levelStaff) {
        this.levelStaff = levelStaff;
    }

    /**
     * get CMND
     *
     * @return
     */
    public String getCMND() {
        return CMND;
    }

    /**
     * set CMND
     *
     * @param CMND: String
     */
    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

}
