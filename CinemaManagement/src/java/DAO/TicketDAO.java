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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;
import org.springframework.scheduling.annotation.Scheduled;
import com.google.gson.Gson;

/**
 *
 * @author phamq
 */
public class TicketDAO {

    private Connection conn;

    public TicketDAO() {
        this.conn = new DBConnection().getDBConnection();
    }
    
    public Ticket getTicketById(int tId) throws SQLException {
        String sql = "SELECT * FROM `ticket` WHERE `tId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, tId);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Ticket(tId, rs.getInt("scheId"), rs.getInt("seatId"), rs.getInt("status"));
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Get ticket price
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public long getTicketPriceByFmId(int fmId) throws SQLException {
        String sql = "SELECT * FROM `formality` WHERE `fmId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, fmId);

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
    
    public long getTicketPriceById(int tId) throws SQLException {
        Ticket ticket = getTicketById(tId);
        ScheduleDAO sd = new ScheduleDAO();
        Scheldule schedule = sd.getScheduleById(ticket.getScheId());
        
        return getTicketPriceByFmId(schedule.getFmId());
    }
    
    public ArrayList<String> getDetail(int sesId, int scheId) throws SQLException {
        ArrayList<String> details = new ArrayList<>();
        ScheduleDAO sd = new ScheduleDAO();
        SessionDAO sed = new SessionDAO();
        Session ses = sed.getSessionById(sesId);
        details.add(ses.getStartTime().toString());
        
        int count = 64;
        ResultSet rs = getTicketByCheduleId(scheId, 1);
        while(rs.next()) {
            count -= 1;
        }
        
        details.add(count + "/64");
        
        return details;
    }
    
    public ResultSet getTicketByCheduleId(int id, int status) throws SQLException {
        String sql = "SELECT * FROM `ticket` WHERE `scheId` = ? and `status` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setInt(2, status);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (Exception e) {}
        return rs;
    }
    
    public HashMap<String, String> getSeatAndTicketByScheduleId(int scheId) throws SQLException {
        Gson gson = new Gson();
        String sql = "SELECT * FROM `ticket` WHERE `scheId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, scheId);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (Exception e) {}
        
        HashMap<String, String> tickets = new HashMap<>();
        ResultSet rs1 = null;
        
        int tId;
        int scheId1;
        int seatId;
        int status;
//        JSONObject jobj;
        String json;
        Ticket ticket;
        
        while(rs.next()) {
            sql = "select * from `roomseat` where seatId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, rs.getInt("seatId"));
            
            rs1 = ps.executeQuery();
            if(rs1.next()) {
                tId = rs.getInt("tId");
                scheId1 = rs.getInt("scheId");
                seatId = rs.getInt("seatId");
                status = rs.getInt("status");
                
                ticket = new Ticket(tId, scheId, seatId, status);
//                jobj = new JSONObject(ticket);
                json = gson.toJson(ticket);
                tickets.put(rs1.getString("seatName"), json);
            }
        }
        
        return tickets;
    }
    
    public boolean createTicket(int scheId, int seatId, int status) throws SQLException {
        String sql = "INSERT INTO `ticket`(`scheId`, `seatId`, `status`) values (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, scheId);
        ps.setInt(2, seatId);
        ps.setInt(3, status);

        int rs = ps.executeUpdate();
        return rs>0?true:false;
    }
    
    public boolean  updateStatus(int tid, int status){
        try {
            String sql = "UPDATE ticket SET status = ? WHERE tId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, tid);
            int rs = ps.executeUpdate();
            
            return rs>0?true:false;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
}
