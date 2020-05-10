package com.fq.thread.design;

public class BaoMaDriveStragegy implements IDriveStrategy {
    @Override
    public void drive() {
        System.out.println("我开着宝马车");
    }
}
