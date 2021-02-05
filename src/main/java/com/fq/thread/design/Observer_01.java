package com.fq.thread.design;

/**
 * 不使用观察者模式
 */
public class Observer_01 {

    //洗衣店
    static class Laundry{
        public void wrashClothes(){
            System.out.println("衣服洗好了！");
        }

        public void sewClothes(){
            System.out.println("衣服缝合好了！");
        }

    }
    //客户A
    static class Customer{
        private String name;
        public Customer(String name){
            this.name = name;
        }
        public void take(){
            System.out.println(this.name+" 取走衣服...");
        }
    }

    public static void main(String[] args) {
        Laundry laundry = new Laundry();
        Customer customer = new Customer("张三");
        laundry.wrashClothes();
        customer.take();
        System.out.println("============================");
        laundry.sewClothes();
        customer.take();
    }
}
