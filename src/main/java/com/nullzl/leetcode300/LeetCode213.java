package main.java.com.nullzl.leetcode300;

public class LeetCode213 {

    public int rob(int[] nums) {

        if(null == nums || 0 == nums.length)
            return 0;
        if(1 == nums.length)
            return nums[0];

        int pre1 = nums[0];
        int pre2 = 0;
        int pre3 = 0;
        int pre4 = 0;
        int temp;
        for(int i = 1; i < nums.length - 2; i++){
            temp = pre1 ;
            pre1 = Math.max(pre1,pre2 + nums[i]);
            pre2 = temp;
            temp = pre3 ;
            pre3 = Math.max(pre3,pre4 + nums[i]);
            pre4 = temp;
        }
        if(nums.length - 2 > 0)
            pre1 = Math.max(pre1,pre2 + nums[nums.length - 2]);
        pre3 += nums[nums.length - 1];

        return Math.max(pre1,pre3);
    }
    public static void main(String[] args){
        System.out.println(new LeetCode213().rob(
                new int[] {
                        4,2,3,3,4
                }
        ));
    }
}
