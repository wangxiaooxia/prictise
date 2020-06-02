package com.atguigu.oss.controller;

import com.atguigu.commonutils.R;
import com.atguigu.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;
    //上传头像的方法
    @PostMapping
    public R uploadOssFile(MultipartFile file) throws IOException {
       String url = ossService.uploadFileAvator(file);
        return R.ok().data("url",url);
    }
    @Value("${service.url.nacos}")
    private String serviceUrl;
//
//    @Resource
//    @LoadBalanced
//    private RestTemplate restTemplate;
//    @GetMapping(value = "/consumer")
//    public String getinfo(){
//
//    }

}
