package com.nullzl.leetcode100;

public class LeetCode11 {

    public int maxArea1(int[] height) {

        int maxArea = 0;
        int i,j,area;
        for(i = 1; i < height.length ; i++){
            if(0 == height[i])
                continue;
            int minStep = maxArea / height[i];
            for(j = i - minStep -1; j >= 0; j--){
                area = (height[i] < height[j] ? height[i] : height[j]) * (i - j);
                if(area > maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }

    //o(n)的算法
    //从步长来考虑，假设最大的步长为k
    /**
     *  步长为k的包含：    h[0]h[k]
     *  步长为k-1的包含：  h[0]h[k-1],h[1]h[k]
     *  步长为k-2的包含：  h[0]h[k-2],h[1]h[k-1],h[2]h[k-2]
     *  发现如果h[0]<h[k],那么凡是和h[0]组队的其他步长，都没有h[0]h[k]大，所以在其他步长时不需要考虑。所以在考虑其他步长时，丢弃h[0]
     *  当h[0]=h[k]时，包含h[0]和h[k]的其他步长都不需要考虑
     *  以此类推，每个步长只需要考虑首尾一对数比较的情况。
     */
    public int maxArea2(int[] height) {

        int maxArea = 0;
        int i,j,area;
        for(i = 0,j = height.length -1; i < j ; ){
            area = j - i;
            if(height[i] < height[j]){
                area = area * height[i];
                i++;
            }else if(height[i] == height[j]){
                area = area * height[i];
                i++;
                j--;
            }else{
                area = area * height[j];
                j--;
            }
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
}
