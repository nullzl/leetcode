package com.nullzl.leetcode100;

public class LeetCode05 {

    int start = 0,end = 0;
    private void longest(boolean[] visited,char[] arr,int pos){
        if(visited[pos])
            return;
        visited[pos] = true;
        int left = pos - 1;
        int right = pos + 1;
        while(left >= 0 && arr[left] == arr[pos]){ visited[left]= true;left--;}
        while(right < arr.length && arr[right] == arr[pos]) {visited[right] = true ; right++;}
        while(left >= 0 && right < arr.length && arr[left] == arr[right]){
            left--;right++;
        }
        if(right - left - 1 > end - start){
            start = left + 1;
            end = right;
        }
    }


    public String longestPalindrome7(String s) {
        boolean[] visited = new boolean[s.length()];
        char[] arr = s.toCharArray();
        int mid = (s.length() - 1) >> 1;
        for(int k = 0 ; (mid + k < arr.length || mid - k >= 0) && ((mid - k + 1) << 1) > (end - start) ; k++){

            if(mid - k >= 0)
                longest(visited,arr,mid - k);
            if(mid + k < arr.length)
                longest(visited,arr,mid + k);
        }
        return s.substring(start,end);
    }

    //马拉车
    //进一步可优化内存，不实际构造字符串
    public String longestPalindrome5(String s) {

        if(null == s || 0 == s.length())
            return "";
        StringBuilder str = new StringBuilder("#");
        for(int i = 0 ; i < s.length() ; i++){
            str.append(s.charAt(i));
            str.append('#');
        }
        int[] len = new int[str.length()];
        int maxLeft = 0;
        int maxRight = 0;
        int maxLen = 1;
        int curCenter = 0;
        int curBound = 0;
        int curIndex = 1;
        int gap;
        for(;curIndex < str.length() && str.length() - curIndex > maxLen ; curIndex++){
            int leftIndex = 2 * curCenter - curIndex;
            if(curIndex < curBound && (len[leftIndex] < curBound - curIndex + 1 )){
                len[curIndex] = len[leftIndex];
                continue;
            }
            if(curIndex >= curBound){
                gap = 1;
            }else{
                gap = curBound - curIndex + 1;
            }
            for(; curIndex - gap >= 0 && curIndex + gap <= str.length()
                    && str.charAt(curIndex - gap) == str.charAt(curIndex + gap); gap++);
            len[curIndex] = gap;
            if(len[curIndex] > maxLen){
                maxLen = len[curIndex];
                maxLeft = curIndex - gap + 1;
                maxRight = curIndex + gap - 1;
            }
            if(curIndex + gap - 1 > curBound){
                curBound = curIndex + gap - 1;
                curCenter = curIndex;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = maxLeft; i <= maxRight ; i++){
            if('#' != str.charAt(i))
                result.append(str.charAt(i));
        }
        return result.toString();

    }

    //动态规划和暴力法类似
    public String longestPalindromeDP(String s) {
        if(null == s || 0 == s.length())
            return "";
        int[][] len = new int[s.length()][s.length()];
        int maxLen = 1;
        int maxStart = 0 ;
        int maxEnd  = 0 ;
        for(int i = 0 ; i < s.length() - 1 ; i++){
            len[i][i] = 1;
            len[i][i + 1] = (s.charAt(i) == s.charAt(i + 1) ? 2 : 0);
            if(2 == len[i][i+1]){
                maxLen = 2;
                maxStart = i;
                maxEnd = i + 1;
            }
        }
        len[s.length() - 1][s.length() -1] = 1;
        for(int k = 2 ; k < s.length() ; k++){
            for(int i = 0,j = k; i < s.length() && j < s.length();i++,j++){
                len[i][j] = (0 != len[i+1][j-1] && s.charAt(i) == s.charAt(j) ? len[i+1][j-1] + 2 : 0);
                if(len[i][j] > maxLen){
                    maxLen = len[i][j];
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }
        return s.substring(maxStart,maxEnd + 1);
    }

    //暴力法，遍历每个字母，以此字母为中心展开
    public String longestPalindrome2(String s) {
        if(null == s || 0 == s.length())
            return "";
        int maxStart = -1;
        int maxLen = 0;
        for(int k = 0 ; k < s.length() ; k++){
            int len = 1;
            for(int i = k - 1, j = k + 1; i >= 0 && j < s.length() ; i--,j++){
                if(s.charAt(i) == s.charAt(j))
                    len += 2;
                else break;
            }
            if(maxLen < len){
                maxLen = len;
                maxStart = k - (len - 1) / 2;
            }

            len = 0;
            for(int i = k,j = k + 1; i >= 0 && j < s.length() ; i--,j++){
                if(s.charAt(i) == s.charAt(j))
                    len += 2;
                else
                    break;
            }
            if(maxLen < len){
                maxLen = len;
                maxStart = k - len / 2 + 1;

            }
        }
        return s.substring(maxStart,maxStart + maxLen);
    }

    public boolean compare(char[] arr,int i,int j){
        return (0 == (i & 1) && 0 == (j & 1)) || (0 != (i & 1) && 0 != (j & 1) && (arr[i >> 1] == arr[j >> 1]));
    }

    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int[] r = new int[(arr.length << 1) + 1];
        int c = 0 , g = 0;
        r[0] = 1;
        for(int i = 1 ; i < r.length ; i++){
            int j = i >= g ? i + 1 : Math.min(g + 1, i + r[(c << 1) - i]);
            while(j < r.length && (i << 1) - j >= 0 && compare(arr,j,(i << 1) - j))j++;
            r[i] = j - i;
            if(j > g) {
                c = i;
                g = j - 1;
            }
        }
        int maxIdx = 0;
        for(int i = 1 ; i < r.length ; i++)
            if(r[maxIdx] < r[i])
                maxIdx = i;

        int a = (maxIdx + r[maxIdx] - 2) >> 1;
        int b = (maxIdx - r[maxIdx] + 2) >> 1;
        return s.substring(b,a + 1);
    }

    public static void main(String[] args){
        String str = "bb";
        System.out.println(new LeetCode05().longestPalindrome(str));
    }
}
