package com.ali.bitcoinexplorer.service.impl;

import com.ali.bitcoinexplorer.dao.TransactionMapper;
import com.ali.bitcoinexplorer.dto.TransactionListDTO;
import com.ali.bitcoinexplorer.po.Transaction;
import com.ali.bitcoinexplorer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public List<TransactionListDTO> getTransactionList() {
        ArrayList<TransactionListDTO> transactionListDTO = new ArrayList<>();
        List<Transaction> transactionList = transactionMapper.getTransactionList1();
        for (Transaction transaction : transactionList) {

            TransactionListDTO trListdto = new TransactionListDTO();

            trListdto.setTsHash(transaction.getTxhash());
            trListdto.setAge(transaction.getTime().getTime());
            trListdto.setAmountBTC(transaction.getAmount());

            transactionListDTO.add(trListdto);
        }
        return transactionListDTO;
    }
}
