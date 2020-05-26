package com.fq.thread.design;

public abstract class AbstractPerson {
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    abstract void accept(IVisitor visitor);

    //付钱
    abstract void pay(int payAmount);

}
