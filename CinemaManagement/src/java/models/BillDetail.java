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
public class BillDetail {

    //declare variable
    private int tId;
    private int bId;

    /**
     * constructor
     *
     * @param tId
     * @param bId
     */
    public BillDetail(int tId, int bId) {
        this.tId = tId;
        this.bId = bId;
    }

    /**
     * constructor
     */
    public BillDetail() {

    }

    /**
     * get tId method
     *
     * @return
     */
    public int gettId() {
        return tId;
    }

    /**
     * set tId method
     *
     * @param tId
     */
    public void settId(int tId) {
        this.tId = tId;
    }

    /**
     * get bId method
     *
     * @return
     */
    public int getbId() {
        return bId;
    }

    /**
     * setbId method
     *
     * @param bId
     */
    public void setbId(int bId) {
        this.bId = bId;
    }

}
