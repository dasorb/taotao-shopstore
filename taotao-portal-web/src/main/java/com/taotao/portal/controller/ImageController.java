package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页展示
 * @author chenjie
 * @date 2018/8/16 0016 - 11:18
 **/
@Controller
public class ImageController {

    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
}
