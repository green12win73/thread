package com.fq.thread.design;

public class State_02 {

    static class Car {

        public static final int state_start = 1;
        public static final int state_run = 2;
        public static final int state_stop = 3;
        public static final int state_open = 4;
        public static final int state_close = 5;
        private int state;//当前状态

        public void setState(int state){
            this.state = state;
        }

        public void start() {
            switch (this.state){
                case state_start:break;
                case state_run:break;
                case state_stop:
                    this.startActive();
                    this.setState(state_start);
                    break;
                case state_open:break;
                case state_close:
                    this.startActive();
                    this.setState(state_start);
                    break;
                default: break;
            }
        }

        public void run() {
            switch (this.state){
                case state_start:
                    this.runActive();
                    this.setState(state_run);
                    break;
                case state_run:break;
                case state_stop:
                    this.runActive();
                    this.setState(state_run);
                    break;
                case state_open:break;
                case state_close:break;
                default: break;
            }
        }

        public void stop() {
            switch (this.state){
                case state_start:break;
                case state_run:
                    this.stopActive();
                    this.setState(state_stop);
                    break;
                case state_stop:break;
                case state_open:break;
                case state_close:break;
                default: break;
            }
        }

        public void openDoor() {
            switch (this.state){
                case state_start:break;
                case state_run:break;
                case state_stop:break;
                case state_open:break;
                case state_close:
                    this.openDoorActive();
                    this.setState(state_open);
                    break;
                default: break;
            }
        }

        public void closeDoor() {
            switch (this.state){
                case state_start:
                    break;
                case state_run:break;
                case state_stop:
                    break;
                case state_open:
                    this.closeDoorActive();
                    this.setState(state_close);
                    break;
                case state_close:
                    break;
                default: break;
            }
        }

        private void startActive() {
            System.out.println("============启动==========");
        }

        private void runActive() {
            System.out.println("============行驶==========");
        }

        private void stopActive() {
            System.out.println("============停止==========");
        }

        private void openDoorActive() {
            System.out.println("============开门==========");
        }

        private void closeDoorActive() {
            System.out.println("============关门==========");
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        //初始状态
        car.setState(Car.state_close);
        car.openDoor();
        car.closeDoor();
        car.start();
        car.run();
        car.stop();
    }
}
