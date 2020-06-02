package com.atguigu.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuliException  extends  ArithmeticException {
    private Integer code; 
    private String message;

}
