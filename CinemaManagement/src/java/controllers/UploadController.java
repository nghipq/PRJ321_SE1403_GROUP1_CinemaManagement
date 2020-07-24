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
 * @author Group 1
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
        //assign properties to jsp callback
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
            MyFiles f = new MyFiles();// recall class Myfiles to use method in this class
            f.setFileId(tnow.getTime()); //recall funtion setFileId in class MyFiles to set Id
            f.setFileName(file.getName());//set file name by the MultipartFile input
            f.setFileName(file.getOriginalFilename());//set file name by OriginalFileName
            f.setFileDate(file.getContentType());//set date by ContentType
            f.setFileSize(file.getSize());//set size by the MultipartFile input
            f.setFileDate(tnow.toString());//set Date by the MultipartFile input

            String filePath = path + file.getOriginalFilename(); //varible to get file path
            File upload = new File(filePath);// create new form of file
            file.transferTo(upload);//recall method and set file by varible upload
            f.setFilePath(filePath);//set path by varible file path have just got

            gd.insertFilmGraphics(Integer.parseInt(fId), f.getFileName(), 1);//then recall method of class to insert
        } catch (Exception ex) {
            System.out.println("error");
        }

        return "redirect:/admins/updateFilm.html?fId=" + fId;//then redirect to the update film page
    }

    /**
     * Method to upload File
     *
     * @param modelMap
     * @param files
     * @param request
     * @return redirect to an upload page
     */
    @RequestMapping(value = "uploadMultiFile.html", method = RequestMethod.POST)
    public String uploadMultiFile(ModelMap modelMap, @RequestParam("files") MultipartFile[] files, HttpServletRequest request) {
        try {
            String path = request.getSession().getServletContext().getRealPath("/") + "resources/uploads/";//create new string and get path of file
            for (MultipartFile file : files) {//the loop to get all element of file
                Timestamp tnow = new Timestamp(new Date().getTime());//recall class Timestamp to create new format
                MyFiles f = new MyFiles();
                f.setFileId(tnow.getTime());//recall funtion setFileId in class MyFiles to set Id
                f.setFileName(file.getName());//set file name by the MultipartFile input
                f.setFileName(file.getOriginalFilename());//set file name by OriginalFileName
                f.setFileDate(file.getContentType());//set date by ContentType
                f.setFileSize(file.getSize());//set size by the MultipartFile input
                f.setFileDate(tnow.toString());//set Date by the MultipartFile input
                listFiles.add(f);// add into list
                FileUtils.forceMkdir(new File(path));//recall class FileUtil to create new file
                File upload = new File(path + file.getOriginalFilename());//recall class file and create new file with path
                file.transferTo(upload);//use method transfer and input upload varible
                f.setFilePath(path + file.getOriginalFilename());//set the path of file by varible path and method of class MultipartFile
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //assign properties to jsp callback
        modelMap.put("listFiles", listFiles);//set list file by modelmap
        return "upload_list";//return upload page
    }

}
