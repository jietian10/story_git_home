package com.hfxt.controller;

import com.hfxt.model.Gameroom;
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
@RequestMapping("/gameroom")
public class GameRoomController extends BaseController{

    /**
     * 所有房间信息条件查询
     * @param gameroom
     * @return
     */
    @RequestMapping(value = "selgameroom",produces = "application/json;charset=UTF-8")
    public Result selgameroom(Gameroom gameroom){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag=true;
        Integer code=0;
        String msg="";

        try {
            List<Gameroom> gameRooms = gameRoomService.selectAll(gameroom);
            map.put("gameRooms",gameRooms);
            flag=true;
            code= StatusCode.OK;
            msg="";
        } catch (Exception e){
            e.printStackTrace();
            map.clear();
            flag=false;
            code=StatusCode.ERROR;
            msg=e.getMessage();
        }


        return new Result(flag, code, msg, map);
    }
}
