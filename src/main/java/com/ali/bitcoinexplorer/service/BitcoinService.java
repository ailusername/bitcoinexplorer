package com.ali.bitcoinexplorer.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BitcoinService {

    void syncBlockchainFromHash(String blockhash) throws Throwable;

    String synchrBlock(String blockhash) throws Throwable;

    void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) throws Throwable;
    //    custom
    void synchrTxDetail(JSONObject txJson, String txid) throws Throwable;

    void synchrTxDetailVout(JSONArray vouts, String txid);

    void synchrTxDetailVin(JSONArray vins, String txid) throws Throwable;

}
