/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phamq
 */
public class RoomSeatDAO {
    private Connection conn;

    public RoomSeatDAO(Connection conn) {
        this.conn = conn;
    }
    
    /**
     * Get room seat by room id
     * @param rId
     * @return
     * @throws SQLException 
     */
    public ResultSet getSeatByRoomId(int rId) throws SQLException {
        String sql = "SELECT * FROM `roomseat` WHERE `rId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, rId);
        ResultSet rs = ps.executeQuery();
        
        return rs;
    }
}
