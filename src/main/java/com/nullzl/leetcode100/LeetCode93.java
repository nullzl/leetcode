package com.nullzl.leetcode100;

import java.util.LinkedList;
import java.util.List;

public class LeetCode93 {

    private void dfs(List<String> rs , String s , int i , String ip,String num, int count){
        if(i == s.length() && 4 == count){
            rs.add(ip);
            return ;
        }
        if(i == s.length() || 4 == count || (4 - count) * 3 < num.length() + s.length() - i)
            return ;

        num += String.valueOf(s.charAt(i));
        if((num.length() > 1 && num.charAt(0) == '0') || Integer.parseInt(num) > 255){
            return ;
        }
        dfs(rs,s,i + 1,0 == count ? num : ip + "." + num,"",count+1);
        dfs(rs,s,i + 1,ip,num,count);
    }

    public List<String> restoreIpAddresses(String s) {

        LinkedList<String> rs = new LinkedList<String>();
        if(null == s || 0 == s.length() || s.length() > 12)
            return rs;
        dfs(rs,s,0,"","",0);
        return rs;
    }
}
