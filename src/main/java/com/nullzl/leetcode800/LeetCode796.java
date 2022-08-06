package com.nullzl.leetcode800;

public class LeetCode796 {

    public boolean rotateString(String s, String goal) {
        String str = s + s;
        return s.length() == goal.length() && str.contains(goal);
    }
}
