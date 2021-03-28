package com.zerodk31.myUtils;

import com.zerodk31.myUtils.utils.utils;
import com.zerodk31.myUtils.vo.TestVo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println("fromMap.toString() = " + fromMap.toString());
        System.out.println("toVo.toString() = " + toVo.toString());
        assertThat(isEqualMapAndVo(fromMap, toVo)).isEqualTo(true);
    }

    @Test
    public void map2newVoTest() {
        // given
        HashMap<String, Object> fromMap1 = new HashMap<>();
        fromMap1.put("stock_code", "005930");
        fromMap1.put("stock_name", "삼성전자");
        fromMap1.put("price_now", 81500);
        fromMap1.put("price_change", 300);
        fromMap1.put("price_change_rate", 0.37);

        HashMap<String, Object> fromMap2 = new HashMap<>();
        fromMap2.put("stock_code", "000660");
        fromMap2.put("stock_name", "SK하이닉스");
        fromMap2.put("price_now", 135000);
        fromMap2.put("price_change", 2000);
        fromMap2.put("price_change_rate", 1.5);

        ArrayList<HashMap<String, Object>> fromList = new ArrayList<>();
        fromList.add(fromMap1);
        fromList.add(fromMap2);

        ArrayList<TestVo> toList = new ArrayList<>();
        fromList.stream().map(utils::map2newVo).forEach(vo -> toList.add((TestVo) vo));

        fromList.forEach(stock -> System.out.println(stock.toString()));
        toList.forEach(stock -> System.out.println(stock.toString()));

        boolean isEqual = true;
        for(int i=0; i<fromList.size(); i++) {
            isEqual = isEqual && isEqualMapAndVo(fromList.get(i), toList.get(i));
            assertThat(isEqual).isEqualTo(true);
        }
    }

    public boolean isEqualMapAndVo(Map<String, Object> map, TestVo vo) {
        return map.get("stock_code").equals(vo.getStockCode())
                && map.get("stock_name").equals(vo.getStockName())
                && map.get("price_now").equals(vo.getPriceNow())
                && map.get("price_change").equals(vo.getPriceChange())
                && map.get("price_change_rate").equals(vo.getPriceChangeRate());
    }
}
