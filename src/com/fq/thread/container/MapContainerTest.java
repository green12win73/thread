package com.fq.thread.container;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author fangqi
 * @description
 * @date 2020/6/5 14:23
 */
public class MapContainerTest {

    public static void main(String[] args) {
//        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < 10; i++) {
//            map.put("map_"+i,i);
//        }

//        testIdentityHashMap();
        HashMap<Object, Object> hashMap = new HashMap<>(8);
        System.out.println(15&hash("test_1"));
        System.out.println(15&hash("test_2"));
        System.out.println(15&hash("test_3"));
        System.out.println(15&hash("fasdfa"));
        System.out.println(15&hash("rty"));
    }

    public static final int hash(Object key) {
        int h = key.hashCode();
        int k = h >>> 16;
        System.out.println("======h="+h+"=======");
        System.out.println("======k="+k+"=======");
        return h^k;
    }

    public static void testIdentityHashMap(){
        Map<String, Integer> hashMap = new IdentityHashMap<>();
        for (int i = 0; i < 100; i++) {
            if(i==64){
                System.out.println();
            }
            hashMap.put("skip_key_"+i, i);
        }
        System.out.println("=======================");

    }

    public static void testLinkedHashMap(){
        Map<String, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < 100; i++) {
            if(i==64){
                System.out.println();
            }
            hashMap.put("skip_key_"+i, i);
        }
        System.out.println("=======================");

    }

    public static void testHashMap(){
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            if(i==64){
                System.out.println();
            }
            hashMap.put("skip_key_"+i, i);
        }
        System.out.println("=======================");

    }


    public static void testSkipList(){
        ConcurrentSkipListMap<String, Integer> skipListMap = new ConcurrentSkipListMap<>();
        for (int i = 0; i < 300; i++) {
            skipListMap.put("skip_key_"+i, i);
        }
        System.out.println("=======================");

    }

    public static void test(){
        Index[] arr = new Index[11];
        Index idx = null;
        for (int i = 0; i < 10; i++) {
            arr[i] = idx = new Index(idx);
        }
        System.out.println("==============");
    }

    static class Index{
        private Index index;
        public Index(Index index) {
            this.index = index;
        }
    }
}
