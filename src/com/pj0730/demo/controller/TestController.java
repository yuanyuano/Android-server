package com.pj0730.demo.controller;

import com.google.gson.Gson;
import com.pj0730.demo.po.test;
import com.pj0730.demo.dao.testDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    @RequestMapping(value = "/test")
    @ResponseBody
    public String getStus(int id) {
        test test = new testDao().test(id);
        Gson gson = new Gson();
        String json = gson.toJson(test);
        System.out.println(json);
        return json;
    }
}