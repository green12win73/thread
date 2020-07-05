package com.fq.thread.design;

import java.util.HashMap;
import java.util.Map;

public class Adapter_01 {
    //己方用户接口
    static class UserService{
        public String getUserName(){
            String name = "张三";
            return name;
        }

    }
    //三方的用户接口
    static class ThrirdPartyUserService{
        public Map<String, Object> getUserInfo(){
            Map<String, Object> map = new HashMap<>();
            map.put("userName","张三");
            map.put("age",23);
            return map;
        }

    }

}
