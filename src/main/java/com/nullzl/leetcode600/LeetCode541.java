package com.nullzl.leetcode600;

public class LeetCode541 {

    public String reverseStr(String s, int k) {

        boolean flag = true;
        int x = 0;
        StringBuffer rs = new StringBuffer(s);
        char temp;
        while(x < s.length()){
            if(flag){

                for(int i = x,j = Math.min(x+k-1,s.length() - 1); i < j ; i++,j--){
                    temp = rs.charAt(i);
                    rs.setCharAt(i,rs.charAt(j));
                    rs.setCharAt(j,temp);
                }
                x += k;
                flag = false;
            }else{
                x += k;
                flag = true;
            }
        }
        return rs.toString();
    }

    public static void main(String[] args){
        LeetCode541 l = new LeetCode541();
        System.out.println(l.reverseStr("abcdef",3));
        System.out.println(l.reverseStr("abcde",3));
        System.out.println(l.reverseStr("abcdefg",3));
        System.out.println(l.reverseStr("abcdefgh",3));
        System.out.println(l.reverseStr("abcdefghi",3));
    }
}
