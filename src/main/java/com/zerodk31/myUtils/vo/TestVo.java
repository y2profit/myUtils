package com.zerodk31.myUtils.vo;

import lombok.Data;

@Data
public class TestVo {
    private String stockCode;
    private String stockName;
    private int priceNow;
    private int priceChange;
    private double priceChangeRate;

    public TestVo() {
    }
}