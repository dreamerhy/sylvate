package com.sylvate.exclusive.mainpackage.example;

import org.junit.Test;

/**
 * 模块：模板
 * 功能：抽象类实例
 *
 * @author syLvate
 * 2023/6/5 11:34
 * -
 **/

public class AbstractTest {

    public abstract class Animalss {
        String name = "猫咪";
        abstract void eat();
    }

    public class Cats extends Animalss{

        @Override
        void eat() {
            System.out.println(name + "正在吃猫粮");
        }
    }


    @Test
    public void test() {
        Cats cats = new Cats();
        cats.eat();
    }
}
