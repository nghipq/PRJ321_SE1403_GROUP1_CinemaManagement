/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                return new Scheldule(scheId, rs.getInt("fId"), rs.getInt("sesId"), rs.getInt("fmId"), rs.getInt("status"), rs.getInt("rId"), rs.getDate("sDate"));
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean updateSchedule(int scheId, int sesId, int fmId, int status, int rId, String sDate) throws SQLException {
        String sql = "update schedule set sesId=?, fmId=?, status=?, rId=?, sDate=? where scheId = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, sesId);
        pst.setInt(2, fmId);
        pst.setInt(3, status);
        pst.setInt(4, rId);
        pst.setDate(5, Date.valueOf(sDate));
        pst.setInt(6, scheId);
        
        int rs = pst.executeUpdate();
        return rs > 0 ? true : false;
    }
    
    public boolean updateStatusSchedule(int scheId, int status) throws SQLException {
        String sql = "update schedule set status=? where scheId = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, status);
        pst.setInt(2, scheId);
        
        int rs = pst.executeUpdate();
        return rs > 0 ? true : false;
    }
    
    public ResultSet getAll() throws SQLException {
        String sql = "SELECT * FROM schedule JOIN session on schedule.sesId = session.sesId ORDER BY session.startTime ASC, schedule.sDate ASC";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (Exception e) {
        }

        return rs;
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
    
        public ResultSet getScheduleByFilmIdandDate(int id, String sDate) throws SQLException {
        String sql = "SELECT * FROM `schedule` WHERE `fId` = ? and sDate = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setDate(2, Date.valueOf(sDate));
        
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

//    /**
//     * get session
//     *
//     * @param id
//     * @return
//     * @throws SQLException
//     */
//    public Session getSessionById(int id) throws SQLException {
//        Session ses = new Session();
//        String sql = "SELECT * FROM `session` WHERE `sesId` = ?";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setInt(1, id);
//
//        try {
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Time startTime = rs.getTime("startTime");
//                Time endTime = rs.getTime("endTime");
//                ses.setSesId(id);
//                ses.setStartTime(startTime);
//                ses.setEndTime(endTime);
//            }
//        } catch (Exception e) {
//        };
//
//        return ses;
//    }

    /**
     *
     * @param fId
     * @return
     * @throws SQLException
     */
    public HashMap<Integer, Scheldule> getSchedulesDetail(int fId, String sDate) throws SQLException {
        SessionDAO sed = new SessionDAO();
        TicketDAO td = new TicketDAO();

        HashMap<Integer, Scheldule> schedules = new HashMap<>();
        ResultSet schedulesList = getScheduleByFilmIdandDate(fId, sDate);
        Session ses = null;
        int count = 64;

        ResultSet rs2 = null;
        while (schedulesList.next()) {
            ses = sed.getSessionById(schedulesList.getInt("sesId"));

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
                            schedulesList.getInt("rId"),
                            schedulesList.getDate("sDate")));

            count = 64;
        }

        return schedules;
    }

    public boolean createSchedule(int sesId, int fmId, int status, int rId, int fId, String sDate) throws SQLException {
        String sql = "INSERT INTO `schedule`(`sesId`, `fmId`, `status`, `rId`, `fId`, `sDate`) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, sesId);
        ps.setInt(2, fmId);
        ps.setInt(3, status);
        ps.setInt(4, rId);
        ps.setInt(5, fId);
        ps.setDate(6, Date.valueOf(sDate));

        try {
            int insert = ps.executeUpdate();
            if (insert == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        };

        return false;
    }

    public int getMaxScheId() {
        try {
            String sql = "select max(scheId) as scheId from schedule";
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
    
    public void autoUpdateSchedule() throws SQLException {
        String sql = "update schedule set status = 0 where sDate < CURRENT_DATE";
        Statement st = conn.createStatement();
        st.execute(sql);
    }
}
