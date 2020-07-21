/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaGrammar;
import database.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;
import models.User;

/**
 *
 * @author Admin
 */
public class UserDAO {

    public Connection conn;

    public UserDAO() {
        DBConnection db = new DBConnection();
        this.conn = db.getDBConnection();
    }

    public boolean InsertUser(String Username, String Email, String Password, Date Birthday, String Address, String Phone) {
        try {
            String sql = "insert into user(username, email, password, birthday, gender, address, phone, permission) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Username);
            pst.setString(2, Email);
            pst.setString(3, Password);
            pst.setDate(4, Birthday);
            pst.setInt(5, 0);
            pst.setString(6, Address);
            pst.setString(7, Phone);
            pst.setInt(8, 0);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public User Login(String emails, String pass) {
        try {
            String sql = "Select * from user where email = ? and password = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, emails);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"), rs.getInt("nId"), rs.getInt("gender"), rs.getDate("birthday"), rs.getString("email"), rs.getString("address"), rs.getString("Phone"), rs.getDate("regisDate"), rs.getInt("permission"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public int getMaxUser() {
        try {
            String sql = "select max(uId) as uId from user";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("uId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public ResultSet getAll() {
        String sql = "SELECT * FROM `user`";
        ResultSet rs = null;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }
}
