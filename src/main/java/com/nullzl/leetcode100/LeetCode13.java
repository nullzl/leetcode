package main.java.com.nullzl.leetcode100;

public class LeetCode13 {

    public int romanToInt(String s) {

        if(null == s)
            return 0;

        int rs = 0;
        int i,j;
        String[] chs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        for(i = 0,j=0 ;i < chs.length && j < s.length();){
            if(s.startsWith(chs[i],j)) {
                rs += nums[i];
                j += chs[i].length();
            }
            else
                i++;
        }
        return rs;
    }
}
