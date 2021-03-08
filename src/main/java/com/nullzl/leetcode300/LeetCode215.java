package com.nullzl.leetcode300;

public class LeetCode215 {

    private void heapify(int[] nums,int root){
        int min = root;
        int left = (root << 1) + 1;
        int right = (root << 1) + 2;
        if(left < nums.length && nums[left] < nums[min])
            min = left;
        if(right < nums.length && nums[right] < nums[min])
            min = right;
        if(min != root) {
            int temp = nums[min];
            nums[min] = nums[root];
            nums[root] = temp;
            heapify(nums, min);
        }
    }

    private void initHeap(int[] nums){
        int i = (nums.length - 2) >> 1;
        for(; i >= 0 ; i--)
            heapify(nums,i);
    }

    public int findKthLargest(int[] nums, int k) {
        if(null == nums || 0 == nums.length || 0 == k || k > nums.length)
            throw new IllegalArgumentException();

        int[] heap = new int[k];
        for(int i = 0 ; i < k ; i++){
            heap[i] = nums[i];
        }
        initHeap(heap);

        for(int i = k ; i < nums.length ; i++){
            if(nums[i] > heap[0]){
                heap[0] = nums[i];
                heapify(heap,0);
            }
        }
        return heap[0];
    }

    public static void main(String[] args){
        System.out.println(new LeetCode215().findKthLargest(
                new int[] {
                        3,2,1,5,6,4
                }
        ,2));
    }
}
