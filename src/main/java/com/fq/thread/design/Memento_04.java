package com.fq.thread.design;

public class Memento_04 {
    static class State implements Cloneable{
        private String state1 = "";
        private String state2 = "";
        private String state3 = "";

        public String getState1() {
            return state1;
        }

        public void setState1(String state1) {
            this.state1 = state1;
        }

        public String getState2() {
            return state2;
        }

        public void setState2(String state2) {
            this.state2 = state2;
        }

        public String getState3() {
            return state3;
        }

        public void setState3(String state3) {
            this.state3 = state3;
        }

        //创建备份
        public Caretaker createMemento(){
            Caretaker caretaker = new Caretaker();
            caretaker.setMemento(this.clone());
            return caretaker;
        }
        //还原备份
        public void restoreMemento(Caretaker caretaker){
            if(null!=caretaker){
                this.setState1(caretaker.getMemento().getState1());
                this.setState2(caretaker.getMemento().getState2());
                this.setState3(caretaker.getMemento().getState3());
            }
        }

        @Override
        protected State clone() {
            try{
                return (State)super.clone();
            }catch (Exception e){

            }
            return null;
        }

        @Override
        public String toString() {
            return "State{" +
                    "state1='" + state1 + '\'' +
                    ", state2='" + state2 + '\'' +
                    ", state3='" + state3 + '\'' +
                    '}';
        }
    }

    //备忘录管理者
    static class Caretaker{
        private State state;

        public State getMemento() {
            return state;
        }

        public void setMemento(State state) {
            this.state = state;
        }
    }

    public static void main(String[] args) {
        State state = new State();
        state.setState1("state1");
        state.setState2("state2");
        state.setState3("state3");
        System.out.println(state.toString());
        System.out.println("=================备份==============");
        Caretaker memento = state.createMemento();
        System.out.println("=================修改==============");
        state.setState1("state11");
        state.setState2("state22");
        state.setState3("state33");
        System.out.println(state.toString());
        System.out.println("=================还原==============");
        state.restoreMemento(memento);
        System.out.println(state.toString());
    }
}
