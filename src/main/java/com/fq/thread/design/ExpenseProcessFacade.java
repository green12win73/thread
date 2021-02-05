package com.fq.thread.design;

public class ExpenseProcessFacade {

    private ExpenseProcess process = new ExpenseProcess();
    private PostpartumRecoveryWrapper recovery = new PostpartumRecoveryWrapper();

    //封装处理过程
    public void process(){
        process.process();
    }

    public void processRecovery(){
        recovery.process();
    }
}
