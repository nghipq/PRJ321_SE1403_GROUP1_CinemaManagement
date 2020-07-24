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
public class Ticket {

    // create variable
    private int tId;
    private int scheId;
    private int seatId;
    private int status;

    /**
     * create Constructor
     *
     * @param tId
     * @param scheId
     * @param seatId
     * @param status
     */
    public Ticket(int tId, int scheId, int seatId, int status) {
        this.tId = tId;
        this.scheId = scheId;
        this.seatId = seatId;
        this.status = status;
    }

    /**
     * create empty Constructor
     */
    public Ticket() {
    }

    /**
     * get tId
     *
     * @return
     */
    public int gettId() {
        return tId;
    }

    /**
     * set tId
     *
     * @param tId: int
     */
    public void settId(int tId) {
        this.tId = tId;
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
     * set ScheId
     *
     * @param scheId: int
     */
    public void setScheId(int scheId) {
        this.scheId = scheId;
    }

    /**
     * get SeatId
     *
     * @return
     */
    public int getSeatId() {
        return seatId;
    }

    /**
     * set SeatId
     *
     * @param seatId:int
     */
    public void setSeatId(int seatId) {
        this.seatId = seatId;
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

}
