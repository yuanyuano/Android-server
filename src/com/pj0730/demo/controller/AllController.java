package com.pj0730.demo.controller;

import com.google.gson.Gson;
import com.pj0730.demo.dao.DaoImpl;
import com.pj0730.demo.dao.MainDaoImpl;
import com.pj0730.demo.dao.MyMomentDao;
import com.pj0730.demo.po.AllInfo;
import com.pj0730.demo.po.Friend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import com.google.gson.reflect.TypeToken;

@Controller
public class AllController {
    @RequestMapping(value = "/all")
    @ResponseBody
    public String getStus(int id) {
        List<AllInfo> list = new DaoImpl().findMainPage(id);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "/mymoment")
    @ResponseBody
    public String MyCollect(int id) {
        List<AllInfo> list = new MyMomentDao().findMyMoment(id);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @RequestMapping(value = "/mainhost")
    @ResponseBody
    public String Mainhost(int id) {
        Friend host = new MainDaoImpl().findhost(id);
        Gson gson = new Gson();
        String json = gson.toJson(host,Friend.class);
        return json;
    }
}