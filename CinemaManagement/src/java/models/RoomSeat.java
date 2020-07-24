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
public class RoomSeat {

    // create variable
    private int seatId;
    private int rId;

    /**
     * create Constructor
     *
     * @param seatId
     * @param rId
     */
    public RoomSeat(int seatId, int rId) {
        this.seatId = seatId;
        this.rId = rId;
    }

    /**
     * create empty Constructor
     */
    public RoomSeat() {
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
     * @param rId: int
     */
    public void setrId(int rId) {
        this.rId = rId;
    }

}
