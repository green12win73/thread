package com.fq.thread.design;

import com.fq.thread.design.vo.IPerson;

public class Main {
    public static void main(String[] args) {
//        Drive drive = new Drive();
//        drive.drive(new BaoMaDriveStragegy());
//        drive.drive(new BenChiDriveStragegy());
//        drive.drive(new AirplaneDriveStragegy());
        AbstrackMediator abstrackMediator = new CommunicateMediator();
        DevelopColleague developColleague = new DevelopColleague(abstrackMediator);
        TestColleague testColleague = new TestColleague(abstrackMediator);
        ProductColleague productColleague = new ProductColleague(abstrackMediator);
        developColleague.repairBug();
    }
}
