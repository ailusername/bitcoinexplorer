package com.ali.bitcoinexplorer.service;

import com.ali.bitcoinexplorer.dto.TransactionListDTO;

import java.util.List;

public interface TransactionService {

    List<TransactionListDTO> getTransactionList();
}
