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
public class Graphics {

    //declare variable
    private int gId;
    private int fId;
    private String content;
    private int sId;

    /**
     * constructor
     *
     * @param gId
     * @param fId
     * @param content
     * @param sId
     */
    public Graphics(int gId, int fId, String content, int sId) {
        this.gId = gId;
        this.fId = fId;
        this.content = content;
        this.sId = sId;
    }

    /**
     * constructor
     */
    public Graphics() {
    }

    /**
     * get gId method
     *
     * @return
     */
    public int getgId() {
        return gId;
    }

    /**
     * set gId method
     *
     * @param gId
     */
    public void setgId(int gId) {
        this.gId = gId;
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
     * get Content method
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * set Content method
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * get sId method
     *
     * @return
     */
    public int getsId() {
        return sId;
    }

    /**
     * set sId method
     *
     * @param sId
     */
    public void setsId(int sId) {
        this.sId = sId;
    }

}
