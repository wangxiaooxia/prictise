package com.atguigu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.service.EduSubjectService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public class SubjectListener extends AnalysisEventListener<SubjectData> {
    //SubjectListener 不能交给spring进行管理，需要自己new，不能注入其他对象
    //不能实现实现数据库操作
    public EduSubjectService subjectService;

    public SubjectListener(){}

    public SubjectListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }
    //读取excel的内容
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if(subjectData == null){
            throw new GuliException(20001,"文件数据为空");
        }
        // 一行一行读取
       EduSubject existOneSubject =  this.existOneSubject(subjectService,subjectData.getOneSubjectName());
        if(existOneSubject == null){
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOneSubjectName());
            subjectService.save(existOneSubject);
        }
        String pid = existOneSubject.getId();
        EduSubject existTwoSubject = this.existTwoSubject(subjectService,subjectData.getTwoSubjectName(),pid);
        if (existTwoSubject == null){
            existOneSubject = new EduSubject();
            existOneSubject.setParentId(pid);
            existOneSubject.setTitle(subjectData.getTwoSubjectName());
            subjectService.save(existOneSubject);
        }
    }
    //判断易积分类不能重复添加
    private EduSubject existOneSubject(EduSubjectService subjectService,String name){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id","0");
        EduSubject one = subjectService.getOne(wrapper);
        return one;
    }
    //判断二级分类
    private EduSubject existTwoSubject(EduSubjectService subjectService,String name,String pid){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        EduSubject two = subjectService.getOne(wrapper);
        return two;
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
