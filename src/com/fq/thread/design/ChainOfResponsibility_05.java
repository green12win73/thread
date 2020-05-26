package com.fq.thread.design;


import java.util.ArrayList;
import java.util.List;

public class ChainOfResponsibility_05 {
    public static void main(String[] args) {
        String string = "HELLO";
        //第一个ChainFilter
        new ChainFilter().add(new ConcatAFilter())
                .add(new ConcatBFilter())
                .add(new ConcatCFilter())
                .doFilter(string);
    }

    interface Filter{
        abstract void doFilter(String s, ChainFilter f);
    }

    static class ConcatAFilter implements Filter {
        @Override
        public void doFilter(String s, ChainFilter f) {
            System.out.println(s + "_A");
            if(f.hasNext()) {
                f.nextFilter().doFilter(s, f);
            }
            System.out.println(s + "_a");
        }
    }

    static class ConcatBFilter implements Filter {
        @Override
        public void doFilter(String s, ChainFilter f) {
            System.out.println(s + "_B");
            if(f.hasNext()) {
                f.nextFilter().doFilter(s, f);
            }
            System.out.println(s + "_b");
        }
    }

    static class ConcatCFilter implements Filter {
        @Override
        public void doFilter(String s, ChainFilter f) {
            System.out.println(s + "_C");
            if(f.hasNext()) {
                f.nextFilter().doFilter(s, f);
            }
            System.out.println(s + "_c");
        }
    }

    static class ChainFilter{
        List<Filter> filters = new ArrayList<>();
        int index = -1;//记录索引下标
        int count = 0;//filter的总数

        //这里返回ChainFilter，采用了链式编程的方式，操作更方便
        public ChainFilter add(Filter filter){
            this.filters.add(filter);
            count++;
            return this;
        }

        public void doFilter(String s){
            if(hasNext()) {
                this.nextFilter().doFilter(s, this);
            }
        }

        public boolean hasNext(){
            if(index+1>=count){
                return false;
            }
            index++;
            return true;
        }

        public Filter nextFilter(){
            return this.filters.get(index);
        }
    }
}
