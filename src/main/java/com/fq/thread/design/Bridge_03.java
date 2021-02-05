package com.fq.thread.design;

public class Bridge_03 {
    //厂家
    static abstract class Factory{
        private Product product;

        public Factory(Product product) {
            this.product = product;
        }

        public void order(){
            this.product.product();
            this.product.post();
        }

        public Product getProduct() {
            return product;
        }
    }
    //商品生产流水线
    interface Product{
        public abstract void product();

        public abstract void post();
    }
    //衣服
    static class Clothes implements Product{
        @Override
        public void product() {
            System.out.println("==============生产衣服==============");
        }

        @Override
        public void post() {
            System.out.println("==============邮寄衣服==============");
        }

    }
    //鞋子
    static class Shoes implements Product{
        @Override
        public void product() {
            System.out.println("==============生产鞋子==============");
        }

        @Override
        public void post() {
            System.out.println("==============邮寄鞋子==============");
        }

    }
    //厂商
    static class ProductFactory extends Factory{

        public ProductFactory(Product product) {
            super(product);
        }

        @Override
        public void order() {
            super.order();
            System.out.println("==============做其他事情=============");
        }
    }
    public static void main(String[] args) {
        Factory factory = new ProductFactory(new Clothes());
        factory.order();
    }
}
