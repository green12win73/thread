package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;

//深克隆
public class PrototypeDeepClone {
    static class Cellphone implements Cloneable{
        private String brand;
        private ArrayList<String> relationNames = new ArrayList<>();

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void addRelationName(String name){
            this.relationNames.add(name);
        }

        public List<String> getRelationNames(){
            return this.relationNames;
        }

        @Override
        protected Cellphone clone() {
            Cellphone cellphone = null;
            try {
                cellphone = (Cellphone)super.clone();
                cellphone.relationNames = (ArrayList<String>) relationNames.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return cellphone;
        }

        @Override
        public String toString() {
            return "Cellphone{" +
                    "brand='" + brand + '\'' +
                    ", relationNames=" + relationNames.toString() +
                    '}';
        }
    }

    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.setBrand("小米");
        Cellphone clone = cellphone.clone();
        cellphone.addRelationName("张三");
        clone.addRelationName("李四");
        System.out.println(clone.toString());
    }
}
