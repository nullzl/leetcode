package com.nullzl.leetcode1100;

import java.util.Random;

public class LeetCode1044 {

    public String longestDupSubstring(String S) {

        if(null == S || 2 > S.length())
            return "";

        int pos = -1;
        int len = 0;
        int[] next = new int[S.length()];
        for(int i = 0 ; i < S.length(); i++){
            next[i] = i;
            int p = i;
            for(int j = i + 1 ; j < S.length() ; ){
                if(S.charAt(j) == S.charAt(p)){
                    next[j++] = ++p;
                    if(p - i > len){
                        len = p - i;
                        pos = i;
                    }
                }else if(i == p){
                    next[j++] = i;
                }else
                    p = next[p-1];
            }
        }
        return len == 0 ? "" : S.substring(pos, pos + len);
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
