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
import java.util.ArrayList;
import models.*;

/**
 *
 * @author phamq
 */
public class ScheduleDAO {

    private Connection conn;

    public ScheduleDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Get schedule in film
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public ResultSet getScheduleByFilmId(int id) throws SQLException {
        String sql = "SELECT * FROM `schedule` WHERE `fId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    /**
     * get session
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Session getSessionByScheduleId(int id) throws SQLException {
        Session ses = new Session();
        String sql = "SELECT * FROM `session` WHERE `sesId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (Exception e) {
        };

        return ses;
    }
}
