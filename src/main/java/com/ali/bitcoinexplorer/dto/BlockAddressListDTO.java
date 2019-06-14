package com.ali.bitcoinexplorer.dto;

public class BlockAddressListDTO {
    private String address;
    private String blockhash;
    private Integer numberOfTrades;
    private double totalNum;
    private Integer  finalBTC ;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Integer getNumberOfTrades() {
        return numberOfTrades;
    }

    public void setNumberOfTrades(Integer numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
    }

    public double getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(double totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getFinalBTC() {
        return finalBTC;
    }

    public void setFinalBTC(Integer finalBTC) {
        this.finalBTC = finalBTC;
    }
}
