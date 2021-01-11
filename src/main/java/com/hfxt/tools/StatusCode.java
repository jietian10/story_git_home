package com.hfxt.tools;

public class StatusCode {

    public static final Integer OK = 10000;  // 成功
    public static final Integer ERROR = 10001;  // 失败
    public static final Integer LOGINERROR = 10002;  // 登录失败
    public static final Integer ACCESSERROR = 10003;  // 权限不足
    public static final Integer REMOTEERROR = 10004;  // 远程调用失败
    public static final Integer REPERROR = 10005;  // 重复操作
}