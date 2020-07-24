/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.*;
import java.io.*;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import until.CSVUtils;
import until.download;

/**
 *
 * @author Group 1
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

    /*
        FILMS
     */
    /**
     * get data of film send to list
     *
     * @param mm
     * @param request
     * @return redirect to admin.filmList
     * @throws SQLException
     */
    @RequestMapping(value = {"", "/filmList"}, method = RequestMethod.GET)
    public String filmListAction(ModelMap mm, HttpServletRequest request) throws SQLException {
        FilmDAO fd = new FilmDAO();//recall class filmDAO()
        fd.autoUpdateFilm();//recall autoYpdateFilm method in FilmDAO
        ArrayList<Films> films = new ArrayList<>();//create new arrayList of Film
        ResultSet rs = fd.getAll();//recall class ResultSet to get all the element in the database
        int status = -1;//create varible to check status
        if (request.getParameter("status") != null) {//if status is not null
            status = Integer.parseInt(request.getParameter("status"));//change type of status to integer
        }

        while (rs.next()) {//the loop to check element in database exist
            if (status > -1) {//if status check greater than -1
                if (rs.getInt("status") == status) {//if status equal current status
                    films.add(new Films(rs.getInt("fId"), rs.getString("fName"), rs.getString("description"), rs.getInt("pId"),
                            rs.getDate("releaseDate"), rs.getInt("rating"),
                            rs.getInt("limitAge"), rs.getInt("status"), rs.getDate("airDate"), rs.getDate("endDate")));//add new film with element get in jsp page
                }
            } else {
                if (rs.getInt("status") == status) {//
                    continue;//continue process
                }
                films.add(new Films(rs.getInt("fId"), rs.getString("fName"), rs.getString("description"), rs.getInt("pId"),
                        rs.getDate("releaseDate"), rs.getInt("rating"),
                        rs.getInt("limitAge"), rs.getInt("status"), rs.getDate("airDate"), rs.getDate("endDate")));//add new film with element get in jsp page
            }

        }

        mm.put("films", films);//assign properties to jsp callback

        fd.closeConnect();

        return "admin.filmList";
    }

    /**
     * delete film in list
     *
     * @param mm
     * @return redirect to admin.deletedFilms
     * @throws SQLException
     */
    @RequestMapping(value = {"/deletedfilms"}, method = RequestMethod.GET)
    public String deletedFilmListAction(ModelMap mm) throws SQLException {
        FilmDAO fd = new FilmDAO();//recall FilmDAO()
        ArrayList<Films> films = new ArrayList<>();//creat arrayList
        ResultSet rs = fd.getAll();//recall class ResultSet to get all the element in the database

        while (rs.next()) {//the loop to check element in database exist
            if (rs.getInt("status") != 2) {//if status other 2
                continue;
            }
            films.add(new Films(rs.getInt("fId"), rs.getString("fName"), rs.getString("description"), rs.getInt("pId"),
                    rs.getDate("releaseDate"), rs.getInt("rating"),
                    rs.getInt("limitAge"), rs.getInt("status"), rs.getDate("airDate"), rs.getDate("endDate")));//add element get in jsp page
        }

        mm.put("films", films);//assign properties to jsp callback

        fd.closeConnect();

        return "admin.deletedFilms";
    }

    /**
     * Get insert Film
     *
     * @param mm
     * @return redirect to "addFilm"
     * @throws SQLException
     */
    @RequestMapping(value = {"/insertFilm"}, method = RequestMethod.GET)
    public String insertFilmAction(ModelMap mm) throws SQLException {
        ProducerDAO prd = new ProducerDAO();//recall ProduceDAO()
        mm.put("producers", prd.getAll());//assign properties to jsp callback

        prd.closeConnect();

        return "addFilm";
    }

    /**
     * Post insert film
     *
     * @param mm
     * @param file
     * @param fName
     * @param fProducer
     * @param fAge
     * @param fStatus
     * @param fInfo
     * @param fRelease
     * @param fStartTime
     * @param fEndTime
     * @param request
     * @return "redirect:/admins/filmList.html" or
     * "redirect:/admins/insertFilm.html"
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = {"/insertFilm"}, method = RequestMethod.POST)
    public String insertFilmSuccess(ModelMap mm, @RequestParam("file") MultipartFile file, String fName, String fProducer, String fAge, String fStatus,
            String fInfo, String fRelease, String fStartTime, String fEndTime, HttpServletRequest request) throws IOException, ServletException {
        try {
            FilmDAO fdao = new FilmDAO();//recall FilmDAO()
            fdao.createFilm(fName, Integer.parseInt(fProducer), fRelease, Integer.parseInt(fAge), fStartTime, fEndTime);//call creatFilm in FilmDAO
            int fId = fdao.maxFilm();//declare fId is max film

            GraphicsDAO gd = new GraphicsDAO();//recall GraphicsDAO()
            String path = request.getSession().getServletContext().getRealPath("/") + "resources/image/";//declare path
            String filePath = path + file.getOriginalFilename();//declare filePath
            File upload = new File(filePath);//recall File()
            file.transferTo(upload);//transfer

            gd.insertFilmGraphics(fId, file.getOriginalFilename(), 1);//insert image film

            fdao.closeConnect();
            gd.closeConnect();

            return "redirect:/admins/filmList.html";
        } catch (SQLException ex) {
            return "redirect:/admins/insertFilm.html";
        }
    }

    /**
     * get update film
     *
     * @param mm
     * @param fId
     * @return redirect to "updateFilm"
     * @throws SQLException
     */
    @RequestMapping(value = {"/updateFilm"}, method = RequestMethod.GET)
    public String updateFilmAction(ModelMap mm, @RequestParam String fId) throws SQLException {
        FilmDAO fd = new FilmDAO();//recall FilmDAO()
        Films film = fd.getFilmsById(Integer.parseInt(fId));//get film by id
        ProducerDAO prd = new ProducerDAO();//recall ProduceDAO()
        mm.put("producers", prd.getAll());//assign properties to jsp callback
        mm.put("film", film);//assign properties to jsp callback

        fd.closeConnect();
        prd.closeConnect();

        return "updateFilm";
    }

    /**
     * post update film
     *
     * @param mm
     * @param response
     * @param request
     * @return "redirect:/admins/filmList.html"
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = {"/updateFilm"}, method = RequestMethod.POST)
    public String updateFilmSuccess(ModelMap mm, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");

            //get all data of a film
            String fId = request.getParameter("fId");
            String fName = request.getParameter("fName");
            String fpro = request.getParameter("fProducer");
            String fage = request.getParameter("fAge");
            String fstatus = request.getParameter("fStatus");
            String finfo = request.getParameter("fInfo");
            String frelease = request.getParameter("fRelease");
            String fstarttime = request.getParameter("fStartTime");
            String fendtime = request.getParameter("fEndTime");

            FilmDAO fdao = new FilmDAO();//recall FilmDAO()
            fdao.updateFilm(Integer.parseInt(fId), fName, Integer.parseInt(fpro), frelease, 5, Integer.parseInt(fage), 0, fstarttime, fendtime, finfo);//update film

            fdao.closeConnect();

        } catch (SQLException ex) {
        }

        return "redirect:/admins/filmList.html";
    }

    /**
     * delete film
     *
     * @param mm
     * @param fId
     * @return "redirect:/admins/filmList.html"
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = {"/deleteFilm"}, method = RequestMethod.GET)
    public String deleteFilmSuccess(ModelMap mm, @RequestParam String fId) throws UnsupportedEncodingException {
        try {
            FilmDAO fdao = new FilmDAO();//recall FilmDAO()
            Films film = fdao.getFilmsById(Integer.parseInt(fId));//declare film to get film by id

            String fName = film.getfName();
            int fpro = film.getpId();
            int fage = film.getLimitAge();
            String finfo = film.getDescription();
            String frelease = film.getReleaseDate().toString();
            String fstarttime = film.getAirDate().toString();
            String fendtime = film.getEndDate().toString();

            fdao.updateFilm(Integer.parseInt(fId), fName, fpro, frelease, 5, fage, 2, fstarttime, fendtime, finfo);//update Film
            fdao.closeConnect();

        } catch (SQLException ex) {
        }

        return "redirect:/admins/filmList.html";
    }

    /**
     * top 10 film
     *
     * @param mm
     * @return "admin.management"
     * @throws SQLException
     */
    @RequestMapping(value = {"/filmsManagement"}, method = RequestMethod.GET)
    public String top10FilmsAction(ModelMap mm) throws SQLException {
        FilmDAO fd = new FilmDAO(); //recall FilmDAO()

        HashMap<Integer, Long> topFilms = fd.findTop10InWeek();

        ArrayList<Films> films = new ArrayList<>();//creat arrayList for film
        ArrayList<Long> prices = new ArrayList<>();//creat arrayList for prices
        ArrayList<String> categories = new ArrayList<>();//creat arrayList for categories

        for (int key : topFilms.keySet()) {//the loop to get all element of hashmap
            films.add(fd.getFilmsById(key));//add film by method get film by id of class FilmDAO
            prices.add(topFilms.get(key));//add price by method get of hashmap
            categories.add(fd.getCategorieNamesInFilm(key));//add categories by method getCategorieNameInFilm
        }

        int len = films.size() - 1;//get size of arraylist

        if (len > 10) {//if length of array greater than 10
            len = 10;//set length equal 10
        };

        mm.put("films", films);//assign properties to jsp callback
        mm.put("prices", prices);//assign properties to jsp callback
        mm.put("categories", categories);//assign properties to jsp callback
        mm.put("len", len);//assign properties to jsp callback

        fd.closeConnect();

        return "admin.management";
    }

    /**
     * Method to export excel file
     *
     * @param mm
     * @param request
     * @return an excel file and redirect to admin page
     * @throws SQLException
     * @throws IOException
     */
    @RequestMapping(value = {"/ExportTop10Films"}, method = RequestMethod.GET)
    public String ExportTop10FilmsAction(ModelMap mm, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        FilmDAO fd = new FilmDAO();//recall class FilmDAO
        SimpleDateFormat format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        HashMap<Integer, Long> topFilms = fd.findTop10InWeek();//create hashmap to save top film

        ArrayList<Films> films = new ArrayList<>();//create arrayList of film
        ArrayList<Long> prices = new ArrayList<>();//create arrayList of prices
        ArrayList<String> categories = new ArrayList<>();//create arrayList of categories

        String path = request.getSession().getServletContext().getRealPath("/") + "resources\\image\\";//create varible to get path of source
        String filePath = path + "Top10Films.csv";//create file path to save file path
        File upload = new File(filePath);//create new File with varible filePath
        upload.createNewFile();//recall method of class file to create new file

        FileWriter writer = new FileWriter(upload);//recall class FileWrite with varible upload

        for (int key : topFilms.keySet()) {//the loop to get varible of topFilm
            films.add(fd.getFilmsById(key));//add film by method getfilmById
            prices.add(topFilms.get(key));//add price by hashmap with key
            categories.add(fd.getCategorieNamesInFilm(key));//add categorieNamesInFilm with key
        }

        int len = films.size();//get film size

        if (len > 11) {//if length greater 11
            len = 11;//set length is 11
        };
        CSVUtils.writeLine(writer, Arrays.asList("RANK", "CODE", "NAME",
                "CATECOGIES", "TOTALPRICE"));//use method writeLine of class CSVUtils
        for (int i = 0; i < len; i++) {//the loop to get the length
            CSVUtils.writeLine(writer, Arrays.asList("" + (i + 1), "" + films.get(i).getfId(), films.get(i).getfName(),
                    categories.get(i), "" + prices.get(i)));//use method writeLine of class CSVUtils
        }

        writer.flush();//Delete backpace
        writer.close();//close the writer

        fd.closeConnect();

        FileInputStream inputStream = new FileInputStream(filePath);
        String disposition = "attachment; fileName=Top10Films.csv";
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", disposition);
        response.setHeader("content-Length", String.valueOf(download.stream(inputStream, response.getOutputStream())));

        return "redirect:/admins/filmsManagement.html";//send redirect to admin page
    }

    /*
        USERS
     */
    /**
     * get data of user and send to list
     *
     * @param mm
     * @return redirect to admin.userList
     * @throws SQLException
     */
    @RequestMapping(value = {"/userList"}, method = RequestMethod.GET)
    public String userListAction(ModelMap mm) throws SQLException {
        UserDAO ud = new UserDAO();//recall userDAO()
        ArrayList<User> users = new ArrayList<>();//create arrayList
        ResultSet rs = ud.getAll();//recall class ResultSet to get all the element in the database

        while (rs.next()) {//the loop to check element in database exist
            if (rs.getInt("permission") == 2) {//if permission = 2
                continue;
            }

            if (rs.getInt("status") == 0) {//if permission = 0
                continue;
            }

            users.add(new User(rs.getInt("uId"), rs.getString("username"), rs.getString("password"), rs.getInt("nId"), rs.getInt("gender"), rs.getDate("birthday"), rs.getString("email"), rs.getString("address"),
                    rs.getString("phone"), rs.getDate("regisDate"), rs.getInt("permission")));//add element get in jsp page
        }

        mm.put("user", users);//assign properties to jsp callback

        ud.closeConnect();

        return "admin.userList";//redirect to admin userList page
    }

    /**
     * Get update user
     *
     * @param mm
     * @param id
     * @param session
     * @param response
     * @param request
     * @return redirect to "updateUser"
     */
    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.GET)
    public String userUpdateAction(ModelMap mm, @RequestParam String id, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        try {
            UserDAO ud = new UserDAO();//recall UserDAO();
            User user = ud.getUserById(Integer.parseInt(id));//declare user is get user by Id
            mm.put("user", user);//assign properties to jsp callback

            ud.closeConnect();

            return "updateUser";

        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "updateUser";
    }

    /**
     * Post user update
     *
     * @param mm
     * @param session
     * @param response
     * @param request
     * @return "redirect:/admins/userList.html"
     */
    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
    public String userUpdateActionAction(ModelMap mm, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws SQLException {
        UserDAO udao = new UserDAO();//recall UserDAO()
        //get data
        String uId = request.getParameter("uId");
        String Uname = request.getParameter("UName");
        String Uemail = request.getParameter("UEmail");
        String Ubirthday = request.getParameter("UBirthday");
        String Ugender = request.getParameter("Ugender");
        String Uaddress = request.getParameter("UAddress");
        String Uphone = request.getParameter("UPhone");
        String Uregis = request.getParameter("URegis");
        String Upermission = request.getParameter("UPermission");
        udao.UpdateUser(uId, Uname, Uemail, Ubirthday, Ugender, Uaddress, Uphone, Uregis, Upermission);//call updateUser method

        udao.closeConnect();

        return "redirect:/admins/userList.html";
    }

    /**
     * delete user
     *
     * @param mm
     * @param uId
     * @return "redirect:/admins/filmList.html"
     * @throws SQLException
     */
    @RequestMapping(value = {"/deleteUser"}, method = RequestMethod.GET)
    public String deleteUserSuccess(ModelMap mm, @RequestParam String uId) throws SQLException {
        UserDAO ud = new UserDAO();//recall userDAO()
        ud.updateStatusUser(uId, 0);//update status user

        ud.closeConnect();

        return "redirect:/admins/filmList.html";
    }

    /*
        BILLS
     */
    /**
     * get data of bill send to list bill
     *
     * @param mm
     * @return redirect to billList in admin page
     * @throws SQLException
     */
    @RequestMapping(value = {"/billList"}, method = RequestMethod.GET)
    public String billListAction(ModelMap mm) throws SQLException {
        BillDAO bd = new BillDAO();//recall BillDatail()
        ArrayList<Bill> bills = new ArrayList<>();//create arrayList

        ResultSet rs = bd.getAll();//recall class ResultSet to get all element in database
        while (rs.next()) {//the loop to check element in database exist
            if (rs.getInt("status") == 2) {//if status is 2
                continue;//continue process
            }
            bills.add(new Bill(rs.getInt("bId"), rs.getInt("cusId"), rs.getInt("sId"),
                    rs.getDate("dateBuy"), rs.getLong("total"), rs.getString("name"), rs.getString("phone"), rs.getInt("status")));//add new Bill 
        }

        mm.put("bills", bills);//assign properties to jsp callback

        bd.closeConnect();

        return "admin.billList";
    }

    /**
     * Get Update bill
     *
     * @param mm
     * @param bId
     * @return "updateBill"
     * @throws SQLException
     */
    @RequestMapping(value = {"updateBill"}, method = RequestMethod.GET)
    public String updateBillAction(ModelMap mm, @RequestParam String bId) throws SQLException {
        BillDAO bd = new BillDAO();//recall BillDAO()
        Bill bill = bd.getBillById(Integer.parseInt(bId));//declare bill by id

        mm.put("bill", bill);//assign properties to jsp callback

        bd.closeConnect();
        return "updateBill";
    }

    /**
     * post update bill
     *
     * @param mm
     * @param bId
     * @param bName
     * @param bPhone
     * @param bTotal
     * @param bStatus
     * @return "redirect:/admins/billList.html"
     * @throws SQLException
     */
    @RequestMapping(value = {"updateBill"}, method = RequestMethod.POST)
    public String updateBillSuccess(ModelMap mm, @RequestParam String bId, String bName, String bPhone, String bTotal, String bStatus) throws SQLException {
        BillDAO bd = new BillDAO();//racall BillDAO()

        bd.updateBill(Integer.parseInt(bId), 1, Long.parseLong(bTotal), Integer.parseInt(bStatus), bPhone, bName);//update bill

        bd.closeConnect();
        return "redirect:/admins/billList.html";
    }

    /**
     * Delete bill
     *
     * @param mm
     * @param bId
     * @return "redirect:/admins/billList.html"
     * @throws SQLException
     */
    @RequestMapping(value = {"/deleteBill"}, method = RequestMethod.GET)
    public String deleteBillSuccess(ModelMap mm, @RequestParam String bId) throws SQLException {
        BillDAO bd = new BillDAO();//recall BillDAO()
        bd.updateBillStatus(Integer.parseInt(bId), 2);//update status of bill

        bd.closeConnect();

        return "redirect:/admins/billList.html";
    }


    /*
        SCHEDULES
     */
    /**
     * get data of schedule send to list schedule
     *
     * @param mm
     * @return redirect to admin.schedule
     * @throws SQLException
     */
    @RequestMapping(value = {"/scheduleList"}, method = RequestMethod.GET)
    public String scheduleListAction(ModelMap mm) throws SQLException {
        ScheduleDAO sched = new ScheduleDAO();//recall ScheduleDAO()
        sched.autoUpdateSchedule();//call autoUpdateSchedule method in scheduleDAO()
        ArrayList<Scheldule> schedules = new ArrayList<>();//create arraylist for schedule

        ResultSet rs = sched.getAll();//recall class ResultSet to get all the element in the database
        while (rs.next()) {//the loop to check element in database exist
            if (rs.getInt("status") == 0) {//if status = 0
                continue;
            }
            schedules.add(new Scheldule(rs.getInt("scheId"), rs.getInt("fId"), rs.getInt("sesId"), rs.getInt("fmId"), rs.getInt("status"), rs.getInt("rId"), rs.getDate("sDate")));//add element get in jsp page
        }

        mm.put("schedules", schedules);//assign properties to jsp callback

        sched.closeConnect();

        return "admin.schedule";
    }

    /**
     * update showtimes in list
     *
     * @param mm
     * @param id
     * @return redirect to updateShowtimes
     * @throws SQLException
     */
    @RequestMapping(value = {"/updateShowtimes"}, method = RequestMethod.GET)
    public String scheduleAction(ModelMap mm, @RequestParam String id) throws SQLException {
        RoomDAO rd = new RoomDAO();//recall RoomDAO()

        mm.put("rooms", rd.getAll());//assign properties to jsp callback
        mm.put("fId", id);//assign properties to jsp callback

        rd.closeConnect();

        return "updateShowtimes";
    }

    /**
     * update schedule Success
     *
     * @param mm
     * @param response
     * @param request
     * @return redirect to admin.filmList or updateShowtimes
     * @throws SQLException
     */
    @RequestMapping(value = {"/updateSuccess"}, method = RequestMethod.POST)
    public String scheduleSuccess(ModelMap mm, HttpServletResponse response, HttpServletRequest request) throws SQLException {
        //declare variable;
        String dateRealease = request.getParameter("sDate");
        String startTime = request.getParameter("sStart") + ":00";
        String endTime = request.getParameter("sEnd") + ":00";
        String sId = request.getParameter("sId");
        String fmId = request.getParameter("fmName");
        String rId = request.getParameter("sRoom");
        SessionDAO sed = new SessionDAO();//recall SessionDAO()
        ScheduleDAO sched = new ScheduleDAO();//recall ScheduleDAO()

        Session session = sed.getSessionByTime(startTime, endTime);
        if (session == null) {//if session is null
            session = sed.createSession(startTime, endTime);//create session
        }

        if (sched.createSchedule(session.getSesId(), Integer.parseInt(fmId), 1, Integer.parseInt(rId), Integer.parseInt(sId), dateRealease)) {
            int scheId = sched.getMaxScheId();//declare scheId is get max scheId
            RoomSeatDAO rsd = new RoomSeatDAO();//recall RoomSeatDAO()
            TicketDAO td = new TicketDAO();//recall TicketDAO()

            ResultSet rs = rsd.getSeatByRoomId(Integer.parseInt(rId));//recall class ResultSet to get seat by room id in the database
            while (rs.next()) {//the loop to check element in database exist
                td.createTicket(scheId, rs.getInt("seatId"), 0);//create ticket
            }

            sed.closeConnect();
            sched.closeConnect();
            rsd.closeConnect();
            td.closeConnect();

            return "admin.filmList";
        } else {
            sed.closeConnect();
            sched.closeConnect();

            return "updateShowtimes";
        }

    }

    /**
     * Get Update schedule
     *
     * @param mm
     * @param scheId
     * @return "updateSchedule"
     * @throws SQLException
     */
    @RequestMapping(value = {"updateSchedule"}, method = RequestMethod.GET)
    public String updateScheduleAction(ModelMap mm, @RequestParam String scheId) throws SQLException {
        ScheduleDAO sched = new ScheduleDAO();//recall ScheduleDAO()
        SessionDAO sed = new SessionDAO();//recall SessionDAO()
        RoomDAO rd = new RoomDAO();//recall RoomDAO

        Scheldule scheldule = sched.getScheduleById(Integer.parseInt(scheId));//declare schedule by id
        Session session = sed.getSessionById(scheldule.getSesId());//declare session by session id

        mm.put("rooms", rd.getAll());//assign properties to jsp callback
        mm.put("schedule", scheldule);//assign properties to jsp callback
        mm.put("session", session);//assign properties to jsp callback

        sched.closeConnect();
        sed.closeConnect();
        rd.closeConnect();

        return "updateSchedule";
    }

    /**
     * post update schedule
     *
     * @param mm
     * @param request
     * @return "redirect:/admins/scheduleList.html"
     * @throws SQLException
     */
    @RequestMapping(value = {"updateSchedule"}, method = RequestMethod.POST)
    public String updateScheduleSuccess(ModelMap mm, HttpServletRequest request) throws SQLException {
        ScheduleDAO sched = new ScheduleDAO();//recall ScheduleDAO()
        SessionDAO sed = new SessionDAO();//recall SessionDAO()

        String scheId = request.getParameter("scheId");
        String dateRealease = request.getParameter("sDate");
        String startTime = request.getParameter("sStart") + ":00";
        String endTime = request.getParameter("sEnd") + ":00";
        String sId = request.getParameter("sId");
        String fmId = request.getParameter("fmName");
        String rId = request.getParameter("sRoom");

        Session session = sed.getSessionByTime(startTime, endTime);//declare session to get session by times
        if (session == null) {//if session is null
            session = sed.createSession(startTime, endTime);//create session
        }

        sched.updateSchedule(Integer.parseInt(scheId), session.getSesId(), Integer.parseInt(fmId), 1, Integer.parseInt(rId), dateRealease);//update schedule

        sched.closeConnect();
        sed.closeConnect();

        return "redirect:/admins/scheduleList.html";
    }

    /**
     * Delete schedule
     *
     * @param mm
     * @param scheId
     * @return "redirect:/admins/scheduleList.html"
     * @throws SQLException
     */
    @RequestMapping(value = {"/deleteSchedule"}, method = RequestMethod.GET)
    public String deleteScheduleSuccess(ModelMap mm, @RequestParam String scheId) throws SQLException {
        ScheduleDAO sched = new ScheduleDAO();//recall ScheduleDAO()
        sched.updateStatusSchedule(Integer.parseInt(scheId), 0); //update Status of schedule

        sched.closeConnect();

        return "redirect:/admins/scheduleList.html";
    }
}
