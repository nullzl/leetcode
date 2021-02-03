package com.nullzl.leetcode400;

import java.util.Arrays;

public class LeetCode324 {


    private void swap(int[] nums,int op1,int op2){
        if(op1 != op2){
            nums[op1] = nums[op1] ^ nums[op2];
            nums[op2] = nums[op1] ^ nums[op2];
            nums[op1] = nums[op1] ^ nums[op2];
        }
    }

    private void partition(int[] nums, int s, int e, int k){
        int pos = s - 1;
        for(int i = s; i < e ; i++){
            if(nums[i] <= nums[e] && ++pos != i){
                swap(nums,i,pos);
            }
        }
        swap(nums,e,++pos);
        if(pos == k)
            return ;
        else if(pos < k)
            partition(nums,pos + 1,e,k);
        else
            partition(nums,s,pos - 1,k);
    }

    private int nextEven(int i,int k){
        if(i + 2 <= k)
            return i + 2;
        if(0 == i % 2 && 1 <= k)
            return 1;
        return -1;
    }

    private int nextOdd(int i , int k,int n){
        if(i - 2 > k)
            return i - 2;
        if(1 == i % 2) {
            i =  (0 == (n - 1) % 2) ? n - 1 : n - 2;
            return i > k ? i : -1;
        }
        return -1;
    }

    public void wiggleSort(int[] nums) {

        if(null == nums || 0 == nums.length)
            return ;

        int k = (nums.length - 1) >> 1;
        partition(nums,0,nums.length - 1, k);
        //此时位置k中的数字为中位数，nums[i] <= nusm[k](i <= k)    nums[i] >= nums[k] (i > k)
        //此时只需要将后半部分的数字插入到前半部分中间，由于nums[j] >= nums[i](i <= k,j > k),相等的情况只有一种，就是等于nums[k]
        //所以直接插入，可能会导致连续出现相等的数。
        //前半部分元素，实际都会放置在偶数位（0，2，4），后半部分放在奇数位（1，3，5）
        //所以我们将前半部分等于nums[k]的数放在最前面的偶数位，后半部分等于nums[k]放在最后面的奇数位
        //这样就会保证，存在可能排列的情况下，相等的数不会连续
        //由于最终插入的方式，采用的是交换前后两部分元素的方式，所以0到k的偶数位顺序实际是0，2，4，...，1，3，5，(遍历过程也采用此顺序)
        //后半部分从后到前的奇数位顺序也类似

        int i = 0 ,j = 0;
        int mid = nums[k];
        for(; j != -1 ; j = nextEven(j,k)){
            if(nums[j] == mid){
                swap(nums,i,j);
                i = nextEven(i,k);
            }
        }

        i = (0 == (nums.length - 1) % 2) ? nums.length - 2 : nums.length - 1;
        j = i;
        for(; j != -1 ; j = nextOdd(j,k,nums.length)){
            if(nums[j] == mid){
                swap(nums,i,j);
                i = nextOdd(i,k,nums.length);
            }
        }
        i = 1;
        j = (1 == (k + 1) % 2) ? k + 2  : k + 1;
        for(; i <= k ; i+= 2,j += 2){
            swap(nums,i,j);
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,2,0};
        new LeetCode324().wiggleSort(nums);
        Arrays.stream(nums).forEach(num -> System.out.print(num + "\t"));
    }
}
