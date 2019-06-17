package com.ali.bitcoinexplorer.controller;

import com.ali.bitcoinexplorer.api.BitcoinRestApi;
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

    @GetMapping("/getutxo")
    public String  getutxo() throws Throwable {
        JSONObject jsonObject = bitcoinRestApi.getUTXO("c1135b58bece0c2ef8dfdf2a5499d9dadf01c2a1df8fe8eed3fc5a5867d2ba96", 0);
        JSONObject checkMempool = bitcoinRestApi.getUTXOCheckMempool("957ea9495f046f08f356fe3fed7ea7fd58546d1989d0615c6033086719649d8c", 0);
        return null;
    }
}
