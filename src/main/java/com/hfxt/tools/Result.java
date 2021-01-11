package com.hfxt.tools;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private boolean flag;//是否成功
    private Integer code;//返回码
    private String msg;//返回信息
    private Object data;//返回数据
}
