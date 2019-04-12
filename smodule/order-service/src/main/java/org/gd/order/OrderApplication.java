package org.gd.order;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @DATA 2019-04-12 09:14
 * @Author 张国伟  WeChat:17630376104
 * @Description
 */
@EnableSwagger2Doc
@EnableDiscoveryClient
@MapperScan("org.gd.order.mapper")
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}