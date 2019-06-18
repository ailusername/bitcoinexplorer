package com.ali.bitcoinexplorer.service.impl;

import com.ali.bitcoinexplorer.dao.BlockMapper;
import com.ali.bitcoinexplorer.dto.BlockListDTO;
import com.ali.bitcoinexplorer.po.Block;
import com.ali.bitcoinexplorer.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

    @Override
    public List<BlockListDTO> getLatelyBlocks() {
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();

        List<Block> blocks = blockMapper.selectLatelyBlocks();

        for (Block block : blocks) {
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setBlockhash(block.getBlockhash());
            blockListDTO.setHeight(block.getHeight());
            blockListDTO.setTime(block.getTime().getTime());
            blockListDTO.setTxsize(block.getTxsize());
            blockListDTO.setSize(block.getSize());
            blockListDTOS.add(blockListDTO);
        }
        return blockListDTOS;
    }
}
