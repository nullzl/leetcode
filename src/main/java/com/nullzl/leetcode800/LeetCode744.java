package com.nullzl.leetcode800;

public class LeetCode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0;
        int e = letters.length - 1;

        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(letters[mid] > target)
                e = mid - 1;
            else
                s = mid + 1;
        }

        return s < letters.length ? letters[s] : letters[0];
    }
}
