package com.zerodk31.myUtils.utils;

import com.zerodk31.myUtils.vo.TestVo;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public class utils {

    /**
     * Data binding from map(snake case) to vo(camel case)
     * @author zerodk31
     */
    public static void map2vo(Map<String, Object> map, Object vo) {
        StringBuilder sb = new StringBuilder();

        for (String mapKey : map.keySet()) {
            sb.setLength(0);
            sb.append("set");
            Arrays.stream(mapKey.split("_")).map(StringUtils::capitalize).forEach(sb::append);

            Method[] methods = vo.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals(sb.toString())) {
                    try {
                        method.invoke(vo, map.get(mapKey));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    /**
     * Data binding from map(snake case) to vo(camel case) (return object)
     * @author zerodk31
     */
    public static Object map2newVo(Map<String, Object> map) {
        TestVo vo = new TestVo();
        StringBuilder sb = new StringBuilder();

        for (String mapKey : map.keySet()) {
            sb.setLength(0);
            sb.append("set");
            Arrays.stream(mapKey.split("_")).map(StringUtils::capitalize).forEach(sb::append);

            Method[] methods = vo.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals(sb.toString())) {
                    try {
                        method.invoke(vo, map.get(mapKey));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return vo;
    }
}
