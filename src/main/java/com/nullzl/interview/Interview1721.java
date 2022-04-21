package com.nullzl.interview;

public class Interview1721 {
    public int trap(int[] height) {
        if(null == height || height.length < 2)
            return 0;

        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            if(height[left] <= height[right]){
                left++;
                if(height[left] < height[left - 1]) {
                    sum += height[left - 1] - height[left];
                    height[left] = height[left - 1];
                }
            }else{
                right--;
                if(height[right] < height[right + 1]){
                    sum += height[right + 1] - height[right];
                    height[right] = height[right + 1];
                }
            }
        }
        return sum;
    }
}
