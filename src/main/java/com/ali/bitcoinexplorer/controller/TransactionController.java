package com.ali.bitcoinexplorer.controller;

import com.ali.bitcoinexplorer.api.BitcoinJsonRpcApi;
import com.ali.bitcoinexplorer.dto.BlockListDTO;
import com.ali.bitcoinexplorer.dto.TransactionListDTO;
import com.ali.bitcoinexplorer.service.TransactionService;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("/transaction")
@Validated
@CrossOrigin
public class TransactionController {


    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getTransactionList")
    public List<TransactionListDTO> getTransactionList(){
        List<TransactionListDTO> transactionList = transactionService.getTransactionList();

        return transactionList;
    }

    @GetMapping("/getLatestTransactionsInMempool")
    public List<JSONObject> getLatestTransactionsInMempool() throws IOException, IOException {
        JSONObject transactionsOrigin = bitcoinJsonRpcApi.getMempoolContents();
        Set<Map.Entry<String, Object>> entries = transactionsOrigin.entrySet();
        ArrayList<JSONObject> transactions = new ArrayList<>();
        for (Map.Entry<String, Object> entry :
                entries) {
            JSONObject transaction = new JSONObject();
            transaction.put("txid", entry.getKey());
            JSONObject value = (JSONObject) entry.getValue();
            Long time = value.getLong("time");
            transaction.put("timestamp", time);
            transaction.put("time", new Date(time * 1000));
            transaction.put("fee", value.getDouble("fee"));
            transactions.add(transaction);
        }

        transactions.sort((x, y) -> {
            Long xtime = x.getLong("timestamp");
            Long ytime = y.getLong("timestamp");
            return (int) (ytime - xtime);
        });
        return transactions;
    }
}
