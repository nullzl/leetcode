package com.nullzl.leetcode1100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LeetCode1044 {

    int base = 26 ;
    int mod = 1000000007;

    private String check(String s, int k){
        long code  = s.charAt(0) - 'a';
        long f = 1;
        for(int i = 1 ; i < k ; i++){
            code = ((code * base) % mod + s.charAt(i) - 'a') % mod;
            f = (f * base) % mod;
        }
        HashMap<Long,List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        map.put(code,list);
        for(int i = 1 ; i + k - 1 < s.length() ; i++){
            code = code - (((s.charAt(i-1) - 'a') * f) % mod);
            code = code < 0 ? mod + code : code;
            code = ((code * base) % mod + s.charAt(i + k - 1) - 'a') % mod;
            list = map.getOrDefault(code,null);
            if(null == list){
                list = new ArrayList<>();
                map.put(code,list);
            }
            String t = s.substring(i,i + k);
            for(int j = 0 ;j < list.size() ; j++){
                if(s.substring(list.get(j),list.get(j) + k).equals(t)){
                    return t;
                }
            }
            list.add(i);
        }
        return "";
    }


    public String longestDupSubstring(String S) {
        if(null == S || 0 == S.length())
            return "";
        int base = 26 ;
        int mod = 1000000007;
        int s = 1, e = S.length() - 1;
        String ans = "";
        while(s < e){
            int mid = s + ((e - s) >> 1);
            String t = check(S,mid);
            if(0 == t.length()){
                e = mid - 1;
            }else {
                ans = t;
                s = mid + 1;
            }
        }
        String t = check(S,s);
        return 0 != t.length() ? t : ans;
    }

    public static void main(String[] args){
        Random r = new Random();
        LeetCode1044 l = new LeetCode1044();
        for(int i = 0 ; i < 10000 ; i++){
            int len = r.nextInt(1000) + 2;
            char[] s = new char[len];
            for(int j = 0 ; j < len ; j++)
                s[j] = (char)('a' + r.nextInt('z' - 'a' + 1));
            System.out.print(i + "\t" + len + "\t");
            String str = new String(s);
            String rs = l.longestDupSubstring(str);
            System.out.print(rs.length() + "\t");
            String rs2 = null;
            int len2 = 0;
            for(int x = 0 ; x < len ; x++){
                for(int y = x + len2 + 1 ; y <= len; y++ ){
                    String tmp = str.substring(x,y);
                    int k = str.indexOf(tmp,x + 1);
                    if(-1 != k && y - x > len2){
                        len2 = y - x;
                        rs2 = str.substring(k,k + len2);
                    }
                }
            }
            if(null == rs2)
                rs2 = "";
            System.out.print(rs2.length() + "\t");
            if(!rs.equals(rs2)){
                System.out.println(str);
                System.out.println(rs);
                System.out.println(rs2);
                break;
            }else{
                System.out.println("ok");
            }
        }
    }
}
