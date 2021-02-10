package com.fq.thread;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description
 * @date 2020/5/7 17:07
 */
public class VolatileOrderTest {

    private boolean stop = false;

    public void stop(){
        int a = 1;
        int b = 2;
        int c = a+b;
        stop = true;
    }

    public boolean isStop(){
        return isStop();
    }
}
