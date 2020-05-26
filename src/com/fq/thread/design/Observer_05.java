package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用观察者模式
 */
public class Observer_05 {

    //被观察者
    interface Obserable{
        public void addObserver(Observer observer);
        public void removeObserver(Observer observer);
        public void notifyObservers();
    }

    //观察者
    interface Observer{
        public void action(Obserable obserable);
    }

    //洗衣店
    static class Laundry implements Obserable{
        private List<Observer> observers = new ArrayList<>();

        @Override
        public void addObserver(Observer observer){
            this.observers.add(observer);
        }
        @Override
        public void removeObserver(Observer observer){
            this.observers.remove(observer);
        }
        @Override
        public void notifyObservers(){
            if(null!=this.observers && this.observers.size()>0){
                this.observers.stream().forEach((e)->e.action(this));
            }
        }

        public void wrashClothes(){
            System.out.println("衣服洗好了！");
            this.notifyObservers();
        }

        public void sewClothes(){
            System.out.println("衣服缝合好了！");
            this.notifyObservers();
        }

    }
    //快递
    static class Expressage implements Obserable{

        private List<Observer> observers = new ArrayList<>();

        @Override
        public void addObserver(Observer observer){
            this.observers.add(observer);
        }
        @Override
        public void removeObserver(Observer observer){
            this.observers.remove(observer);
        }
        @Override
        public void notifyObservers(){
            if(null!=this.observers && this.observers.size()>0){
                this.observers.stream().forEach((e)->e.action(this));
            }
        }

        public void arrived(){
            System.out.println("快递已经到达，请尽快领取...");
            this.notifyObservers();
        }
    }
    //银行
    static class Bank implements Obserable{

        private List<Observer> observers = new ArrayList<>();

        @Override
        public void addObserver(Observer observer){
            this.observers.add(observer);
        }
        @Override
        public void removeObserver(Observer observer){
            this.observers.remove(observer);
        }
        @Override
        public void notifyObservers(){
            if(null!=this.observers && this.observers.size()>0){
                this.observers.stream().forEach((e)->e.action(this));
            }
        }

        public void transfer(){
            System.out.println("银行转账20元已经到账...");
            this.notifyObservers();
        }
    }

    //客户
    static class Customer implements Observer{
        private String name;
        public Customer(String name){
            this.name = name;
        }
        @Override
        public void action(Obserable obserable){
            if(obserable.getClass().isAssignableFrom(Bank.class)){
                System.out.println("转账终于到了，好开心...");
            }else if(obserable.getClass().isAssignableFrom(Expressage.class)){
                System.out.println("取快递去了...");
            }else if(obserable.getClass().isAssignableFrom(Laundry.class)) {
                System.out.println(this.name + " 取走衣服...");
            }
        }
    }

    public static void main(String[] args) {
        Customer customer = new Customer("张三");
        Laundry laundry = new Laundry();
        laundry.addObserver(customer);
        Bank bank = new Bank();
        bank.addObserver(customer);
        Expressage expressage = new Expressage();
        expressage.addObserver(customer);
        laundry.wrashClothes();
        System.out.println("============================");
        bank.transfer();
        System.out.println("============================");
        expressage.arrived();
    }
}
