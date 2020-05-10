package com.fq.thread.design;

import com.fq.thread.design.vo.AppleComputer;
import com.fq.thread.design.vo.AppleKeyboard;
import com.fq.thread.design.vo.AppleMouse;
import com.fq.thread.design.vo.Computer;
import com.fq.thread.design.vo.Keyboard;
import com.fq.thread.design.vo.Mouse;

public class AppleFactory extends AbstractFactory {
    @Override
    public Computer createComputer() {
        return new AppleComputer();
    }

    @Override
    public Keyboard createKeyboard() {
        return new AppleKeyboard();
    }

    @Override
    public Mouse createMouse() {
        return new AppleMouse();
    }
}
