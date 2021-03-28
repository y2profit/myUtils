package com.zerodk31.myUtils;

import com.zerodk31.myUtils.utils.utils;
import com.zerodk31.myUtils.vo.TestVo;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class utilsTest {

    @Test
    public void map2voTest() {
        // given
        HashMap<String, Object> fromMap = new HashMap<>();
        fromMap.put("stock_code", "005930");
        fromMap.put("stock_name", "삼성전자");
        fromMap.put("price_now", 81500);
        fromMap.put("price_change", 300);
        fromMap.put("price_change_rate", 0.37);

        TestVo toVo = new TestVo();

        // when
        utils.map2vo(fromMap, toVo);

        // then
        System.out.println("toVo.toString() = " + toVo.toString());
        assertThat(fromMap.get("stock_code").equals(toVo.getStockCode())
                        && fromMap.get("stock_name").equals(toVo.getStockName())
                        && fromMap.get("price_now").equals(toVo.getPriceNow())
                        && fromMap.get("price_change").equals(toVo.getPriceChange())
                        && fromMap.get("price_change_rate").equals(toVo.getPriceChangeRate())
        );
    }
}
