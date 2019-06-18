package com.ali.bitcoinexplorer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ali.bitcoinexplorer.dao")
@EnableFeignClients
@EnableScheduling
@EnableAsync
public class BitcoinexplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitcoinexplorerApplication.class, args);
	}

}
