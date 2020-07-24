/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.web.bind.annotation.RestController;
import models.*;
import DAO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Group 1
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = {"index.html"}, method = RequestMethod.GET)
    public String homeAction(ModelMap mm) throws SQLException {
        FilmDAO fd = new FilmDAO();//recall class filmDao
        fd.autoUpdateFilm();// recall funtion autoUpdateFilm in FilmDao
        ArrayList<Films> films = new ArrayList<>();//create arraylist and set name is films
        ResultSet rs = fd.getAll();//recall funtion getAll in FilmDao

        while (rs.next()) {//insert into arraylist
            films.add(new Films(rs.getInt("fId"), rs.getString("fName"), rs.getString("description"), rs.getInt("pId"),
                    rs.getDate("releaseDate"), rs.getInt("rating"),
                    rs.getInt("limitAge"), rs.getInt("status"), rs.getDate("airDate"), rs.getDate("endDate")));
        }
        //assign properties to jsp callback
        mm.put("films", films);
        fd.closeConnect();
        
        return "index";
    }
}
