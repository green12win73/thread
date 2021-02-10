package com.fq.thread.design;

import com.fq.thread.design.vo.IPerson;

public class Main {
    public static void main(String[] args) {
//        Drive drive = new Drive();
//        drive.drive(new BaoMaDriveStragegy());
//        drive.drive(new BenChiDriveStragegy());
//        drive.drive(new AirplaneDriveStragegy());
//        AbstrackMediator abstrackMediator = new CommunicateMediator();
//        DevelopColleague developColleague = new DevelopColleague(abstrackMediator);
//        TestColleague testColleague = new TestColleague(abstrackMediator);
//        ProductColleague productColleague = new ProductColleague(abstrackMediator);
//        developColleague.repairBug();

        //访问者模式--要求被访问者对访问者开发响应的信息
//        IVisitor visitor = new SubwayVisitor();
//        AbstractPerson person = new OfficeWorker();
//        person.accept(visitor);

        //门面模式
//        ExpenseProcessFacade process = new ExpenseProcessFacade();
//        System.out.println("准妈妈到医院生孩子...");
//        process.process();
//        process.processRecovery();
        String st1 = "和谐";
        String st2 = "社会";
        String st3 = "和谐社会";
        String st4 = st3;
        System.out.println(st3 == st4);
        System.out.println(st3 == (st1+st2));
        System.out.println(st3 == (st1+st2).intern());
    }

}
