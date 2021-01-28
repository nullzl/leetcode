package main.java.com.nullzl.leetcode100;

public class LeetCode29 {

    public int divide(int dividend, int divisor) {
        if(0 == divisor)
            return 0x7FFFFFFF;
        if(0x80000000 == dividend && -1 == divisor)
            return 0x7FFFFFFF;
        if(-1 == divisor)
            return -dividend;
        if(1 == divisor)
            return dividend;

        boolean flag = (((dividend & 0x80000000) == (divisor & 0x80000000))  ? true :  false);
        int maxLen = 31;
        int len = 1;
        int count = 1;
        divisor = divisor < 0 ? divisor : -divisor;
        dividend = dividend < 0 ? dividend : -dividend;
        int[] nums = new int[maxLen];
        nums[0] = divisor;
        for(int i = 1 ; i < maxLen && (dividend - nums[i-1]) <= nums[i-1] ; i++){
            nums[i] = nums[i] << 1;
            len++;
            count = count << 1;
        }

        int rs = 0 ;
        for(int i = len -1 ;i >= 0 ; i--){
            if(dividend <= nums[i]){
                rs += count;
                dividend -= nums[i];
            }
            count = count >> 1;
        }
        if(!flag){
            rs = -rs;
        }
        return rs;

    }
}
