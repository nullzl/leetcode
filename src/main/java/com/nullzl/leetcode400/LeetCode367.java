package com.nullzl.leetcode400;

public class LeetCode367 {

    public boolean isPerfectSquare(int num) {

        if(1 == num)
            return true;

        int s = 2;
        int e = num / 2;

        while(s <= e){
            int mid = s + ((e - s) >> 1);
            int tmp = num / mid  ;
            if(tmp == mid && 0 == num % mid)
                return true;
            if(tmp == mid)
                return false;
            if(tmp > mid)
                s = mid + 1;
            else
                e = mid -1;
        }
        return false;

    }

    public static void main(String[] args){
        System.out.println(new LeetCode367().isPerfectSquare(14));
    }
}
