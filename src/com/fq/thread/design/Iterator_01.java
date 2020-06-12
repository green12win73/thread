package com.fq.thread.design;

public class Iterator_01 {

    static class Item{
        private String name;

        public Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Item[] itemArr = {new Item("1"),new Item("2"),new Item("3")};
        for (int i = 0; i < itemArr.length; i++) {
            System.out.println(itemArr[i].getName());
        }
    }
}
