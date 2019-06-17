package com.ali.bitcoinexplorer.api;

import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpcApi {
    JSONObject getBlockchainInfo() throws Throwable;
}
