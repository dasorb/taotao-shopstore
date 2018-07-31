package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理返回页面的请求
 * @author chenjie
 * @date 2018/7/31 0031 - 22:16
 **/
@Controller
public class pageController {

    @RequestMapping("/")
    public String getIndexPage(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String getPages(@PathVariable("page")String page){
        return page;
    }
}
