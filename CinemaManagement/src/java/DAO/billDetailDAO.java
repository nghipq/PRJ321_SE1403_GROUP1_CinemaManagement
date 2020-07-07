/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author phamq
 */
public class billDetailDAO {
    private Connection conn;

    public billDetailDAO(Connection conn) {
        this.conn = conn;
    }
    
    public boolean createBillDetail(int tId, int bId) throws SQLException {
        String sql = "INSERT INTO `billdetail`(`tId`, `bId`) values(?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, tId);
        ps.setInt(2, bId);
        
        try {
            int insert = ps.executeUpdate();
            if(insert == 1) return false;
            else return true;
        } catch (Exception e) {};
        
        return false;
    }
}
