package com.pj0730.demo.controller;

import com.google.gson.Gson;
import com.pj0730.demo.dao.MyPraiseDao;
import com.pj0730.demo.dao.PraisedUpdate;
import com.pj0730.demo.po.MyPraised;
import com.pj0730.demo.po.PraiseInfo;
import com.pj0730.demo.po.PraiseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PraisedController {
    @RequestMapping(value = "/findpraise")
    @ResponseBody
    public String Praised(@RequestBody String json){
        Gson gson = new Gson();
        PraiseInfo praiseInfo = gson.fromJson(json,PraiseInfo.class);
        System.out.println(praiseInfo.toString());
        Gson gsonresult = new Gson();
         PraiseResult result =new PraisedUpdate().findpraised(praiseInfo);
         String jsonrsutlt = gsonresult.toJson(result,PraiseResult.class);
        return jsonrsutlt;
    }


    @RequestMapping(value = "/mypraise")
    @ResponseBody
    public String Mypraise(int id) {
        List<MyPraised> list = new MyPraiseDao().findMyPraise(id);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}