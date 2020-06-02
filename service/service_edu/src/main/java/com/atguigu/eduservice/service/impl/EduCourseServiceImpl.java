package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduCourseDescription;
import com.atguigu.eduservice.entity.vo.CourceInfoVO;
import com.atguigu.eduservice.mapper.EduCourseMapper;
import com.atguigu.eduservice.service.EduCourseDescriptionService;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-04-13
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
    @Autowired
    private EduCourseDescriptionService eduCourseDescriptionService;
    @Override
    public void saveCourseInfo(CourceInfoVO courceInfoVO) {
        EduCourse eduCorse = new EduCourse();
        BeanUtils.copyProperties(courceInfoVO,eduCorse);
        int insert = baseMapper.insert(eduCorse);
        if(insert <= 0){
            throw new GuliException(20001,"添加课程失败");
        }
        String cid = eduCorse.getId();
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setId(cid);
        eduCourseDescription.setDescription(courceInfoVO.getDescription());
        eduCourseDescriptionService.save(eduCourseDescription);
    }
}
