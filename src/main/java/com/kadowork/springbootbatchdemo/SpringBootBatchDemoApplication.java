package com.kadowork.springbootbatchdemo;

import lombok.extern.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
@Slf4j
public class SpringBootBatchDemoApplication {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SpringApplication.run(SpringBootBatchDemoApplication.class, args);
        long endTime = System.currentTimeMillis();
        System.out.println("開始時刻：" + startTime + " ms");
        System.out.println("終了時刻：" + endTime + " ms");
        System.out.println("処理時間：" + (endTime - startTime) + " ms");
    }
}
