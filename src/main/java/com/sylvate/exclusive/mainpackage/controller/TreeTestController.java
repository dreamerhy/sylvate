package com.sylvate.exclusive.mainpackage.controller;

import com.sylvate.exclusive.mainpackage.base.entity.TreeTest;
import com.sylvate.exclusive.mainpackage.common.ApiResponse;
import com.sylvate.exclusive.mainpackage.service.TreeTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 模块：
 * 功能：
 *
 * @author syLvate
 * 2022/7/12 11:04
 * -
 **/

@Slf4j
@RestController
@RequestMapping("/treeTestController")
public class TreeTestController {

    @Resource
    TreeTestService treeTestService;

    /**
     * 查询树信息
     *
     * @param treeTest 信息
     * @return 结果
     */
    @PostMapping("/queryTreeTest")

    public ApiResponse<Object> queryTreeTest(@RequestBody TreeTest treeTest) {
        try {
            ApiResponse<Object> apiResponse;
            log.info("TreeTestController-queryTreeTest 查询树信息");
            apiResponse = treeTestService.queryTreeTest(treeTest);
            log.info("TreeTestController-queryTreeTest 查询树信息响应：{}", apiResponse.getCode());
            return apiResponse;
        } catch (Exception e) {
            log.info(e.getMessage());
            return ApiResponse.fail("查询树信息" + e.getMessage());
        }
    }

    /**
     * 递归查询树
     *
     * @param treeTest 信息
     * @return 结果
     */
    @PostMapping("/recursionTreeTest")
    public ApiResponse<Object> recursionTreeTest(@RequestBody TreeTest treeTest) {
        try {
            ApiResponse<Object> apiResponse;
            log.info("TreeTestController-queryTreeTest 递归查询树");
            apiResponse = treeTestService.recursionTreeTest(treeTest);
            log.info("TreeTestController-queryTreeTest 递归查询树响应：{}", apiResponse.getCode());
            return apiResponse;
        } catch (Exception e) {
            log.info(e.getMessage());
            return ApiResponse.fail("递归查询树" + e.getMessage());
        }
    }
}
