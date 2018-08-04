package com.taotao.com.taotao.test;

import com.taotao.utils.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * @author chenjie
 * @date 2018/8/4 0004 - 16:13
 **/
public class TestFastDFS {
    @Test
    public void uploadFile() throws Exception{
        //向工程中添加Jar包
        //2. 创建一个配置文件，配置tracker服务器地址。client.conf
        //3. 加载配置文件
        ClientGlobal.init("E:\\IDEAWorkspace\\taotao\\taotao-manager-web\\src\\main\\resources\\resource\\client.conf");
        //4. 创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        //5.使用TrackerClient对象获得trackerserver对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //6. 创StorageServer的应用null可以
        StorageServer storageServer = null;
        //7. 创建一个StoragteClient对象。trackerserver、storageServer两个参数
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        //8. 使用该对象上传文件
        String[] strings = storageClient.upload_file("f:/图片/壁纸/59359695_p0.jpg","jpg",null);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void uploadFileUtils() throws  Exception{
        FastDFSClient fastDFSClient = new FastDFSClient("E:\\IDEAWorkspace\\taotao\\taotao-manager-web\\src\\main\\resources\\resource\\client.conf");
        String path = fastDFSClient.uploadFile("f:/图片/壁纸/20180127161202.jpg");
        System.out.println(path);
    }
}
