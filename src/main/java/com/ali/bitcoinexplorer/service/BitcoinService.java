package com.ali.bitcoinexplorer.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BitcoinService {

    void synchrBlock(String blockhash);

    void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations);
    //    custom
    void synchrTxDetail(JSONObject txJson, String txHash);

    void synchrTxDetailVout(JSONArray vouts, String txHash);

    void synchrTxDetailVin(JSONArray vins, String txHash);

}
