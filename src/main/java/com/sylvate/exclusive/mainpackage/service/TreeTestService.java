package com.sylvate.exclusive.mainpackage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sylvate.exclusive.mainpackage.base.entity.TreeTest;
import com.sylvate.exclusive.mainpackage.common.ApiResponse;

/**
 * 模块：
 * 功能：
 *
 * @author syLvate
 * 2022/7/12 11:08
 * -
 **/

public interface TreeTestService extends IService<TreeTest> {

    /**
     * 查询树信息
     *
     * @param treeTest 信息
     * @return 结果
     */
    ApiResponse<Object> queryTreeTest(TreeTest treeTest);

    /**
     * 递归查询树
     *
     * @param treeTest 信息
     * @return 结果
     */
    ApiResponse<Object> recursionTreeTest(TreeTest treeTest);
}
