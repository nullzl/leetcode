package main.java.com.nullzl.leetcode200;

public class LeetCode189 {

    public void swap(int[] nums,int i,int j){
        if(i != j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    public void reverse(int[] nums,int s,int e){
        while(s < e){
            swap(nums,s++,e--);
        }
    }

    public void rotate(int[] nums, int k) {

        if(null == nums || 0 == nums.length)
            return ;
        k = k % nums.length;
        if(0 == k)
            return ;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k ,nums.length - 1);

    }
}
