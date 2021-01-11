package com.hfxt.controller;

import com.hfxt.model.Roominformation;
import com.hfxt.tools.Result;
import com.hfxt.tools.StatusCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/roominfo")
public class RoomInfoController extends BaseController{

    @RequestMapping(value = "selroominfo",produces = "application/json;charset=UTF-8")
    public Result selgameroom(Roominformation roominfo){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag=true;
        Integer code=0;
        String msg="";

        try {
            roominfo.setIdentifier("1");
            List<Roominformation> roominfos=roomInfoService.selectAll(roominfo);
            map.put("roominfos",roominfos);
            flag=true;
            code=StatusCode.OK;
            msg="";
        } catch (Exception e){
            e.printStackTrace();
            map.clear();
            flag=false;
            code= StatusCode.ERROR;
            msg=e.getMessage();
        }

        return new Result(flag, code, msg, map);
    }

}
