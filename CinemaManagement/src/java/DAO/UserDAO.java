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
import java.time.LocalDate;
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
            String sql = "insert into user(username, email, password, birthday, gender, address, phone, permission) values (?,?,md5(?),?,?,?,?,?)";
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
            String sql = "Select * from user where email = ? and password = md5(?)";
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

    public ResultSet getUserByPermission(int per) {
        try {
            String sql = "SELECT * FROM `user` WHERE `permission` = ?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, per);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM `user` WHERE `uId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        User user = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                //films = new Films();
                user = new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"), rs.getInt("nId"), rs.getInt("gender"), rs.getDate("birthday"), rs.getString("email"), rs.getString("address"),
                        rs.getString("phone"), rs.getDate("regisDate"), rs.getInt("permission"));
            }
        } catch (Exception e) {
        }

        return user;
    }

    public int UpdateUser(String uId,String username, String email, String Birthday, String gender, String address, String phone, String RegisDate, String Permission) {
        try {
            String sql = "UPDATE `user` SET `username`=?,`email`=?,`birthday`=?,`gender`=?,`address`=?,`phone`=?,`regisDate`=?, `permission`=? WHERE uId=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2,email);
            pst.setDate(3, Date.valueOf(Birthday));
            pst.setInt(4, Integer.parseInt(gender));
            pst.setString(5, address);
            pst.setString(6, phone);
            pst.setDate(7, Date.valueOf(RegisDate));
            pst.setInt(8, Integer.parseInt(Permission));
            pst.setInt(9, Integer.parseInt(uId));
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
