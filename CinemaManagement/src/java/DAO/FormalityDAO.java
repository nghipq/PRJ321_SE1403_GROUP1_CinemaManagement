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
import models.*;

/**
 *
 * @author GF63 8RD
 */
public class FormalityDAO {
    private Connection conn;

    public FormalityDAO() {
        this.conn = new DBConnection().getDBConnection();
    }
    
    public Formality getFormalityById(int fmId) throws SQLException {
        String sql = "SELECT * FROM formality WHERE fmId = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, fmId);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                Formality formality = new Formality(fmId, rs.getString("fmName"), rs.getString("description"), rs.getInt("ticketPrice"));
                return formality;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public ResultSet getFormalityByScheduleId(int id) throws SQLException{
        String sql = "SELECT * FROM formality WHERE `fmId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(2, id);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }
    
    public Formality getFormalitybyBillId(int id) throws SQLException{
        billDetailDAO bdDao = new billDetailDAO();
        TicketDAO tDao = new TicketDAO();
        ScheduleDAO sDao = new ScheduleDAO();
        
        BillDetail billDetail = bdDao.getBillDetailByBillId(id).get(0);
        Ticket ticket = tDao.getTicketById(billDetail.gettId());
        Scheldule scheldule = sDao.getScheduleById(ticket.getScheId());
        return getFormalityById(scheldule.getFmId());
    }
}
