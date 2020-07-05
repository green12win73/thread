package com.fq.thread.design;

import java.util.HashMap;
import java.util.Map;

public class Adapter_02 {
    interface IUser{
        public String getUserName();
    }
    //己方用户接口
    static class UserService{
        public String getUserName(){
            String name = "张三";
            return name;
        }

    }

    interface IThrirdPartyUser{
        public Map<String, Object> getUserInfo();
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
    //用户接口适配器
    static class UserServiceAdapter extends ThrirdPartyUserService implements IUser{
        @Override
        public String getUserName(){
            Map<String, Object> userInfo = this.getUserInfo();
            return (String)userInfo.get("userName");
        }
    }

    public static void main(String[] args) {
        IUser user = new UserServiceAdapter();
        user.getUserName();
    }
}
