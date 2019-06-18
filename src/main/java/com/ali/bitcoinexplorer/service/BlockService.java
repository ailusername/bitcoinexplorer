package com.ali.bitcoinexplorer.service;

import com.ali.bitcoinexplorer.dto.BlockListDTO;

import java.util.List;

public interface BlockService {
    /***
     * lately  最新的区块
     * @return
     */
    List<BlockListDTO> getLatelyBlocks();
}
