package com.fq.thread.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 */
public class FlyWeight_02 {

    //抽象课程类
    static abstract class AbstractCourse{
        private Integer id;//课程ID
        private String courseName;//课程名称
        private String teacher;//授课老师
        private String address;//授课地址

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    //具体课程类
    static class ConcreteCourse extends AbstractCourse{
        private final String key;//用final修饰，保证key不会被改变
        public ConcreteCourse(String key) {
            this.key = key;
        }
    }

    //工厂方法模式创建课程
    static class CourseFactory{
        private static Map<String, AbstractCourse> courseMap = new HashMap<>();

        public static AbstractCourse createCourse(String key){
            if(!courseMap.containsKey(key)){
                AbstractCourse course = new ConcreteCourse(key);
                //初始化，设置参数
                String[] arr = key.split("_");
                course.setId(Integer.valueOf(arr[0]));
                course.setCourseName(arr[1]);
                course.setTeacher(arr[2]);
                course.setAddress(arr[3]);
                courseMap.put(key, course);
            }
            return courseMap.get(key);
        }
    }

    public static void main(String[] args) {
        AbstractCourse course = CourseFactory.createCourse("1_物理课_张老师_A-1");
        AbstractCourse course1 = CourseFactory.createCourse("1_物理课_李老师_A-2");
        AbstractCourse course2 = CourseFactory.createCourse("2_高数课_赵老师_B-1");
        AbstractCourse course3 = CourseFactory.createCourse("2_高数课_蒙老师_B-2");
        //再次获取张老师的物理课，对比是否是同一个对象
        AbstractCourse course01 = CourseFactory.createCourse("1_物理课_张老师_A-1");
        System.out.println(course01==course);
        System.out.println(course01.equals(course));
    }
}
