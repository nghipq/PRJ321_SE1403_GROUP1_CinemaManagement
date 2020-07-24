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
public class UpdateHistory {

    // create variable
    private int upId;
    private int fId;
    private String content;
    private int sId;

    /**
     * create Constructor
     *
     * @param upId
     * @param fId
     * @param content
     * @param sId
     */
    public UpdateHistory(int upId, int fId, String content, int sId) {
        this.upId = upId;
        this.fId = fId;
        this.content = content;
        this.sId = sId;
    }

    /**
     * create empty Constructor
     */
    public UpdateHistory() {
    }

    /**
     * Get UpId
     *
     * @return
     */
    public int getUpId() {
        return upId;
    }

    /**
     * Set UpId
     *
     * @param upId:int
     */
    public void setUpId(int upId) {
        this.upId = upId;
    }

    /**
     * Get fId
     *
     * @return
     */
    public int getfId() {
        return fId;
    }

    /**
     * Set fId
     *
     * @param fId: int
     */
    public void setfId(int fId) {
        this.fId = fId;
    }

    /**
     * get Content
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * set Content
     *
     * @param content: String
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * get sId
     *
     * @return
     */
    public int getsId() {
        return sId;
    }

    /**
     * set sId
     *
     * @param sId: int
     */
    public void setsId(int sId) {
        this.sId = sId;
    }

}
