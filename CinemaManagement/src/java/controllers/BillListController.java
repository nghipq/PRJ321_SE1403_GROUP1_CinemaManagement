/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import DAO.BillDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Bill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author GF63 8RD
 */
    @Controller
@RequestMapping("/bill")
public class BillListController {


    @RequestMapping(value = {"/billList"}, method = RequestMethod.GET)
    public String billListAction(ModelMap mm) throws SQLException {
        BillDAO bd = new BillDAO();
        ArrayList<Bill> bill = new ArrayList<>();
        ResultSet rs = bd.getAll();
         while (rs.next()) {
            bill.add(new Bill(rs.getInt("bId"), rs.getInt("cusId"), rs.getInt("sId"), rs.getDate("dateBuy"), rs.getLong("total"), rs.getString("name"), rs.getString("phone")));
         }
         
        mm.put("bill", bill);

        return "billList";
    }
    
    
}
