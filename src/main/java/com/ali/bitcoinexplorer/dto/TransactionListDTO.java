package com.ali.bitcoinexplorer.dto;

public class TransactionListDTO {

    private String TsHash;

    private String age;

    private  double amountBTC;

    private  String amountUSD;

    public String getTsHash() {
        return TsHash;
    }

    public void setTsHash(String tsHash) {
        TsHash = tsHash;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public double getAmountBTC() {
        return amountBTC;
    }

    public void setAmountBTC(double amountBTC) {
        this.amountBTC = amountBTC;
    }

    public String getAmountUSD() {
        return amountUSD;
    }

    public void setAmountUSD(String amountUSD) {
        this.amountUSD = amountUSD;
    }
}
