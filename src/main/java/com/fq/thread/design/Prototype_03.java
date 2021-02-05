package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Prototype_03 {
    //手机
    static class Cellphone implements Cloneable{
        private String brand;//品牌
        private String model;//型号
        private String serialNum;//唯一编号
        private double price;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getSerialNum() {
            return serialNum;
        }

        public void setSerialNum(String serialNum) {
            this.serialNum = serialNum;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Cellphone{" +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", serialNum='" + serialNum + '\'' +
                    ", price=" + price +
                    '}';
        }
        @Override
        public Cellphone clone(){
            Cellphone cellphone = null;
            try {
                cellphone = (Cellphone)super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return cellphone;
        }
    }

    public static void main(String[] args) {
        List<Cellphone> cellphones = new ArrayList<>();
        Cellphone cellphone = new Cellphone();
        cellphone.setBrand("小米");
        cellphone.setModel("MAX 10");
        cellphone.setPrice(1800);
        cellphone.setSerialNum(UUID.randomUUID().toString());
        //下面要求生产十台相同型号的小米手机(每台机器的序列号都是唯一的)
        for (int i = 0; i < 10; i++) {
            Cellphone clone = cellphone.clone();
            clone.setSerialNum(UUID.randomUUID().toString());
            System.out.println(clone.toString());
            cellphones.add(clone);
        }
    }
}
