package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;

//克隆失败
public class PrototypeCloneFailed {
    static class CloneTest implements Cloneable{
        private Integer num;
        private static String name;
        private final ArrayList<String> list = new ArrayList<>();

        public CloneTest(){
            System.out.println("===========初始化数据==========");
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            CloneTest.name = name;
        }

        public void addValue(String str){
            this.list.add(str);
        }

        public List<String> getValue(){
            return this.list;
        }

        @Override
        protected CloneTest clone() {
            CloneTest cloneTest = null;
            try {
                cloneTest = (CloneTest)super.clone();
                //错误提示，不能对final修饰的参数再次赋值
//                cloneTest.list = (ArrayList<String>)this.list.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return cloneTest;
        }

        @Override
        public String toString() {
            return "CloneTest{" +
                    "num=" + num +
                    ",name="+ name +
                    ", list=" + list.toString() +
                    '}';
        }
    }

    public static void main(String[] args) {
        CloneTest cloneTest = new CloneTest();
        cloneTest.setNum(1);
        cloneTest.setName("test");
        cloneTest.addValue("张三");
        CloneTest clone = cloneTest.clone();
        clone.setNum(2);
        clone.setName("test2");
        clone.addValue("李四");
        System.out.println("原始数据="+cloneTest.toString());
        System.out.println("克隆数据="+clone.toString());
    }
}
