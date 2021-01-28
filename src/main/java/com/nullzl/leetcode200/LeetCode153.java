package main.java.com.nullzl.leetcode200;

public class LeetCode153 {

    public int findMin(int[] nums) {

        int s = 0 ;
        int e = nums.length - 1;

        while(s <= e){
            if(nums[e] >= nums[s])
                return nums[s];
            int mid = (s + e) >> 1;
            if(nums[mid] >= nums[s]){
                s = mid + 1;
            }else {
                e = mid;
            }
        }

        int min = 0 ;
        if(s < nums.length){
            min = nums[s];
        }
        if(e >= 0){
            min = Math.min(min,nums[e]);
        }
        return min;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode153().findMin(
                new int[] {
                        3,1,2
                }
        ));
    }

}
