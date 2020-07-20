/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.FilmDAO;
import DAO.PersonDAO;
import DAO.ScheduleDAO;
import DAO.TicketDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Films;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/admins")
public class AdminController {
    @RequestMapping(value = {"/filmList"}, method = RequestMethod.GET)
    public String filmListAction(ModelMap mm) throws SQLException {
        FilmDAO fd = new FilmDAO();
        ArrayList<Films> films = new ArrayList<>();
        ResultSet rs = fd.getAll();

        while (rs.next()) {
            films.add(new Films(rs.getInt("fId"), rs.getString("fName"), rs.getString("description"), rs.getInt("pId"),
                    rs.getDate("releaseDate"), rs.getInt("rating"),
                    rs.getInt("limitAge"), rs.getInt("status"), rs.getDate("airDate"), rs.getDate("endDate")));
        }

        mm.put("films", films);

        return "admin.filmList";
    }
    @RequestMapping(value = {"/admins"}, method = RequestMethod.GET)
    public String filmAction(@RequestParam String id, ModelMap mm) throws SQLException {
        int fId = Integer.parseInt(id);
        FilmDAO fd = new FilmDAO();
        PersonDAO pd = new PersonDAO();

        try {
            Films film = fd.getFilmsById(fId);

            mm.put("film", film);
            mm.put("directors", pd.getPersonNameFilmId(fId, 1));
            mm.put("actors", pd.getPersonNameFilmId(fId, 2));
            mm.put("categories", fd.getCategorieNamesInFilm(fId));
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "admin.filmList";
    }
    
}
