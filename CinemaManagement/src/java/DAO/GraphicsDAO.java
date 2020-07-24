/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import models.*;
import DAO.*;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Group 1
 */
public class GraphicsDAO {

    private Connection conn;

    public GraphicsDAO() {
        this.conn = new DBConnection().getDBConnection();
    }

    /**
     * insert film graphics
     *
     * @param fId
     * @param path
     * @param type
     * @return
     * @throws SQLException
     */
    public boolean insertFilmGraphics(int fId, String path, int type) throws SQLException {
        String sql = "insert into graphic(fId, path, type) values(?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, fId);
        pst.setString(2, path);
        pst.setInt(3, type);

        int rs = pst.executeUpdate();
        return rs > 0 ? true : false;
    }
}
