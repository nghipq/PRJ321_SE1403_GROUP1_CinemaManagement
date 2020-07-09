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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author phamq
 */
@Controller
@RequestMapping("/")
public class HomeController {
    
    @RequestMapping(value = {"index.html"}, method = RequestMethod.GET)
    public String homeAction(ModelMap mm) {
        return "index";
    }
}
