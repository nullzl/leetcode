package com.nullzl.leetcode400;

public class LeetCode331 {

    public boolean isValidSerialization(String preorder) {

        String[] nodes = preorder.split(",");
        int out = 1;
        for(String s : nodes){
            if(out <= 0)
                return false;
            out--;
            if(!"#".equals(s))
                out += 2;
        }
        return 0 == out;
    }
}
