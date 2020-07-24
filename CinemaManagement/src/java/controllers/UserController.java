/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.CustomerDAO;
import javax.servlet.http.HttpSession;
import models.*;
import DAO.*;
import java.sql.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Group 1
 */
@Controller
@RequestMapping("/auth")
public class UserController {

    /**
     * controller of page login
     *
     * @param id
     * @param mm
     * @return
     */
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String LoginAction(String id, ModelMap mm) {//
        //assign properties to jsp callback
        mm.put("tk", new User());
        return "auth";
    }

    /**
     *
     * @param user
     * @param mm
     * @param session
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String LoginAction(@ModelAttribute(value = "tk") User user, ModelMap mm, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        String emails = user.getEmail();    // get user Emaill
        String pass = user.getPassword();   // get user password
        UserDAO udao = new UserDAO();       // recall UserDao
        User check = udao.Login(emails, pass);
//        int id = user.getuId();
//        String name = user.getUsername();
        if (check != null) {    // if != null save cookie
            Cookie emailCookie = new Cookie("ID", String.valueOf(check.getuId()));
            emailCookie.setMaxAge(60 * 60 * 24 * 365);  // set time of cookie
            Cookie nameCookie = new Cookie("Name", check.getUsername());
            nameCookie.setMaxAge(60 * 60 * 24 * 365);
            emailCookie.setPath("/");
            nameCookie.setPath("/");
            response.addCookie(emailCookie);    // add cookie
            response.addCookie(nameCookie);
//            request.getSession().setAttribute("ID", id);
//            request.getSession().setAttribute("Name", name);
            //          return "redirect:/";
            switch (check.getPremission()) {    // check premission of accout
                case 0: {//if is user
                    try {
                        String url = request.getParameter("returnURL");
                        if (url != null) {
                            return ("redirect:/" + url);
                        } else {
                            return "redirect:/";
                        }
                    } catch (Exception e) {
                        return "redirect:/";
                    }
                }
                case 2://if is admin
                    return "redirect:/admins/filmList.html";
                default:
                    return "redirect:/";
            }
        } else {
            //assign properties to jsp callback
            mm.put("message", "Không hợp lệ");
            return "redirect:/auth.html";
        }
    }

//    @RequestMapping(value = {""}, method = RequestMethod.GET)
//    public String RegisAction(ModelMap mm) {//
//        mm.put("dktk", new User());
//        return "auth";
//    }
    /**
     * Controller of Regis
     *
     * @param user
     * @param mm
     * @param session
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String RegisAction(@ModelAttribute(value = "tk") User user, ModelMap mm, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        UserDAO udao = new UserDAO();   // recall class UserDao
        CustomerDAO cdao = new CustomerDAO();   // recall class CustomerDao
        if (request.getParameter("txtconfirmpass").equals(request.getParameter("txtPass"))) {   //check confirpass and pass 
            // recall insertUser and insertCustomers to add into database
            udao.InsertUser(request.getParameter("txtName"), request.getParameter("txtEmail"), request.getParameter("txtPass"), Date.valueOf(request.getParameter("txtDate")), request.getParameter("txtAddress"), request.getParameter("txtPhone"));
            cdao.InsertCustomers();
            return "redirect:/";
        } else {
//        {mm.put("message", "Mật khẩu không hợp lệ");
            return "auth";
        }

    }

    /**
     * Controller for logout
     *
     * @param user
     * @param mm
     * @param session
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String LogoutAction(@ModelAttribute(value = "tk") User user, ModelMap mm, HttpSession session, HttpServletResponse response, HttpServletRequest request) {

        Cookie[] list = request.getCookies(); // get cookies

        for (Cookie items : list) { // set cookie age = 0 to delete cookie
            if (items.getName().equals("Name")) {
                items.setMaxAge(0);
                items.setPath("/");
                response.addCookie(items);
            }
            if (items.getName().equals("ID")) {
                items.setMaxAge(0);
                items.setPath("/");
                response.addCookie(items);
            }
        }

        return "redirect:/";
    }
}
