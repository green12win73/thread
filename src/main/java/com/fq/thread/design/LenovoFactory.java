package com.fq.thread.design;

import com.fq.thread.design.vo.Computer;
import com.fq.thread.design.vo.Keyboard;
import com.fq.thread.design.vo.LenovoComputer;
import com.fq.thread.design.vo.LenovoKeyboard;
import com.fq.thread.design.vo.LenovoMouse;
import com.fq.thread.design.vo.Mouse;

public class LenovoFactory extends AbstractFactory {
    @Override
    public Computer createComputer() {
        return new LenovoComputer();
    }

    @Override
    public Keyboard createKeyboard() {
        return new LenovoKeyboard();
    }

    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }
}
