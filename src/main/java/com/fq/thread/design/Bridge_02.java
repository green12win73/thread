package com.fq.thread.design;

public class Bridge_02 {

    static abstract class Product{

        public abstract void product();

        public abstract void post();

        public void order(){
            this.product();
            this.post();
        }
    }
    //衣服
    static class Clothes extends Product{
        @Override
        public void product() {
            System.out.println("==============生产衣服==============");
        }

        @Override
        public void post() {
            System.out.println("==============邮寄衣服==============");
        }

        @Override
        public void order() {
            System.out.println("==============衣服下单==============");
            super.order();
        }
    }
    //鞋子
    static class Shoes extends Product{
        @Override
        public void product() {
            System.out.println("==============生产鞋子==============");
        }

        @Override
        public void post() {
            System.out.println("==============邮寄鞋子==============");
        }

        @Override
        public void order() {
            System.out.println("==============鞋子下单==============");
            super.order();
        }
    }
    //鞋子和衣服厂商
    static class ShoesAndClothes extends Product{
        private Product product;

        public ShoesAndClothes(Product product) {
            this.product = product;
        }

        @Override
        public void product() {
            this.product.product();
        }

        @Override
        public void post() {
            this.product.post();
        }

        @Override
        public void order() {
            this.product.order();
        }
    }
    public static void main(String[] args) {
        //购买鞋子
        ShoesAndClothes shoesAndClothes = new ShoesAndClothes(new Shoes());
        shoesAndClothes.order();
        System.out.println("-----------------------------------");
        //购买鞋子
        shoesAndClothes = new ShoesAndClothes(new Clothes());
        shoesAndClothes.order();
    }
}
