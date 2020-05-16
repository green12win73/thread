package com.fq.thread.design;

/**
 * 访问者接口
 */
public interface IVisitor {
    //付钱
    void visit(AbstractPerson person);
}
