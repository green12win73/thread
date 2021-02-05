package com.fq.proxy.undynamic;

/**
 * @author fangqi
 * @description
 * @date 2020/10/10 9:23
 */
public class DriverDelegate {
    private Driver driver;
    public DriverDelegate(Driver driver){
        this.driver = driver;
    }


    public void drive(){
        System.out.println("被代理了....");
        this.driver.drive();
    }
}
