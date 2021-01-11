package com.hfxt.controller;

import com.hfxt.model.Hallinformation;
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
@RequestMapping("/hall")
public class HallInfoController extends BaseController{

    @RequestMapping(value = "selgonggaos",produces = "application/json;charset=UTF-8")
    public Result selGongGaos(){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag=true;
        Integer code=0;
        String msg="";

        try {
            List<Hallinformation> gonggaos =  hallInfoService.selectAll();
            map.put("gonggaos",gonggaos);
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
