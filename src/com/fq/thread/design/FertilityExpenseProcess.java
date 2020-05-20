package com.fq.thread.design;

/**
 * s生育险保险过程
 */
public class FertilityExpenseProcess implements IFertilityExpenseProcess {

    @Override
    public void pay(){
        System.out.println("缴纳生孩子的相关费用....");
    }

    @Override
    public void dealWithFormalities(){
        System.out.println("出院办理生育险报销的相关证明材料...");
    }

    @Override
    public void application(){
        System.out.println("拿着相关材料到公司，由公司进行信息核实并上报....");
    }

    @Override
    public void transfer(){
        System.out.println("社保局审核通过后，将报销费用返还....");
    }

}
