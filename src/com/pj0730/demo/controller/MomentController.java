package com.pj0730.demo.controller;

import com.google.gson.Gson;
import com.pj0730.demo.dao.MomentInsert;
import com.pj0730.demo.po.Moment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MomentController {
    @RequestMapping(value = "/momentadd", produces = "applicaton/json;charset=utf-8")
    @ResponseBody
    public String getStus(@RequestBody String jsonstr) {
        Gson gson = new Gson();
        Moment moment = gson.fromJson(jsonstr, Moment.class);
        MomentInsert momentInsert = new MomentInsert();
        int dynamicID = momentInsert.insert(moment);
       return String.valueOf(dynamicID);
    }
}
