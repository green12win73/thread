package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用观察者模式
 */
public class Observer_04 {

    //被观察者
    interface Obserable{
        public void addObserver(Observer observer);
        public void removeObserver(Observer observer);
        public void notifyObservers();
    }

    //观察者
    interface Observer{
        public void action();
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
                this.observers.stream().forEach((e)->e.action());
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
    //客户
    static class Customer implements Observer{
        private String name;
        public Customer(String name){
            this.name = name;
        }
        @Override
        public void action(){
            System.out.println(this.name+" 取走衣服...");
        }
    }

    public static void main(String[] args) {
        Laundry laundry = new Laundry();
        laundry.addObserver(new Customer("张三"));
        laundry.addObserver(new Customer("李四"));
        laundry.addObserver(new Customer("王五"));
        laundry.wrashClothes();
        System.out.println("============================");
        laundry.sewClothes();
    }
}
