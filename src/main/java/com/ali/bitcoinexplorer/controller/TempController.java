package com.ali.bitcoinexplorer.controller;

import com.ali.bitcoinexplorer.api.BitcoinRestApi;
import com.ali.bitcoinexplorer.dao.BlockMapper;
import com.ali.bitcoinexplorer.service.BitcoinService;
import com.alibaba.fastjson.JSONArray;
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

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private BitcoinService bitcoinService;

    @GetMapping("/synchrBlock")
    public String synchrBlock() throws Throwable {
        String provBlockHash = "00000000000000af3bf6e396a265c9266f8a47611b0714b92cd1c4048b7f1f62";
        bitcoinService.synchrBlock(provBlockHash);
        return null;
    }

    @GetMapping("/provBlockHash")
    public String provBlockHash() throws Throwable {
        String provBlockHash = "0000000000029f08ac10391dba1a70db8049efac60f2596715b0c13694744167";
        bitcoinService.synchrBlock(provBlockHash);
        return null;
    }

    @GetMapping("/txBlockHash")
    public String txBlockHash() throws Throwable {
        String txBlockHash = "0000000000000f9b0410f69ccdf1521647fd03e0e2703bca7659d0f196f2dc8f";
        bitcoinService.synchrBlock(txBlockHash);
        return null;
    }
















    /**
     *
     * @return
     */
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
     *
     * @return
     */

    @GetMapping("/getBlockNotxdetails")
    public String getBlockNotxdetails(){
        JSONObject blockNotxdetails = bitcoinRestApi.getBlockNotxdetails("0000000000bd883cdf9abf9fc161c383ac1b42f14cd6fb4354196a50230f07cc");
        return blockNotxdetails.toJSONString();
    }

    /**
     *
     * @return
     */
    @GetMapping("/getHeaders")
    public JSONArray getRestHeaders(){
        JSONArray restHeaders = bitcoinRestApi.getRestHeaders(6,"0000000000fc17f0e6f986fdaf4d2e206b3ddcbdc8866fb1a8fe6a7277df57b8");
        return restHeaders;
    }

    /**
     *
     * @return
     */

    @GetMapping("/getRestGetBlockHashByHeight")
    public String getRestGetBlockHashByHeight(){
        JSONObject restGetBlockHashByHeight = bitcoinRestApi.getRestGetBlockHashByHeight(20799);
        return restGetBlockHashByHeight.toJSONString();
    }

    /**
     *
     * @return
     */
    @GetMapping("/getRestBlock")
    public String getRestBlock(){
        JSONObject restBlock = bitcoinRestApi.getRestBlock("0000000000bd883cdf9abf9fc161c383ac1b42f14cd6fb4354196a50230f07cc");
        return restBlock.toJSONString();
    }

    /**
     *
     *
     * @return
     */
    @GetMapping("/getRestMemPoolInfo")
    public String getRestMemPoolInfo(){
        JSONObject restMemPoolInfo = bitcoinRestApi.getRestMemPoolInfo();
        return restMemPoolInfo.toJSONString();
    }
    /**
     *
     *
     * @return
     */
    @GetMapping("/getRestTx")
    public String getRestTx(){
        JSONObject restTx = bitcoinRestApi.getRestTx("28e021d33edebe831c985dfcbaabfa13d3cd3f0642a8db3bbd148caaf31bf1ae");
        return restTx.toJSONString();
    }


}
