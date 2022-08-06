package com.nullzl.leetcode400;


import java.util.Random;

public class LeetCode316 {

    public String removeDuplicateLetters(String s) {

        int[] count = new int['z' - 'a' + 1];
        boolean[] exist = new boolean['z' - 'a' + 1];

        for(int i = 0 ; i < s.length() ; i++){
            count[s.charAt(i) - 'a']++;
        }
        StringBuffer rs = new StringBuffer();
        for(int i = 0 ; i < s.length() ; i++){
            int index = s.charAt(i) - 'a';
            if(!exist[index]) {
                while(rs.length() > 0
                        && count[rs.charAt(rs.length() - 1) - 'a'] > 0
                        && rs.charAt(rs.length() - 1) > s.charAt(i)) {
                    exist[rs.charAt(rs.length() - 1) - 'a'] = false;
                    rs.deleteCharAt(rs.length() - 1);
                }
                exist[index] = true;
                rs.append(s.charAt(i));
            }
            count[index]--;
        }
        return rs.toString();

    }

    public static void main(String[] args){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < 1000;i++){
            sb.append((char)(r.nextInt('f' - 'a' + 1) + 'a'));
        }
        System.out.println(sb.toString());
    }


}
