package main.java.com.nullzl.leetcode400;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LeetCode350 {

    private void heapify(int[] nums,int r,int e){
        int min = r;
        int left = 2 * r  + 1;
        int right = 2 * r + 2;
        if(left <= e && nums[left] < nums[min])
            min = left;
        if(right <= e && nums[right] < nums[min])
            min = right;
        if(r != min){
            nums[min] = nums[r] ^ nums[min];
            nums[r] = nums[r] ^ nums[min];
            nums[min] = nums[r] ^ nums[min];
            heapify(nums,min,e);
        }
    }


    private void initHeap(int[] nums){
        int e = nums.length - 1;
        int i = (e - 1) >> 1;
        for(; i >= 0 ; i--){
            heapify(nums,i,e);
        }
    }

    private int poll(int[] nums,int e){
        if(0 != e){
            nums[0] = nums[0] ^ nums[e];
            nums[e] = nums[0] ^ nums[e];
            nums[0] = nums[0] ^ nums[e];
            heapify(nums,0,e-1);
        }
        return nums[e];
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        if(null == nums1 || 0 == nums1.length
        || null == nums2 || 0 == nums2.length)
            return new int[0];


        initHeap(nums1);
        initHeap(nums2);

        LinkedList<Integer> list = new LinkedList<>();
        int i = nums1.length - 1,j = nums2.length - 1;

        while(i >= 0 && j >= 0){
            if(nums1[0] == nums2[0]){
                list.add(nums1[0]);
                poll(nums1,i--);
                poll(nums2,j--);
            }else if(nums1[0] < nums2[0]){
                poll(nums1,i--);
            }else{
                poll(nums2,j--);
            }
        }
        return list.stream().mapToInt(num -> num).toArray();
    }

    public static void main(String[] args){
        Arrays.stream(
                new LeetCode350().intersect(
                        new int[]{2,3,4,1,2},
                        new int[]{1,6,1,2,6,2}
                )
        ).forEach(num -> System.out.println(num));
    }

}
