package com.fq.thread.design.vo;

public class Teacher implements IPerson {
    @Override
    public void doSomething() {
        System.out.println("===========我是老師，要去上課==========");
    }
}
