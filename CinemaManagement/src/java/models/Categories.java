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
public class Categories {

    //declare variable
    private int cateId;
    private String cateName;
    private String description;

    /**
     * constructor
     *
     * @param cateId
     * @param cateName
     * @param description
     */
    public Categories(int cateId, String cateName, String description) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.description = description;
    }

    /**
     * constructor
     */
    public Categories() {
    }

    /**
     * get cateId method
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

    /**
     * get cateName method
     *
     * @return
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * set cateName method
     *
     * @param cateName
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    /**
     * get Description method
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * set Description method
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
