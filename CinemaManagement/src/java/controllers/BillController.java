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
import models.*;
import java.sql.SQLException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author phamq
 */
@Controller
@RequestMapping("/bill")
public class BillController {
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String beforeBillAction(@RequestParam String tickets, String ticketNames, String rId, ModelMap mm) throws SQLException {
        mm.put("tickets", tickets);
        String[] ticketList = tickets.split(", ");
        TicketDAO td = new TicketDAO();
        int tId=Integer.parseInt(ticketList[0]);
        long totalPrice = td.getTicketPriceById(tId)*ticketList.length;
        Ticket ticket = td.getTicketById(tId);
        ScheduleDAO sd = new ScheduleDAO();
        Scheldule schedule = sd.getScheduleById(ticket.getScheId());
        FilmDAO fd = new FilmDAO();
        Films films = fd.getFilmsById(schedule.getfId());
        FormalityDAO fod = new FormalityDAO();
        Formality formality = fod.getFormalityById(schedule.getFmId());
        SessionDAO sed = new SessionDAO();
        Session session = sed.getSessionById(schedule.getSesId());
        
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
    
    @RequestMapping(value = {"/createBill"}, method = RequestMethod.POST)
    public String billAction(@ModelAttribute(value = "billModel") Bill bill, @RequestParam String tickets, String ticketNames, String rId, ModelMap mm, HttpServletRequest request) throws SQLException {
        mm.put("tickets", tickets);
        String[] ticketList = tickets.split(", ");
        String name = request.getParameter("txtName");
        String phone = request.getParameter("txtSDT");
        long total = Long.parseLong(request.getParameter("txtTotal"));
        BillDAO bd = new BillDAO();
        billDetailDAO bdd = new billDetailDAO();
        TicketDAO td = new TicketDAO();
        Cookie[] cookies = null;
        boolean check;
        // Get an array of Cookies associated with the this domain
        cookies = request.getCookies();
        int ID;
        if (cookies.length > 1) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ID")) {
                    ID = Integer.parseInt(cookie.getValue());
                    check = bd.createBill(ID, total, phone, name);
                    int bid = bd.maxBill();
                    for(String ticket: ticketList){
                        bdd.createBillDetail(Integer.parseInt(ticket), bid);
                        td.updateStatus(Integer.parseInt(ticket), 1);
                    }
                    
                    break;
                }
            }
        }
        int tId=Integer.parseInt(ticketList[0]);
        long totalPrice = td.getTicketPriceById(tId)*ticketList.length;
        Ticket ticket = td.getTicketById(tId);
        ScheduleDAO sd = new ScheduleDAO();
        Scheldule schedule = sd.getScheduleById(ticket.getScheId());
        FilmDAO fd = new FilmDAO();
        Films films = fd.getFilmsById(schedule.getfId());
        FormalityDAO fod = new FormalityDAO();
        Formality formality = fod.getFormalityById(schedule.getFmId());
        int b = bd.maxBill();


        

        mm.put("formality", formality);
        mm.put("film", films);

       mm.put("bid", b);
        mm.put("name", name);
        mm.put("phone", phone);
        mm.put("total", total);
        
        return "bill";
    }
    
    @RequestMapping(value = {"/billlist"}, method = RequestMethod.GET)
    public String BillListAction() {
        return "billList";
    }
}
