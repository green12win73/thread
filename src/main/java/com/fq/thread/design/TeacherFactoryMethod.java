package com.fq.thread.design;

import com.fq.thread.design.vo.IPerson;
import com.fq.thread.design.vo.Teacher;

public class TeacherFactoryMethod implements IFactoryMethod{

    @Override
    public IPerson create() {
        return new Teacher();
    }
}
