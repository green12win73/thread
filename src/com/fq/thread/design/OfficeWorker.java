package com.fq.thread.design;

/**
 * 上班族
 */
public class OfficeWorker extends AbstractPerson {
    @Override
    void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    void pay(int payAmount) {
        System.out.println("支付交通费："+payAmount+"元");
        this.setAmount(this.getAmount()-payAmount);
        System.out.println("剩余交通费："+this.getAmount()+"元");
    }

}
