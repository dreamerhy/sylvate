package com.sylvate.exclusive.mainpackage.common.enums;

/**
 * 树节点 图标枚举
 *
 * @author syLvate
 * @date 2021/3/29 15:11
 */
public enum TreeIconEnum {
    MXZB("模型指标", "icon-icon2x1"),
    YXZB("运行指标", "icon-icon-22x");
    private String nodeName;
    private String icon;

    TreeIconEnum(String nodeName, String icon) {
        this.nodeName = nodeName;
        this.icon = icon;
    }

    public String getNodeName() {
        return nodeName;
    }

    public String getIcon() {
        return icon;
    }
}
