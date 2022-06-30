package com.nullzl.offer;

import java.util.LinkedList;
import java.util.List;

public class Offer2_87 {

    List<String> ans = new LinkedList<>();

    private void dfs(String s,String[] ip,int size,int idx){
        if(idx == s.length() && size == ip.length){
            StringBuilder str = new StringBuilder();
            str.append(ip[0]);
            str.append("." + ip[1]);
            str.append("." + ip[2]);
            str.append("." + ip[3]);
            ans.add(str.toString());
            return ;
        }

        if(idx == s.length() || size == ip.length)
            return ;
        boolean prev = true;
        for(int i = 1 ; i <= 3 && idx + i <= s.length() ; i++){
            String num = s.substring(idx,idx + i);
            if(check(num)){
                ip[size] = num;
                dfs(s,ip,size + 1,idx + i);
            }else{
                break;
            }
        }
    }

    private boolean check(String s){
        if('0' == s.charAt(0) && 1 != s.length())
            return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

    public List<String> restoreIpAddresses(String s) {
        String[] ip = new String[4];
        dfs(s,ip,0,0);
        return ans;
    }
}
