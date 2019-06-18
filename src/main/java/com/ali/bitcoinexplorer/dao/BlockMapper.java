package com.ali.bitcoinexplorer.dao;

import com.ali.bitcoinexplorer.dto.BlockListDTO;
import com.ali.bitcoinexplorer.po.Block;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    //    ----------------
    List<Block> selectLatelyBlocks();

}