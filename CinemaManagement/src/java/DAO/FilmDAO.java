/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.*;
import org.springframework.messaging.tcp.reactor.ReactorNettyTcpClient;

/**
 *
 * @author phamq
 */
public class FilmDAO {
    private Connection conn;
    
    public FilmDAO() {
        conn = new DBConnection().getDBConnection();
    }
    
    /**
     * Get all films
     * @return 
     */
    public ResultSet getAll() {
        String sql = "SELECT * FROM `films`";
        ResultSet rs = null;
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        }catch(Exception e) {}
        
        return rs;
    }
    
    /**
     * Get film's poster by film's id
     * @return 
     */
    public String getFilmPoster(int id) throws SQLException {
        String sql = "SELECT * FROM `graphic` WHERE `fId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = null;
        String imgPath = "#";
        
        try {
            rs = ps.executeQuery();
            if(rs.next()) {
                imgPath = rs.getString("path");
            }
        } catch (Exception e) {};
        
        return "<c:url value='/resources/image/" + imgPath + "'/>";
    }
    
    /**
     * Get categories of film
     * @param id
     * @return
     * @throws SQLException 
     */
    public ArrayList<Categories> getCategoriesInFilm(int id) throws SQLException {
        ArrayList<Categories> categories = new ArrayList<Categories>();
        
        String sql = "SELECT * FROM `categoryinfilm` WHERE `fId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = null;
        ResultSet ans = null;
        try {
            rs = ps.executeQuery();
            while(rs.next()) {
                sql = "SELECT * FROM `categories` WHERE `cateId` = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, rs.getInt("cateId"));
                
                ans = ps.executeQuery();
                if(ans.next()) {
                    categories.add(new Categories(ans.getInt("cateId"), ans.getString("cateName"), ans.getString("description")));
                }
            }
        } catch (Exception e) {};
        
        return categories;
    }
}
