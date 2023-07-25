package com.sylvate.exclusive.mainpackage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sylvate.exclusive.mainpackage.base.dto.TreeTestDto;
import com.sylvate.exclusive.mainpackage.base.entity.TreeTest;
import com.sylvate.exclusive.mainpackage.common.ApiResponse;
import com.sylvate.exclusive.mainpackage.dao.TreeTestDao;
import com.sylvate.exclusive.mainpackage.service.TreeTestService;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 模块：
 * 功能：
 *
 * @author syLvate
 * 2022/7/12 11:09
 * -
 **/

@Service
public class TreeTestServiceImpl extends ServiceImpl<TreeTestDao, TreeTest> implements TreeTestService {

    @Resource
    TreeTestDao treeTestDao;

    /**
     * 查询树信息
     *
     * @param treeTest 信息
     * @return 结果
     */
    @Override
    public ApiResponse<Object> queryTreeTest(TreeTest treeTest) {
        List<TreeTest> treeTestList = treeTestDao.queryTreeTest(treeTest);
        if (null == treeTestList) {
            return ApiResponse.fail("查询失败");
        } else {
            return ApiResponse.data(treeTestList);
        }
    }

    /**
     * 递归查询树
     *
     * @param treeTest 信息
     * @return 结果
     */
    @Override
    public ApiResponse<Object> recursionTreeTest(TreeTest treeTest) {
        Map<String, Object> param = new HashMap<>(500);
        param.put("TEMPLATE_ID", treeTest.getTemplateId());
        List<TreeTest> treeTestList = listByMap(param);
        List<TreeTestDto> treeTestDtoList = new ArrayList<>();
        for (TreeTest test : treeTestList) {
            TreeTestDto treeTestDto = new TreeTestDto();
            BeanUtils.copyProperties(test, treeTestDto);
            treeTestDtoList.add(treeTestDto);
        }
        List<TreeTestDto> resultTree = recursionTree("0", treeTestDtoList);
        if (resultTree != null && resultTree.size() > 0) {
            return ApiResponse.data(resultTree);
        } else {
            return ApiResponse.fail("构建树失败");
        }

    }


    /**
     * 递归获取所有数据
     * @param rootId 根节点id
     * @param rootTree 所有数据
     * @return 树结果
     */
    private List<TreeTestDto> recursionTree(String rootId, List<TreeTestDto> rootTree) {
        List<TreeTestDto> childList = new ArrayList<>();
        for (TreeTestDto node : rootTree) {
            if (rootId.equals(node.getParentId())) {
                childList.add(node);
            }
        }
        for (TreeTestDto childNode : childList) {
            childNode.setChildList(recursionTree(childNode.getId(), rootTree));
        }
        if (childList.isEmpty()) {
            return null;
        }
        return childList;
    }

    @Test
    public void test() {

        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("name", "张三");
        map1.put("sex", "男");
        map1.put("age", "18");
        list.add(map1);
        Map<String, String> map2 = new HashMap<>();
        map2.put("name", "李四");
        map2.put("sex", "男");
        map2.put("age", "19");
        list.add(map2);
        Map<String, String> map3 = new HashMap<>();
        map3.put("name", "王五");
        map3.put("sex", "男");
        map3.put("age", "22");
        list.add(map3);
        Map<String, String> map4 = new HashMap<>();
        map4.put("name", "小红");
        map4.put("sex", "女");
        map4.put("age", "17");
        list.add(map4);
        list.stream().filter(map -> Integer.parseInt(map.get("age")) >= 18).forEach(System.out::println);
        List<Map<String, String>> newList = new ArrayList<>();
        list.stream().filter(map -> {
            if (Integer.parseInt(map.get("age")) >= 18 ) {
                return true;
            } {
                return false;
            }
        }).forEach(newList::add);
        System.out.println(newList);
        list.stream().filter(map -> Integer.parseInt(map.get("age")) > 18 ).forEach(newList :: add);
        List<Map<String, String>> l = list.stream().filter(map -> Integer.parseInt(map.get("age")) > 18 ).collect(Collectors.toList());
        System.out.println(l);
    }
}
