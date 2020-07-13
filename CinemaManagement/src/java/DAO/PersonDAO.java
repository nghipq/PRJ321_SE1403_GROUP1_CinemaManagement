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
    
    public String getPersonNameFilmId(int fId, int rId) throws SQLException {
        String list = "";
        
        String sql = "SELECT * FROM `personinfilm` WHERE `fId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, fId);
        
        ResultSet rs = ps.executeQuery();
        ResultSet rs1 = null;
        
        Statement st = conn.createStatement();
        int pId;
        while(rs.next()) {
            pId = rs.getInt("pId");
            sql = "SELECT * FROM `person` WHERE `pId` = " + rs.getInt("pId");
            rs1 = st.executeQuery(sql);
            if(rs1.next()) {
                if(rs1.getInt("rID") == rId) {
                    list += rs1.getString("pName") + " ";
                }
            }
        }
        
        return list;
    }
}
