package com.fq.thread.design;

public class State_03 {

    static abstract class AbstractState{
        private Context context;

        public void setContext(Context context) {
            this.context = context;
        }

        public abstract void start();

        public abstract void run();

        public abstract void stop();

        public abstract void open();

        public abstract void close();

    }

    static class Context{
        public static final AbstractState startState = new StartState();
        public static final AbstractState runState = new RunState();
        public static final AbstractState stopState = new StopState();
        public static final AbstractState openState = new OpenState();
        public static final AbstractState closeState = new CloseState();

        private AbstractState state;

        public AbstractState getState() {
            return state;
        }

        public void setState(AbstractState state) {
            this.state = state;
            this.state.setContext(this);
        }

        public void start(){
            state.start();
        }

        public void run(){
            state.run();
        }

        public void stop(){
            state.stop();
        }

        public void open(){
            state.open();
        }

        public void close(){
            state.close();
        }
    }

    //启动状态
    static class StartState extends AbstractState{
        @Override
        public void start() {
            System.out.println("================启动================");
        }

        @Override
        public void run() {
            super.context.setState(Context.runState);
            super.context.getState().run();
        }

        @Override
        public void stop() {
            super.context.setState(Context.stopState);
            super.context.getState().stop();
        }

        @Override
        public void open() {

        }

        @Override
        public void close() {

        }
    }

    //行驶状态
    static class RunState extends AbstractState{
        @Override
        public void start() {

        }

        @Override
        public void run() {
            System.out.println("================运行================");
        }

        @Override
        public void stop() {
            super.context.setState(Context.stopState);
            super.context.getState().stop();
        }

        @Override
        public void open() {

        }

        @Override
        public void close() {

        }
    }

    //停止状态
    static class StopState extends AbstractState{
        @Override
        public void start() {
            super.context.setState(Context.startState);
            super.context.getState().start();
        }

        @Override
        public void run() {

        }

        @Override
        public void stop() {
            System.out.println("===============停止===============");
        }

        @Override
        public void open() {

        }

        @Override
        public void close() {

        }
    }

    //开门状态
    static class OpenState extends AbstractState{
        @Override
        public void start() {

        }

        @Override
        public void run() {

        }

        @Override
        public void stop() {

        }

        @Override
        public void open() {
            System.out.println("================开门=================");
        }

        @Override
        public void close() {
            super.context.setState(Context.closeState);
            super.context.getState().close();
        }
    }

    //启动状态
    static class CloseState extends AbstractState{
        @Override
        public void start() {
            super.context.setState(Context.startState);
            super.context.getState().start();
        }

        @Override
        public void run() {

        }

        @Override
        public void stop() {

        }

        @Override
        public void open() {
            super.context.setState(Context.openState);
            super.context.getState().open();
        }

        @Override
        public void close() {
            System.out.println("================关门=================");
        }
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(Context.closeState);
        context.open();
        context.close();
        context.start();
        context.run();
        context.stop();
    }
}
