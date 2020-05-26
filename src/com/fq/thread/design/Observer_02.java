package com.fq.thread.design;

/**
 * 不使用观察者模式
 */
public class Observer_02 {

    //洗衣店
    static class Laundry{
        private Customer zhangsan;
        public Laundry(Customer zhangsan){
            this.zhangsan = zhangsan;
        }

        public void wrashClothes(){
            System.out.println("衣服洗好了！");
            this.zhangsan.take();
        }

        public void sewClothes(){
            System.out.println("衣服缝合好了！");
            this.zhangsan.take();
        }

    }
    //客户
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
        Laundry laundry = new Laundry(new Customer("张三"));
        laundry.wrashClothes();
        System.out.println("============================");
        laundry.sewClothes();
    }
}
