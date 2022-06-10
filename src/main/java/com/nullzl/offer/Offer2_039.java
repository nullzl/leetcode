package com.nullzl.offer;

import com.nullzl.util.Util;

import java.util.LinkedList;

public class Offer2_039 {

    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> stk = new LinkedList<>();
        int maxArea = 0;
        for(int i = 0 ; i < heights.length ; i++){
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i]){
                int h = heights[stk.pop()];
                int s = stk.isEmpty() ? -1 : stk.peek();
                int e = i;
                int area = (e - s - 1) * h;
                if(area > maxArea)
                    maxArea = area;
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int h = heights[stk.pop()];
            int s = stk.isEmpty() ? -1 : stk.peek();
            int area = (heights.length - s - 1) * h;
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }

    public static void main(String[] args){
        System.out.println(Util.generateRandomArray(10000,0,10000));
    }
}
