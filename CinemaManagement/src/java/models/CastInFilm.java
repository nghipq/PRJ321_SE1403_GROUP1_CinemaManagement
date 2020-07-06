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
public class CastInFilm {

    private int fId;
    private int cateId;

    public CastInFilm(int fId, int cateId) {
        this.fId = fId;
        this.cateId = cateId;
    }

    public CastInFilm() {
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

}
