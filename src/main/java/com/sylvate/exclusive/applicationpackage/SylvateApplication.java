package com.sylvate.exclusive.applicationpackage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author syLvate
 */
@SpringBootApplication( scanBasePackages = {"com.sylvate.exclusive.mainpackage", "com.sylvate.exclusive.otherspackage"})
@MapperScan(basePackages = {"com.sylvate.exclusive.mainpackage.**.dao", "com.sylvate.exclusive.otherspackage.**.dao"})
public class SylvateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SylvateApplication.class, args);
    }

}
