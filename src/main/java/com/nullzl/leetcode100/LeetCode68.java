package main.java.com.nullzl.leetcode100;

import java.util.LinkedList;
import java.util.List;

public class LeetCode68 {

    private String getString(String[] words,int maxWidth,int start,int end,int width){
        int count = end - start;
        StringBuilder str = new StringBuilder();
        str.append(words[start]);
        if(0 == count){
            for(int i = 0 ; i < maxWidth - words[start].length() ; i++){
                str.append(' ');
            }
            return str.toString();
        }
        int k = (maxWidth - width) / count;
        int t = (maxWidth - width) % count;

        for(int i = start + 1 ; i <= end ;i++){
            int blankCount = k + 1 + (i - start <= t ? 1 : 0);
            for(int x = 0 ;  x < blankCount ; x++){
                str.append(' ');
            }
            str.append(words[i]);
        }
        return str.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> rs = new LinkedList<String>();
        if(null == words || 0 == words.length)
            return rs;

        int width = words[0].length();
        int start = 0;
        int end = 0;
        for(int i = 1; i < words.length ;i++){
            if(width + words[i].length() + 1 > maxWidth){
                rs.add(getString(words,maxWidth,start,end,width));
                start = i;
                end = i;
                width = words[i].length();
            }else{
                end = i;
                width += (1 + words[i].length());
            }
        }
        StringBuilder str = new StringBuilder();
        str.append(words[start]);
        for(int i = start + 1 ; i <= end ; i++){
            str.append(' ');
            str.append(words[i]);
        }
        int len = maxWidth - width;
        for(int i = 0 ; i < len;  i++){
            str.append(' ');
        }
        rs.add(str.toString());
        return rs;
    }
}
