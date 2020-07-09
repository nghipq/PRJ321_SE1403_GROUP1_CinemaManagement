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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;

/**
 *
 * @author phamq
 */
public class ScheduleDAO {

    private Connection conn;

    public ScheduleDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Get schedule in film
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public ResultSet getScheduleByFilmId(int id) throws SQLException {
        String sql = "SELECT * FROM `schedule` WHERE `fId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    /**
     * get session
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Session getSessionByScheduleId(int id) throws SQLException {
        Session ses = new Session();
        String sql = "SELECT * FROM `session` WHERE `sesId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (Exception e) {
        };

        return ses;
    }

    public boolean createSchedule(int sesId, int fmId, int status) throws SQLException {
        String sql = "INSERT INTO `schedule`(`sesId`, `fmId`, `status`) values (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, sesId);
        ps.setInt(2, fmId);
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

    public int getMaxScheId() {
        try {
            String sql = "select max(scheId) from schedule";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("scheId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


}
