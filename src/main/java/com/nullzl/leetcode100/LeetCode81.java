package main.java.com.nullzl.leetcode100;

public class LeetCode81 {

    public boolean find(int[] nums,int target,int start,int end){
        if(start > end)
            return false;
        int mid = ((start + end) >> 1);
        if(nums[mid] == target)
            return true;
        if(nums[start] < nums[end]){
            if(target < nums[mid])
                return find(nums,target,start,mid-1);
            else
                return find(nums,target,mid+1,end);
        }else if(nums[start] == nums[end]){
            if(nums[mid] < nums[start]){
                if(target < nums[mid] || target > nums[end]){
                    return find(nums,target,start,mid-1);
                }else{
                    return find(nums,target,mid+1,end);
                }
            }else if(nums[mid] == nums[start]){
                return find(nums,target,start,mid-1) ||
                        find(nums,target,mid+1,end);
            }else{
                if(target < nums[mid] && target >= nums[start])
                    return find(nums,target,start,mid-1);
                else
                    return find(nums,target,mid+1,end);
            }
        }else{
            if(nums[mid] < nums[start]){
                if(target < nums[mid] || target > nums[end])
                    return find(nums,target,start,mid-1);
                else
                    return find(nums,target,mid+1,end);
            }else if(nums[mid] == nums[start]){
                return find(nums,target,mid+1,end);
            }else{
                if(target>= nums[start] && target < nums[mid])
                    return find(nums,target,start,mid-1);
                else
                    return find(nums,target,mid+1,end);
            }
        }
    }

    public boolean search(int[] nums, int target) {

        if(null == nums || 0 == nums.length)
            return false;
        return find(nums,target,0,nums.length-1);

    }
}
