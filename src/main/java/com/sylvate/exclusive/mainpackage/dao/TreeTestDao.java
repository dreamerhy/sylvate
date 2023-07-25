package com.sylvate.exclusive.mainpackage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sylvate.exclusive.mainpackage.base.entity.TreeTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 模块：
 * 功能：
 *
 * @author syLvate
 * 2022/7/12 11:09
 * -
 **/

@Mapper
public interface TreeTestDao extends BaseMapper<TreeTest> {

    /**
     * 查询树信息
     *
     * @param treeTest 信息
     * @return 结果
     */
    List<TreeTest> queryTreeTest(@Param("treeTest") TreeTest treeTest);
}
