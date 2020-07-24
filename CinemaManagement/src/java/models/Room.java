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
public class Room {

    // create variable
    private int rId;
    private int seatNumber;
    private int size;
    private int rStatus;

    /**
     * create Constructor
     *
     * @param rId
     * @param seatNumber
     * @param size
     * @param rStatus
     */
    public Room(int rId, int seatNumber, int size, int rStatus) {
        this.rId = rId;
        this.seatNumber = seatNumber;
        this.size = size;
        this.rStatus = rStatus;
    }

    /**
     * create empty Constructor
     */
    public Room() {
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
     * get SeatNumber
     *
     * @return
     */
    public int getSeatNumber() {
        return seatNumber;
    }

    /**
     * set SeatNumber
     *
     * @param seatNumber: int
     */
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * get Size
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * set Size
     *
     * @param size:int
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * get rStatus
     *
     * @return
     */
    public int getrStatus() {
        return rStatus;
    }

    /**
     * set rStatus
     *
     * @param rStatus:int
     */
    public void setrStatus(int rStatus) {
        this.rStatus = rStatus;
    }

}
