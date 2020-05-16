package com.fq.thread.design;

public abstract class AbstrackMediator {
    protected DevelopColleague developColleague;
    protected TestColleague testColleague;
    protected ProductColleague productColleague;

    public AbstrackMediator() {
//        developColleague = new DevelopColleague(this);
//        testColleague = new TestColleague(this);
//        productColleague = new ProductColleague(this);
    }

    public void setDevelopColleague(DevelopColleague developColleague) {
        this.developColleague = developColleague;
    }

    public void setTestColleague(TestColleague testColleague) {
        this.testColleague = testColleague;
    }

    public void setProductColleague(ProductColleague productColleague) {
        this.productColleague = productColleague;
    }

    public abstract void excute(Integer type);
}
