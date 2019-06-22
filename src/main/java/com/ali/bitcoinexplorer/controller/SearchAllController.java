package com.ali.bitcoinexplorer.controller;

import com.ali.bitcoinexplorer.dao.BlockMapper;
import com.ali.bitcoinexplorer.dao.TransactionDetailMapper;
import com.ali.bitcoinexplorer.dao.TransactionMapper;
import com.ali.bitcoinexplorer.po.Block;
import com.ali.bitcoinexplorer.po.Transaction;
import com.ali.bitcoinexplorer.po.TransactionDetail;
import com.ali.bitcoinexplorer.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.bouncycastle.crypto.tls.CipherType.block;


@RestController
@RequestMapping("/search")
@EnableAutoConfiguration
@CrossOrigin


public class SearchAllController {


    @Autowired
    private BlockService blockService;


    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    @GetMapping("/getByHeight")
    public Object getByHeight(@RequestParam String target) {
//        Block searchHeight = blockService.getSearchHeight(Integer.parseInt(target));
//        Block block = blockMapper.selectByPrimaryKey(target);
        if (target.length() <= 7) {
            Block searchHeight = blockService.getSearchHeight(Integer.parseInt(target));
            return searchHeight;
        } else if (target.length() == 64) {
            String result = "^[0]{5,}.*$";
            if (target.matches(result)) {
                Block block = blockMapper.selectByPrimaryKey(target);
                return block;
            } else {
                List<TransactionDetail> transactionDetails = transactionDetailMapper.selectByAddress(target);
                return transactionDetails;
            }
        } else {
            Transaction transaction = transactionMapper.selectByPrimaryKey(target);
            return transaction;
        }
    }
}
