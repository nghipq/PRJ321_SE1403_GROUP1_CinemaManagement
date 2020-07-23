/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;
import org.springframework.messaging.tcp.reactor.ReactorNettyTcpClient;

/**
 *
 * @author phamq
 */
public class FilmDAO {

    private Connection conn;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  //format date

    public FilmDAO() {
        conn = new DBConnection().getDBConnection();
    }

    /**
     * Get all films
     *
     * @return
     */
    public ResultSet getAll() {
        String sql = "SELECT * FROM `films`";
        ResultSet rs = null;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }

        return rs;
    }

    /**
     * Get film's poster by film's id
     *
     * @return
     */
    public String getFilmPoster(int id) throws SQLException {
        String sql = "SELECT * FROM `graphic` WHERE `fId` = ? and `type` = 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        String imgPath = "#";

        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                imgPath = rs.getString("path");
            }
        } catch (Exception e) {};
        
        return imgPath;
    }

    /**
     * Get categories of film
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public ArrayList<Categories> getCategoriesInFilm(int id) throws SQLException {
        ArrayList<Categories> categories = new ArrayList<Categories>();

        String sql = "SELECT * FROM `categoryinfilm` WHERE `fId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        ResultSet ans = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                sql = "SELECT * FROM `categories` WHERE `cateId` = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, rs.getInt("cateId"));

                ans = ps.executeQuery();
                if (ans.next()) {
                    categories.add(new Categories(ans.getInt("cateId"), ans.getString("cateName"), ans.getString("description")));
                }
            }
        } catch (Exception e) {
        };

        return categories;
    }
    /*
     * Get categories of film
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public String getCategorieNamesInFilm(int id) throws SQLException {
        String categories = "";

        String sql = "SELECT * FROM `categoryinfilm` WHERE `fId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        ResultSet ans = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                sql = "SELECT * FROM `categories` WHERE `cateId` = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, rs.getInt("cateId"));

                ans = ps.executeQuery();
                if (ans.next()) {
                    categories += ans.getString("cateName");
                }
            }
        } catch (Exception e) {
        };

        return categories;
    }

    /**
     *
     */
    public Films getFilmsById(int id) throws SQLException {
        String sql = "SELECT * FROM `films` WHERE `fId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = null;
        Films films = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                //films = new Films();
                films = new Films(id, rs.getString("fName"), rs.getString("description"),rs.getInt("pId"), rs.getDate("releaseDate"), rs.getDouble("rating"), rs.getInt("limitAge"), rs.getInt("status"), rs.getDate("airDate"), rs.getDate("endDate"));
            }
        } catch (Exception e) {
        }

        return films;
    }
        /**
         * create new film into database
         *
         * @param fId
         * @param fName
         * @param pId
         * @param releaseDate
         * @param rating
         * @param limitAge
         * @param status
         * @param airDate
         * @param endDate
         * @return
         * @throws SQLException
         */
    public boolean createFilm(String fName, int pId, String releaseDate, int limitAge, String airDate, String endDate) throws SQLException {
        String sql = "INSERT INTO `films`(`fname`, `pId`, `releaseDate`, `rating`, `limitAge`, `status`, `airDate`, `endDate`) values (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        //ps.setInt(1, fId);
        ps.setString(1, fName);
        ps.setInt(2, pId);
        ps.setDate(3, Date.valueOf(releaseDate));
        ps.setInt(4, 5);
        ps.setInt(5, limitAge);
        ps.setInt(6, 0);
        ps.setDate(7, Date.valueOf(airDate));
        ps.setDate(8, Date.valueOf(endDate));

        try {
            int insert = ps.executeUpdate();
            if (insert == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        };

        return false;
    }
    
        public int maxFilm() {
        String sql = "Select max(fId) as fId from films";

        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("fId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    /**
     * update film
     *
     * @param fId
     * @param fName
     * @param pId
     * @param releaseDate
     * @param rating
     * @param limitAge
     * @param status
     * @param airDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public boolean updateFilm(int fId, String fName, int pId, String releaseDate, double rating, int limitAge, int status, String airDate, String endDate, String description) throws SQLException {
        String sql = "UPDATE `films` SET `fName` = ?, `pId` = ?, `rating` = ?, `limitAge` = ?, `status` = ?, `releaseDate` = ?, `airDate` = ?, `endDate` = ?, description = ? WHERE `fId` = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        //ps.setInt(1, fId);
        ps.setString(1, fName);
        ps.setInt(2, pId);
        ps.setInt(3, (int) rating);
        ps.setInt(4, limitAge);
        ps.setInt(5, status);
        ps.setDate(6, Date.valueOf(releaseDate));
        ps.setDate(7, Date.valueOf(airDate));
        ps.setDate(8, Date.valueOf(endDate));
        ps.setString(9, description );
        ps.setInt(10, fId);

        int rs = ps.executeUpdate();
        return rs > 0 ? true : false;
    }
    
    public Films getFilmsByBillId(int id) throws SQLException {
        billDetailDAO bdDao = new billDetailDAO();
        TicketDAO tDao = new TicketDAO();
        ScheduleDAO sDao = new ScheduleDAO();
        
        BillDetail billDetail = bdDao.getBillDetailByBillId(id).get(0);
        Ticket ticket = tDao.getTicketById(billDetail.gettId());
        Scheldule scheldule = sDao.getScheduleById(ticket.getScheId());
        return getFilmsById(scheldule.getfId());
    }
    
    public void autoUpdateFilm() throws SQLException {
        String sql = "update films set status = 1 where airDate <= CURRENT_DATE and endDate >= CURRENT_DATE";
        Statement st = conn.createStatement();
        st.execute(sql);
        
        sql = "update films set status = 2 where endDate < CURRENT_DATE";
        st.execute(sql);
    }
}
