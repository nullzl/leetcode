package com.nullzl.interview;

public class Interview1719 {

    public int[] missingTwo1(int[] nums) {
        if(null == nums || 0 == nums.length)
            return new int[]{1,2};

        int[] pos = new int[]{-1,-1};
        int n = nums.length + 2;
        for(int i = 0 ; i < nums.length ; ){
            if(nums[i] >= n - 1){
                pos[nums[i] - n + 1] = ++i;
            }else if(nums[i] == i + 1)
                i++;
            else{
                int j = nums[i] - 1;
                nums[i] = nums[j] ^ nums[i];
                nums[j] = nums[j] ^ nums[i];
                nums[i] = nums[j] ^ nums[i];
            }
        }
        if(-1 == pos[0])
            pos[0] = n - 1;
        if(-1 == pos[1])
            pos[1] = n;
        return pos;
    }

    public int[] missingTwo(int[] nums) {
        if(null == nums || 0 == nums.length)
            return new int[]{1,2};

        int missSum = 0;
        int sum = 0;
        for(int num : nums)
            missSum ^= num;
        for(int i = 1 ; i <= nums.length + 2 ; i++)
            sum ^= i;

        int delta = sum ^ missSum;
        int lowbit = delta & (-delta);
        missSum = sum = 0;
        for(int num : nums){
            if(0 != (lowbit & num))
                missSum ^= num;
        }
        for(int i = 1 ; i <= nums.length + 2 ; i++){
            if(0 != (lowbit & i))
                sum ^= i;
        }
        return new int[]{sum ^ missSum, sum ^ missSum ^ delta};
    }
}
