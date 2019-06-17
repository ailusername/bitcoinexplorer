package com.ali.bitcoinexplorer.controller;

import com.ali.bitcoinexplorer.api.BitcoinJsonRpcApi;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.net.URL;

@RestController
@RequestMapping("/getBlockchain")
@EnableAutoConfiguration
public class TestController {

    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @GetMapping("/getBlockchainInfo")
    public String test() throws Throwable {
        JSONObject blockchainInfo = bitcoinJsonRpcApi.getBlockchainInfo();
        String s = blockchainInfo.toJSONString();
        return s;
    }
}
