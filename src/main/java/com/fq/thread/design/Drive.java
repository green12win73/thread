package com.fq.thread.design;

public class Drive {
    public void drive(IDriveStrategy driveStrategy){
        driveStrategy.drive();
    }
}
