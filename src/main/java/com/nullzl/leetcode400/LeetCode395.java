package main.java.com.nullzl.leetcode400;

public class LeetCode395 {

    private int longest(char[] chs,int s,int e,int k){
        if(e < s || e - s + 1 < k)
            return 0;
        int[] amount = new int['z' - 'a' + 1];
        int i;
        for(i = s ; i <= e; i++){
            amount[chs[i] - 'a']++;
        }
        for(i = 0 ; i < amount.length ; i++){
            if(0 != amount[i] && amount[i] < k)
                break;
        }
        if(i == amount.length)
            return e - s + 1;

        int len = 0;
        int start = s;
        for(i = s; i <= e ; i++){
            if(amount[chs[i] - 'a'] < k){
                if(i - start > len){
                    len = Math.max(len,longest(chs,start,i-1,k));
                }
                start = i + 1;
            }
        }
        if(start <= e && i - start > len){
            len = Math.max(len,longest(chs,start,i-1,k));
        }
        return len;
    }

    public int longestSubstring(String s, int k) {
        if(null == s || 0 == s.length())
            return 0;
        char[] chs = s.toCharArray();
        return longest(chs,0,s.length() - 1,k);
    }

    public static void main(String[] args){
        System.out.println(new LeetCode395().longestSubstring("bbaaacbd",3));
    }
}
