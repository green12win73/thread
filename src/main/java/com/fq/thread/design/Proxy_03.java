package com.fq.thread.design;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
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

    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Driver driver = new Driver("张三");
        DriverHandler driverHandler = new DriverHandler(driver);
        proxyProcess(driverHandler);
//        Class<?> proxyClass = Proxy.getProxyClass(driverHandler.getClass().getClassLoader(),
//                new Class[]{IDrive.class});
//        Constructor<?> constructor = proxyClass.getConstructor(null);
//        IDrive driveProxy = (IDrive)constructor.newInstance(new Object[]{driverHandler});
//        driveProxy.start();
//        driveProxy.run();
//        driveProxy.stop();
    }

    public static void proxyProcess(InvocationHandler handler){
        IDrive driveProxy = (IDrive) Proxy.newProxyInstance(handler.getClass().getClassLoader(), new Class[]{IDrive.class}, handler);
        driveProxy.start();
        driveProxy.run();
        driveProxy.stop();

    }

}
