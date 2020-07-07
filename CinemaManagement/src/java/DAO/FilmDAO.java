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
        
        return imgPath;
    }
}
