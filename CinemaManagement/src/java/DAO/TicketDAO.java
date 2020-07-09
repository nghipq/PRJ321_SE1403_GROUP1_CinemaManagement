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
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;

/**
 *
 * @author phamq
 */
public class TicketDAO {

    private Connection conn;

    public TicketDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Get ticket price
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public long getTicket(int id) throws SQLException {
        String sql = "SELECT * FROM `formality` WHERE `fmId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ticketPrice");
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int getTicketByCheduleId(int id) throws SQLException {
        String sql = "SELECT * FROM `schedule` WHERE `scheId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }
    
    public boolean createTicket(int scheId, int seatId, int status) throws SQLException {
        String sql = "INSERT INTO `ticket`(`scheId`, `seatId`, `status`) values (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, scheId);
        ps.setInt(2, seatId);
        ps.setInt(3, status);
        

        try {
            int insert = ps.executeUpdate();
            if (insert == 1) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
        };

        return false;
    }
}
