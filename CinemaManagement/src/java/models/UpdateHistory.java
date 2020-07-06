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
public class UpdateHistory {

    private int upId;
    private int fId;
    private String content;
    private int sId;

    public UpdateHistory(int upId, int fId, String content, int sId) {
        this.upId = upId;
        this.fId = fId;
        this.content = content;
        this.sId = sId;
    }

    public UpdateHistory() {
    }

    public int getUpId() {
        return upId;
    }

    public void setUpId(int upId) {
        this.upId = upId;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

}
