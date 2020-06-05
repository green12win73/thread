package com.fq.thread.container;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fangqi
 * @description
 * @date 2020/6/5 14:23
 */
public class MapContainerTest {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("map_"+i,i);
        }
    }
}
