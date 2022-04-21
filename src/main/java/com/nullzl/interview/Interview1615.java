package com.nullzl.interview;

public class Interview1615 {

    private int index(char ch){
        char[] chs = new char[]{'R','G','B','Y'};
        for(int i = 0 ;i < 3 ; i++) {
            if (chs[i] == ch)
                return i;
        }
        return 3;
    }

    public int[] masterMind(String solution, String guess) {

        char[] s = solution.toCharArray();
        char[] g = guess.toCharArray();
        int[] counts = new int[4];
        int[] countg = new int[4];
        int match = 0;
        for(int i = 0 ; i < s.length ; i++){
            if(s[i] == g[i])
                match++;
            counts[index(s[i])]++;
            countg[index(g[i])]++;
        }
        int total = 0;
        for(int i = 0 ;i < 4 ; i++)
            total += Math.min(counts[i],countg[i]);
        return new int[]{match,total - match};

    }
}
