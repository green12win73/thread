package com.fq.thread.design;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author fangqi
 * @description
 * @date 2020/5/9 10:48
 */
public class SerializableBrokenSingleton implements Serializable {

    private static final SerializableBrokenSingleton singleton = new SerializableBrokenSingleton();
    public int count = 1;
    private SerializableBrokenSingleton(){
        System.out.println("=============初始化============");
    }

    public static SerializableBrokenSingleton getInstance(){
        return singleton;
    }

    private Object readResolve(){
        return singleton;
    }

    public static void main(String[] args){
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            SerializableBrokenSingleton instance = SerializableBrokenSingleton.getInstance();
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("out.obj"));
            objectOutputStream.writeObject(instance);
            objectOutputStream.flush();

            objectInputStream = new ObjectInputStream(new FileInputStream("out.obj"));
            Object o = objectInputStream.readObject();
            SerializableBrokenSingleton brokenSingleton = (SerializableBrokenSingleton)o;

            System.out.println("instance.hashCode="+instance.hashCode());
            System.out.println("brokenSingleton.hashCode="+brokenSingleton.hashCode());
            objectInputStream.close();
        }catch (Exception e){

        }
    }
}
