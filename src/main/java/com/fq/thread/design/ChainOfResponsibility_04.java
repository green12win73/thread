package com.fq.thread.design;


import java.util.ArrayList;
import java.util.List;

public class ChainOfResponsibility_04 {
    public static void main(String[] args) {
        String string = "HELLO";
        //第一个ChainFilter
        ChainFilter chainFilter = new ChainFilter()
                        .add(new ConcatDownLineFilter())
                        .add(new ConcatWorldFilter());
        //将第二个ChainFilter添加到第一个
        chainFilter.add(new ChainFilter().add(new ConvertLowerCaseFilter()));
        //执行
        chainFilter.doFilter(string);
    }

    interface Filter{
        abstract boolean doFilter(String s);
    }

    static class ConcatDownLineFilter implements Filter{
        @Override
        public boolean doFilter(String s) {
            if(null==s || "".equals(s)){
                return false;
            }
            if(s.contains("_")){
                return false;
            }
            System.out.println(s+"_");
            return true;
        }
    }

    static class ConcatWorldFilter implements Filter{
        @Override
        public boolean doFilter(String s) {
            if(null==s || "".equals(s)){
                return false;
            }
            if(s.startsWith("H")){
                return false;
            }
            System.out.println(s+" world");
            return true;
        }
    }

    static class ConvertLowerCaseFilter implements Filter{
        @Override
        public boolean doFilter(String s) {
            if(null==s || "".equals(s)){
                return false;
            }
            System.out.println(s.toLowerCase());
            return true;
        }
    }

    //让ChainFilter也实现Filter，这样其中的属性filters就可以将所有实现了Filter的都保存，
    //包括其余的ChainFilter
    static class ChainFilter implements Filter{
        List<Filter> filters = new ArrayList<>();

        //这里返回ChainFilter，采用了链式编程的方式，操作更方便
        public ChainFilter add(Filter filter){
            this.filters.add(filter);
            return this;
        }

        @Override
        public boolean doFilter(String string){
            for (Filter filter : filters) {
                boolean b = filter.doFilter(string);
                if(!b){
                    return false;
                }
            }
            return true;
        }
    }
}
