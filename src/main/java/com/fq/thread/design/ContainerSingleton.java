package com.fq.thread.design;

import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {
    private static Map<String, Object> ioc = new ConcurrentHashMap<>();
    private ContainerSingleton(){}

    public static Object getBean(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object obj = null;
                try {
                    Object o = Class.forName(className).newInstance();
                    ioc.put(className, o);
                }catch (Exception e){

                }
                return obj;
            }else {
                return ioc.get(className);
            }
        }
    }
}
