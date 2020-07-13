/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpSession;
import models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author phamq
 */
@Controller
@RequestMapping("/auth")
public class UserController {    
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String LoginAction(ModelMap mm){//
        mm.put("tk", new User());
        return "auth";
    }
//    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
//    public String LoginAction(@ModelAttribute(value = "tk") User user, ModelMap mm, HttpSession session) {
//        if (user.getUsername().equals("nhan") && user.getPassword().equals("123")) {
//            session.setAttribute("username", user.getUsername());
//            return "index";
//        } else {
//            mm.put("message", "Khong hop le");
//            return "login";
//        }
//    }
}
