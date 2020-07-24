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
import models.BillDetail;
import models.Categories;

/**
 *
 * @author phamq
 */
public class billDetailDAO {

    private Connection conn;

    public billDetailDAO() {
        DBConnection db = new DBConnection();
        this.conn = db.getDBConnection();
    }

    /**
     * Create bill detail
     *
     * @param tId
     * @param bId
     * @return
     * @throws SQLException
     */
    public boolean createBillDetail(int tId, int bId) throws SQLException {
        String sql = "INSERT INTO `billdetail`(`tId`, `bId`) values(?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, tId);
        ps.setInt(2, bId);

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
     * Update bill detail
     *
     * @param tId
     * @param bId
     * @return
     * @throws SQLException
     */
    public boolean updateBillDetail(int tId, int bId) throws SQLException {
        String sql = "UPDATE `billDetail` SET `tId` = ? WHERE `bId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, tId);
        ps.setInt(2, bId);

        int rs = ps.executeUpdate();
        return rs > 0 ? true : false;
    }

    /**
     * Select billdetail where billid=?
     *
     * @param bId
     * @return
     * @throws SQLException
     */
    public ArrayList<BillDetail> getBillDetailByBillId(int bId) throws SQLException {
        ArrayList<BillDetail> billDetail = new ArrayList<BillDetail>();

        String sql = "SELECT * FROM `billdetail` WHERE `bId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, bId);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                billDetail.add(new BillDetail(rs.getInt("tId"), bId));
            }
        } catch (Exception e) {
        };

        return billDetail;
    }

    public ArrayList<BillDetail> getAllBillDetail() throws SQLException {
        ArrayList<BillDetail> billDetail = new ArrayList<BillDetail>();

        String sql = "SELECT * FROM `billdetail`";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                billDetail.add(new BillDetail(rs.getInt("tId"), rs.getInt("bId")));
            }
        } catch (Exception e) {
        };

        return billDetail;
    }

    /**
     * Close db connection
     *
     * @throws SQLException
     */
    public void closeConnect() throws SQLException {
        this.conn.close();
    }
}
