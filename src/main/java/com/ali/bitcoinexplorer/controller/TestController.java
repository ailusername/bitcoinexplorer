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
@RequestMapping("/test")
@EnableAutoConfiguration
public class TestController {

    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @GetMapping("/getBlockchainInfo")
    public String test() throws Throwable {
        JSONObject blockchainInfo = bitcoinJsonRpcApi.getBlockchainInfo();
        String result = blockchainInfo.toJSONString();
        return result;
    }

    @GetMapping("/getrawtransaction")
    public String  getrawtransaction() throws Throwable {
        JSONObject jsonRpcApiBlockByHash = bitcoinJsonRpcApi.getBlockByHash("0000000000000bc3051e4ed64bf256b7101426e8c01ce18e424f9a246322bb70");
        JSONObject jsonObject = bitcoinJsonRpcApi.getTransactionById("f71795f30d0b909ff8d8bcf61d542003d84abae994d8aca0e77de41134e36ffa");
        return null;
    }
}
