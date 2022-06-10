package com.nullzl.offer;

import java.util.LinkedList;

public class Offer2_040 {

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

    public int maximalRectangle(String[] matrix) {
        if(null == matrix || 0 == matrix.length || 0 == matrix[0].length())
            return  0;

        char[][] arr = new char[matrix.length][];
        for(int i = 0 ;i < matrix.length ; i++){
            arr[i] = matrix[i].toCharArray();
        }

        int[] heights = new int[matrix[0].length()];
        int max = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                heights[j] = '1' == arr[i][j] ? heights[j] + 1 : 0;
            }
            max = Math.max(max,largestRectangleArea(heights));
        }
        return max;
    }
}
