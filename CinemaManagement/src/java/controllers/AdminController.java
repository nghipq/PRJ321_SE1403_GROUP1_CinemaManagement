/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.BillDAO;
import DAO.FilmDAO;
import DAO.GraphicsDAO;
import DAO.ProducerDAO;
import DAO.RoomDAO;
import DAO.RoomSeatDAO;
import DAO.ScheduleDAO;
import DAO.SessionDAO;
import DAO.TicketDAO;
import DAO.UserDAO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import until.CSVUtils;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

    @RequestMapping(value = {"/filmList"}, method = RequestMethod.GET)
    public String filmListAction(ModelMap mm, HttpServletRequest request) throws SQLException {
        FilmDAO fd = new FilmDAO();
        fd.autoUpdateFilm();
        ArrayList<Films> films = new ArrayList<>();
        ResultSet rs = fd.getAll();
        int status = -1;
        if (request.getParameter("status") != null) {
            status = Integer.parseInt(request.getParameter("status"));
        }

        while (rs.next()) {
            if (status > -1) {
                if (rs.getInt("status") == status) {
                    films.add(new Films(rs.getInt("fId"), rs.getString("fName"), rs.getString("description"), rs.getInt("pId"),
                            rs.getDate("releaseDate"), rs.getInt("rating"),
                            rs.getInt("limitAge"), rs.getInt("status"), rs.getDate("airDate"), rs.getDate("endDate")));
                }
            } else {
                if (rs.getInt("status") == status) {
                    continue;
                }
                films.add(new Films(rs.getInt("fId"), rs.getString("fName"), rs.getString("description"), rs.getInt("pId"),
                        rs.getDate("releaseDate"), rs.getInt("rating"),
                        rs.getInt("limitAge"), rs.getInt("status"), rs.getDate("airDate"), rs.getDate("endDate")));
            }

        }

        mm.put("films", films);

        return "admin.filmList";
    }

    @RequestMapping(value = {"/deletedfilms"}, method = RequestMethod.GET)
    public String deletedFilmListAction(ModelMap mm) throws SQLException {
        FilmDAO fd = new FilmDAO();
        ArrayList<Films> films = new ArrayList<>();
        ResultSet rs = fd.getAll();

        while (rs.next()) {
            if (rs.getInt("status") != 2) {
                continue;
            }
            films.add(new Films(rs.getInt("fId"), rs.getString("fName"), rs.getString("description"), rs.getInt("pId"),
                    rs.getDate("releaseDate"), rs.getInt("rating"),
                    rs.getInt("limitAge"), rs.getInt("status"), rs.getDate("airDate"), rs.getDate("endDate")));
        }

        mm.put("films", films);

        return "admin.deletedFilms";
    }

    @RequestMapping(value = {"/userList"}, method = RequestMethod.GET)
    public String userListAction(ModelMap mm) throws SQLException {
        UserDAO ud = new UserDAO();
        ArrayList<User> users = new ArrayList<>();
        ResultSet rs = ud.getAll();

        while (rs.next()) {
            if (rs.getInt("permission") == 2) {
                continue;
            }

            if (rs.getInt("status") == 0) {
                continue;
            }

            users.add(new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"), rs.getInt("nId"), rs.getInt("gender"), rs.getDate("birthday"), rs.getString("email"), rs.getString("address"),
                    rs.getString("phone"), rs.getDate("regisDate"), rs.getInt("permission")));
        }

        mm.put("user", users);

        return "admin.userList";
    }

    @RequestMapping(value = {"/billList"}, method = RequestMethod.GET)
    public String billListAction(ModelMap mm) throws SQLException {
        BillDAO bd = new BillDAO();
        ArrayList<Bill> bills = new ArrayList<>();

        ResultSet rs = bd.getAll();
        while (rs.next()) {
            if (rs.getInt("status") == 2) {
                continue;
            }
            bills.add(new Bill(rs.getInt("bId"), rs.getInt("cusId"), rs.getInt("sId"),
                    rs.getDate("dateBuy"), rs.getLong("total"), rs.getString("name"), rs.getString("phone"), rs.getInt("status")));
        }

        mm.put("bills", bills);

        return "admin.billList";
    }

    @RequestMapping(value = {"/scheduleList"}, method = RequestMethod.GET)
    public String scheduleListAction(ModelMap mm) throws SQLException {
        ScheduleDAO sched = new ScheduleDAO();
        sched.autoUpdateSchedule();
        ArrayList<Scheldule> schedules = new ArrayList<>();

        ResultSet rs = sched.getAll();
        while (rs.next()) {
            if (rs.getInt("status") == 0) {
                continue;
            }
            schedules.add(new Scheldule(rs.getInt("scheId"), rs.getInt("fId"), rs.getInt("sesId"), rs.getInt("fmId"), rs.getInt("status"), rs.getInt("rId"), rs.getDate("sDate")));
        }

        mm.put("schedules", schedules);

        return "admin.schedule";
    }

    @RequestMapping(value = {"/updateShowtimes"}, method = RequestMethod.GET)
    public String scheduleAction(ModelMap mm, @RequestParam String id) throws SQLException {
        RoomDAO rd = new RoomDAO();

        mm.put("rooms", rd.getAll());
        mm.put("fId", id);

        return "updateShowtimes";
    }

    @RequestMapping(value = {"/updateSuccess"}, method = RequestMethod.POST)
    public String scheduleSuccess(ModelMap mm, HttpServletResponse response, HttpServletRequest request) throws SQLException {
        String dateRealease = request.getParameter("sDate");
        String startTime = request.getParameter("sStart") + ":00";
        String endTime = request.getParameter("sEnd") + ":00";
        String sId = request.getParameter("sId");
        String fmId = request.getParameter("fmName");
        String rId = request.getParameter("sRoom");
        SessionDAO sed = new SessionDAO();
        ScheduleDAO sched = new ScheduleDAO();

        Session session = sed.getSessionByTime(startTime, endTime);
        if (session == null) {
            session = sed.createSession(startTime, endTime);
        }

        if (sched.createSchedule(session.getSesId(), Integer.parseInt(fmId), 1, Integer.parseInt(rId), Integer.parseInt(sId), dateRealease)) {
            int scheId = sched.getMaxScheId();
            RoomSeatDAO rsd = new RoomSeatDAO();
            TicketDAO td = new TicketDAO();

            ResultSet rs = rsd.getSeatByRoomId(Integer.parseInt(rId));
            while (rs.next()) {
                td.createTicket(scheId, rs.getInt("seatId"), 0);
            }

            return "admin.filmList";
        } else {
            return "updateShowtimes";
        }

    }

    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.GET)
    public String userUpdateAction(ModelMap mm, @RequestParam String id, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        try {
            UserDAO ud = new UserDAO();
            User user = ud.getUserById(Integer.parseInt(id));
            mm.put("user", user);
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

    @RequestMapping(value = {"/insertFilm"}, method = RequestMethod.GET)
    public String insertFilmAction(ModelMap mm) throws SQLException {
        ProducerDAO prd = new ProducerDAO();
        mm.put("producers", prd.getAll());
        return "addFilm";
    }

    @RequestMapping(value = {"/insertFilm"}, method = RequestMethod.POST)
    public String insertFilmSuccess(ModelMap mm, @RequestParam("file") MultipartFile file, String fName, String fProducer, String fAge, String fStatus,
            String fInfo, String fRelease, String fStartTime, String fEndTime, HttpServletRequest request) throws IOException, ServletException {
        try {
            FilmDAO fdao = new FilmDAO();
            fdao.createFilm(fName, Integer.parseInt(fProducer), fRelease, Integer.parseInt(fAge), fStartTime, fEndTime);
            int fId = fdao.maxFilm();

            GraphicsDAO gd = new GraphicsDAO();
            String path = request.getSession().getServletContext().getRealPath("/") + "resources/image/";
            String filePath = path + file.getOriginalFilename();
            File upload = new File(filePath);
            file.transferTo(upload);

            gd.insertFilmGraphics(fId, file.getOriginalFilename(), 1);

            return "redirect:/admins/filmList.html";
        } catch (SQLException ex) {
            return "redirect:/admins/insertFilm.html";
        }
    }

    @RequestMapping(value = {"/updateFilm"}, method = RequestMethod.GET)
    public String updateFilmAction(ModelMap mm, @RequestParam String fId) throws SQLException {
        FilmDAO fd = new FilmDAO();
        Films film = fd.getFilmsById(Integer.parseInt(fId));
        ProducerDAO prd = new ProducerDAO();
        mm.put("producers", prd.getAll());
        mm.put("film", film);

        return "updateFilm";
    }

    @RequestMapping(value = {"/updateFilm"}, method = RequestMethod.POST)
    public String updateFilmSuccess(ModelMap mm, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");

            String fId = request.getParameter("fId");
            String fName = request.getParameter("fName");
            String fpro = request.getParameter("fProducer");
            String fage = request.getParameter("fAge");
            String fstatus = request.getParameter("fStatus");
            String finfo = request.getParameter("fInfo");
            String frelease = request.getParameter("fRelease");
            String fstarttime = request.getParameter("fStartTime");
            String fendtime = request.getParameter("fEndTime");
            FilmDAO fdao = new FilmDAO();
            fdao.updateFilm(Integer.parseInt(fId), fName, Integer.parseInt(fpro), frelease, 5, Integer.parseInt(fage), 0, fstarttime, fendtime, finfo);

        } catch (SQLException ex) {
        }

        return "redirect:/admins/filmList.html";
    }

    @RequestMapping(value = {"/deleteFilm"}, method = RequestMethod.GET)
    public String deleteFilmSuccess(ModelMap mm, @RequestParam String fId) throws UnsupportedEncodingException {
        try {
            FilmDAO fdao = new FilmDAO();
            Films film = fdao.getFilmsById(Integer.parseInt(fId));

            String fName = film.getfName();
            int fpro = film.getpId();
            int fage = film.getLimitAge();
            String finfo = film.getDescription();
            String frelease = film.getReleaseDate().toString();
            String fstarttime = film.getAirDate().toString();
            String fendtime = film.getEndDate().toString();

            fdao.updateFilm(Integer.parseInt(fId), fName, fpro, frelease, 5, fage, 2, fstarttime, fendtime, finfo);

        } catch (SQLException ex) {
        }

        return "redirect:/admins/filmList.html";
    }

    @RequestMapping(value = {"/deleteUser"}, method = RequestMethod.GET)
    public String deleteUserSuccess(ModelMap mm, @RequestParam String uId) throws SQLException {
        UserDAO ud = new UserDAO();
        ud.updateStatusUser(uId, 0);
        return "redirect:/admins/filmList.html";
    }

    @RequestMapping(value = {"updateBill"}, method = RequestMethod.GET)
    public String updateBillAction(ModelMap mm, @RequestParam String bId) throws SQLException {
        BillDAO bd = new BillDAO();
        Bill bill = bd.getBillById(Integer.parseInt(bId));

        mm.put("bill", bill);
        return "updateBill";
    }

    @RequestMapping(value = {"updateSchedule"}, method = RequestMethod.GET)
    public String updateScheduleAction(ModelMap mm, @RequestParam String scheId) throws SQLException {
        ScheduleDAO sched = new ScheduleDAO();
        SessionDAO sed = new SessionDAO();
        RoomDAO rd = new RoomDAO();

        Scheldule scheldule = sched.getScheduleById(Integer.parseInt(scheId));
        Session session = sed.getSessionById(scheldule.getSesId());

        mm.put("rooms", rd.getAll());
        mm.put("schedule", scheldule);
        mm.put("session", session);

        return "updateSchedule";
    }

    @RequestMapping(value = {"updateSchedule"}, method = RequestMethod.POST)
    public String updateScheduleSuccess(ModelMap mm, HttpServletRequest request) throws SQLException {
        ScheduleDAO sched = new ScheduleDAO();
        SessionDAO sed = new SessionDAO();

        String scheId = request.getParameter("scheId");
        String dateRealease = request.getParameter("sDate");
        String startTime = request.getParameter("sStart") + ":00";
        String endTime = request.getParameter("sEnd") + ":00";
        String sId = request.getParameter("sId");
        String fmId = request.getParameter("fmName");
        String rId = request.getParameter("sRoom");

        Session session = sed.getSessionByTime(startTime, endTime);
        if (session == null) {
            session = sed.createSession(startTime, endTime);
        }

        sched.updateSchedule(Integer.parseInt(scheId), session.getSesId(), Integer.parseInt(fmId), 1, Integer.parseInt(rId), dateRealease);

        return "redirect:/admins/scheduleList.html";
    }

    @RequestMapping(value = {"/deleteSchedule"}, method = RequestMethod.GET)
    public String deleteScheduleSuccess(ModelMap mm, @RequestParam String scheId) throws SQLException {
        ScheduleDAO sched = new ScheduleDAO();
        sched.updateStatusSchedule(Integer.parseInt(scheId), 0);

        return "redirect:/admins/scheduleList.html";
    }

    @RequestMapping(value = {"updateBill"}, method = RequestMethod.POST)
    public String updateBillSuccess(ModelMap mm, @RequestParam String bId, String bName, String bPhone, String bTotal, String bStatus) throws SQLException {
        BillDAO bd = new BillDAO();

        bd.updateBill(Integer.parseInt(bId), 1, Long.parseLong(bTotal), Integer.parseInt(bStatus), bPhone, bName);
        return "redirect:/admins/billList.html";
    }

    @RequestMapping(value = {"/deleteBill"}, method = RequestMethod.GET)
    public String deleteBillSuccess(ModelMap mm, @RequestParam String bId) throws SQLException {
        BillDAO bd = new BillDAO();
        bd.updateBillStatus(Integer.parseInt(bId), 2);

        return "redirect:/admins/billList.html";
    }

    @RequestMapping(value = {"/filmsManagement"}, method = RequestMethod.GET)
    public String top10FilmsAction(ModelMap mm) throws SQLException {
        FilmDAO fd = new FilmDAO();

        HashMap<Integer, Long> topFilms = fd.findTop10InWeek();

        ArrayList<Films> films = new ArrayList<>();
        ArrayList<Long> prices = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();

        for (int key : topFilms.keySet()) {
            films.add(fd.getFilmsById(key));
            prices.add(topFilms.get(key));
            categories.add(fd.getCategorieNamesInFilm(key));
        }

        int len = films.size() - 1;

        if (len > 10) {
            len = 10;
        };

        mm.put("films", films);
        mm.put("prices", prices);
        mm.put("categories", categories);
        mm.put("len", len);

        return "admin.management";
    }

    @RequestMapping(value = {"/ExportTop10Films"}, method = RequestMethod.GET)
    public String ExportTop10FilmsAction(ModelMap mm, HttpServletRequest request) throws SQLException, IOException {
        FilmDAO fd = new FilmDAO();
        SimpleDateFormat format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        HashMap<Integer, Long> topFilms = fd.findTop10InWeek();

        ArrayList<Films> films = new ArrayList<>();
        ArrayList<Long> prices = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();

        String path = request.getSession().getServletContext().getRealPath("/") + "resources\\image\\";
        String filePath = path + "Top10Films.csv";
        File upload = new File(filePath);
        upload.createNewFile();

        FileWriter writer = new FileWriter(upload);

        for (int key : topFilms.keySet()) {
            films.add(fd.getFilmsById(key));
            prices.add(topFilms.get(key));
            categories.add(fd.getCategorieNamesInFilm(key));
        }

        int len = films.size();

        if (len > 11) {
            len = 11;
        };
        CSVUtils.writeLine(writer, Arrays.asList("RANK", "CODE", "NAME",
                "CATECOGIES", "TOTALPRICE"));
        for (int i = 0; i < len; i++) {
            CSVUtils.writeLine(writer, Arrays.asList("" + (i + 1), "" + films.get(i).getfId(), films.get(i).getfName(),
                    categories.get(i), "" + prices.get(i)));
        }

        writer.flush();
        writer.close();

        return "redirect:/admins/filmsManagement.html";
    }
}
