package com.nullzl.leetcode900;

public class LeetCode818 {

    public int racecar(int target) {

        if(0 == target)
            return 0;
        int max = 13;
        int f = (1 << max);
        int pos = max + 1;

        while(0 == (f & target)){
            f >>= 1;
            pos--;
        }
        int count = pos;
        int cur = 1;
        while(f != 0){
            int tmp = (f & target) == 0 ? 0 : 1;
            if(tmp != cur){
                cur = cur == 0 ? 1 : 0;
                count += (pos + 1);
            }
            f >>= 1;
            pos --;
        }
        return count;
    }

    public static void main(String[] args){
        new LeetCode818().racecar(8);
    }
}
