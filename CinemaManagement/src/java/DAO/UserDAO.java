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

    /**
     * InsertUser from user
     *
     * @param Username
     * @param Email
     * @param Password
     * @param Birthday
     * @param Address
     * @param Phone
     * @return
     */
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

    /**
     * Select user where email = ? and password = ?
     *
     * @param emails
     * @param pass
     * @return
     */
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

    /**
     * get max uId of user
     *
     * @return
     */
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

    /**
     * get All user
     *
     * @return
     */
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

    /**
     * get all user wher permission = ?
     *
     * @param per
     * @return
     */
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

    /**
     * get all user where uId =?
     *
     * @param id
     * @return
     * @throws SQLException
     */
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

    /**
     * Update user
     *
     * @param uId
     * @param username
     * @param email
     * @param Birthday
     * @param gender
     * @param address
     * @param phone
     * @param RegisDate
     * @param Permission
     * @return
     */
    public int UpdateUser(String uId, String username, String email, String Birthday, String gender, String address, String phone, String RegisDate, String Permission) {
        try {
            String sql = "UPDATE `user` SET `username`=?,`email`=?,`birthday`=?,`gender`=?,`address`=?,`phone`=?,`regisDate`=?, `permission`=? WHERE uId=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, email);
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

    /**
     * Update status of user by uId
     *
     * @param uId
     * @param status
     * @return
     * @throws SQLException
     */
    public boolean updateStatusUser(String uId, int status) throws SQLException {
        String sql = "update user set status = ? where uId = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, status);
        pst.setInt(2, Integer.parseInt(uId));

        return pst.executeUpdate() > 0 ? true : false;
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
