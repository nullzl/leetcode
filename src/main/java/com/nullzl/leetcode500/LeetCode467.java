package main.java.com.nullzl.leetcode500;

import java.util.Random;

public class LeetCode467 {

    public int findSubstringInWraproundString(String p) {

        if(null == p || 0 == p.length())
            return 0;

        int len = 'z' - 'a' + 1;
        int[] map = new int[len];
        int key = p.charAt(0) - 'a';
        int l = 1;
        for(int i = 1 ; i < p.length() ; i++){
            if(1 == p.charAt(i) - p.charAt(i-1) ||(p.charAt(i) == 'a' && p.charAt(i-1) == 'z')){
                l++;
            }else{
                if(l > map[key]){
                    map[key] = l;
                }
                l = 1;
                key = p.charAt(i) - 'a';
            }
        }
        map[key] = Math.max(map[key],l);
        for(int i = 0; i < map.length ; i++){
            for(int j = 1 ; j < len && j < map[i] ; j++){
                int k = (i + j) % len;
                map[k] = Math.max(map[k],map[i] - j);
            }
        }

        int count = 0;
        for(int i = 0 ; i < map.length ; i++){
            count += map[i];
        }
        return count;


    }

    public static  void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(100000);
        StringBuffer s = new StringBuffer();
        for(int i = 0 ; i < len ; i++){
            s.append((char)('a' + r.nextInt('z' - 'a') + 1));
        }
        System.out.println("\"" + s.toString() + "\"");
    }
}
