package com.fq.thread.design;

public class Proxy_01 {

    interface IDrive{
        public abstract void start();

        public abstract void run();

        public abstract void stop();
    }
    //车主
    static class Driver implements IDrive{
        private String name;

        public Driver(String name) {
            this.name = name;
        }

        @Override
        public void start() {
            System.out.println(this.name+"发动车辆");
        }

        @Override
        public void run() {
            System.out.println(this.name+"驾驶车辆");
        }

        @Override
        public void stop() {
            System.out.println(this.name+"停止车辆");
        }
    }
    //代驾
    static class DriverProxy implements IDrive{
        private IDrive drive;

        public DriverProxy(IDrive drive) {
            this.drive = drive;
        }

        @Override
        public void start() {
            this.drive.start();
        }

        @Override
        public void run() {
            this.drive.run();
        }

        @Override
        public void stop() {
            this.drive.stop();
        }
    }

    public static void main(String[] args) {
        DriverProxy proxy = new DriverProxy(new Driver("张三"));
        proxy.start();
        proxy.run();
        proxy.stop();
    }
}
