package com.fq.thread.design;

public class AirplaneDriveStragegy implements IDriveStrategy {
    @Override
    public void drive() {
        System.out.println("我开着飞机");
    }
}
