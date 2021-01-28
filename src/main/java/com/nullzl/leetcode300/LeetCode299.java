package com.nullzl.leetcode300;

public class LeetCode299 {
    public String getHint(String secret, String guess) {

        if(null == secret || null == guess || secret .length() != guess.length())
            throw new IllegalArgumentException();
        int[] amount1 = new int[10];
        int[] amount2 = new int[10];
        int count = 0;
        int amount = 0;
        for(int i = 0 ; i < secret.length() ; i++){
            char ch1 = secret.charAt(i);
            char ch2 = guess.charAt(i);
            if(ch1 == ch2)
                count++;
            amount1[ch1 - '0']++;
            amount2[ch2 - '0']++;
        }
        for(int i = 0 ; i < 10 ; i++){
            amount += Math.min(amount1[i],amount2[i]);
        }
        return count + "A" + (amount - count) + "B";
    }
}
