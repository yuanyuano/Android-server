package com.pj0730.demo.controller;

import com.google.gson.Gson;
import com.pj0730.demo.Utils;
import com.pj0730.demo.dao.HostInfoUpdate;
import com.pj0730.demo.po.HostInfo;
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
public class UpdateController {
    @RequestMapping(value = "/update",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(@RequestBody String json){
        HostInfoUpdate idupdate = new HostInfoUpdate();
        Gson gson = new Gson();
        HostInfo hostInfo = gson.fromJson(json,HostInfo.class);
        System.out.println("----"+hostInfo.toString());
        int flag = idupdate.update(hostInfo);
        if (flag!=-1)
            return "success";
        return "fail";
    }

}
