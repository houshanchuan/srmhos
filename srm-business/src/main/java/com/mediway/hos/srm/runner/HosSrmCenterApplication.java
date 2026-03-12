package com.mediway.hos.srm.runner;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {"com.mediway.hos.srm.business"})
@ServletComponentScan(basePackages = "com.mediway.hos.srm.business")
@MapperScan(basePackages = {"com.mediway.hos.srm.business.**.mapper"})
@SpringBootApplication
@EnableAsync
@EnableScheduling
@Slf4j
public class HosSrmCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HosSrmCenterApplication.class, args);
        log.info("启动完成");
    }

}
