package com.nullzl.leetcode100;

import java.util.LinkedList;

public class LeetCode85 {


    private int findMaxArea(int[] heights){
        int maxArea = 0;
        LinkedList<Integer> stk = new LinkedList<Integer>();
        stk.push(-1);
        for(int i = 0  ; i < heights.length;  i++){
            while(-1 != stk.peek()){
                if(heights[stk.peek()] == heights[i]) {
                    stk.pop();
                    continue;
                }
                if(heights[stk.peek()] < heights[i])
                    break;
                maxArea = Math.max(maxArea,heights[stk.pop()] * (i-stk.peek()-1));
            }
            stk.push(i);
        }
        while(-1 != stk.peek()){
            maxArea = Math.max(maxArea,heights[stk.pop()] * (heights.length-stk.peek()-1));
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {

        if(null == matrix || 0 == matrix.length || null == matrix[0] || 0 == matrix[0].length)
            return 0;

        int maxArea = 0;
        int[] heights = new int[matrix[0].length];

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                heights[j] = ('0' == matrix[i][j] ? 0 : heights[j]+1);
            }
            maxArea = Math.max(maxArea,findMaxArea(heights));
        }
        return maxArea;
    }
}
