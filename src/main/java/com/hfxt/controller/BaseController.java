package com.hfxt.controller;


import com.hfxt.service.*;
import com.hfxt.tools.RabbitSend;
import com.hfxt.tools.RedisUtil;

import javax.annotation.Resource;
import java.io.File;

public class BaseController {

    //图片地址，结尾有File.separator
//    String path_img1=new File(new File(this.getClass().getClassLoader().getResource("").getPath()).getParent()).getParent() + File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"image"+File.separator;

    String path_img="/usr/local/data/";
//    String path_img1="E:/图片/image/";

    @Resource
    protected RabbitSend rabbitSend;

    @Resource
    protected RedisUtil redisUtil;

    @Resource
    protected MenuService menuService;

    @Resource
    protected AccountService accountService;

    @Resource
    protected RoomInfoService roomInfoService;

    @Resource
    protected GameRoomService gameRoomService;

    @Resource
    protected HallInfoService hallInfoService;



}
