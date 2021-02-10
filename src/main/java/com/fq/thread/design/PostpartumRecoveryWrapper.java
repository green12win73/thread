package com.fq.thread.design;

public class PostpartumRecoveryWrapper {

    private PostpartumRecovery postpartumRecovery = new PostpartumRecovery();

    public void process(){
        postpartumRecovery.find();
        postpartumRecovery.consulting();
        postpartumRecovery.pay();
    }
}
