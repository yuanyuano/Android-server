package com.pj0730.demo.controller;

import com.pj0730.demo.Utils;
import com.pj0730.demo.dao.ImageUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("/uploadavatar")
    @ResponseBody
    public String uploadavatar(@RequestParam("file") MultipartFile file, String hostID, HttpServletRequest request) {
        String dirPath = request.getServletContext().getRealPath("/uploadavatar/");
        System.out.println(dirPath);
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            String ip = request.getRemoteAddr();
            String sufix = file.getOriginalFilename().split("\\.")[1];
            String fileName = Utils.getFileName(ip)+"."+sufix;
            file.transferTo(new File(dirPath+ fileName));
            ImageUpload imageUpload = new ImageUpload();
            imageUpload.avatar(fileName,hostID);
        } catch (Exception e) {
            e.printStackTrace();
            return"afail";
        }
        return "asuccess";
    }

    @RequestMapping("/uploadimage")
    @ResponseBody
    public String uploadimage(@RequestParam("file") MultipartFile file, String dynamicID, HttpServletRequest request) {
        String dirPath = request.getServletContext().getRealPath("/uploadimage/");
        System.out.println(dirPath);
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            String ip = request.getRemoteAddr();
            String sufix = file.getOriginalFilename().split("\\.")[1];
            String fileName = Utils.getFileName(ip)+"."+sufix;
            file.transferTo(new File(dirPath+ fileName));
            ImageUpload imageUpload =new ImageUpload();
            imageUpload.image(fileName,dynamicID);
        } catch (Exception e) {
            e.printStackTrace();
            return"error";
        }
        return "success";
    }
}
