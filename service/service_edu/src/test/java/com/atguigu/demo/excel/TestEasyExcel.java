package com.atguigu.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {
    public static void main(String[] args) {
//        //实现excel写的操作
//        // 1.设置写入到文件夹的地址和名称
//        String fileName = "F://write.xls";
//        // 2 调用easyexcel里面的方法和实现步骤
//
//        EasyExcel.write(fileName,DemoData.class).sheet("学生列表").doWrite(getData());
//
        String fileName = "F://write.xls";
        EasyExcel.read(fileName,DemoData.class,new ExcelListener()).sheet().doRead();

    }
    private static List<DemoData> getData(){
        List<DemoData> demoDataList = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            DemoData data = new DemoData();
            data.setName("lucy"+i);
            data.setSno(i);
            demoDataList.add(data);
        }
        return demoDataList;
    }
}
