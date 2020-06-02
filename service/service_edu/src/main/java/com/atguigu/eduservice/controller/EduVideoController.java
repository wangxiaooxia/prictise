package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/eduservice/edu-video")
public class EduVideoController {
    @Autowired
    private VodClient vodClient;
    @Autowired
    private EduVideoService eduVideoService;

    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id){

       EduVideo eduVideo =  eduVideoService.getById(id);
       String videoID = eduVideo.getVideoSourceId();
        if(!StringUtils.isEmpty(videoID)){
            vodClient.removeAlyVideo(videoID);
        }
        eduVideoService.removeById(id);
        return R.ok();
    }



    @DeleteMapping("{deleteBatchs}")
    public R deletBatch(@RequestParam("videoIdList") List<String> videoIdList){

        R r = vodClient.deleteBatch(videoIdList);
        if (r.getCode() == 20001){
            throw new GuliException(20001,"shibai");
        }
      //  eduVideoService.removeById(id);
        return R.ok();
    }
}

