package com.sylvate.exclusive.mainpackage.example;

/**
 * 模块：mainpackage
 * 功能：字符串翻转方法
 *
 * @author syLvate
 * 2023/6/5 10:38
 * -
 **/

public class StringReverseTest {

    public static void main(String[] args) {
        String str = "abcdefg";
        StringBuilder sb = new StringBuilder(str);
        String ret = sb.reverse().toString();
        System.out.println(ret);
    }
}
