/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import DAO.*;
import java.sql.ResultSet;
import models.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Group 1
 */
@Controller
@RequestMapping("/bill")
public class BillController {

    /**
     * get all infomation and fill into bill form controller of bill form
     *
     * @param tickets
     * @param ticketNames
     * @param rId
     * @param mm
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String beforeBillAction(@RequestParam String tickets, String ticketNames, String rId, ModelMap mm) throws SQLException {
        mm.put("tickets", tickets);
        String[] ticketList = tickets.split(", ");
        TicketDAO td = new TicketDAO(); //recall class ticketDao
        int tId = Integer.parseInt(ticketList[0]);
        long totalPrice = td.getTicketPriceById(tId) * ticketList.length;
        Ticket ticket = td.getTicketById(tId);//recall funtion get ticker id
        ScheduleDAO sd = new ScheduleDAO(); // recall class scheduleDao
        Scheldule schedule = sd.getScheduleById(ticket.getScheId());// recall funtion get schedule by id
        FilmDAO fd = new FilmDAO();//recall class filmDao
        Films films = fd.getFilmsById(schedule.getfId());//recall funtion films by id 
        FormalityDAO fod = new FormalityDAO();//recall class formalityDao
        Formality formality = fod.getFormalityById(schedule.getFmId()); // recall funtion  get formality by id
        SessionDAO sed = new SessionDAO();// recall class SessionDao
        Session session = sed.getSessionById(schedule.getSesId());//recall funtion get sess by id
        //assign properties to jsp callback
        mm.put("session", session);
        mm.put("rId", rId);
        mm.put("tickets", tickets);
        mm.put("ticketNames", ticketNames);
        mm.put("formality", formality);
        mm.put("film", films);
        mm.put("schedule", schedule);
        mm.put("total", totalPrice);
        mm.put("billModel", new Bill());

        return "billForm";
    }

    /**
     * get all infomation and fill into bill controller of bill
     *
     * @param bill
     * @param tickets
     * @param ticketNames
     * @param rId
     * @param mm
     * @param request
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = {"/createBill"}, method = RequestMethod.POST)
    public String billAction(@ModelAttribute(value = "billModel") Bill bill, @RequestParam String tickets, String ticketNames, String rId, ModelMap mm, HttpServletRequest request) throws SQLException {
        mm.put("tickets", tickets);
        String[] ticketList = tickets.split(", ");
        String name = request.getParameter("txtName");//get parameter input of user in bill form page
        String phone = request.getParameter("txtSDT");
        long total = Long.parseLong(request.getParameter("txtTotal"));
        BillDAO bd = new BillDAO();//recall class billDao
        billDetailDAO bdd = new billDetailDAO();//recall class billdetailDao
        TicketDAO td = new TicketDAO();//recall class ticketDao
        Cookie[] cookies = null;
        boolean check;
        // Get an array of Cookies associated with the this domain
        cookies = request.getCookies();
        int bid = 0;
        int ID;
        if (cookies.length > 1) { // get cookie and add into database
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ID")) {
                    ID = Integer.parseInt(cookie.getValue());
                    check = bd.createBill(ID, total, phone, name);
                    bid = bd.maxBill();
                    for (String ticket : ticketList) {
                        bdd.createBillDetail(Integer.parseInt(ticket), bid);
                        td.updateStatus(Integer.parseInt(ticket), 1);
                    }

                    break;
                }
            }
        }

        int tId = Integer.parseInt(ticketList[0]);
        long totalPrice = td.getTicketPriceById(tId) * ticketList.length;
        Ticket ticket = td.getTicketById(tId);//recall funtion gettickketbyid
        ScheduleDAO sd = new ScheduleDAO();// recall class scheduleDao
        Scheldule schedule = sd.getScheduleById(ticket.getScheId());//recall funtion get schedulebyid
        FilmDAO fd = new FilmDAO();//recall class filmDao
        Films films = fd.getFilmsById(schedule.getfId());//recall funtion get filmbyid
        FormalityDAO fod = new FormalityDAO();
        Formality formality = fod.getFormalityById(schedule.getFmId());
        //assign properties to jsp callback
        mm.put("formality", formality);
        mm.put("film", films);
        mm.put("bid", bid);
        mm.put("name", name);
        mm.put("phone", phone);
        mm.put("total", total);

        return "bill";
    }

    /**
     * get all infomation and fill into billlist controller of bill list
     *
     * @param mm
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = {"/billList"}, method = RequestMethod.GET)
    public String billListAction(ModelMap mm) throws SQLException {
        BillDAO bd = new BillDAO();//recall class BillDao
        ArrayList<Bill> bill = new ArrayList<>();//create array list to get all infomation
        ResultSet rs = bd.getAll();//recall funtion getAll of billDao
        while (rs.next()) {
            bill.add(new Bill(rs.getInt("bId"), rs.getInt("cusId"), rs.getInt("sId"), rs.getDate("dateBuy"), rs.getLong("total"), rs.getString("name"), rs.getString("phone"), rs.getInt("status")));
        }
        //assign properties to jsp callback
        mm.put("bill", bill);

        return "billList";
    }

    /**
     * get all infomation and fill into bill(when click view bill click)
     *
     * @param bId
     * @param mm
     * @return
     * @throws SQLException
     */
    @RequestMapping("/billDetail")
    public String BillDetailAction(@RequestParam String bId, ModelMap mm) throws SQLException {
        BillDAO bd = new BillDAO();
        FilmDAO fd = new FilmDAO();
        FormalityDAO fod = new FormalityDAO();
        billDetailDAO bdd = new billDetailDAO();
        TicketDAO td = new TicketDAO();
        System.out.println(bId);

        Bill bill = bd.getBillById(Integer.parseInt(bId));
        //assign properties to jsp callback
        mm.put("formality", fod.getFormalitybyBillId(Integer.parseInt(bId)));
        mm.put("film", fd.getFilmsByBillId(Integer.parseInt(bId)));
        mm.put("bid", bId);
        mm.put("name", bill.getName());
        mm.put("phone", bill.getPhone());
        mm.put("total", bill.getTotal());

        return "bill";
    }
}
