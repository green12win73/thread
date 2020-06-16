package com.fq.thread.design;

//模拟学生上课过程
public class TemlateMethod_02 {

    static abstract class AbstractStudent{
        public void study(){
            this.enterClassroom();
            this.listen();
            this.liveClassroom();
        }

        public void enterClassroom(){
            System.out.println("===========进入教室=========");
        }

        public abstract void listen();

        public void liveClassroom(){
            System.out.println("===========离开教室=========");
        }
    }

    static class GoodStudent extends AbstractStudent{
        @Override
        public void listen(){
            System.out.println("===========认真听课，做笔记=========");
        }
    }

    static class BadStudent extends AbstractStudent{
        @Override
        public void listen(){
            System.out.println("===========不想听课，睡觉吧=========");
        }

    }

    public static void main(String[] args) {
        //模拟好学生的上课过程
        AbstractStudent goodStudent = new GoodStudent();
        goodStudent.study();
        System.out.println("==============================");
        //模拟坏学生的上课过程
        AbstractStudent badStudent = new BadStudent();
        badStudent.study();
    }
}
