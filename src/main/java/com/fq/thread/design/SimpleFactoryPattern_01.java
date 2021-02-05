package com.fq.thread.design;

import com.fq.thread.design.vo.IPerson;
import com.fq.thread.design.vo.Student;
import com.fq.thread.design.vo.Teacher;

public class SimpleFactoryPattern_01 {

    public static IPerson create(String className){
        IPerson person = null;
        try {
            Object o = Class.forName(className).newInstance();
            if(null!=o){
                person = (IPerson)o;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }
}
