package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class VodFileDegradeFeignClient implements VodClient {
    @Override
    public R removeAlyVideo(String videoID) {

        return R.error().message("出错");
    }

    @Override
    public R deleteBatch(List<String> videoIdList) {
        return R.error().message("出错");
    }
}
