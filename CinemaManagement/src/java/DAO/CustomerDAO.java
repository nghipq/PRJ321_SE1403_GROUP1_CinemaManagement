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
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;
import models.User;

/**
 *
 * @author Admin
 */
public class CustomerDAO {

    public Connection conn;

    public CustomerDAO() {
        DBConnection db = new DBConnection();
        this.conn = db.getDBConnection();
    }

    public boolean InsertCustomers() {
        UserDAO udao = new UserDAO();
        int id = udao.getMaxUser();
        try {

            String sql = "insert into customers(cusId, levelAccount, totalPrice, totalTime) values (?,0,0,0)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
//            pst.setInt(2, 0);
//            pst.setInt(3, 0);
//            pst.setTime(4, Time.valueOf("00:00:00"));

            int rs = pst.executeUpdate();
            return rs > 0 ? true : false;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
