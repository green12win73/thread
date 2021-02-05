package com.fq.thread.design;

/**
 * 测试同事
 */
public class TestColleague {
    private AbstrackMediator abstrackMediator;

    public TestColleague(AbstrackMediator abstrackMediator) {
        this.abstrackMediator = abstrackMediator;
    }

    public void test(){
        System.out.println("测试开发的新功能...");
    }

    public void findBug(){
        System.out.println("开发中发现bug，交由开发者修复...");
        abstrackMediator.excute(4);
    }

    //发现需求跟文档不一致
    public void findRequirementInconformity(){
        System.out.println("测试中发现实现和需求描述不一致,找产品和开发确认需求最终的实现方式...");
        abstrackMediator.excute(3);
    }
}
