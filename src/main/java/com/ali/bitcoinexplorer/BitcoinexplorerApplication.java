package com.ali.bitcoinexplorer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.ali.bitcoinexplorer.dao")
@EnableFeignClients
public class BitcoinexplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitcoinexplorerApplication.class, args);
	}

}
