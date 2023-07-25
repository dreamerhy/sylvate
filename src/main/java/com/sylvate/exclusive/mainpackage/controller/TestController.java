package com.sylvate.exclusive.mainpackage.controller;

import com.sylvate.exclusive.mainpackage.common.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 模块：
 * 功能：
 *
 * @author Fanhb
 * 2023/7/20 16:24
 * -
 **/

@Slf4j
@RestController
@RequestMapping("/testController")
public class TestController {

    /**
     * 测试类
     * @param params 参数
     * @return 结果
     */
    @PostMapping("/test")
    public ApiResponse<Object> test(@RequestBody Map<String, Object> params) {
        long startTime = System.currentTimeMillis();
        log.info("VersioningController-getFileListByFileId-通过文件id获取该文档的所有版本-开始，请求参数：{}", params);
        String str = "成功调用后台";
        log.info("VersioningController-getFileListByFileId-通过文件id获取该文档的所有版本-响应: {}, 耗时: {} ms", 200, (System.currentTimeMillis() - startTime));
        return ApiResponse.data(str);
    }
}
