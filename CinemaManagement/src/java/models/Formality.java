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
public class Formality {

    private int fmId;
    private String fmName;
    private String description;
    private long ticketPrice;

    public Formality(int fmId, String fmName, String description, long ticketPrice) {
        this.fmId = fmId;
        this.fmName = fmName;
        this.description = description;
        this.ticketPrice = ticketPrice;
    }

    public Formality() {
    }

    public int getFmId() {
        return fmId;
    }

    public void setFmId(int fmId) {
        this.fmId = fmId;
    }

    public String getFmName() {
        return fmName;
    }

    public void setFmName(String fmName) {
        this.fmName = fmName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

}
