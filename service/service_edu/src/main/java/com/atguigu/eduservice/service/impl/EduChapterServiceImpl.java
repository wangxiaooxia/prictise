package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.atguigu.eduservice.entity.chapter.VideoVo;
import com.atguigu.eduservice.mapper.EduChapterMapper;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-04-13
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {
    @Autowired
    private EduVideoService eduVideoService;
    @Override
    public List<ChapterVo> getChapterVideoByCourceId(String courseId) {
        //1 查询章节
        QueryWrapper<EduChapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        List<EduChapter> chapterList = baseMapper.selectList(queryWrapper);

        QueryWrapper<EduVideo> wrapperVideo = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        List<EduVideo> videoList = eduVideoService.list(wrapperVideo);


        List<ChapterVo> finalList = new ArrayList<>();

        chapterList.forEach(chapter -> {
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter,chapterVo);
            finalList.add(chapterVo);
            List<VideoVo> videoVoList = new ArrayList<>();
            videoList.forEach(video -> {
                if(video.getChapterId().equals(chapter.getId())){
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video,videoVo);
                    videoVoList.add(videoVo);
                }
            });
            chapterVo.setChildren(videoVoList);
        });

        return finalList;
    }
}
