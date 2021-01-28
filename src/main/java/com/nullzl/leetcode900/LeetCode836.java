package main.java.com.nullzl.leetcode900;

public class LeetCode836 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        if(null == rec1 || null == rec2
        || 4 != rec1.length || 4 != rec2.length)
            throw new IllegalArgumentException();

        if(rec1[2]<= rec2[0] || rec1[0] >= rec2[2]
            || rec1[3] <= rec2[1] || rec1[1] >= rec2[3])
            return  false;
        return true;
    }
}
