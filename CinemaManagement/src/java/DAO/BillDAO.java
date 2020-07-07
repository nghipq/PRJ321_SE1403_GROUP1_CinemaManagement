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

/**
 *
 * @author phamq
 */
public class BillDAO {

    public Connection conn;

    public BillDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean createBill(int cusId, long total) throws SQLException {
        String sql = "INSERT INTO `bill`(`cusId`, `total`) values (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, cusId);
        ps.setInt(2, (int) total);

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
