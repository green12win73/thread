package com.fq.thread.design;

/**
 * 使用中介者模式
 */
public class Mediator_03 {
    //抽象中间部门
    static abstract class AbstrackMediatorDept{
        //人事部
        private PersonnelDept personnelDept;
        //财务部
        private FinanceDept financeDept;
        //采购部
        private PurchasingDept purchasingDept;

        public PersonnelDept getPersonnelDept() {
            return personnelDept;
        }

        public void setPersonnelDept(PersonnelDept personnelDept) {
            this.personnelDept = personnelDept;
        }

        public FinanceDept getFinanceDept() {
            return financeDept;
        }

        public void setFinanceDept(FinanceDept financeDept) {
            this.financeDept = financeDept;
        }

        public PurchasingDept getPurchasingDept() {
            return purchasingDept;
        }

        public void setPurchasingDept(PurchasingDept purchasingDept) {
            this.purchasingDept = purchasingDept;
        }

        public abstract void recordSalaries();
        public abstract void offerOffices();
        public abstract void offerMoney();
    }
    //具体中间部门（协调部门）
    static class MediatorDept extends AbstrackMediatorDept{
        //员工加入公司
        @Override
        public void recordSalaries(){
            //登记员工薪水以及银行账户
            super.financeDept.recordSalaries();
        }
        //提供办公用品
        @Override
        public void offerOffices(){
            //通过办公用品的申请
            super.purchasingDept.auditPassApply();
        }
        //提供采购资金
        @Override
        public void offerMoney(){
            //通过采购资金的申请
            super.financeDept.auditPassApply();
        }
    }
    //抽象部门类
    static abstract class AbstractDept{
        private AbstrackMediatorDept abstrackMediatorDept;
        public AbstractDept(AbstrackMediatorDept abstrackMediatorDept){
            this.abstrackMediatorDept = abstrackMediatorDept;
        }
    }
    //人事部
    static class PersonnelDept extends AbstractDept{
        public PersonnelDept(AbstrackMediatorDept abstrackMediatorDept){
            super(abstrackMediatorDept);
        }
        public void joinCompany(){
            System.out.println("人事部：新员工入职登记,并领取办公用品");
            super.abstrackMediatorDept.recordSalaries();
        }

        public void acceptOffices(){
            System.out.println("人事部：领取采购部门提供的办公用品");
        }

        public void applyOffices(){
            System.out.println("人事部：向采购部门申请办公用品!");
            super.abstrackMediatorDept.offerOffices();
            this.acceptOffices();
        }

    }

    //财务部
    static class FinanceDept extends AbstractDept{
        public FinanceDept(AbstrackMediatorDept abstrackMediatorDept){
            super(abstrackMediatorDept);
        }
        public void recordSalaries(){
            System.out.println("财务部：财务部门登记了新同事的薪水!");
        }

        public void auditPassApply(){
            System.out.println("财务部：通过办公用品采购资金的申请!");
            this.offerMoney();
        }

        public void offerMoney(){
            System.out.println("财务部：将采购资金划拨到采购部门");
        }
    }

    //采购部
    static class PurchasingDept extends AbstractDept{
        public PurchasingDept(AbstrackMediatorDept abstrackMediatorDept){
            super(abstrackMediatorDept);
        }
        public void auditPassApply(){
            System.out.println("采购部：通过办公用品的申请!");
            //申请采购资金
            this.applyMoney();
            //采购办公用品
            this.purchasing();
        }
        public void acceptMoney(){
            System.out.println("采购部：接受到财务部门划拨的采购资金了!");
        }
        public void applyMoney(){
            System.out.println("采购部：向财务部门申请资金!");
            super.abstrackMediatorDept.offerMoney();
            this.acceptMoney();
        }
        private void purchasing(){
            System.out.println("采购部：采购办公用品!");
        }
    }

    public static void main(String[] args) {
        AbstrackMediatorDept abstrackMediatorDept = new MediatorDept();
        //人事部
        PersonnelDept personnelDept = new PersonnelDept(abstrackMediatorDept);
        //财务部
        FinanceDept financeDept = new FinanceDept(abstrackMediatorDept);
        //采购部
        PurchasingDept purchasingDept = new PurchasingDept(abstrackMediatorDept);
        abstrackMediatorDept.setFinanceDept(financeDept);
        abstrackMediatorDept.setPersonnelDept(personnelDept);
        abstrackMediatorDept.setPurchasingDept(purchasingDept);
        //人事部新员工入职
        personnelDept.joinCompany();
        //给新员工申请办公用品
        personnelDept.applyOffices();
    }
}
