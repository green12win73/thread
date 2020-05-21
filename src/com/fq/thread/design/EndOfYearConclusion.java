package com.fq.thread.design;

/**
 * 年终总结
 */
public class EndOfYearConclusion {
    //A同事的年终总结
    static class AConclusion{

        //自我介绍
        public void introduce(){
            System.out.println("我是A....");
        }

        //报告内容(毫无技术含量)
        public void report(){
            System.out.println("今年主要是完成指定的需求,bababababa....");
        }
    }

    //B同事的年终总结
    static class BConclusion{

        //自我介绍
        public void introduce(){
            System.out.println("尊敬个各位领导/同事,我是B....,接下来是我的年终总结：");
        }

        //报告内容(经过精心整理)
        public void report(){
            System.out.println("今年主要是完成指定的需求,在完成需求的同时，也对以前的一些逻辑做重构，降低后期的维护成本，balaba...");
        }
    }

    public static void main(String[] args) {
        AConclusion aConclusion = new AConclusion();
        aConclusion.introduce();
        aConclusion.report();
        //领导听完A汇报
        System.out.println("我都快睡着了，A这个小伙子表现一般，年终奖降一点吧!");
        System.out.println("=========================================================================");
        BConclusion bConclusion = new BConclusion();
        bConclusion.introduce();
        bConclusion.report();
        //领导听完B汇报
        System.out.println("B这个小伙子做了这么多事情，超出了我的期望值，不错，今年的优秀员工就给他一个名额吧!");
    }
}
