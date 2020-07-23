/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.GraphicsDAO;
import FileUpload.MyFiles;
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
 * @author phamq
 */
@Controller
@RequestMapping(value = "files")
public class UploadController {

    private static List<MyFiles> listFiles = null;

    public UploadController() {
        this.listFiles = new ArrayList<>();
    }

    @RequestMapping(value = "list.html", method = RequestMethod.GET)
    public String uploadList(ModelMap modelMap) {
        modelMap.put("listFiles", listFiles);
        return "upload_list";
    }

    @RequestMapping(value = "uploadFile.html", method = RequestMethod.GET)
    public String uploadForm(ModelMap modelMap) {
        return "jsp/upload_file";
    }

    @RequestMapping(value = "uploadMultiFile.html", method = RequestMethod.GET)
    public String uploadMulForm(ModelMap mm) {
        return "jsp/upload_multiple_file";
    }

    @RequestMapping(value = "uploadFile.html", method = RequestMethod.POST)
    public String uploadFile(ModelMap modelMap, @RequestParam("file") MultipartFile file, String fId, HttpServletRequest request) {
        try {
            GraphicsDAO gd = new GraphicsDAO();
            String path = request.getSession().getServletContext().getRealPath("/") + "resources/image/";

            Timestamp tnow = new Timestamp(new Date().getTime());
            MyFiles f = new MyFiles();
            f.setFileId(tnow.getTime());
            f.setFileName(file.getName());
            f.setFileName(file.getOriginalFilename());
            f.setFileDate(file.getContentType());
            f.setFileSize(file.getSize());
            f.setFileDate(tnow.toString());

            String filePath = path + file.getOriginalFilename();
            File upload = new File(filePath);
            file.transferTo(upload);
            f.setFilePath(filePath);
            
            gd.insertFilmGraphics(Integer.parseInt(fId), f.getFileName(), 1);
        } catch (Exception ex) {
            System.out.println("error");
        }

        return "redirect:/admins/updateFilm.html?fId=" + fId;
    }

    @RequestMapping(value = "uploadMultiFile.html", method = RequestMethod.POST)
    public String uploadMultiFile(ModelMap modelMap, @RequestParam("files") MultipartFile[] files, HttpServletRequest request) {
        try {
            String path = request.getSession().getServletContext().getRealPath("/") + "resources/uploads/";
            for (MultipartFile file : files) {
                Timestamp tnow = new Timestamp(new Date().getTime());
                MyFiles f = new MyFiles();
                f.setFileId(tnow.getTime());
                f.setFileName(file.getName());
                f.setFileName(file.getOriginalFilename());
                f.setFileDate(file.getContentType());
                f.setFileSize(file.getSize());
                f.setFileDate(tnow.toString());
                listFiles.add(f);
                FileUtils.forceMkdir(new File(path));
                File upload = new File(path + file.getOriginalFilename());
                file.transferTo(upload);
                f.setFilePath(path + file.getOriginalFilename());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        modelMap.put("listFiles", listFiles);
        return "upload_list";
    }

}
