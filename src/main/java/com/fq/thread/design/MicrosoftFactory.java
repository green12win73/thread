package com.fq.thread.design;

import com.fq.thread.design.vo.Computer;
import com.fq.thread.design.vo.Keyboard;
import com.fq.thread.design.vo.MicrosoftComputer;
import com.fq.thread.design.vo.MicrosoftKeyboard;
import com.fq.thread.design.vo.MicrosoftMouse;
import com.fq.thread.design.vo.Mouse;

public class MicrosoftFactory extends AbstractFactory {
    @Override
    public Computer createComputer() {
        return new MicrosoftComputer();
    }

    @Override
    public Keyboard createKeyboard() {
        return new MicrosoftKeyboard();
    }

    @Override
    public Mouse createMouse() {
        return new MicrosoftMouse();
    }
}
