package com.ali.bitcoinexplorer.api.impl;

import com.ali.bitcoinexplorer.api.BitcoinJsonRpcApi;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Component
public class BitcoinJsonRpcApiImpl implements BitcoinJsonRpcApi {


    private JsonRpcHttpClient jsonRpcHttpClient;


    private Retrofit retrofit;


    private BitcoinJsonRpcApi bitcoinJsonRpcApi;

    public BitcoinJsonRpcApiImpl(@Value("${bitcoin.jsonrpc.username}") String username,
                                 @Value("${bitcoin.jsonrpc.password}")String password,
                                 @Value("${bitcoin.jsonrpc.url}")String url) throws MalformedURLException {
        HashMap<String, String> headers = new HashMap<>();
        String authStrOrig = String.format("%s:%s","zf","123456");
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authStrResult = String.format("Basic %s",authStr);
        headers.put("Authorization",authStrResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL("http://localhost:18332"),headers);
    }

    @Override
    public JSONObject getBlockchainInfo() throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);
        return jsonObject;
    }



    @Override
    public JSONObject getBlockByHash(String blockhash) throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getblock", new Object[]{blockhash}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONObject getTransactionById(String txid) throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONObject getMempoolContents() throws IOException {
        Call<JSONObject> call = (Call<JSONObject>) bitcoinJsonRpcApi.getMempoolContents();
        Response<JSONObject> response = call.execute();
        JSONObject body = response.body();
        return body;
    }

}
