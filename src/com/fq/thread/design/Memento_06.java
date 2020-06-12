package com.fq.thread.design;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Memento_06 {
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
        public Caretaker createMemento(String backupId){
            Caretaker caretaker = new Caretaker();
            caretaker.setMemento(backupId, new Memento(BeanUtils.backupProp(this)));
            return caretaker;
        }
        //还原备份
        public void restoreMemento(Memento memento){
            if(null!=memento){
                BeanUtils.restoreProp(this, memento.getMemento());
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
        private Map<String, Memento> mementoMap = new HashMap<>();

        public Map<String, Memento> getMemento() {
            return this.mementoMap;
        }

        public void setMemento(String id, Memento memento) {
            this.mementoMap.put(id, memento);
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
        System.out.println("=================备份第一次==============");
        String uuid1 = UUID.randomUUID().toString();
        Caretaker memento = state.createMemento(uuid1);
        System.out.println("=================修改第一次==============");
        state.setState1("state11");
        state.setState2("state22");
        state.setState3("state33");
        System.out.println(state.toString());
        System.out.println("=================备份第二次==============");
        String uuid2 = UUID.randomUUID().toString();
        memento = state.createMemento(uuid2);
        System.out.println("=================修改第二次==============");
        state.setState1("state111");
        state.setState2("state222");
        state.setState3("state333");
        System.out.println(state.toString());
        System.out.println("=================还原到第二次==============");
        state.restoreMemento(memento.getMemento().get(uuid2));
        System.out.println(state.toString());
    }
}
