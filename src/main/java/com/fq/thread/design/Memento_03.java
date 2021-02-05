package com.fq.thread.design;

public class Memento_03 {
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
    //备忘录
    static class Memento{
        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
    //备忘录管理者
    static class Caretaker{
        private Memento memento;

        public Memento getMemento() {
            return memento;
        }

        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    }

    public static void main(String[] args) {
        State state = new State();
        Caretaker caretaker = new Caretaker();
        state.setState("初始状态....");
        System.out.println(state.getState());
        System.out.println("============备份状态=============");
        caretaker.setMemento(state.createMemento());
        System.out.println("============改变状态=============");
        state.changeState();
        System.out.println(state.getState());
        System.out.println("============还原状态==============");
        state.restoreMemento(caretaker.getMemento());
        System.out.println(state.getState());
    }
}
