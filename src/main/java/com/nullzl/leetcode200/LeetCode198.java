package main.java.com.nullzl.leetcode200;

public class LeetCode198 {

    public int rob(int[] nums) {

        if(null == nums || 0 == nums.length)
            return 0;
        int preVal = 0;
        int val = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            int temp = Math.max(preVal + nums[i] , val);
            preVal = val;
            val = temp;
        }
        return val;
    }

    public static void main(String[] args){
        System.out.print(new LeetCode198().rob(
                new int[] {
                        2
                }
        ));
    }
}
