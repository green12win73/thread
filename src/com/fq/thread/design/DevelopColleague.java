package com.fq.thread.design;

/**
 * 研发同事
 */
public class DevelopColleague {

    private AbstrackMediator abstrackMediator;

    public DevelopColleague(AbstrackMediator abstrackMediator) {
        this.abstrackMediator = abstrackMediator;

        this.abstrackMediator.setDevelopColleague(this);
    }

    public void develop(){
        System.out.println("根据产品需求进行响应的功能研发....");
    }

    public void verifyRequiredment(){
        System.out.println("开发中对需求有疑问，需要跟产品沟通...");
        abstrackMediator.excute(2);
    }

    public void repairBug(){
        System.out.println("修复bug，再次交由测试人员...");
        abstrackMediator.excute(5);
    }
}
