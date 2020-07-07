/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaGrammar;
import database.DBConnection;
import java.sql.Connection;
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
    public boolean InsertUser(User s){
      try {
          String sql = "insert into user(username, email, password, birthday, nId, gender, address, phone, permission) values (?,?,?,?,?,?,?,?,?)";
          PreparedStatement pst = conn.prepareStatement(sql);
          pst.setString(1, s.getUsername());
          pst.setString(2, s.getUsername());
          pst.setString(3, s.getPassword());
          pst.setDate(4, s.getBirthday());
          pst.setInt(5, s.getnId());
          pst.setInt(6, s.getGender());
          pst.setString(7, s.getAddress());
          pst.setString(8, s.getPhone());
          pst.setInt(9, s.getPremission());
          return pst.execute();
      } catch (SQLException ex) {
          Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
      return false;
    }
    public boolean Login(String emails, String pass){
      try {
          String sql = "Select * from user where email = ?";
          PreparedStatement pst = conn.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
          if(rs.next()){
              return pass.equals(rs.getString("password"));
          }
          
      } catch (SQLException ex) {
          Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
      return false;
    }
    public int getMaxUser(){
      try {
          String sql = "select max(uId) from user";
          PreparedStatement pst = conn.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
          if(rs.next()){
              return rs.getInt("uId");
          }
      } catch (SQLException ex) {
          Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
      return 0;
    }
}
