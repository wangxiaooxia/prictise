package com.atguigu.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component
public class ConstantPropertiesUtils implements InitializingBean {
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyId}")
    private String keyId;
    @Value("${aliyun.oss.file.keysecret}")
    private String keysecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketname;

    public static  String END_POINT;
    public static  String KEY_ID;
    public static  String KEY_SECRET;
    public static  String BUCKET_NAME;


    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        KEY_ID = keyId;
        KEY_SECRET = keysecret;
        BUCKET_NAME =  bucketname;

    }
}
