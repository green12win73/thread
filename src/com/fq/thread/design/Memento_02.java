package com.fq.thread.design;

public class Memento_02 {
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
        //创建备份
        public Memento createMemento(){
            Memento memento = new Memento();
            memento.setState(this.state);
            return memento;
        }
        //还原备份
        public void restoreMemento(Memento memento){
            this.state = memento.getState();
        }
    }

    static class Memento{
        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    public static void main(String[] args) {
        State state = new State();
        state.setState("初始状态....");
        System.out.println(state.getState());
        System.out.println("============备份状态=============");
        Memento memento = state.createMemento();
        System.out.println("============改变状态=============");
        state.changeState();
        System.out.println(state.getState());
        System.out.println("============还原状态==============");
        state.restoreMemento(memento);
        System.out.println(state.getState());
    }
}
