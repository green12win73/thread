package com.fq.thread.design;

public class State_01 {

    static class Car {

        public void start() {
            System.out.println("============启动==========");
        }

        public void run() {
            System.out.println("============行驶==========");
        }

        public void stop() {
            System.out.println("============停止==========");
        }

        public void openDoor() {
            System.out.println("============开门==========");
        }

        public void closeDoor() {
            System.out.println("============关门==========");
        }
    }
}
