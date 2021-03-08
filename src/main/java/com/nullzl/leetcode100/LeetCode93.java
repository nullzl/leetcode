package com.nullzl.leetcode100;

import java.util.LinkedList;
import java.util.List;

public class LeetCode93 {

    private void getIP(List<String> rs,String s,int index,int count,String ip){
        if(4 == count){
            int num = 0;
            for(int i = index ; i < s.length() ; i++){
                num = num * 10 + (s.charAt(i) - '0');
                if(num == 0 && i != s.length() - 1){
                    return ;
                }
            }
            if(num >= 0 && num <= 255){
                ip += ("." + num);
                rs.add(ip);
            }
            return ;
        }


    }

    public List<String> restoreIpAddresses(String s) {

        LinkedList<String> rs = new LinkedList<String>();
        if(null == s || 0 == s.length() || s.length() > 12)
            return rs;

        return rs;

    }
}
