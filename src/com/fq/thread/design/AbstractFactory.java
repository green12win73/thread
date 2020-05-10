package com.fq.thread.design;

import com.fq.thread.design.vo.Computer;
import com.fq.thread.design.vo.Keyboard;
import com.fq.thread.design.vo.Mouse;

//抽象工厂类
public abstract class AbstractFactory {

    //创建电脑类
    public abstract Computer createComputer();
    //创建键盘类
    public abstract Keyboard createKeyboard();
    //创建鼠标类
    public abstract Mouse createMouse();
}
