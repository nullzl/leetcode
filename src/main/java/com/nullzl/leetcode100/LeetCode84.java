package main.java.com.nullzl.leetcode100;

import java.util.LinkedList;

public class LeetCode84 {
    //每根柱子作为矩形中的最低高度，所能找到的最大矩形
    //即找到每个元素，左边第一个小于该元素的位置，和右边第一个小于该元素的位置
    //使用栈，栈顶大于当前元素的都出栈
    //每个元素出栈时，新的栈顶为左边小于它的第一个位置，使其出栈的元素位置，为它右边第一个小于它元素的位置
    //对于一直没有出栈的元素，其矩形可一直延伸到最左边
    //分治法，找到最小的一根柱子，最大面积是三者之一：最小柱子左边最大，右边最大，最小柱子扩展的矩形面积
    public int largestRectangleArea(int[] heights) {

        if(null == heights || 0 == heights.length)
            return 0;

        int max = 0x80000000;

        LinkedList<Integer> stk = new LinkedList<Integer>();
        stk.push(-1);
        for(int i = 0; i < heights.length ; i++){
            while(-1 != stk.peek()){
                if(heights[stk.peek()]==heights[i]){
                    stk.pop();
                    continue;
                }else if(heights[stk.peek()] < heights[i]){
                    break;
                }
                int height = heights[stk.pop()];
                int start = stk.peek() + 1;
                int area = (i - start) * height;
                if(area > max)
                    max = area;
            }
            stk.push(i);
        }
        while(-1 != stk.peek()){
            int height = heights[stk.pop()];
            int start = stk.peek() + 1;
            int area = (heights.length - start) * height;
            if(area > max)
                max = area;
        }
        return max;
    }
}
