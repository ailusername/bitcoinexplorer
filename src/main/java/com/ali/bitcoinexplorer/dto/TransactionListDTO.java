package com.ali.bitcoinexplorer.dto;

public class TransactionListDTO {

    private String TsHash;

    private Long age;

    private Double amountBTC;


    public String getTsHash() {
        return TsHash;
    }

    public void setTsHash(String tsHash) {
        TsHash = tsHash;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Double getAmountBTC() {
        return amountBTC;
    }

    public void setAmountBTC(Double amountBTC) {
        this.amountBTC = amountBTC;
    }
}
