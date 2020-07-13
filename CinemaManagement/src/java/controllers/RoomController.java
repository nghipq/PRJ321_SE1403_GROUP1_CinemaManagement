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
import java.util.HashMap;
import java.util.Map;
import models.Ticket;
import org.json.JSONObject;

/**
 *
 * @author phamq
 */
@Controller
@RequestMapping("/room")
public class RoomController {
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String roomAction(@RequestParam String fId, String rId, String scheId, ModelMap mm) throws SQLException {
        TicketDAO td = new TicketDAO();
        Map<String, String> tickets = (Map) td.getSeatAndTicketByScheduleId(Integer.parseInt(scheId));
        JSONObject jobj = new JSONObject(tickets);
        
        mm.put("fId", fId);
        mm.put("rId", rId);
        mm.put("tickets", jobj);
        return "room";
    }
}
