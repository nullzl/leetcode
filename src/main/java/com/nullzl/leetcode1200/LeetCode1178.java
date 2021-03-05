package com.nullzl.leetcode1200;

import java.util.*;

public class LeetCode1178 {

    private int countValid(HashMap<Integer,Integer> map,int[] masks,String puzzle,int code,int next){
        if(7 == next)
            return map.getOrDefault(code,0);

        return countValid(map,masks,puzzle,code,next + 1) +
                countValid(map,masks,puzzle,code | masks[puzzle.charAt(next) - 'a'],next + 1);
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        int size = 'z' - 'a' + 1;
        int[] masks = new int[size];
        masks[0] = 1;
        for(int i = 1; i < size ; i++)
            masks[i] = masks[i - 1] << 1;

        if(words.length <= (1 << 6)){
            int[] codes = new int[words.length];
            for(int i = 0 ; i < words.length ; i++){
                for(int j = 0 ;  j < words[i].length() ; j++)
                    codes[i] |= masks[words[i].charAt(j) - 'a'];
            }

            List<Integer> rs = new ArrayList<>(puzzles.length);
            for(String puzzle : puzzles){
                if(null == puzzle || 7 != puzzle.length())
                    throw new IllegalArgumentException();

                int num = 0;
                int first = masks[puzzle.charAt(0) - 'a'];
                int code = first;
                for(int i = 1 ; i < puzzle.length(); i++)
                    code |= masks[puzzle.charAt(i) - 'a'];

                for(int word : codes){
                    if((0 != (first & word)) && ((word & code) == word))
                        num++;
                }
                rs.add(num);
            }
            return rs;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(String word : words){
            int code = 0;
            for(int i = 0 ; i < word.length() ; i++){
                code |= masks[word.charAt(i) - 'a'];
            }
            map.put(code,map.getOrDefault(code,0) + 1);
        }
        List<Integer> rs = new ArrayList<>(puzzles.length);
        for(String puzzle : puzzles){
            if(null == puzzle || 7 != puzzle.length())
                throw new IllegalArgumentException();

            rs.add(countValid(map,masks,puzzle,masks[puzzle.charAt(0) - 'a'],1));
        }
        return rs;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len1 = r.nextInt(30)+ 1;
        int len2 = r.nextInt(100) + 1;

        System.out.print("[");
        StringBuffer str = new StringBuffer();
        int size = r.nextInt(46) + 4;
        for(int i = 0 ; i < size ; i++)
            str.append((char)('a' + r.nextInt(9)));
        System.out.print("\"" + str.toString() + "\"");
        for(int i = 1 ; i < len1 ; i++){
            str = new StringBuffer();
            size = r.nextInt(46) + 4;
            for(int j = 0 ; j < size ; j++)
                str.append((char)('a' + r.nextInt(9)));
            System.out.print(",\"" + str.toString() + "\"");
        }

        System.out.print("]\r\n[");
        HashSet<String> set = new HashSet<>();
        str = new StringBuffer();
        int code = 0;
        for(int i = 0 ; i < 7 ; ) {
            int t = r.nextInt(9);
            if(0 != ((1 << t) & code))
                continue;
            code |= (1 << t);
            str.append((char)('a' + t));
            i++;
        }
        set.add(str.toString());
        System.out.print("\"" + str.toString() + "\"");
        for(int i = 1 ; i < len2 ; i++){
            str = new StringBuffer();
            code = 0;
            for(int j = 0 ; j < 7 ; ) {
                int t = r.nextInt(9);
                if(0 != ((1 << t) & code))
                    continue;
                code |= (1 << t);
                str.append((char)('a' + t));
                j++;
            }
            if(!set.contains(str.toString())) {
                System.out.print(",\"" + str.toString() + "\"");
                set.add(str.toString());
            }
        }
        System.out.print("]\r\n");

    }
}
