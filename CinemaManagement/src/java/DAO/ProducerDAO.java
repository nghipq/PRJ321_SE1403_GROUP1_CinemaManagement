/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Statement;
import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.*;
/**
 *
 * @author phamq
 */
public class ProducerDAO {
    private Connection conn;

    public ProducerDAO() {
        this.conn = new DBConnection().getDBConnection();
    }
    
    public ArrayList<Producer> getAll() throws SQLException {
        String sql = "select * from producers";
        Statement st = (Statement) conn.createStatement();
        
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Producer> producers = new ArrayList<>();
        
        while(rs.next()) {
            producers.add(new Producer(rs.getInt("pId"), rs.getString("pName"), 
                    rs.getInt("nId"), rs.getString("description"), rs.getDate("birthday"), 
                    rs.getString("address"), rs.getString("phoneNumber"), 
                    rs.getString("email")));
        }
        
        return producers;
    }
}
