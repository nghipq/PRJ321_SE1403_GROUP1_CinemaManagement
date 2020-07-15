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
import models.Session;

/**
 *
 * @author GF63 8RD
 */
public class SessionDAO {
            private Connection conn;

    public SessionDAO() {
        this.conn = new DBConnection().getDBConnection();
    }
    
    public Session getSessionById(int sesId) throws SQLException {
        String sql = "SELECT * FROM session WHERE sesId = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, sesId);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                Session session = new Session(sesId, rs.getTime("startTime"), rs.getTime("endTime"));
                return session;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
