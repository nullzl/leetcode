package com.nullzl.leetcode200;

public class LeetCode137 {

    /**
     * 因为使用位运算来实现，所以只考虑一位
     * 出现两次，可以使用异或，实现出现两次1，就归0
     * 出现k次，使用1个位就无法表达1出现了几次，假设n为二进制可表达k，所以使用n个数
     * 题中k为3，则使用两位，每次遇到1变化的这两位变化的轨迹为00-01-10-00
     * 低位A，只有在上次为00，且本次输入为1时，才会变为1，所以低位为1的逻辑表达式为 （非A & 非B）
     * 高位B，只有在上次为01，且本次输入位1时，才变为1，所以逻辑表达式为(A & 非B)
     * 当输入为0时，需要保持不变：
     * 低位逻辑表达式 （num & 非A & 非B）| （非num & A）
     * 高位逻辑表达式（num & A & 非B ） | （非num & B）
     * 每个数有32位，所以使用两个数，low表示每个数的低位，high表示高位
     */

    public int singleNumber(int[] nums) {

        if(null == nums || 0 == nums.length){
            return 0 ;
        }

        int low = 0;
        int high = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int temp = low;
            int num1 = ~nums[i];
            int low1 = ~low;
            int high1 = ~high;
            low = ((nums[i] & low1 & high1) | (num1 & low));
            high = ((nums[i] & temp & high1) | (num1 & high));
        }
        return low;
    }

    public static void main(String[] args){
        int[] nums = {0};
        System.out.println(new LeetCode137().singleNumber(nums));
    }

}
