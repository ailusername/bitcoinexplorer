package com.ali.bitcoinexplorer.service.impl;

import com.ali.bitcoinexplorer.api.BitcoinRestApi;
import com.ali.bitcoinexplorer.dao.BlockMapper;
import com.ali.bitcoinexplorer.po.Block;
import com.ali.bitcoinexplorer.service.BitcoinService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BitcoinServiceImpl implements BitcoinService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BlockMapper blockMapper;

    @Override
    public void synchrBlock(String blockhash) {
        String provBlockHash = blockhash;
        while (provBlockHash != null && !provBlockHash.isEmpty()) {
            JSONObject restBlock = bitcoinRestApi.getRestBlock(provBlockHash);
            Block block = new Block();
            block.setBlockhash(restBlock.getString("hash"));
            block.setHeight(restBlock.getInteger("height"));
            Long time = restBlock.getLong("time");
            block.setTime(new Date(time * 1000));
            block.setTxsize(restBlock.getShort("nTx"));
            block.setSize(restBlock.getInteger("size"));
            block.setWeight(restBlock.getFloat("weight"));
            block.setDifficulty(restBlock.getDouble("difficulty"));
            block.setPrevBlock(restBlock.getString("previousblockhash"));
            block.setNextBlock(restBlock.getString("nextblockhash"));
            blockMapper.insert(block);
            provBlockHash = block.getNextBlock();
        }
        logger.info("show time end synchr Block ");

    }


}
