package com.pj0730.demo.controller;

import com.google.gson.Gson;
import com.pj0730.demo.dao.HostInfoInsert;
import com.pj0730.demo.po.HostInfo;
import com.pj0730.demo.po.HostInsertInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class InsertController {
    @RequestMapping(value = "/insert",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insert(@RequestBody String json){
        Gson gson = new Gson();
        HostInfo info = gson.fromJson(json,HostInfo.class);
        HostInfoInsert hostinfoinsert = new HostInfoInsert();
        int flag = hostinfoinsert.insert(info);
        if(flag!=-1)
       return "success";
        return "fail";
    }

}
