package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourceInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-04-13
 */
public interface EduCourseService extends IService<EduCourse> {

    void saveCourseInfo(CourceInfoVO courceInfoVO);
}
