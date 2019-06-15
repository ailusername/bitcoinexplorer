package com.ali.bitcoinexplorer.dto;

public class BlockGetDTO {

    private String blockhash;
    private Integer heigth;
    private String prevBlock;
    private String nextBlock;
    private String merkleRoot;
    private Short txSize;
    private Double outputTotal;
    private Double fees;
    private Long time;
    private Double difficulty;
    private Integer sise;


    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Integer getHeigth() {
        return heigth;
    }

    public void setHeigth(Integer heigth) {
        this.heigth = heigth;
    }

    public String getPrevBlock() {
        return prevBlock;
    }

    public void setPrevBlock(String prevBlock) {
        this.prevBlock = prevBlock;
    }

    public String getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(String nextBlock) {
        this.nextBlock = nextBlock;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }

    public Short getTxSize() {
        return txSize;
    }

    public void setTxSize(Short txSize) {
        this.txSize = txSize;
    }

    public Double getOutputTotal() {
        return outputTotal;
    }

    public void setOutputTotal(Double outputTotal) {
        this.outputTotal = outputTotal;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getSise() {
        return sise;
    }

    public void setSise(Integer sise) {
        this.sise = sise;
    }
}
