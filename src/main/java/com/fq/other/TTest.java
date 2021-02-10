package com.fq.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqi
 * @description
 * @date 2021/1/19 10:30
 */
public class TTest {

    public static <T> void p1(List<T> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println("T==》"+list.get(i).getClass().getName());
        }
    }

    public static void p2(List<?> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println("?==》"+list.get(i).getClass().getName());
        }
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add("String===》》》"+i);
        }

        List list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if(i %2==0){
                list2.add(i);
            }else{
                list2.add("String===》》》"+i);
            }
        }

        p1(list2);
        p1(list1);
        System.out.println("============================");
        p2(list2);
        p2(list1);
    }
}
