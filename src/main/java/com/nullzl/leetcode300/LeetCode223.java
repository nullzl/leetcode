package com.nullzl.leetcode300;

public class LeetCode223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        int x1 = Math.max(A,E);
        int x2 = Math.min(C,G);
        if(x1 >= x2)
            return area;
        int y1 = Math.max(B,F);
        int y2 = Math.min(D,H);
        if(y1 >= y2)
            return area;
        return area - (x2 - x1) * (y2 - y1);
    }
}
