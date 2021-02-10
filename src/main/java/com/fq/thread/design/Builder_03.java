package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;

public class Builder_03 {

    //飞机抽象类
    static abstract class Airplane{
        private List<String> sequences;
        //组装引擎
        protected abstract void assembleEnginee();
        //组装机身
        protected abstract void assembleBody();
        //组装控制台
        protected abstract void assembleControl();
        //组装武器
        protected abstract void assembleWeapon();

        public void finish(){
            if(null!=this.sequences && this.sequences.size()>0){
                for (String sequence : this.sequences) {
                    switch (sequence.toLowerCase()){
                        case "enginee": this.assembleEnginee();break;
                        case "body": this.assembleBody();break;
                        case "control": this.assembleControl();break;
                        case "weapon": this.assembleWeapon();break;
                        default:break;
                    }
                }
            }
        }

        public void setSequences(List<String> sequences){
            this.sequences = sequences;
        }
    }

    //歼-7前线机
    static class AnnihilatSevenAirplane extends Airplane{
        @Override
        protected void assembleEnginee() {
            System.out.println("组装歼-7前线机引擎");
        }

        @Override
        protected void assembleBody() {
            System.out.println("组装歼-7前线机机身");
        }

        @Override
        protected void assembleControl() {
            System.out.println("组装歼-7前线机控制台");
        }

        @Override
        protected void assembleWeapon() {
            System.out.println("组装歼-7前线机武器");
        }
    }
    //歼-8高空高速截击机
    static class AnnihilatEightAirplane extends Airplane{
        @Override
        protected void assembleEnginee() {
            System.out.println("组装歼-8高空高速截击机引擎");
        }

        @Override
        protected void assembleBody() {
            System.out.println("组装歼-8高空高速截击机机身");
        }

        @Override
        protected void assembleControl() {
            System.out.println("组装歼-8高空高速截击机控制台");
        }

        @Override
        protected void assembleWeapon() {
            System.out.println("组装歼-8高空高速截击机武器");
        }
    }
    //抽象建造者
    static abstract class AirplaneBuilder{
        public abstract Airplane getAirplane();

        public abstract void setSequences(List<String> sequences);
    }
    //歼-7前线机建造者
    static class AnnihilatSevenAirplaneBuilder extends AirplaneBuilder{
        private Airplane airplane = new AnnihilatSevenAirplane();
        @Override
        public Airplane getAirplane() {
            return airplane;
        }

        @Override
        public void setSequences(List<String> sequences) {
            this.airplane.setSequences(sequences);
        }
    }
    //歼-8高空高速截击机建造者
    static class AnnihilatEightAirplaneBuilder extends AirplaneBuilder{
        private Airplane airplane = new AnnihilatEightAirplane();
        @Override
        public Airplane getAirplane() {
            return airplane;
        }

        @Override
        public void setSequences(List<String> sequences) {
            this.airplane.setSequences(sequences);
        }
    }
    //导演类，封装不同飞机型号的组装顺序
    static class Director{
        private List<String> sequences = new ArrayList<>();
        private Airplane annihilatSevenAirplane = new AnnihilatSevenAirplane();
        private Airplane annihilatEightAirplane = new AnnihilatEightAirplane();

        public Airplane getABAnnihilatSevenAirplane(){
            this.sequences.clear();
            sequences.add("enginee");
            sequences.add("body");
            this.annihilatSevenAirplane.setSequences(sequences);
            return annihilatSevenAirplane;
        }

        public Airplane getCDAnnihilatSevenAirplane(){
            this.sequences.clear();
            sequences.add("control");
            sequences.add("weapon");
            this.annihilatSevenAirplane.setSequences(sequences);
            return annihilatSevenAirplane;
        }

        public Airplane getACBDAnnihilatEightAirplane(){
            this.sequences.clear();
            sequences.add("enginee");
            sequences.add("control");
            sequences.add("body");
            sequences.add("weapon");
            this.annihilatEightAirplane.setSequences(sequences);
            return annihilatEightAirplane;
        }

    }

    public static void main(String[] args) {
        Director director = new Director();

        director.getABAnnihilatSevenAirplane().finish();

        System.out.println("==========================================================");

        director.getACBDAnnihilatEightAirplane().finish();
    }
}
