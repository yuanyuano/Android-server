package com.pj0730.demo.controller;

import com.google.gson.Gson;
import com.pj0730.demo.dao.Login;
import com.pj0730.demo.po.HostInfo;
import com.pj0730.demo.po.LoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getStus(@RequestBody String json) {
        Gson gson = new Gson();
        HostInfo hostInfo = gson.fromJson(json,HostInfo.class);
        int result = new Login().findLogin(hostInfo);
        if(result!=-1){
            return "success";
        }
        else return "fail";
    }
}
