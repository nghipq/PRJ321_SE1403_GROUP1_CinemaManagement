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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import models.*;

/**
 *
 * @author phamq
 */
public class PersonDAO {
    private Connection conn;

    public PersonDAO() {
        conn = new DBConnection().getDBConnection();
    }
    
    public HashMap<Integer, String> getPersonNameFilmId(int fId, int rId) throws SQLException {
        HashMap<Integer, String> list = new HashMap<>();
        
        String sql = "SELECT * FROM `personinfilm` WHERE `fId` = ? and `rId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, fId);
        ps.setInt(2, rId);
        
        ResultSet rs = ps.executeQuery();
        ResultSet rs1 = null;
        
        Statement st = conn.createStatement();
        int pId;
        while(rs.next()) {
            pId = rs.getInt("pId");
            sql = "SELECT * FROM `person` WHERE `pId` = " + rs.getInt("pId");
            rs1 = st.executeQuery(sql);
            if(rs1.next()) {
                list.put(pId, rs1.getString("pName"));
            }
        }
        
        return list;
    }
}
