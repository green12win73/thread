package com.fq.thread.concurrent;

import java.util.concurrent.Phaser;

/**
 * @author fangqi
 * @description
 * @date 2020/5/11 17:10
 */
public class PhaserTest {
    //完成一项任务后，再继续往下，分阶段执行
    static DriverExamPhaser phaser = new DriverExamPhaser();

    static class Driver implements Runnable {

        public void item_1() {
            System.out.println("科目一考试");
            phaser.arriveAndAwaitAdvance();
        }

        public void item_2() {
            System.out.println("科目二考试");
            phaser.arriveAndAwaitAdvance();
        }

        public void item_3() {
            System.out.println("科目三考试");
            phaser.arriveAndAwaitAdvance();
        }

        public void item_4() {
            System.out.println("科目四考试");
            phaser.arriveAndAwaitAdvance();
        }

        @Override
        public void run() {
            item_1();
            item_2();
            item_3();
            item_4();
        }
    }

    public static void main(String[] args) {
        phaser.bulkRegister(4);
        for (int i = 0; i < 4 ; i++) {
            new Thread(new Driver(),"thread-"+i).start();
        }

    }
}

//驾照考试：科目一、科目二、科目三、科目四
class DriverExamPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase){
            case 0:
                System.out.println("科目一考试人员到齐，开始考试，总人数："+registeredParties);
                return false;
            case 1:
                System.out.println("科目二考试人员到齐，开始考试，总人数："+registeredParties);
                return false;
            case 2:
                System.out.println("科目三考试人员到齐，开始考试，总人数："+registeredParties);
                return false;
            case 3:
                System.out.println("科目四考试人员到齐，开始考试，总人数："+registeredParties);
                return true;
                default: return true;
        }
    }

}