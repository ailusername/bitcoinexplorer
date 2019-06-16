package com.ali.bitcoinexplorer.controller;

import com.ali.bitcoinexplorer.api.BitcoinRestApi;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
public class TempController {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @GetMapping("/getBlockChainInfo")
    public String getBlockChainInfo(){
        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
        return blockChainInfo.toJSONString();
    }

    @GetMapping("/getRestMempooContents")
    public String getRestMempooContents(){
        JSONObject restMempooContents = bitcoinRestApi.getRestMempooContents();
        return restMempooContents.toJSONString();
    }

    /**
     * 2
     * @return
     */

    @GetMapping("/getBlockNotxdetails")
    public String getBlockNotxdetails(){
        JSONObject blockNotxdetails = bitcoinRestApi.getBlockNotxdetails("0000000000bd883cdf9abf9fc161c383ac1b42f14cd6fb4354196a50230f07cc");
        return blockNotxdetails.toJSONString();
    }

    /**
     * 4
     * @return
     */
    @GetMapping("/getRestHeaders")
    public JSONObject getRestHeaders(){
        JSONObject restHeaders = bitcoinRestApi.getRestHeaders(5,"0000000000fc17f0e6f986fdaf4d2e206b3ddcbdc8866fb1a8fe6a7277df57b8");
        return restHeaders;
    }


    @GetMapping("/getRestGetBlockHashByHeight")
    public String getRestGetBlockHashByHeight(){
        JSONObject restGetBlockHashByHeight = bitcoinRestApi.getRestGetBlockHashByHeight(20799);
        return restGetBlockHashByHeight.toJSONString();
    }

    /**
     * 3
     * @return
     */
    @GetMapping("/getRestBlock")
    public String getRestBlock(){
        JSONObject restBlock = bitcoinRestApi.getRestBlock("0000000000bd883cdf9abf9fc161c383ac1b42f14cd6fb4354196a50230f07cc");
        return restBlock.toJSONString();
    }

    /**
     *
     *1
     * @return
     */
    @GetMapping("/getRestMemPoolInfo")
    public String getRestMemPoolInfo(){
        JSONObject restMemPoolInfo = bitcoinRestApi.getRestMemPoolInfo();
        return restMemPoolInfo.toJSONString();
    }
    /**
     *
     *1
     * @return
     */
    @GetMapping("/getRestTx")
    public String getRestTx(){
        JSONObject restTx = bitcoinRestApi.getRestTx("28e021d33edebe831c985dfcbaabfa13d3cd3f0642a8db3bbd148caaf31bf1ae");
        return restTx.toJSONString();
    }
}
