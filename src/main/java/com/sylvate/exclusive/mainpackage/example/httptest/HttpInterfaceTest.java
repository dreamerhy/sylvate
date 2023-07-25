package com.sylvate.exclusive.mainpackage.example.httptest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 模块：exclusive
 * 功能：http请求需要的接口
 *
 * @author syLvate
 * 2023/3/22 16:12
 * -
 **/

@Slf4j
@RestController
@RequestMapping("/httpInterfaceTest")
public class HttpInterfaceTest {


    /**
     * 获取文件流
     *
     * @param param 信息
     * @return 结果
     */
    @PostMapping("/filesByteDownloadApi")

    public Map<String, Object> getFileIs(@RequestBody Map<String, String> param) {
        try {
            long startTime = System.currentTimeMillis();
            log.info("testHttpController-getFileIs-获取文件流-开始: {}", param);
            String inputFilePath = "D:\\Document\\ideaWorkSpace\\sylvate\\document\\httptest\\httpRequestTestDocument.docx";
            InputStream is = new FileInputStream(inputFilePath);
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            is.close();
            Map<String, Object> map = new HashMap<>();
            map.put("code", "1");
            map.put("msg", "success");
            map.put("fileStream", bytes);

            log.info("docx4jController-htmlToDocx-html转docx-响应: {}, 耗时: {} ms", 200, (System.currentTimeMillis() - startTime));
            return map;
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }

    @PostMapping("/uploadFileByteApiUrl")
    public Map<String, Object> uploadFileByteApiUrl(@RequestBody Map<String, String> param) {
        try {
            long startTime = System.currentTimeMillis();
            log.info("testHttpController-getFileIs-获取文件流-开始: {}", param);
            String inputFilePath = "D:\\Document\\ideaWorkSpace\\sylvate\\document\\httptest\\httpRequestTestDocument.docx";
            InputStream is = new FileInputStream(inputFilePath);
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            is.close();
            Map<String, Object> map = new HashMap<>();
            map.put("code", "1");
            map.put("msg", "success");
            map.put("fileStream", bytes);

            log.info("docx4jController-htmlToDocx-html转docx-响应: {}, 耗时: {} ms", 200, (System.currentTimeMillis() - startTime));
            return map;
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }
}
