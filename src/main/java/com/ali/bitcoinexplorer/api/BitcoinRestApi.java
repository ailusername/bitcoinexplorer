package com.ali.bitcoinexplorer.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BitcoinRestApi",url = "http://localhost:18332")
public interface BitcoinRestApi  {
    @GetMapping("/rest/chaininfo.json")
    JSONObject getBlockChainInfo();


    @GetMapping("/rest/block/notxdetails/{blockhash}.json")
    JSONObject getBlockNotxdetails(@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/block/{blockhash}.json")
    JSONObject getRestBlock(@PathVariable("blockhash") String blockhash);

    @GetMapping ("/rest/headers/{count}/{blockhash}.json")
    JSONArray getRestHeaders(@PathVariable("count") Integer count, @PathVariable("blockhash") String blockhash);

    @GetMapping("/rest/tx/{blockhash}.json")
    JSONObject getRestTx(@PathVariable("blockhash")String blockhash);

    @GetMapping("/rest/getblockhashbyheight/{height}.json")
    JSONObject getRestGetBlockHashByHeight(@PathVariable("height") Integer height);

    ///rest/mempool/contents.json
    @GetMapping("/rest/mempool/info.json")
    JSONObject getRestMemPoolInfo();

    @GetMapping("/rest/mempool/contents.json")
    JSONObject getRestMempooContents();

    @GetMapping("/rest/getutxos/{txid}-{n}.json")
    JSONObject getUTXO(@PathVariable String txid, @PathVariable Integer n);

    @GetMapping("/rest/getutxos/checkmempool/{txid}-{n}.json")
    JSONObject getUTXOCheckMempool(@PathVariable String txid, @PathVariable Integer n);
}
