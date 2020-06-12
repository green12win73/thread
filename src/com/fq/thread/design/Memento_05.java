package com.fq.thread.design;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Memento_05 {
    static class State{
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
            caretaker.setMemento(new Memento(BeanUtils.backupProp(this)));
            return caretaker;
        }
        //还原备份
        public void restoreMemento(Caretaker caretaker){
            if(null!=caretaker){
                BeanUtils.restoreProp(this, caretaker.getMemento().getMemento());
            }
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
    //备忘录
    static class Memento{
        private Map<String, Object> map;

        public Memento(Map<String, Object> map) {
            this.map = map;
        }

        public Map<String,Object> getMemento(){
            return this.map;
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

    static class BeanUtils{
        public static Map<String, Object> backupProp(Object bean){
            Map<String, Object> map = new HashMap<>();
            try{
                Field[] declaredFields = bean.getClass().getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    map.put(declaredField.getName(), declaredField.get(bean));
                }
            }catch (Exception e){

            }
            return map;
        }

        public static void restoreProp(Object bean, Map<String, Object> map){
            try {
                if (null != map && map.size() > 0) {
                    Set<String> fieldNams = map.keySet();
                    Field[] declaredFields = bean.getClass().getDeclaredFields();
                    for (Field declaredField : declaredFields) {
                        declaredField.setAccessible(true);
                        if (fieldNams.contains(declaredField.getName())) {
                            declaredField.set(bean, map.get(declaredField.getName()));
                        }
                    }

                }
            }catch (Exception e){

            }
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
