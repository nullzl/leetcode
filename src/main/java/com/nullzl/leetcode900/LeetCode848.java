package com.nullzl.leetcode900;

public class LeetCode848 {

    public String shiftingLetters(String s, int[] shifts) {
        int sum = 0;
        char[] arr = s.toCharArray();
        for(int n : shifts){
            sum = (sum + n) % 26;
        }
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = (char)((((arr[i] - 'a') + sum) % 26) + 'a');
            sum = (((sum - shifts[i]) % 26) + 26) % 26;
        }
        return new String(arr);
    }
}
