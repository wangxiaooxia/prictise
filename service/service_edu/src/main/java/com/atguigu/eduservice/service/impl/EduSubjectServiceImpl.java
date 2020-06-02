package com.atguigu.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.entity.suject.OneSubject;
import com.atguigu.eduservice.entity.suject.TwoSubject;
import com.atguigu.eduservice.listener.SubjectListener;
import com.atguigu.eduservice.mapper.EduSubjectMapper;
import com.atguigu.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-04-10
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file,EduSubjectService eduSubjectService) {
        try {
            InputStream in = file.getInputStream();
            EasyExcel.read(in, SubjectData.class,new SubjectListener(eduSubjectService)).sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        //1 查询出所有的一级分类
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper();
        wrapperOne.eq("parent_id","0");
        List<EduSubject> listone =  baseMapper.selectList(wrapperOne);

        List<OneSubject> finalSubject = new ArrayList<>();
        //2 查询所有的二级分类
        QueryWrapper<EduSubject> wrapperTwo= new QueryWrapper();
        wrapperTwo.ne("parent_id","0");
        List<EduSubject> listtwo =  baseMapper.selectList(wrapperTwo);

        //3 封装一级分类
        listone.forEach(one -> {
            OneSubject oneSubject = new OneSubject();
//            oneSubject.setId(one.getId());
//            oneSubject.setTitie(one.getTitle());
            BeanUtils.copyProperties(one,oneSubject);


            List<TwoSubject> towFinalSubjectList = new ArrayList<>();
            listtwo.forEach(tow ->{
                if(tow.getParentId().equals(one.getId())){
                    TwoSubject t = new TwoSubject();
                    BeanUtils.copyProperties(tow,t);
                    towFinalSubjectList.add(t);
                }
            });
            oneSubject.setChildren(towFinalSubjectList);
            finalSubject.add(oneSubject);

        });
        //4 封装二级分类

        return finalSubject;
    }
}
