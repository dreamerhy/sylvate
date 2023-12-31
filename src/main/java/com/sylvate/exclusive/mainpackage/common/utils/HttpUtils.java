package com.sylvate.exclusive.mainpackage.common.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * 模块：
 * 功能：
 *
 * @author syLvate
 * 2023/3/22 15:57
 * -
 **/
@Slf4j
public class HttpUtils {


    /**
     * http post请求
     *
     * @param postUrl 请求路径
     * @param param   参数
     * @return 结果
     * @throws Exception
     */
    public static String httpPost(String postUrl, Map<String, Object> param) throws Exception {
        log.info("跨服务http请求开始");
        // 1.请求URL
//        String postUrl = "http://127.0.0.1:48583/unstruct/filesByteDownloadApi";
        // 2.请求参数JSON格式
        String json = JSON.toJSONString(param);
        // 3.创建连接与设置连接参数
        URL urlObj = new URL(postUrl);
        HttpURLConnection httpConn = (HttpURLConnection) urlObj.openConnection();
        httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("Charset", "UTF-8");
        // POST请求且JSON数据,必须设置
        httpConn.setRequestProperty("Content-Type", "application/json");
        // 打开输出流,默认是false
        httpConn.setDoOutput(true);
        // 打开输入流,默认是true,可省略
        httpConn.setDoInput(true);
        // 4.从HttpURLConnection获取输出流和写数据
        OutputStream oStream = httpConn.getOutputStream();
        oStream.write(json.getBytes());
        oStream.flush();
        // 5.发起http调用(getInputStream触发http请求)
        if (httpConn.getResponseCode() != 200) {
            log.info("跨服务http请求异常");
            throw new Exception("调用服务端异常.");
        } else {
            log.info("跨服务http请求成功");
        }
        // 6.从HttpURLConnection获取输入流和读数据
        BufferedReader br = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
        StringBuilder resultData = new StringBuilder();
        String line = "";
        while ((line = br.readLine()) != null) {
            resultData.append(line);
        }
        log.info("从服务端返回结果: " + resultData);
        // 7.关闭HttpURLConnection连接
        httpConn.disconnect();
        return resultData.toString();
    }

}
