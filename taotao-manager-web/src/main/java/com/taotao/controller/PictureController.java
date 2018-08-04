package com.taotao.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjie
 * @date 2018/8/4 0004 - 16:43
 **/
@Controller
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String picUpload(MultipartFile uploadFile){
        //接收上传的文件
        try {
            //取扩展名
            String originalFileName = uploadFile.getOriginalFilename();
            String extName = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
            //上传到图片服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            url = IMAGE_SERVER_URL + url;

            //创建map并返回
            //响应上传图片的url。格式："error":0,"url"：""/"error":1,"message":"错误信息"
            Map result = new HashMap();
            result.put("error",0);
            result.put("url",url);
            return JsonUtils.objectToJson(result);

        }catch (Exception e){
            e.printStackTrace();
            //创建map并返回
            Map result = new HashMap();
            result.put("error",1);
            result.put("message","图片上传失败");
            return JsonUtils.objectToJson(result);
        }
    }
}
