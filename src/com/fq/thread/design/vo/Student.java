package com.fq.thread.design.vo;

public class Student implements IPerson {
    @Override
    public void doSomething() {
        System.out.println("=========我是學生，我要去學習==========");
    }
}
