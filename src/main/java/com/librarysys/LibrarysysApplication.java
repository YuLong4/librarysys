package com.librarysys;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LibrarysysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarysysApplication.class, args);
        log.info("SpringBoot项目启动成功");
    }

}
