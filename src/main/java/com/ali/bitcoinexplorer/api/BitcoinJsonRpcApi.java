package com.ali.bitcoinexplorer.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface BitcoinJsonRpcApi {
    JSONObject getBlockchainInfo() throws Throwable;

    JSONObject getBlockByHash(String blockhash) throws Throwable;


    JSONObject getTransactionById(String txid) throws Throwable;


    JSONObject getBlockhashByHeight(Integer height) throws Throwable;

}
