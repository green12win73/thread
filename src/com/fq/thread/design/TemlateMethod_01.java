package com.fq.thread.design;

//模拟学生上课过程
public class TemlateMethod_01 {

    static class GoodStudent{

        public void enterClassroom(){
            System.out.println("===========进入教室=========");
        }

        public void listen(){
            System.out.println("===========认真听课，做笔记=========");
        }

        public void liveClassroom(){
            System.out.println("===========离开教室=========");
        }
    }

    static class BadStudent{

        public void enterClassroom(){
            System.out.println("===========进入教室=========");
        }

        public void listen(){
            System.out.println("===========不想听课，睡觉吧=========");
        }

        public void liveClassroom(){
            System.out.println("===========离开教室=========");
        }
    }

    public static void main(String[] args) {
        //模拟好学生的上课过程
        GoodStudent goodStudent = new GoodStudent();
        goodStudent.enterClassroom();
        goodStudent.listen();
        goodStudent.liveClassroom();
        System.out.println("==============================");
        //模拟坏学生的上课过程
        BadStudent badStudent = new BadStudent();
        badStudent.enterClassroom();
        badStudent.listen();
        badStudent.liveClassroom();
    }
}
