/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import models.*;

/**
 *
 * @author phamq
 */
@Controller
@RequestMapping("/films")
public class FilmController {

    @RequestMapping(value = {""}, method = RequestMethod.GET)
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

        return "filmList";
    }

    @RequestMapping(value = {"/film"}, method = RequestMethod.GET)
    public String filmAction(@RequestParam String id, ModelMap mm) throws SQLException {
        int fId = Integer.parseInt(id);
        FilmDAO fd = new FilmDAO();
        PersonDAO pd = new PersonDAO();
        ScheduleDAO sd = new ScheduleDAO();
        TicketDAO td = new TicketDAO();

        try {
            Films film = fd.getFilmsById(fId);

            mm.put("film", film);
            mm.put("directors", pd.getPersonNameFilmId(fId, 1));
            mm.put("actors", pd.getPersonNameFilmId(fId, 2));
            mm.put("categories", fd.getCategorieNamesInFilm(fId));
            mm.put("schedules", sd.getSchedulesDetail(fId));
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "filmDetail";
    }
}
