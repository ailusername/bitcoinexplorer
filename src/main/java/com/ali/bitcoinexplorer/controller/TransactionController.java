package com.ali.bitcoinexplorer.controller;

import com.ali.bitcoinexplorer.dto.BlockListDTO;
import com.ali.bitcoinexplorer.dto.TransactionListDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @GetMapping("/getTransactionList")
    public List<TransactionListDTO> getTransactionList(){
        ArrayList<TransactionListDTO> transactionListDTOS = new ArrayList<>();
        TransactionListDTO transactionListDTO = new TransactionListDTO();
        transactionListDTO.setTsHash("8b134c88b099ba3092b6a6d2ef7770f631802044788fb9b0c51495f278e262fc");
        transactionListDTO.setAge("3minutes");
        transactionListDTO.setAmountUSD("0.01817652");
        transactionListDTO.setAmountUSD("241.02");
        transactionListDTOS.add(transactionListDTO);

        TransactionListDTO transactionListDTO1= new TransactionListDTO();
        transactionListDTO1.setTsHash("f78das88b099ba3092b6a6d2ef7770f631802044788fb9b0c51495f278e262fc");
        transactionListDTO1.setAge("8seconds");
        transactionListDTO1.setAmountUSD("0.01327652");
        transactionListDTO1.setAmountUSD("2.72");
        transactionListDTOS.add(transactionListDTO1);
        return transactionListDTOS;
    }

}
