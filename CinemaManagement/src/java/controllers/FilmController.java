/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.FilmDAO;
import java.sql.SQLException;
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
    public String filmListAction() {
        return "filmList";
    }
    
    @RequestMapping(value = {"/film"}, method = RequestMethod.GET)
    public String filmAction(@RequestParam String id, ModelMap mm) {
        int fId = Integer.parseInt(id);
        FilmDAO fd = new FilmDAO();
        
        try {
            Films film = fd.getFilmsById(fId);
            mm.put("film", film);
        } catch (SQLException ex) {
            Logger.getLogger(FilmController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "filmDetail";
    }
}
