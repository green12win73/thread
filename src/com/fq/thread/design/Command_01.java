package com.fq.thread.design;

public class Command_01 {

    //抽象小组
    abstract static class Group{
        //添加需求
        public abstract void add();
        //修改需求
        public abstract void change();
        //删除需求
        public abstract void delete();
    }
    //需求小组
    static class RequiredGroup extends Group{

        @Override
        public void add() {
            System.out.println("=========新增需求=========");
        }

        @Override
        public void change() {
            System.out.println("=========修改需求=========");
        }

        @Override
        public void delete() {
            System.out.println("=========删除需求=========");
        }
    }
    //设计小组
    static class DesignGroup extends Group{

        @Override
        public void add() {
            System.out.println("=========新增页面=========");
        }

        @Override
        public void change() {
            System.out.println("=========修改页面=========");
        }

        @Override
        public void delete() {
            System.out.println("=========删除页面=========");
        }
    }
    //开发小组
    static class DevelopGroup extends Group{

        @Override
        public void add() {
            System.out.println("=========新增功能=========");
        }

        @Override
        public void change() {
            System.out.println("=========修改功能=========");
        }

        @Override
        public void delete() {
            System.out.println("=========删除功能=========");
        }
    }

    public static void main(String[] args) {
        //先找到需求小组，新增需求
        RequiredGroup requiredGroup = new RequiredGroup();
        requiredGroup.add();
        //在找到设计小组，新增页面
        DesignGroup designGroup = new DesignGroup();
        designGroup.add();
        //最后找到开发小组，新增功能
        DevelopGroup developGroup = new DevelopGroup();
        developGroup.add();
    }
}
