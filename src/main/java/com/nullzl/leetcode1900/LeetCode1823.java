package com.nullzl.leetcode1900;

import java.util.Random;

public class LeetCode1823 {

    public int findTheWinner(int n, int k) {

        int w = 0;
        for(int count = 2; count <= n ; count++){
            w = (w + k) % count;
        }
        return w + 1;
    }

    public static void main(String[] args){
        Random r = new Random();
        int n = r.nextInt(500) + 1;
        int k = r.nextInt(n - 1) + 1;
        System.out.println(n + "\n" + k);
    }
}
