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
public class CastInFilm {

    //declare variable
    private int fId;
    private int cateId;

    /**
     * constructor
     *
     * @param fId
     * @param cateId
     */
    public CastInFilm(int fId, int cateId) {
        this.fId = fId;
        this.cateId = cateId;
    }

    /**
     * constructor
     */
    public CastInFilm() {
    }

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
     * get CateId method
     *
     * @return
     */
    public int getCateId() {
        return cateId;
    }

    /**
     * set CateId method
     *
     * @param cateId
     */
    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

}
