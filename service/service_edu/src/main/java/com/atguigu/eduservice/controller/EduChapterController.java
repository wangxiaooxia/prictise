package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.atguigu.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/eduservice/chapter")
public class EduChapterController {
     @Autowired
    private EduChapterService eduChapterService;
     @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId){
         List<ChapterVo> list = eduChapterService.getChapterVideoByCourceId(courseId);
        return  R.ok().data("allChapterVideo",list);
    }

}

