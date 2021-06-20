package com.zerodk31.myUtils.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class ValidVo {

    @Size(max = 6, message = "종목코드는 6자 이하로 설정해주세요.")
    private String stockCode;

    @Min(value = 0, message = "0보다 큰값을 입력해주세요.")
    private int price;
}
