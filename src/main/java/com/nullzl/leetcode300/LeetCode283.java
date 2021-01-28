package main.java.com.nullzl.leetcode300;

public class LeetCode283 {

    public void moveZeroes(int[] nums) {

        if(null == nums)
            return ;

        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(0 == nums[i])
                count++;
            else if(0 != count)
                nums[i - count] = nums[i];
        }
        for(int i = 0 ; i < count; i++)
            nums[nums.length - 1 - i] = 0;

    }

    public static void main(String[] args){
        int[] nums = {2,0,3,0,4};
        new LeetCode283().moveZeroes(nums);
        for(int i = 0 ; i < nums.length; i++)
            System.out.print(nums[i] + "\t");
    }
}
