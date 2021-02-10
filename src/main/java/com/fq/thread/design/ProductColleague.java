package com.fq.thread.design;

/**
 * 产品同事
 */
public class ProductColleague {
    private AbstrackMediator abstrackMediator;

    public ProductColleague(AbstrackMediator abstrackMediator) {
        this.abstrackMediator = abstrackMediator;
    }

    public void design(){
        System.out.println("完成需求设计....");
    }

    public void verifyRequirement(){
        System.out.println("产品确认需求...");
    }

    public void giveDesignToDeveloper(){
        System.out.println("设计完成，交由开发人员...");
        abstrackMediator.excute(1);
    }
}
