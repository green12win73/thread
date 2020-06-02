package com.fq.thread.design;

/**
 * 使用中介者模式
 */
public class Mediator_02 {

    //人事部
    static class PersonnelDept{
        private MediatorDept mediatorDept;

        public PersonnelDept(MediatorDept mediatorDept){
            this.mediatorDept = mediatorDept;
        }

        public void joinCompany(){
            System.out.println("人事部：新员工入职登记,并领取办公用品");
            mediatorDept.recordSalaries();
        }

        public void acceptOffices(){
            System.out.println("人事部：领取采购部门提供的办公用品");
        }

        public void applyOffices(){
            System.out.println("人事部：向采购部门申请办公用品!");
            mediatorDept.offerOffices();
            this.acceptOffices();
        }

    }

    //财务部
    static class FinanceDept{
        private MediatorDept mediatorDept;

        public FinanceDept(MediatorDept mediatorDept){
            this.mediatorDept = mediatorDept;
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
    static class PurchasingDept{
        private MediatorDept mediatorDept;

        public PurchasingDept(MediatorDept mediatorDept){
            this.mediatorDept = mediatorDept;
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
            mediatorDept.offerMoney();
            this.acceptMoney();
        }
        private void purchasing(){
            System.out.println("采购部：采购办公用品!");
        }
    }

    //中间部门（协调部门）
    static class MediatorDept{
        //人事部
        private PersonnelDept personnelDept;
        //财务部
        private FinanceDept financeDept;
        //采购部
        private PurchasingDept purchasingDept;
        //员工加入公司
        public void recordSalaries(){
            //登记员工薪水以及银行账户
            financeDept.recordSalaries();
        }
        //提供办公用品
        public void offerOffices(){
            //通过办公用品的申请
            purchasingDept.auditPassApply();

        }
        //提供采购资金
        public void offerMoney(){
            //通过采购资金的申请
            financeDept.auditPassApply();
        }

        public void setPersonnelDept(PersonnelDept personnelDept) {
            this.personnelDept = personnelDept;
        }

        public void setFinanceDept(FinanceDept financeDept) {
            this.financeDept = financeDept;
        }

        public void setPurchasingDept(PurchasingDept purchasingDept) {
            this.purchasingDept = purchasingDept;
        }
    }

    public static void main(String[] args) {
        MediatorDept mediatorDept = new MediatorDept();
        //人事部
        PersonnelDept personnelDept = new PersonnelDept(mediatorDept);
        //财务部
        FinanceDept financeDept = new FinanceDept(mediatorDept);
        //采购部
        PurchasingDept purchasingDept = new PurchasingDept(mediatorDept);
        mediatorDept.setFinanceDept(financeDept);
        mediatorDept.setPersonnelDept(personnelDept);
        mediatorDept.setPurchasingDept(purchasingDept);
        //人事部新员工入职
        personnelDept.joinCompany();
        //给新员工申请办公用品
        personnelDept.applyOffices();
    }
}
