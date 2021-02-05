package com.fq.thread.design;


import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 */
public class ChainMain {

    public static void main(String[] args) {
        Request request = new Request();
        request.str="request";

        Response response = new Response();
        response.str="response";

        FilterChain filterChain = new FilterChain();
        filterChain.add(new ConcatFilter()).add(new LowerCaseFilter());
        filterChain.doFilter(request, response);

        System.out.println("request.str="+request.str);
        System.out.println("response.str="+response.str);
    }


}

class Request{
    String str;
}

class Response{
    String str;
}

interface Filter{
    boolean doFilter(Request request, Response response);
}

class FilterChain implements Filter{
//    List<Filter> filters = new ArrayList<>();
    FilterChain preFilter = null;
    FilterChain nextFilter = null;
    public FilterChain add(FilterChain filter){
        if(null==nextFilter){
            nextFilter = filter;
            filter.preFilter=this;
        }else{
            filter.add(this);
        }
        return filter;
    }

    @Override
    public boolean doFilter(Request request, Response response) {
        if(null!=nextFilter) {
            System.out.println("==========request.str="+request.str+"==========");
            nextFilter.doFilter(request, response);
        }else if(null!=preFilter){
            System.out.println("==========response.str="+response.str+"==========");
            preFilter.nextFilter=null;
            preFilter.doFilter(request, response);
        }
        return true;
    }
}

class ConcatFilter extends FilterChain{
//    Filter nextFilter = null;
    @Override
    public boolean doFilter(Request request, Response response) {
        if(null!=nextFilter) {
            request.str = request.str + "_A";
            System.out.println("==========request拼接字符串_A==========");
            nextFilter.doFilter(request, response);
        }else if(null!=preFilter){
            response.str = response.str+"_B";
            System.out.println("==========response拼接字符串_B==========");
            preFilter.nextFilter=null;
            preFilter.doFilter(request, response);
        }
        return true;
    }
}

class LowerCaseFilter extends FilterChain{
//    Filter nextFilter = null;
    @Override
    public boolean doFilter(Request request, Response response) {
        if(null!=nextFilter){
            request.str = request.str.toLowerCase();
            System.out.println("==========request全部转小写==========");
            nextFilter.doFilter(request, response);
        }else if(null!=preFilter){
            response.str = response.str.toLowerCase();
            System.out.println("==========response全部转小写==========");
            preFilter.nextFilter=null;
            preFilter.doFilter(request, response);
        }
        return true;
    }
}