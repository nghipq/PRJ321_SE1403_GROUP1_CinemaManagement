/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Statement;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.*;

/**
 *
 * @author phamq
 */
public class RoomDAO {

    private Connection conn;

    public RoomDAO() {
        this.conn = new DBConnection().getDBConnection();
    }

    public ArrayList<Room> getAll() throws SQLException {
        String sql = "select * from room";
        Statement st = (Statement) conn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        ArrayList<Room> rooms = new ArrayList<>();

        while (rs.next()) {
            rooms.add(new Room(rs.getInt("rId"), rs.getInt("seatNumber"), rs.getInt("size"), rs.getInt("rStatus")));
        }

        return rooms;
    }

    /**
     * Update room status
     *
     * @param status
     * @return
     * @throws SQLException
     */
    public boolean updateRoom(int status) throws SQLException {
        String sql = "UPDATE `room` SET `status` = ?";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setInt(1, status);

        int rs = ps.executeUpdate();

        return rs > 0 ? true : false;
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
