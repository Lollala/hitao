package com.hzitxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@MapperScan("com.hzitxx.hitao.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class System8082 {
  public static void main(String[] args) {
	SpringApplication.run(System8082.class, args);
}
}
