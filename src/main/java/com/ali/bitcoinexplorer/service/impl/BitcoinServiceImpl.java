package com.ali.bitcoinexplorer.service.impl;

import com.ali.bitcoinexplorer.api.BitcoinJsonRpcApi;
import com.ali.bitcoinexplorer.api.BitcoinRestApi;
import com.ali.bitcoinexplorer.dao.BlockMapper;
import com.ali.bitcoinexplorer.dao.TransactionDetailMapper;
import com.ali.bitcoinexplorer.dao.TransactionMapper;
import com.ali.bitcoinexplorer.dto.BlockListDTO;
import com.ali.bitcoinexplorer.enumeration.TxDetailType;
import com.ali.bitcoinexplorer.po.Block;
import com.ali.bitcoinexplorer.po.Transaction;
import com.ali.bitcoinexplorer.po.TransactionDetail;
import com.ali.bitcoinexplorer.service.BitcoinService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BitcoinServiceImpl implements BitcoinService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @Override
    @Async
    @Transactional
    public void synchrBlock(String blockhash) throws Throwable {
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
    public void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) throws Throwable {
        Transaction transaction = new Transaction();
        String txid = txJson.getString("txid");
        transaction.setTxhash(txid);
        transaction.setBlockhash(blockhash);
        transaction.setTime(time);
        transaction.setSize(txJson.getInteger("size"));
        transaction.setWeight(txJson.getFloat("weight"));
        transaction.setConfirmations(confirmations);
        transactionMapper.insert(transaction);


        synchrTxDetail(txJson, txid);
    }


    @Override
    public void synchrTxDetail(JSONObject txJson, String txid) throws Throwable {
        JSONArray vouts = txJson.getJSONArray("vout");
        synchrTxDetailVout(vouts, txid);
        JSONArray vins = txJson.getJSONArray("vin");
        synchrTxDetailVin(vins, txid);
    }

    @Override
    @Transactional
    public void synchrTxDetailVout(JSONArray vouts, String txid) {
        for (Object voutObj : vouts) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) voutObj);
            TransactionDetail txDetail = new TransactionDetail();
            txDetail.setAmount(jsonObject.getDouble("value"));
            txDetail.setTxhash(txid);
            txDetail.setType((byte) TxDetailType.Receive.ordinal());
            JSONObject scriptPubKey = jsonObject.getJSONObject("scriptPubKey");
            JSONArray addresses = scriptPubKey.getJSONArray("addresses");
            if (addresses != null) {
                String address = addresses.getString(0);
                txDetail.setAddress(address);
            }
            transactionDetailMapper.insert(txDetail);
            }
        }


    @Override
    @Transactional
    public void synchrTxDetailVin(JSONArray vins, String txid) throws Throwable {
        for (Object vinObj : vins) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vinObj);
            String vinTxid = jsonObject.getString("txid");
            Integer n = jsonObject.getInteger("vout");
            if (vinTxid != null) {
                JSONObject vinTxJson = bitcoinJsonRpcApi.getTransactionById(vinTxid);
                JSONArray vouts = vinTxJson.getJSONArray("vout");
                JSONObject utxoJson = vouts.getJSONObject(n);

                TransactionDetail txDetail = new TransactionDetail();
                txDetail.setAmount(-utxoJson.getDouble("value"));
                txDetail.setTxhash(txid);
                txDetail.setType((byte) TxDetailType.Send.ordinal());
                JSONObject scriptPubKey = utxoJson.getJSONObject("scriptPubKey");
                JSONArray addresses = scriptPubKey.getJSONArray("addresses");
                if (addresses != null) {
                    String address = addresses.getString(0);
                    txDetail.setAddress(address);
                }
                transactionDetailMapper.insert(txDetail);
            }
        }
//custom

    }
}
