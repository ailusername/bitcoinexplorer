package com.ali.bitcoinexplorer.dao;

import com.ali.bitcoinexplorer.po.TransactionDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionDetailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);

    Double getBalance(@Param("address") String address);

    List<TransactionDetail> selectByAddress(String target);

}