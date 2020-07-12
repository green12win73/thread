package com.fq.thread.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy_03 {

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
            System.out.println(this.name + "驾驶车辆");
        }

        @Override
        public void stop() {
            System.out.println(this.name + "停止车辆");
        }
    }
    //代驾
    static class DriverHandler implements InvocationHandler {
        //被代理对象
        private Object object;

        public DriverHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("==========================");
            return method.invoke(this.object, args);
        }
    }

    public static void main(String[] args) {
        Driver driver = new Driver("张三");
        DriverHandler driverHandler = new DriverHandler(driver);
        IDrive driveProxy = (IDrive) Proxy.newProxyInstance(driverHandler.getClass().getClassLoader(), new Class[]{IDrive.class}, driverHandler);
        driveProxy.start();
        driveProxy.run();
        driveProxy.stop();
    }
}
