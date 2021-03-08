package com.nullzl.leetcode500;

public class LeetCode416 {


    /**
     * 1. 分为和相等的两个子集，那么各子集的和一定为数组总和的一半，假设为k(总和为奇数，直接返回fanlse)
     * 2. 最多200个数，最大为100，因此子集总和最大为10000
     * 3. 使用boolean f[10001]来记录范围0到10000，true，表示某个子集和为下标值
     * 4. 如果能找到和为k的子集，就可以分割，否则不可以分割
     * 5. 初始和为0，所以f[0] = true
     * 6. 遍历每个数nums[j]，然后遍历整个f数组，如果f[i]=true则置f[i+nums[j]=true
     * 7. 直到遍历完毕，或者找到k
     * 8. 整体循环次数不超过200 * 10001
     */
    public boolean canPartition(int[] nums) {

        if(null == nums || nums.length > 200 || 0 == nums.length)
            throw new IllegalArgumentException();

        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1)
            return false;
        else
            sum = sum / 2;

        boolean[] flag = new boolean[sum + 1];
        flag[0] = true;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 100)
                throw new IllegalArgumentException();
            //必须从尾到头遍历，从头到尾，本轮会修改后面的flag值，导致flag为true
            for(int j = sum ;  j >= 0 ; j--){
                if(flag[j] && j + nums[i] <= sum){
                    flag[j + nums[i]] = true;
                    if(sum == j + nums[i])
                        return true;
                }
            }
        }
        return false;
    }
}
