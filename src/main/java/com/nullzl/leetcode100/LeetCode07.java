package main.java.com.nullzl.leetcode100;

public class LeetCode07 {

    public int reverse(int x) {
        long result = 0;
        while(0 != x){
            result = result * 10 + x % 10L;
            x = x / 10;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int)result;
    }

    public static void main(String[] args){

    }
}
