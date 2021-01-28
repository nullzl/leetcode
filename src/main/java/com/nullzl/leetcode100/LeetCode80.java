package main.java.com.nullzl.leetcode100;

public class LeetCode80 {

    public int removeDuplicates(int[] nums) {

        if(null == nums || 0 == nums.length)
            return 0;

        int preVal = nums[0];
        int count = 1;
        int maxSize = 2;
        int removeSize = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(preVal == nums[i])
                count++;
            else{
                preVal = nums[i];
                count = 1;
            }

            if(count > 2){
                removeSize++;
            }else{
                nums[i - removeSize] = nums[i];
            }
        }
        return nums.length - removeSize;
    }
}
