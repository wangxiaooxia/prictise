package com.atguigu.eduservice.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.commonutils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@RestController
@RequestMapping("/eduservice/user")
public class EduLoginController {


    @PostMapping("login")
    public R login() {
        return R.ok().data("token", R.ok());
    }

    @GetMapping("info")
    public R info() {
        return R.ok().data("roles", "admin").data("avatar", "");
    }

}
