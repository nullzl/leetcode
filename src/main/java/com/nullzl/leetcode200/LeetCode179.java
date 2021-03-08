package com.nullzl.leetcode200;

public class LeetCode179 {

    /**
     * 特殊输入：
     * 1. {0,0,0} 结果为0
     */

    private int compare(String num1,String num2){
        int index1 = 0;
        int index2 = 0;
        char ch1,ch2;
        String str1 = num1;
        String str2 = num2;
        int len = num1.length() + num2.length();
        for(int i = 0 ; i < len ; i++){
            ch1 = str1.charAt(index1++);
            ch2 = str2.charAt(index2++);
            if(ch1 > ch2)
                return 1;
            else if(ch1 < ch2)
                return -1;
            else{
                if(index1 == str1.length()){
                    index1 = 0;
                    str1 = num2;
                }
                if(index2 == str2.length()){
                    index2 = 0;
                    str2 = num1;
                }
            }
        }
        return 0;
    }

    private void swap(String[] strs,int i,int j){
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    private void heapify(String[] strs,int root,int end){
        int left = (root << 1) + 1;
        int right = (root << 1) + 2;
        int max = root;
        if(left <= end && compare(strs[max],strs[left]) < 0){
            max = left;
        }
        if(right <= end && compare(strs[max],strs[right]) < 0)
            max = right;
        if(max != root){
            swap(strs,max,root);
            heapify(strs,max,end);
        }
    }

    private void initHeap(String[] strs){
        int k = (strs.length - 2) >> 1;
        for(; k >= 0 ; k--){
            heapify(strs,k,strs.length - 1);
        }
    }

    private void mergeSort(String[] strs){
        initHeap(strs);
        for(int i = strs.length - 1; i > 0 ; i--){
            swap(strs,0,i);
            heapify(strs,0,i-1);
        }
    }

    public String largestNumber(int[] nums) {

        if(null == nums || 0 == nums.length)
            return "";
        String[] strs = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            strs[i] = String.valueOf(nums[i]);
        }

        mergeSort(strs);
        StringBuffer rs = new StringBuffer();
        for(int i = strs.length - 1 ; i >= 0 ; i--){
            rs.append(strs[i]);
        }
        return ('0' == rs.charAt(0) ? "0" : rs.toString());
    }

    public static void main(String[] args){
        System.out.print(new LeetCode179().largestNumber(
                new int[] {
                        3,33332,33334
                }
        ));

    }
}
