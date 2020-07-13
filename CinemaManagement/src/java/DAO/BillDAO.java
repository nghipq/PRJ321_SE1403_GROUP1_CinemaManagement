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
public class BillDAO {

    public Connection conn;

    public BillDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Get All Bill
     *
     * @return
     * @throws SQLException
     */
    public ResultSet getAll() throws SQLException {
        String sql = "SELECT * FROM `bill`";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = null;

        try {
            rs = ps.executeQuery();
        } catch (Exception e) {
        };

        return rs;
    }

    /**
     * Get bill by given bill id
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Bill getBillById(int id) throws SQLException {
        String sql = "SELECT * FROM `bill` WHERE `bId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        Bill bill = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                bill = new Bill(id, rs.getInt("cusId"), rs.getInt("sId"), rs.getDate("dateBuy"), rs.getLong("total"), rs.getString("phone"), rs.getString("name"));
            }
        } catch (Exception e) {
        }

        return bill;
    }

    /**
     * Create new bill
     *
     * @param cusId
     * @param total
     * @return
     * @throws SQLException
     */
    public boolean createBill(int cusId, long total, String phone, String name) throws SQLException {
        String sql = "INSERT INTO `bill`(`cusId`, `total`) values (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, cusId);
        ps.setInt(2, (int) total);
        ps.setString(3, phone);
        ps.setString(4, name);

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

    /**
     * Update bill by given values
     *
     * @param bId
     * @param sId
     * @param total
     * @return
     * @throws SQLException
     */
    public boolean updateBill(int bId, int sId, long total, int status, String phone, String name) throws SQLException {
        String sql = "UPDATE `bill` SET `sId` = ?, `total` = ?, `status` = ?, `phone` = ?, `name` = ? WHERE `bId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, sId);
        ps.setLong(2, total);
        ps.setInt(3, bId);
        ps.setInt(4, status);
        ps.setString(5, phone);
        ps.setString(6, name);

        int rs = ps.executeUpdate();
        return rs > 0 ? true : false;
    }

    /**
     * Get max bill id
     *
     * @return
     */
    public int maxBill() {
        String sql = "Select max(bId) as bId from bill";

        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("bId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
}
