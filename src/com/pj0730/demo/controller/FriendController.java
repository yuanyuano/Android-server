package com.pj0730.demo.controller;

import com.google.gson.Gson;

import com.pj0730.demo.dao.FriendDaoImpl;
import com.pj0730.demo.dao.FriendInfoInsert;
import com.pj0730.demo.po.AllInfo;
import com.pj0730.demo.po.CheckFriend;
import com.pj0730.demo.po.Friend;
import com.pj0730.demo.po.FriendInsertInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;
        import java.util.List;
        import com.google.gson.reflect.TypeToken;

@Controller
public class FriendController {
    @RequestMapping(value = "/friend")
    @ResponseBody
    public String getStus1(int id) {
        List<Friend> list = new FriendDaoImpl().findFriend(id);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        return json;
    }




    @RequestMapping(value = "/findfriend")
    @ResponseBody
    public String getStus2(@RequestBody String jsonstr) {
        Gson gsonstr = new Gson();
        FriendInsertInfo friendInsertInfo = gsonstr.fromJson(jsonstr,FriendInsertInfo.class);
        int flag = new FriendInfoInsert().checkFriend(friendInsertInfo);
        Friend friend = new FriendInfoInsert().findFriend(friendInsertInfo);
        CheckFriend checkFriend = new CheckFriend(friend.getAvatar(),friend.getNick(),friend.getSign(),flag);
        Gson gson = new Gson();
        String json = gson.toJson(checkFriend,CheckFriend.class);
        return json;
    }


    @RequestMapping(value = "/friendadd",produces = "applicaton/json;charset=utf-8")
    @ResponseBody
    public String getStus(@RequestBody String jsonstr){
        Gson gson = new Gson();
        FriendInsertInfo friendInsertInfo = gson.fromJson(jsonstr,FriendInsertInfo.class);
        FriendInfoInsert friendInfoInsert = new FriendInfoInsert();
        int flag = friendInfoInsert.insert(friendInsertInfo);
        if(flag!=-1)
        return "success";
        return "fail";
    }
}
