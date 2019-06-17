package com.ali.bitcoinexplorer.controller;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.net.URL;

@RestController
@RequestMapping("/test1")
@EnableAutoConfiguration
public class TestController {

    private JsonRpcHttpClient jsonRpcHttpClient;

    @GetMapping("/test")
    public String test() throws Throwable {
        HashMap<String, String> headers = new HashMap<>();
        String authStrOrig = "zf:123456";
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authStrResult = String.format("Basic %s", authStr);
        headers.put("Authorization", authStrResult);
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://localhost:18332"), headers);
        client.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);
        return null;
    }
}
