package com.hfxt.controller;

import com.hfxt.model.Menu;
import com.hfxt.tools.Result;
import com.hfxt.tools.StatusCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @GetMapping(value = "selectAll")
    public Result selectAll(){
        Map<String,Object> map=new HashMap<String, Object>();
        boolean flag=true;
        Integer code=0;
        String msg="";

        try {
            List<Menu> menus = menuService.selectAll();
            map.put("menus",menus);
            flag=true;
            code=StatusCode.OK;
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
