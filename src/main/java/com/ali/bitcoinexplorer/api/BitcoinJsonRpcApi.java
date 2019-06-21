package com.ali.bitcoinexplorer.api;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public interface BitcoinJsonRpcApi {
    JSONObject getBlockchainInfo() throws Throwable;

    JSONObject getBlockByHash(String blockhash) throws Throwable;

    JSONObject getTransactionById(String txid) throws Throwable;

//    JSONObject getUTXO(Boolean isCheckMempool, String txHash, Integer index) throws IOException;

    JSONObject getMempoolContents() throws IOException;


}
