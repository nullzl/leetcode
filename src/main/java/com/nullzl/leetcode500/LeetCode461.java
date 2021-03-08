package com.nullzl.leetcode500;

public class LeetCode461 {

    public int hammingDistance(int x, int y) {

        int count = 0;
        if(x == y)
            return 0;
        for(int i = 1,exp = 1; i <= 31 ; i++,exp = exp << 1){
            if(0 != ((x & exp) ^ (y & exp)))
                count++;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.print(new LeetCode461().hammingDistance(0x7FFFFFFF,1));
    }
}
