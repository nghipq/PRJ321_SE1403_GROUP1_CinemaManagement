/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author GF63 8RD
 */
public class BillDetail {
    private int tId;
    private int bId;

    public BillDetail(int tId, int bId) {
        this.tId = tId;
        this.bId = bId;
    }

    public BillDetail() {

    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }
    
    
    
}
