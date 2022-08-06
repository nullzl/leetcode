package com.nullzl.leetcode1500;

public class LeetCode1423 {

    public int maxScore(int[] cardPoints, int k) {
        for(int i =  1; i < cardPoints.length ; i++)
            cardPoints[i] += cardPoints[i-1];

        if(k == cardPoints.length)
            return cardPoints[cardPoints.length - 1];

        k = cardPoints.length - k;
        int min  = cardPoints[k-1];
        for(int i = k ; i < cardPoints.length ; i++){
            min = Math.min(min,cardPoints[i] - cardPoints[i - k]);
        }
        return cardPoints[cardPoints.length - 1] - min;
    }
}
