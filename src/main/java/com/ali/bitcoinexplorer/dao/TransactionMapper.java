package com.ali.bitcoinexplorer.dao;

import com.ali.bitcoinexplorer.dto.TransactionListDTO;
import com.ali.bitcoinexplorer.po.Transaction;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    List<TransactionListDTO> getTransactionList();

}