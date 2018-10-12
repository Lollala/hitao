package com.hzitxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * 启动类:
 * @author Lenovo
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Gateway8081 {
 public static void main(String[] args) {
	SpringApplication.run(Gateway8081.class, args);
}
}
