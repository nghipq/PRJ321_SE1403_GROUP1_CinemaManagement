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
import models.*;

/**
 *
 * @author phamq
 */
public class RoomDAO {
    private Connection conn;

    public RoomDAO(Connection conn) {
        this.conn = conn;
    }
    
    /**
     * Update room status
     * @param status
     * @return
     * @throws SQLException 
     */
    public boolean updateRoom(int status) throws SQLException {
        String sql = "UPDATE `room` SET `status` = ?";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setInt(1, status);
        
        int rs = ps.executeUpdate();
        
        return rs>0?true:false;
    }
}
