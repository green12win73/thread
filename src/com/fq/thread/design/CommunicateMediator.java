package com.fq.thread.design;

/**
 * 沟通中介者
 */
public class CommunicateMediator extends AbstrackMediator{

    @Override
    public void excute(Integer type) {
        if(1==type){//产品需求完成，交由开发
            super.developColleague.develop();
        }else if(2==type){//开发人员找产品确认需求
            super.productColleague.verifyRequirement();
        }else if(3==type){//测试人员发现需求跟功能不一致，跟开发和产品确认需求
            super.developColleague.verifyRequiredment();
            super.productColleague.verifyRequirement();
        }else if(4==type){//测试人员发现bug，交由开发人员修改
            super.developColleague.repairBug();
        }else if(5==type){//交由测试人员
            super.testColleague.test();
        }
    }
}
