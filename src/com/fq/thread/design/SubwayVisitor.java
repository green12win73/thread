package com.fq.thread.design;

/**
 * 地铁访问者
 */
public class SubwayVisitor implements IVisitor {
    @Override
    public void visit(AbstractPerson person) {
        person.pay(4);
    }
}
