/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.*;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import models.*;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.http.HttpServletRequest;

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
        Gson gson = new Gson();
        ArrayList<Films> films = new ArrayList<>();
        ArrayList<Films> filmsNow = new ArrayList<>();
        ArrayList<Films> filmsNew = new ArrayList<>();
        HashMap<Integer, Films> filmsJSON = new HashMap<>();
        ResultSet rs = fd.getAll();
        
        while (rs.next()) {
            Films film = new Films(rs.getInt("fId"), rs.getString("fName"), rs.getString("description"), rs.getInt("pId"),
                    rs.getDate("releaseDate"), rs.getInt("rating"),
                    rs.getInt("limitAge"), rs.getInt("status"), rs.getDate("airDate"), rs.getDate("endDate"));
            films.add(film);
            if (film.getStatus() == 1) {
                filmsNow.add(film);
            } else if (film.getStatus() == 0) {
                filmsNew.add(film);
                filmsJSON.put(film.getfId(), film);
            }
        }
        
        mm.put("films", films);
        mm.put("filmsNow", filmsNow);
        mm.put("filmsNew", filmsNew);
        mm.put("filmsJSON", gson.toJson((Map) filmsJSON));
        
        return "filmList";
    }
    
    @RequestMapping(value = {"/film"}, method = RequestMethod.GET)
    public String filmAction(@RequestParam String id, ModelMap mm, HttpServletRequest request) throws SQLException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int fId = Integer.parseInt(id);
        FilmDAO fd = new FilmDAO();
        PersonDAO pd = new PersonDAO();
        ScheduleDAO sd = new ScheduleDAO();
        TicketDAO td = new TicketDAO();
        
        try {
            Films film = fd.getFilmsById(fId);
            String date = java.sql.Date.valueOf(format.format(new Date())).toString();
            if (request.getParameter("date") != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(GregorianCalendar.DAY_OF_MONTH, Integer.parseInt(request.getParameter("date")));
                date = format.format(cal.getTime());
            }
            
            mm.put("film", film);
            mm.put("directors", pd.getPersonNameFilmId(fId, 1));
            mm.put("actors", pd.getPersonNameFilmId(fId, 2));
            mm.put("categories", fd.getCategorieNamesInFilm(fId));
            mm.put("schedules", sd.getSchedulesDetail(fId, date));
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "filmDetail";
    }
}
