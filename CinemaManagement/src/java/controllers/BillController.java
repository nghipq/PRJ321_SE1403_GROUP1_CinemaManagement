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
        mm.put("ticketNames", ticketNames);
        mm.put("formality", formality);
        mm.put("film", films);
        mm.put("schedule", schedule);
        mm.put("total", totalPrice);
        
        return "billForm";
    }
    
    @RequestMapping(value = {"/billlist"}, method = RequestMethod.GET)
    public String BillListAction() {
        return "billList";
    }
}
