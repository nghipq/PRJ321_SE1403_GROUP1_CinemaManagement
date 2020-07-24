/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.GraphicsDAO;
import java.io.File;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Group 1
 */
@Controller
@RequestMapping(value = "files")
public class UploadController {

    /**
     * uploadFile controller
     *
     * @param modelMap
     * @param file
     * @param fId
     * @param request
     * @return redirect to /admins/updateFilm.html?fId=
     */
    @RequestMapping(value = "uploadFile.html", method = RequestMethod.POST)
    public String uploadFile(ModelMap modelMap, @RequestParam("file") MultipartFile file, String fId, HttpServletRequest request) {
        try {
            GraphicsDAO gd = new GraphicsDAO(); //recall class GraphicsDao
            String path = request.getSession().getServletContext().getRealPath("/") + "resources/image/"; // upload image

            Timestamp tnow = new Timestamp(new Date().getTime());//recall class Timetamp to create new format

            String filePath = path + file.getOriginalFilename(); //varible to get file path
            File upload = new File(filePath);// create new form of file
            file.transferTo(upload);//recall method and set file by varible upload

            gd.insertFilmGraphics(Integer.parseInt(fId), file.getOriginalFilename(), 1);//then recall method of class to insert
            
            gd.closeConnect();
        } catch (Exception ex) {
            System.out.println("error");
        }

        return "redirect:/admins/updateFilm.html?fId=" + fId;//then redirect to the update film page
    }
}
