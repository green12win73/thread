package com.fq.thread.design;

/**
 * 年终总结
 */
public class EndOfYearConclusion_02 {

    //年终总结接口
    interface Conclusion{
        //自我介绍
        public void introduce();

        //报告内容(毫无技术含量)
        public void report();
    }

    //基本的年终总结模板
    static class BaseConclusion implements Conclusion{
        //自我介绍
        @Override
        public void introduce(){
            System.out.println("我是XXX");
        }

        //报告内容(毫无技术含量)
        @Override
        public void report(){
            System.out.println("今年主要是完成指定的需求");
        }
    }

    //这是一个抽象类，主要是被子类继承，并且自身持有了一个总结的引用
    static abstract class AbstractConclusion implements Conclusion{
        private Conclusion conclusion;

        public AbstractConclusion(Conclusion conclusion){
            this.conclusion = conclusion;
        }

        public Conclusion getConclusion() {
            return conclusion;
        }
    }

    //A同事的年终总结,
    static class AConclusion extends AbstractConclusion{

        public AConclusion(Conclusion conclusion) {
            super(conclusion);
        }

        @Override
        public void introduce(){
            System.out.println("尊敬的各位领导/同事：");
            super.getConclusion().introduce();
        }

        @Override
        public void report(){
            super.getConclusion().report();
            System.out.println("在完成需求的同时，也对以前的一些逻辑做重构，降低后期的维护成本");
        }
    }

    //B同事的年终总结
    static class BConclusion extends AbstractConclusion{

        public BConclusion(Conclusion conclusion) {
            super(conclusion);
        }

        @Override
        public void introduce(){
            super.getConclusion().introduce();
            System.out.println("接下来是我的年终总结：");
        }

        @Override
        public void report(){
            super.getConclusion().report();
            System.out.println("在今年的工作中，对自己有了更高的要求，主要体现在对系统的性能做了优化，等等...");
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
        BaseConclusion baseConclusion = new BaseConclusion();
        Leader leader = new Leader();
        leader.setConclusion(new AConclusion(baseConclusion));
        leader.listenReport();
        System.out.println("今年A这个小伙子进步很大呀，有前途，加点年终奖...");
        System.out.println("===================================================");
        leader.setConclusion(new BConclusion(baseConclusion));
        leader.listenReport();
        System.out.println("今年B这个小伙子也很不错，居然超出了预期，继续保留优秀员工...");
        System.out.println("===============================================================");
        leader.setConclusion(new BConclusion(new AConclusion(baseConclusion)));
        leader.listenReport();
        System.out.println("哟呵，这个小伙子更不错啊，居然A和B能做的事情他都有做，很好，给他优秀员工，加年终，加薪...");
    }
}
