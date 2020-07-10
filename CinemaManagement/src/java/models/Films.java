/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Films {

    private int fId;
    private String fName;
    private String description;
    private int pId;
    private Date releaseDate;
    private double rating;
    private int limitAge;
    private int status;
    private Date airDate;
    private Date endDate;

    public Films() {
    }

    public Films(int fId, String fName, String description, int pId, Date releaseDate, double rating, int limitAge, int status, Date airDate, Date endDate) {
        this.fId = fId;
        this.fName = fName;
        this.description = description;
        this.pId = pId;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.limitAge = limitAge;
        this.status = status;
        this.airDate = airDate;
        this.endDate = endDate;
    }

    

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getLimitAge() {
        return limitAge;
    }

    public void setLimitAge(int limitAge) {
        this.limitAge = limitAge;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getAirDate() {
        return airDate;
    }

    public void setAirDate(Date airDate) {
        this.airDate = airDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    

}
