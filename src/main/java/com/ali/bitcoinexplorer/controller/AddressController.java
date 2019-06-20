package com.ali.bitcoinexplorer.controller;

import com.ali.bitcoinexplorer.dao.TransactionDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    @GetMapping("/getBalance")
    public Double getbalance(@RequestParam String address) {
        Double balance = transactionDetailMapper.getBalance(address);
        return balance;
    }

}
