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
public class Formality {

    //declare variable
    private int fmId;
    private String fmName;
    private String description;
    private long ticketPrice;

    /**
     * constructor
     *
     * @param fmId
     * @param fmName
     * @param description
     * @param ticketPrice
     */
    public Formality(int fmId, String fmName, String description, long ticketPrice) {
        this.fmId = fmId;
        this.fmName = fmName;
        this.description = description;
        this.ticketPrice = ticketPrice;
    }

    /**
     * constructor
     */
    public Formality() {
    }

    /**
     * get FmId method
     *
     * @return
     */
    public int getFmId() {
        return fmId;
    }

    /**
     * set FmId method
     *
     * @param fmId
     */
    public void setFmId(int fmId) {
        this.fmId = fmId;
    }

    /**
     * get FmName method
     *
     * @return
     */
    public String getFmName() {
        return fmName;
    }

    /**
     * set FmName method
     *
     * @param fmName
     */
    public void setFmName(String fmName) {
        this.fmName = fmName;
    }

    /**
     * get description method
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * set description method
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get TicketPrice method
     *
     * @return
     */
    public long getTicketPrice() {
        return ticketPrice;
    }

    /**
     * set TicketPrice method
     *
     * @param ticketPrice
     */
    public void setTicketPrice(long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

}
