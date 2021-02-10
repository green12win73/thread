package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;

public class Visitor_01 {
    //员工抽象类
    abstract static class Employee{
        private String name;//名字
        private int salary;//薪水
        private String job;//工作内容

        public Employee(String name, int salary, String job) {
            this.name = name;
            this.salary = salary;
            this.job = job;
        }

        public void report(){
            String report = new StringBuilder()
                    .append("姓名："+this.name)
                    .append("       薪水："+this.salary)
                    .append("       工作："+this.job)
                    .append(this.getOtherInfo())
                    .toString();
            System.out.println(report);
        }

        public abstract String getOtherInfo();
    }

    //管理层
    static class Leader extends Employee{
        public Leader(String name, int salary, String job) {
            super(name, salary, job);
        }

        @Override
        public String getOtherInfo() {
            return new StringBuilder().append("     其他：爱拍马屁!!!").toString();
        }
    }
    //普通员工
    static class CommonEmploee extends Employee{
        public CommonEmploee(String name, int salary, String job) {
            super(name, salary, job);
        }

        @Override
        public String getOtherInfo() {
            return new StringBuilder().append("     其他：技术研究!!!").toString();
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Leader("张三",18000, "管理员工"));
        employees.add(new CommonEmploee("李四", 15000, "架构设计"));
        employees.add(new CommonEmploee("王五", 12000, "写业务逻辑"));
        for (Employee employee : employees) {
            employee.report();
        }
    }
}
