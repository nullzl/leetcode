package main.java.com.nullzl.leetcode300;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode202 {


    public boolean isHappy(int n) {

        if(n <= 0)
            return false;
        HashSet<Integer> set = new HashSet<>();
        int sum,temp;
        while(1 != n){
            if(set.contains(n))
                return false;
            set.add(n);
            sum = 0;
            while(0 != n){
                temp = n % 10;
                n = n / 10;
                sum += (temp * temp);
            }
            n = sum;
        }
        return true;
    }


    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        System.out.print(new LeetCode202().isHappy(0x7FFFFFFF));
    }
}
