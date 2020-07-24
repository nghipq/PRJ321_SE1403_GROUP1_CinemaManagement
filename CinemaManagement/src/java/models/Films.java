/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Group 1
 */
public class Films {

    //declare variable
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

    /**
     * constructor
     */
    public Films() {
    }

    /**
     * constructor
     *
     * @param fId
     * @param fName
     * @param description
     * @param pId
     * @param releaseDate
     * @param rating
     * @param limitAge
     * @param status
     * @param airDate
     * @param endDate
     */
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

//    /**
//     *
//     * @param aInt
//     * @param string
//     * @param string0
//     * @param aInt0
//     */
//    public Films(int aInt, String string, String string0, int aInt0) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    /**
     * get fId method
     *
     * @return
     */
    public int getfId() {
        return fId;
    }

    /**
     * set fId method
     *
     * @param fId
     */
    public void setfId(int fId) {
        this.fId = fId;
    }

    /**
     * get fName method
     *
     * @return
     */
    public String getfName() {
        return fName;
    }

    /**
     * set fName method
     *
     * @param fName
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * get pId method
     *
     * @return
     */
    public int getpId() {
        return pId;
    }

    /**
     * set pId method
     *
     * @param pId
     */
    public void setpId(int pId) {
        this.pId = pId;
    }

    /**
     * get ReleaseDate method
     *
     * @return
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * set ReleaseDate method
     *
     * @param releaseDate
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * get Rating method
     *
     * @return
     */
    public double getRating() {
        return rating;
    }

    /**
     * set Rating method
     *
     * @param rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * get LimitAge method
     *
     * @return
     */
    public int getLimitAge() {
        return limitAge;
    }

    /**
     * set LimitAge method
     *
     * @param limitAge
     */
    public void setLimitAge(int limitAge) {
        this.limitAge = limitAge;
    }

    /**
     * get Status method
     *
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * set Status method
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * get AirDate method
     *
     * @return
     */
    public Date getAirDate() {
        return airDate;
    }

    /**
     * set AirDate methods
     *
     * @param airDate
     */
    public void setAirDate(Date airDate) {
        this.airDate = airDate;
    }

    /**
     * get EndDate method
     *
     * @return
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * set EndDate method
     *
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

}
