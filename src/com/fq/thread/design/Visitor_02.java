package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;

public class Visitor_02 {
    interface IVisitor{
        void visitor(Leader leader);
        void visitor(CommonEmploee commonEmploee);
    }

    static class Visitor implements IVisitor{
        @Override
        public void visitor(Leader leader) {
            String report = new StringBuilder()
                    .append("姓名："+leader.getName())
                    .append("       薪水："+leader.getSalary())
                    .append("       工作："+leader.getJob())
                    .append("       其他：爱拍马屁")
                    .toString();
            System.out.println(report);
        }

        @Override
        public void visitor(CommonEmploee commonEmploee) {
            String report = new StringBuilder()
                    .append("姓名："+commonEmploee.getName())
                    .append("       薪水："+commonEmploee.getSalary())
                    .append("       工作："+commonEmploee.getJob())
                    .append("       其他：技术研究")
                    .toString();
            System.out.println(report);
        }


    }
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public abstract void accept(IVisitor iVisitor);
    }

    //管理层
    static class Leader extends Employee{
        public Leader(String name, int salary, String job) {
            super(name, salary, job);
        }

        @Override
        public void accept(IVisitor iVisitor) {
            iVisitor.visitor(this);
        }
    }
    //普通员工
    static class CommonEmploee extends Employee{
        public CommonEmploee(String name, int salary, String job) {
            super(name, salary, job);
        }

        @Override
        public void accept(IVisitor iVisitor) {
            iVisitor.visitor(this);
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Leader("张三",18000, "管理员工"));
        employees.add(new CommonEmploee("李四", 15000, "架构设计"));
        employees.add(new CommonEmploee("王五", 12000, "写业务逻辑"));
        Visitor visitor = new Visitor();
        for (Employee employee : employees) {
            employee.accept(visitor);
        }
    }
}
