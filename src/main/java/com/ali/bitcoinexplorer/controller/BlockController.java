package com.ali.bitcoinexplorer.controller;

import com.ali.bitcoinexplorer.dto.BlockGetDTO;
import com.ali.bitcoinexplorer.dto.BlockListDTO;
import com.ali.bitcoinexplorer.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private BlockService blockService;

    @GetMapping("/getLatelyBlocks")
    public List<BlockListDTO> getLatelyBlocks() {
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();

//
//        BlockListDTO blockListDTO = new BlockListDTO();
//        blockListDTO.setBlockhash("0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8");
//        blockListDTO.setHeight(580689);
//        blockListDTO.setTime(new Date());
//        blockListDTO.setTxsize((short)1818);
//        blockListDTO.setSize(1115746);
//        blockListDTOS.add(blockListDTO);
//
//        BlockListDTO blockListDTO1 = new BlockListDTO();
//        blockListDTO1.setBlockhash("000000000000000000119eed9e97a87ae33a6b04a504daecab57b5fdf90ab807");
//        blockListDTO1.setHeight(580658);
//        blockListDTO1.setTime(new Date());
//        blockListDTO1.setTxsize((short)1314);
//        blockListDTO1.setSize(1235746);
//        blockListDTOS.add(blockListDTO1);
//        return blockListDTOS;
        List<BlockListDTO> recentBlocks = blockService.getLatelyBlocks();
        return recentBlocks;
    }

    @GetMapping("/getBlockhash")
    public BlockGetDTO getBlockhash(@RequestParam String blockhash){
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("0000000000000000001977cc76a51d81f9dbcda92f05c17ae649423c8ae5857f");
        blockGetDTO.setHeigth(580582);
        blockGetDTO.setPrevBlock("000000000000000000062da626194c52e82547cb36e0e713efdb9c9214516aad");
        blockGetDTO.setNextBlock("00000000000000000011723cc650765b9788f9b193d938f49e200569e9b03941");
        blockGetDTO.setMerkleRoot("76ccc53957b99aa552a019ce93de939d2f5a6e5ee4f01161aa335f71ae73500e");
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setFees(0.49897166);
        blockGetDTO.setTxSize((short)1200.753);
        blockGetDTO.setDifficulty(7459680720542.3);
        blockGetDTO.setSise(2455);
        blockGetDTO.setOutputTotal(4411.45080838);
        return blockGetDTO;
    }

    @GetMapping("/getByHeight")
    public BlockGetDTO getByHeight(@RequestParam Integer height){
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("0000000000000000001977cc76a51d81f9dbcda92f05c17ae649423c8ae5857f");
        blockGetDTO.setHeigth(580582);
        blockGetDTO.setPrevBlock("000000000000000000062da626194c52e82547cb36e0e713efdb9c9214516aad");
        blockGetDTO.setNextBlock("00000000000000000011723cc650765b9788f9b193d938f49e200569e9b03941");
        blockGetDTO.setMerkleRoot("76ccc53957b99aa552a019ce93de939d2f5a6e5ee4f01161aa335f71ae73500e");
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setFees(0.49897166);
        blockGetDTO.setTxSize((short)1200.753);
        blockGetDTO.setDifficulty(7459680720542.3);
        blockGetDTO.setSise(2455);
        blockGetDTO.setOutputTotal(4411.45080838);
        return blockGetDTO;
    }



//    @GetMapping("/getByAddress")
//    public BlockAddressListDTO getByAddress(@RequestParam String address){
//        BlockAddressListDTO blockAddressListDTO = new BlockAddressListDTO();
//        blockAddressListDTO.setAddress("1Ckc9bQWux4NhaqDiFspuhzb3zn7D3uqAU");
//        blockAddressListDTO.setBlockhash("80e89c34ffdd94f03f3af401b99505ad2807b8e5");
//        blockAddressListDTO.setNumberOfTrades(14);
//        blockAddressListDTO.setTotalNum(0.09691501);
//        blockAddressListDTO.setFinalBTC(0);
//
//        return blockAddressListDTO;
//    }

//    @GetMapping("/getByess")
//    public BlockAddressListDTO getByess(@RequestParam String address){
//        return null;
//    }

}
