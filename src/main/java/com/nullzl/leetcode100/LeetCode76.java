package com.nullzl.leetcode100;

import java.util.HashMap;

public class LeetCode76 {

    public String minWindow(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int[] map = new int[256];
        int total = arr2.length;
        for(char ch : arr2)
            map[ch]++;
        int left = 0,right = 0;
        int begin = -1, end = arr1.length;
        for(; right < arr1.length ; right++){
            //更新窗口缺失计数
            if(map[arr1[right]]-- > 0)
                total--;

            //收缩窗口，记录可能的最大left
            int max = -1;
            while(0 == total){
                if(++ map[arr1[left]] > 0)
                    total++;
                max = left++;
            }

            //更新结果子串
            if(-1 != max && right - left + 1 < end - begin){
                begin = left;
                end = right + 1;
            }
        }
        return -1 == begin ? "" : s.substring(begin,end);
    }

    public String minWindow1(String s, String t) {
        if(null == s || 0 == s.length() || null == t || 0 == t.length() || s.length() < t.length())
            return "";
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> countMap = new HashMap<Integer, Integer>();
        int minLen = 0x7FFFFFFF;
        int minStart = -1;
        int minEnd = -1;
        int i,j,len = 0;

        for(i = 0 ; i < t.length() ; i++)
            map.put((int)t.charAt(i),map.getOrDefault((int)t.charAt(i),0) + 1);

        for(i = 0 , j = 0 ; j < s.length() ;j++ ){
            int num = s.charAt(j);
            if(map.containsKey(num)){
                int count = countMap.getOrDefault(num,0);
                int max = map.get(num);
                if(count < max)
                    len++;
                countMap.put(num,count+1);

                if(len == t.length()){
                    for(;i <= j ; i++){
                        num = s.charAt(i);
                        if(map.containsKey(num)){
                            count = countMap.get(num);
                            max = map.get(num);
                            countMap.put(num,count - 1);
                            if(count == max)
                                break;
                        }
                    }
                    if(j - i + 1 < minLen){
                        minStart = i;
                        minEnd = j;
                        minLen = j -  i + 1;
                    }
                    len--;
                    i++;
                }
            }
        }
        if(-1 != minStart){
            return s.substring(minStart,minEnd + 1);
        }
        return "";
    }
    public static void main(String[] args){
        System.out.println(new LeetCode76().minWindow("aa","aa"));
    }
}
