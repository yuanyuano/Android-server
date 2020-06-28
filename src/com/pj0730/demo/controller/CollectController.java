package com.pj0730.demo.controller;

import com.google.gson.Gson;
import com.pj0730.demo.dao.CollectedUpdate;
import com.pj0730.demo.dao.MyCollectDao;
import com.pj0730.demo.po.AllInfo;
import com.pj0730.demo.po.CollectInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CollectController {
    @RequestMapping(value = "/findcollect")
    @ResponseBody
    public String Collect(@RequestBody String json) {
        Gson gson = new Gson();
        CollectInfo collectInfo = gson.fromJson(json, CollectInfo.class);
        int result = new CollectedUpdate().findCollected(collectInfo);
        return String.valueOf(result);
    }


    @RequestMapping(value = "/mycollect")
    @ResponseBody
    public String MyCollect(int id) {
        List<AllInfo> list = new MyCollectDao().findMyCollect(id);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
