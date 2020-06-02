package com.fq.thread.design;

/**
 * 不使用中介者模式
 */
public class Mediator_01 {

    //人事部
    static class PersonnelDept{

        public void registerEmployee(){
            System.out.println("人事部：新员工入职登记,并领取办公用品");
            this.offerEmplyeeData();
            this.applyOffices();
        }

        public void acceptOffices(){
            System.out.println("人事部：领取采购部门提供的办公用品");
        }

        private void applyOffices(){
            System.out.println("人事部：向采购部门申请办公用品!");
            new PurchasingDept().auditPassApply();
        }

        private void offerEmplyeeData(){
            System.out.println("人事部：提供员工信息（主要是薪资和银行卡）给财务");
            new FinanceDept().recordSalaries();
        }

    }

    //财务部
    static class FinanceDept{

        public void recordSalaries(){
            System.out.println("财务部：财务部门登记了新同事的薪水!");
        }

        public void auditPassApply(){
            System.out.println("财务部：通过办公用品采购资金的申请!");
            this.offerMoney();
        }

        private void offerMoney(){
            System.out.println("财务部：将采购资金划拨到采购部门");
            new PurchasingDept().acceptMoney();
        }
    }

    //采购部
    static class PurchasingDept{

        public void auditPassApply(){
            System.out.println("采购部：通过办公用品的申请!");
            this.applyMoney();
        }
        public void acceptMoney(){
            System.out.println("采购部：接受到财务部门划拨的采购资金了!");
            this.purchasing();
            new PersonnelDept().acceptOffices();
        }
        private void applyMoney(){
            System.out.println("采购部：向财务部门申请资金!");
            new FinanceDept().auditPassApply();
        }
        private void purchasing(){
            System.out.println("采购部：采购办公用品!");
        }
    }

    public static void main(String[] args) {
        PersonnelDept personnelDept = new PersonnelDept();
        personnelDept.registerEmployee();
    }
}
