package com.fq.thread;

/**
 * @author fangqi
 * @description
 * @date 2020/6/17 16:48
 */
public class ReferenceOfStrongReference {

    static class Strong {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
//        System.gc();
//        System.out.println("========================");
//        Strong strong = new Strong();
//        strong.setName("张三");
//        System.gc();
//
//        strong = null;
//        System.out.println("======================");
//        System.gc();
    }
}
