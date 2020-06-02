package vod.controller;

import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.atguigu.commonutils.R;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vod.service.VodService;

import java.util.List;

@RestController
@RequestMapping("/eduvod/vodservice")
@CrossOrigin
public class VodController {

    @GetMapping("/testA")
    public String testA(){
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "----testB";
    }

//    @Autowired
//    private VodService vodService;
//
//    //上传视频到阿里云
//    @PostMapping("uploadAlyiVideo")
//    public R uploadAlyiVideo(MultipartFile file) {
//        //返回上传视频id
//        String videoId = vodService.uploadVideoAly(file);
//        return R.ok().data("videoId",videoId);
//    }
//
//    @DeleteMapping("removeAlyVideo/{videoID}")
//    public R removeAlyVideo(@PathVariable String videoID){
//        try {
//            //初始化对象
//           // DefaultAcsClient client = InitVodCilent.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
//            //创建删除视频request对象
//            DeleteVideoRequest request = new DeleteVideoRequest();
//            //向request设置视频id
//            request.setVideoIds(videoID);
//            //调用初始化对象的方法实现删除
//           // client.getAcsResponse(request);
//            return R.ok();
//        }catch(Exception e) {
//            e.printStackTrace();
//            throw new GuliException(20001,"删除视频失败");
//        }
//    }
//   @DeleteMapping("delete_batch")
//   public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList){
//        vodService.removeMoreAlyVideo(videoIdList);
//        return R.ok();
//   }

}
