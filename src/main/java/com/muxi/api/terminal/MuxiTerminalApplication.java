package com.muxi.api.terminal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication	
@EnableDiscoveryClient
public class MuxiTerminalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuxiTerminalApplication.class, args);
	}
}
