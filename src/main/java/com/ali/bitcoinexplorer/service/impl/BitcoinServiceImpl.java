package com.ali.bitcoinexplorer.service.impl;

import com.ali.bitcoinexplorer.api.BitcoinRestApi;
import com.ali.bitcoinexplorer.dao.BlockMapper;
import com.ali.bitcoinexplorer.dao.TransactionMapper;
import com.ali.bitcoinexplorer.po.Block;
import com.ali.bitcoinexplorer.po.Transaction;
import com.ali.bitcoinexplorer.service.BitcoinService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;

@Service
public class BitcoinServiceImpl implements BitcoinService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionMapper transactionMapper;


    @Override
    @Async
    @Transactional
    public void synchrBlock(String blockhash) {
        String provBlockHash = blockhash;
        while (provBlockHash != null && !provBlockHash.isEmpty()) {
            JSONObject restBlock = bitcoinRestApi.getRestBlock(provBlockHash);
            Block block = new Block();
            block.setBlockhash(restBlock.getString("hash"));
            block.setHeight(restBlock.getInteger("height"));

            Long timestamp = restBlock.getLong("time");
            Date time = new Date(timestamp * 1000);
            block.setTime(time);

            block.setTxsize(restBlock.getShort("nTx"));
            block.setSize(restBlock.getInteger("size"));
            block.setWeight(restBlock.getFloat("weight"));
            block.setDifficulty(restBlock.getDouble("difficulty"));
            block.setPrevBlock(restBlock.getString("previousblockhash"));
            block.setNextBlock(restBlock.getString("nextblockhash"));
            Integer confirmations = restBlock.getInteger("confirmations");
            blockMapper.insert(block);
            JSONArray txArray = restBlock.getJSONArray("tx");
            for (Object tx : txArray) {
                JSONObject jsonObject = new JSONObject((LinkedHashMap) tx);
                syncTx(jsonObject, provBlockHash, time, confirmations);
            }
            provBlockHash = block.getNextBlock();
        }
        logger.info("show time end synchr Block ");

    }

    @Override
    @Transactional
    public void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) {
        Transaction transaction = new Transaction();
        transaction.setTxhash(txJson.getString("txid"));
        transaction.setBlockhash(blockhash);
        transaction.setTime(time);
        transaction.setSize(txJson.getInteger("size"));
        transaction.setWeight(txJson.getFloat("weight"));
        transaction.setConfirmations(confirmations);
        transactionMapper.insert(transaction);

    }


}
