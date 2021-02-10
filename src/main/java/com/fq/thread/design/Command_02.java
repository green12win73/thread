package com.fq.thread.design;

public class Command_02 {

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

    //抽象命令
    static abstract class Command{
        private RequiredGroup requiredGroup = new RequiredGroup();
        private DesignGroup designGroup = new DesignGroup();
        private DevelopGroup developGroup = new DevelopGroup();
        public abstract void excute();
    }
    //新增需求命令
    static class AddRequiredCommand extends Command{
        @Override
        public void excute() {
            super.requiredGroup.add();
            super.designGroup.add();
            super.developGroup.add();
        }
    }

    //删除需求命令
    static class DeleteRequiredCommand extends Command{
        @Override
        public void excute() {
            super.requiredGroup.delete();
            super.designGroup.delete();
            super.developGroup.delete();
        }
    }

    //修改需求命令
    static class ChangeRequiredCommand extends Command{
        @Override
        public void excute() {
            super.requiredGroup.change();
            super.designGroup.change();
            super.developGroup.change();
        }
    }

    //调用者，接受封装的命令，并执行其对应的逻辑
    static class Invoker{
        public void excute(Command command){
            command.excute();
        }
    }
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.excute(new DeleteRequiredCommand());
    }
}
