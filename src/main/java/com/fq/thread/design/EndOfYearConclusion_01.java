package com.fq.thread.design;

/**
 * 年终总结
 */
public class EndOfYearConclusion_01 {

    //年终总结接口
    interface Conclusion{
        //自我介绍
        public void introduce();

        //报告内容(毫无技术含量)
        public void report();
    }

    //A同事的年终总结
    static class AConclusion implements Conclusion{

        //自我介绍
        @Override
        public void introduce(){
            System.out.println("我是A....");
        }

        //报告内容(毫无技术含量)
        @Override
        public void report(){
            System.out.println("今年主要是完成指定的需求,bababababa....");
        }
    }

    //B同事的年终总结
    static class BConclusion implements Conclusion{

        //自我介绍
        @Override
        public void introduce(){
            System.out.println("尊敬个各位领导/同事,我是B....,接下来是我的年终总结：");
        }

        //报告内容(经过精心整理)
        @Override
        public void report(){
            System.out.println("今年主要是完成指定的需求,在完成需求的同时，也对以前的一些逻辑做重构，降低后期的维护成本，balaba...");
        }
    }

    //领导
    static class Leader{
        private Conclusion conclusion;

        public void listenReport(){
            conclusion.introduce();
            conclusion.report();
        }

        public Conclusion getConclusion() {
            return conclusion;
        }

        public void setConclusion(Conclusion conclusion) {
            this.conclusion = conclusion;
        }
    }

    public static void main(String[] args) {
        Leader leader = new Leader();
        leader.setConclusion(new AConclusion());
        leader.listenReport();
        //领导听完A汇报
        System.out.println("我都快睡着了，A这个小伙子表现一般，年终奖降一点吧!");
        System.out.println("=========================================================================");
        leader.setConclusion(new BConclusion());
        leader.listenReport();
        //领导听完B汇报
        System.out.println("B这个小伙子做了这么多事情，超出了我的期望值，不错，今年的优秀员工就给他一个名额吧!");
    }
}
