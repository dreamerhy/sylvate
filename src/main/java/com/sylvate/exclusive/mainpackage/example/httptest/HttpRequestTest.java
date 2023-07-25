package com.sylvate.exclusive.mainpackage.example.httptest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sylvate.exclusive.mainpackage.common.ApiResponse;
import com.sylvate.exclusive.mainpackage.common.utils.HttpUtils;
import com.sylvate.exclusive.mainpackage.common.utils.ZipUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 模块：
 * 功能：http请求测试
 *
 * @author syLvate
 * 2023/7/24 16:42
 * -
 **/

@Slf4j
@RestController
@RequestMapping("/httpRequestTest")
public class HttpRequestTest {

    @Value("${filesByteDownloadApiUrl}")
    private String filesByteDownloadApiUrl;

    @Value("${uploadFileByteApiUrl}")
    private String uploadFileByteApiUrl;


    /**
     * 测试HTTP请求下载文件
     * @param params 信息
     * @return 结果htmlStr
     */
    @PostMapping("filesByteDownloadApiUrl")
    public ApiResponse<Object> filesByteDownloadApiUrl(@RequestBody Map<String, Object> params) {
        long startTime = System.currentTimeMillis();
        log.info("httpRequestTest-filesByteDownloadApiUrl-测试HTTP请求下载文件-开始: {}, 参数: {}", new Date(), params);
        try {
            //TODO 通过HTTP请求获取文件流
            String fileId = params.get("fileId").toString();
            String decryptResult = "";
            String fileName = "";
            byte[] bytes = null;
            try {
                decryptResult = HttpUtils.httpPost(filesByteDownloadApiUrl, params);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONObject result = JSON.parseObject(decryptResult);
            if ("1".equals(result.get("code").toString())) {
                //请求成功
                bytes = result.getBytes("fileStream");
                if (null != result.get("fileName")) {
                    fileName = result.get("fileName").toString();
                }
            } else {
                return ApiResponse.fail(result.get("msg").toString());
            }
            InputStream is = null;
            if (bytes != null) {
                is = new ByteArrayInputStream(bytes);
            }
            /*
            TODO 业务相关代码区域

             */

            String htmlStr = "";
            //压缩
            String gzipStr = ZipUtils.gzip(htmlStr);

            if (is != null) {
                is.close();
            }
            log.info("httpRequestTest--测试HTTP请求下载文件-响应: {}, 耗时: {} ms", 200, (System.currentTimeMillis() - startTime));
            return ApiResponse.data(new Object());
        } catch (IOException e) {
            e.printStackTrace();
            log.info("httpRequestTest--测试HTTP请求下载文件-异常: {}, 耗时: {} ms", "操作文件异常", (System.currentTimeMillis() - startTime));
            return ApiResponse.fail("转换失败" + e.getMessage());
        }
    }


    /**
     * 测试HTTP请求上传文件
     *
     * @param docxAndHtmlInfo 文档和html相关信息
     */
    @PostMapping("uploadFileByteApi")
    public ApiResponse<Object> uploadFileByteApi(@RequestBody Map<String, Object> docxAndHtmlInfo) {
        long startTime = System.currentTimeMillis();
        log.info("httpRequestTest-uploadFileByteApi-测试HTTP请求上传文件-开始: {}， 参数: {}", new Date(), docxAndHtmlInfo);
        try {
            String htmlZipStr = docxAndHtmlInfo.get("html").toString();
            String id = docxAndHtmlInfo.get("id").toString();
            //祛除字符串中的特殊字符回车
            htmlZipStr = htmlZipStr.replaceAll("(\\\\r\\\\n)|(\\\\n)", "");
            //解压
            String htmlStr = ZipUtils.gunzip(htmlZipStr);
            
            /*
            TODO 业务相关代码区域
             */
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] bs = bos.toByteArray();
            Map<String, Object> param = new HashMap<>();
            param.put("fileId", id);
            param.put("fileStream", bs);
            String decryptResult = HttpUtils.httpPost(uploadFileByteApiUrl, param);
            if ("null".equals(decryptResult)) {
                return ApiResponse.fail("http跨服务请求异常，返回：" + decryptResult);
            }
            JSONObject result = JSON.parseObject(decryptResult);
            if ("1".equals(result.get("code"))) {
                return ApiResponse.success(result.get("msg").toString());
            } else {
                return ApiResponse.fail("保存失败");
            }
        }  catch (JAXBException e) {
            e.printStackTrace();
            log.info("httpRequestTest-httpRequestTest-测试HTTP请求上传文件-异常: {}, 耗时: {} ms", "解析文档异常", (System.currentTimeMillis() - startTime));
        } catch (IOException e) {
            e.printStackTrace();
            log.info("httpRequestTest-httpRequestTest-测试HTTP请求上传文件-异常: {}, 耗时: {} ms", "io流操作异常", (System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("httpRequestTest-uploadFileByteApi-测试HTTP请求上传文件-响应: {}, 耗时: {} ms", 200, (System.currentTimeMillis() - startTime));
        return ApiResponse.fail("发现未知异常，请联系管理员");
    }

}
