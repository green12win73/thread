package com.fq.thread.design;


import java.util.ArrayList;
import java.util.List;

public class ChainOfResponsibility_02 {
    public static void main(String[] args) {
        String string = "HELLO";
        ChainFilter chainFilter = new ChainFilter();
        chainFilter.add(new ConcatDownLineFilter());
        chainFilter.add(new ConcatWorldFilter());
        chainFilter.add(new ConvertLowerCaseFilter());
        String s = chainFilter.doFilter(string);
        System.out.println(s);
    }

    interface Filter{
        abstract String doFilter(String s);
    }

    static class ConcatDownLineFilter implements Filter{
        @Override
        public String doFilter(String s) {
            return s+"_";
        }
    }

    static class ConcatWorldFilter implements Filter{
        @Override
        public String doFilter(String s) {
            return s+"world";
        }
    }

    static class ConvertLowerCaseFilter implements Filter{
        @Override
        public String doFilter(String s) {
            return s.toLowerCase();
        }
    }

    static class ChainFilter{
        List<Filter> filters = new ArrayList<>();

        public void add(Filter filter){
            this.filters.add(filter);
        }

        public String doFilter(String string){
            for (Filter filter : filters) {
                string = filter.doFilter(string);
            }
            return string;
        }
    }
}
