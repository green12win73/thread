package com.fq.thread.design;

public class ExpenseProcess {

    IFertilityExpenseProcess iFertilityExpenseProcess = new FertilityExpenseProcess();

    //封装处理过程
    public void process(){
        iFertilityExpenseProcess.pay();
        iFertilityExpenseProcess.dealWithFormalities();
        iFertilityExpenseProcess.application();
        iFertilityExpenseProcess.transfer();
    }
}
