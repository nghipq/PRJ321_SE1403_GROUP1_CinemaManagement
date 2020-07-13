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
import java.sql.SQLException;

/**
 *
 * @author phamq
 */
@Controller
@RequestMapping("/bill")
public class BillController {
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String beforeBillAction(@RequestParam String tickets, ModelMap mm) throws SQLException {
        mm.put("tickets", tickets);
        String[] ticketList = tickets.split(", ");
        TicketDAO td = new TicketDAO();
        
        long totalPrice = td.getTicketPriceById(Integer.parseInt(ticketList[0]))*ticketList.length;
        
        mm.put("total", totalPrice);
        
        return "billForm";
    }
    
    @RequestMapping(value = {"/billlist"}, method = RequestMethod.GET)
    public String BillListAction() {
        return "billList";
    }
}
