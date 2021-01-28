package main.java.com.nullzl.leetcode500;

import java.util.LinkedList;
import java.util.List;

public class LeetCode438 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> rs = new LinkedList<>();
        if(p.length() > s.length())
            return rs;
        int[] target = new int['z'- 'a' + 1];
        int[] diff = new int['z' - 'a' + 1];
        int diffCount = 0;
        int index,i,j;
        for(i = 0 ; i < p.length(); i++){
            target[p.charAt(i) - 'a']++;
            diff[p.charAt(i) - 'a']--;
            diffCount++;
        }
        for(i = 0 ; i < s.length() ; i++){
            if(i - p.length() >= 0){
                index = s.charAt(i - p.length()) - 'a';
                if(0 != target[index]){
                    if(diff[index] <= 0)
                        diffCount++;
                    diff[index]--;
                }
            }
            index = s.charAt(i) - 'a';
            if(0 != target[index]){
                if(diff[index] < 0)
                    diffCount--;
                diff[index]++;
            }

            if(0 == diffCount)
                rs.add(i - p.length() + 1);

        }

        return rs;
    }
}
