/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.FilmDAO;
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
    @ResponseBody
    public String filmAction(@RequestParam String id) {
        int fId = Integer.parseInt(id);
        FilmDAO fd = new FilmDAO();
        
        return "film";
    }
}
