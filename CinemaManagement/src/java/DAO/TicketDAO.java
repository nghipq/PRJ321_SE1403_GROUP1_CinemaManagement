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
}
