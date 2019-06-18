package com.ali.bitcoinexplorer.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BitcoinService {

    void synchrBlock(String blockhash);

    void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations);

}
