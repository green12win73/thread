package com.fq.thread.design;

public class Proxy_02 {

    interface IDrive{
        public abstract void start();

        public abstract void run();

        public abstract void stop();
    }
    //车主
    static class Driver implements IDrive{
        private String name;
        private IDrive proxy;

        public Driver(String name) {
            this.name = name;
        }

        @Override
        public void start() {
            if(this.isProxy()){
                System.out.println(this.name+"发动车辆");
            }else {
                System.out.println("喝醉了，需要代驾");
            }
        }

        @Override
        public void run() {
            if(this.isProxy()){
                System.out.println(this.name + "驾驶车辆");
            }else {
                System.out.println("喝醉了，需要代驾");
            }
        }

        @Override
        public void stop() {
            if (this.isProxy()) {
                System.out.println(this.name + "停止车辆");
            }else {
                System.out.println("喝醉了，需要代驾");
            }
        }

        public IDrive getProxy(){
            this.proxy = new DriverProxy(this);
            return this.proxy;
        }

        public boolean isProxy(){
            return this.proxy!=null?true:false;
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
        Driver driver = new Driver("张三");
        //不能执行对应的方法
//        DriverProxy proxy = new DriverProxy(driver);
        //代理成功
        IDrive proxy = driver.getProxy();
        proxy.start();
        proxy.run();
        proxy.stop();
    }
}
