package com.ali.bitcoinexplorer.service;

import com.ali.bitcoinexplorer.dto.BlockListDTO;
import com.ali.bitcoinexplorer.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockService {
    /***
     * lately  最新的区块
     * @return
     */
    List<BlockListDTO> getLatelyBlocks();

    Block getSearchHeight(@Param("height") Integer target);



}
