package main.java.com.nullzl.leetcode200;

public class LeetCode115 {

    public int numDistinct(String s, String t) {

        if(null == s || null == t)
            return 0;
        if(0 == t.length())
            return 1;
        if(s.length() < t.length())
            return 0;


        int[] nums = new int[t.length()];
        for(int i = 0 ; i < s.length() ; i++){
            int preVal = nums[0];
            if(t.charAt(0) == s.charAt(i)){
                nums[0]++;
            }
            for(int j = 1 ; j <= i && j < t.length() ; j++){
                int temp = nums[j];
                if(t.charAt(j) == s.charAt(i)){
                    nums[j] += preVal;
                }
                preVal = temp;
            }
        }
        return nums[t.length() - 1];
    }
}
