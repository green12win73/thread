package com.fq.thread.design;

public class Memento_01 {
    static class State{
        private String state = "";
        //设置状态
        public void setState(String state){
            this.state = state;
        }
        //获取状态
        public String getState(){
            return this.state;
        }
        //改变状态
        public void changeState(){
            this.state = "状态改变了....";
        }
        //还原状态
        public void restoreState(String state){
            this.state = state;
        }
    }

    public static void main(String[] args) {
        State state = new State();
        state.setState("初始状态....");
        System.out.println(state.getState());
        System.out.println("============备份状态=============");
        State backup = new State();
        backup.setState(state.getState());
        System.out.println("============改变状态=============");
        state.changeState();
        System.out.println(state.getState());
        System.out.println("============还原状态==============");
        state.restoreState(backup.getState());
        System.out.println(state.getState());
    }
}
