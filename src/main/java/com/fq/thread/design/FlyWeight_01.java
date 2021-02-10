package com.fq.thread.design;

import java.util.Date;

/**
 * 享元模式
 */
public class FlyWeight_01 {

    //课程类
    static class Course{
        private Integer id;//课程ID
        private String courseName;//课程名称
        private String teacher;//授课老师
        private String address;//授课地址

        public Course(Integer id, String courseName, String teacher, String address) {
            this.id = id;
            this.courseName = courseName;
            this.teacher = teacher;
            this.address = address;
        }

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

    public static void main(String[] args) {
        //物理课-张老师
        Course physicsCourse1 = new Course(1,"物理课","张老师", "A-1");
        //物理课-李老师
        Course physicsCourse2 = new Course(1,"物理课","李老师", "A-2");
        //高数课-赵老师
        Course mathCourse1 = new Course(2,"高数课","赵老师", "B-1");
        //高数课-蒙老师
        Course mathCourse2 = new Course(2,"高数课","蒙老师", "B-2");
    }
}
