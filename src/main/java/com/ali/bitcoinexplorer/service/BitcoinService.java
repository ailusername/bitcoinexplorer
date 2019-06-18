package com.ali.bitcoinexplorer.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BitcoinService {

    void synchrBlock(String blockhash);

    void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations);

    //    custom
    void synchrTxDetail(JSONObject txJson);

    void synchrTxDetailVout(JSONArray vouts);

    void synchrTxDetailVin(JSONArray vins);

}
