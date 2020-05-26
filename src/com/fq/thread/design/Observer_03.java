package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 不使用观察者模式
 */
public class Observer_03 {

    //洗衣店
    static class Laundry{
        private List<Customer> customers = new ArrayList<>();

        public void addCustomer(Customer customer){
            this.customers.add(customer);
        }

        public void wrashClothes(){
            System.out.println("衣服洗好了！");
            this.notifyCustomers();
        }

        public void sewClothes(){
            System.out.println("衣服缝合好了！");
            this.notifyCustomers();
        }

        private void notifyCustomers(){
            if(null!=this.customers && this.customers.size()>0){
                this.customers.stream().forEach((e)->e.take());
            }
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
        Laundry laundry = new Laundry();
        laundry.addCustomer(new Customer("张三"));
        laundry.addCustomer(new Customer("李四"));
        laundry.addCustomer(new Customer("王五"));
        laundry.wrashClothes();
        System.out.println("============================");
        laundry.sewClothes();
    }
}
