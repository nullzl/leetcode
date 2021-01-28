package main.java.com.nullzl.leetcode200;

public class LeetCode172 {

    public int trailingZeroes(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        while(0 != n){
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode172().trailingZeroes(1));
    }
}
