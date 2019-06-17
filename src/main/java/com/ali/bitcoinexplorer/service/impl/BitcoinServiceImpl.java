package com.ali.bitcoinexplorer.service.impl;

import com.ali.bitcoinexplorer.api.BitcoinJsonRpcApi;
import com.ali.bitcoinexplorer.service.BitcoinService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BitcoinServiceImpl  implements BitcoinService{
    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @Override
    public String getBlockhashByHeith(Integer heith) throws Throwable {
        JSONObject blockhashByHeight = bitcoinJsonRpcApi.getBlockhashByHeight(heith);
        String result = blockhashByHeight.getString("result");
        return result;
    }
}
