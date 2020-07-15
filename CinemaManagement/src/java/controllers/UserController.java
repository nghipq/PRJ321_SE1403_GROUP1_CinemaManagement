/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.CustomerDAO;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;
import models.User;
import DAO.UserDAO;
import java.sql.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
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
    public String LoginAction(ModelMap mm) {//
        mm.put("tk", new User());
        return "auth";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String LoginAction(@ModelAttribute(value = "tk") User user, ModelMap mm, HttpSession session, HttpServletResponse response) {
        String emails = user.getEmail();
        String pass = user.getPassword();
        UserDAO udao = new UserDAO();
        User check = udao.Login(emails, pass);
        if (check != null) {
            Cookie emailCookie = new Cookie("ID", String.valueOf(check.getuId()));
            emailCookie.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(emailCookie);
            return "index";
        } else {
            mm.put("message", "Không hợp lệ!");
            return "auth";
        }
    }

//    @RequestMapping(value = {""}, method = RequestMethod.GET)
//    public String RegisAction(ModelMap mm) {//
//        mm.put("dktk", new User());
//        return "auth";
//    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String RegisAction(@ModelAttribute(value = "tk") User user, ModelMap mm, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        UserDAO udao = new UserDAO();
        CustomerDAO cdao = new CustomerDAO();
        if(request.getParameter("txtconfirmpass").equals(request.getParameter("txtPass"))){
            udao.InsertUser(request.getParameter("txtName"),request.getParameter("txtEmail"), request.getParameter("txtPass"),Date.valueOf(request.getParameter("txtDate")), request.getParameter("txtAddress"),request.getParameter("txtPhone"));
            cdao.InsertCustomers();
            return "index";
        }
        else
            return "auth";
        
        
    }
}
