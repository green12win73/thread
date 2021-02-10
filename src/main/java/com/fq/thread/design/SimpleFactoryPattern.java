package com.fq.thread.design;

import com.fq.thread.design.vo.IPerson;
import com.fq.thread.design.vo.Student;
import com.fq.thread.design.vo.Teacher;

public class SimpleFactoryPattern {

    public static IPerson create(String name){
        IPerson person = null;
        if("teacher".equals(name)){
            person = new Teacher();
        }else if("student".equals(name)){
            person = new Student();
        }
        return person;
    }
}
