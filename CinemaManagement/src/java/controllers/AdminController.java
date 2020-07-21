/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.CustomerDAO;
import DAO.FilmDAO;
import DAO.PersonDAO;
import DAO.ScheduleDAO;
import DAO.TicketDAO;
import DAO.UserDAO;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Customer;
import models.Films;
import models.User;
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

    @RequestMapping(value = {"/userList"}, method = RequestMethod.GET)
    public String userListAction(ModelMap mm) throws SQLException {
        UserDAO ud = new UserDAO();
        ArrayList<User> users = new ArrayList<>();
        ResultSet rs = ud.getAll();

        while (rs.next()) {
            users.add(new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"), rs.getInt("nId"), rs.getInt("gender"), rs.getDate("birthday"), rs.getString("email"), rs.getString("address"),
                    rs.getString("phone"), rs.getDate("regisDate"), rs.getInt("permission")));
        }

        mm.put("user", users);

        return "admin.userList";
    }

    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.GET)
    public String userUpdateAction(ModelMap mm, @RequestParam String id, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        try {
            UserDAO ud = new UserDAO();
            User user = ud.getUserById(Integer.parseInt(id));
            mm.put("user", user);
//            UserDAO udao = new UserDAO();
//            String Uname = request.getParameter("UName");
//            String Uemail = request.getParameter("UEmail");
//            String Ubirthday = request.getParameter("UBirthday");
//            String Ugender = request.getParameter("Ugender");
//            String Uaddress = request.getParameter("UAddress");
//            String Uphone = request.getParameter("UPhone");
//            String Uregis = request.getParameter("URegis");
//            String Upermission = request.getParameter("UPermission");
//        udao.UpdateUser(Uname, Uemail, Ubirthday, Ugender, Uaddress, Uphone, Uregis,Upermission);
            return "updateUser";

        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "updateUser";
    }

    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
    public String userUpdateActionAction(ModelMap mm, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        UserDAO udao = new UserDAO();
        String uId = request.getParameter("uId");
        String Uname = request.getParameter("UName");
        String Uemail = request.getParameter("UEmail");
        String Ubirthday = request.getParameter("UBirthday");
        String Ugender = request.getParameter("Ugender");
        String Uaddress = request.getParameter("UAddress");
        String Uphone = request.getParameter("UPhone");
        String Uregis = request.getParameter("URegis");
        String Upermission = request.getParameter("UPermission");
        udao.UpdateUser(uId, Uname, Uemail, Ubirthday, Ugender, Uaddress, Uphone, Uregis, Upermission);
        return "redirect:/admins/userList.html";
    }

}
