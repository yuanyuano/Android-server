package com.pj0730.demo.controller;

import com.google.gson.Gson;
import com.pj0730.demo.dao.CommentDaoImpl;
import com.pj0730.demo.dao.CommentInfoInsert;
import com.pj0730.demo.dao.MyCommentDao;
import com.pj0730.demo.po.CommentInfo;
import com.pj0730.demo.po.CommentInsertInfo;
import com.pj0730.demo.po.MyComment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {
    @RequestMapping(value = "/comment")
    @ResponseBody
    public String getStus1(int id) {
        List<CommentInfo> list = new CommentDaoImpl().findCommentPage(id);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;

    }

    @RequestMapping(value = "/commentadd", produces = "applicaton/json;charset=utf-8")
    @ResponseBody
    public String getStus(@RequestBody String jsonstr) {
        Gson gson = new Gson();
        CommentInsertInfo commentInsertInfo = gson.fromJson(jsonstr, CommentInsertInfo.class);
        CommentInfoInsert commentInfoInsert = new CommentInfoInsert();
        int flag = commentInfoInsert.insert(commentInsertInfo);
        if (flag != -1)
            return "success";
        return "fail";
    }

    @RequestMapping(value = "/mycomment")
    @ResponseBody
    public String getStus2(int id) {
        List<MyComment> list = new MyCommentDao().findMyComment(id);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;

    }
}