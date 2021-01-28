package main.java.com.nullzl.leetcode200;

public class LeetCode162 {

    public int findPeakElement(int[] nums) {

        if(null == nums || 0 == nums.length )
            return -1;

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start <= end){
            mid = (start + end) >> 1;
            if(mid - 1 >= 0 && nums[mid - 1] > nums[mid]){
                end = mid - 1;
            }else if(mid + 1 < nums.length && nums[mid + 1] > nums[mid]){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode162().findPeakElement(
                new int[]{1,2,1,3,5,6,4}
        ));
    }
}
