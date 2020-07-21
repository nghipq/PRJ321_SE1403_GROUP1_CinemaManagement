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
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;

/**
 *
 * @author phamq
 */
public class ScheduleDAO {

    private Connection conn;

    public ScheduleDAO() {
        this.conn = new DBConnection().getDBConnection();
    }
    
        public Scheldule getScheduleById(int scheId) throws SQLException {
        String sql = "SELECT * FROM `schedule` WHERE `scheId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, scheId);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Scheldule(scheId, rs.getInt("fId"), rs.getInt("sesId"), rs.getInt("fmId"), rs.getInt("status"), rs.getInt("rId"));
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
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
    public Session getSessionById(int id) throws SQLException {
        Session ses = new Session();
        String sql = "SELECT * FROM `session` WHERE `sesId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Time startTime = rs.getTime("startTime");
                Time endTime = rs.getTime("endTime");
                ses.setSesId(id);
                ses.setStartTime(startTime);
                ses.setEndTime(endTime);
            }
        } catch (Exception e) {
        };

        return ses;
    }
    
    /**
     * 
     * @param fId
     * @return
     * @throws SQLException 
     */
    public HashMap<Integer, Scheldule> getSchedulesDetail(int fId) throws SQLException {
        TicketDAO td = new TicketDAO();
        
        HashMap<Integer, Scheldule> schedules = new HashMap<>();
        ResultSet schedulesList = getScheduleByFilmId(fId);
        Session ses = null;
        int count = 64;

        ResultSet rs2 = null;
        while (schedulesList.next()) {
            ses = getSessionById(schedulesList.getInt("sesId"));

            rs2 = td.getTicketByCheduleId(schedulesList.getInt("scheId"), 1);

            while (rs2.next()) {
                count -= 1;
            }

            schedules.put(schedulesList.getInt("scheId"), 
                    new Scheldule(
                            schedulesList.getInt("scheId"),
                            fId, 
                            schedulesList.getInt("sesId"), 
                            schedulesList.getInt("fmId"), 
                            schedulesList.getInt("status"), 
                            schedulesList.getInt("rId")));

            count = 64;
        }
        
        return schedules;
    }
    
    public boolean createSchedule(int sesId, int fmId, int status, int rId) throws SQLException {
        String sql = "INSERT INTO `schedule`(`sesId`, `fmId`, `status`, `rId`) values (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, sesId);
        ps.setInt(2, fmId);
        ps.setInt(3, status);
        ps.setInt(4, rId);

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
