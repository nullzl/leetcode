package com.nullzl.leetcode100;

import java.util.LinkedList;

public class LeetCode20 {

    public boolean isValid(String s) {

        if(null == s || 0 == s.length())
            return true;

        LinkedList<Integer> stk = new LinkedList<Integer>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if('(' == ch){
                stk.offer(1);
            }else if(')' == ch){
                if(stk.isEmpty() || stk.pollLast() - 1 != 0)
                    return false;
            }else if('[' == ch){
                stk.offer(2);
            }else if(']' == ch){
                if(stk.isEmpty() || stk.pollLast() - 2 != 0)
                    return false;
            }else if('{' == ch){
                stk.offer(3);
            }else{
                if(stk.isEmpty() || stk.pollLast() - 3 != 0)
                    return false;
            }
        }
        if(!stk.isEmpty())
            return false;
        return true;

    }
}
