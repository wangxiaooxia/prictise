package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.vo.CourceInfoVO;
import com.atguigu.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {
    @Autowired
    private EduCourseService eduCourseService;

    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourceInfoVO courceInfoVO){
        eduCourseService.saveCourseInfo(courceInfoVO);
        return R.ok();
    }

}

