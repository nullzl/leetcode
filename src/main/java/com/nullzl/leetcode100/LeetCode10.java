package com.nullzl.leetcode100;

public class LeetCode10 {

    public boolean isMatch(String s, String p) {
        if(null == s || null == p)
            return false;
        int i,j,plen,nums = 0;
        char pchar;
        boolean hasStar,preVal,temp;
        for(i = 0 ; i < p.length() ; i++){
            if('*' == p.charAt(i))
                nums++;
        }
        plen = p.length() - nums;
        boolean[] rs = new boolean[plen + 1];
        rs[0] = true;

        for(i = 1,nums = 0; i <= plen ; i++){
            hasStar = false;
            if(i + nums < p.length() && '*' == p.charAt(i + nums)){
                nums++;
                hasStar = true;
            }
            if(hasStar){
                rs[i] = rs[i-1];
            }else{
                rs[i] = false;
            }

        }

        //rs[i][j]
        //p[j-1] = '.'    rs[i-1][j-1]
        //p[j-1] = '*'    rs[i][j-1],rs[i-1][j-1]...rs[0][j-1]
        //p[j-1] = 其他    s[i-1] = p[j-1]   rs[i-1][j-1]
        //                s[i-1] <> p[j-1]   false
        for(i = 1 ; i <= s.length();i++) {
            preVal = rs[0];
            rs[0] = false;
            for (j = 1, nums = 0; j <= plen; j++) {
                temp = rs[j];
                pchar = p.charAt(j + nums - 1);
                hasStar = false;
                if (j + nums < p.length() && '*' == p.charAt(j + nums)) {
                    nums++;
                    hasStar = true;
                }
                if (hasStar) {

                    if('.' != pchar && s.charAt(i - 1) != pchar)
                        rs[j] = false;
                    rs[j] = rs[j] || rs[j-1];
                } else {
                    if ('.' == pchar) {
                        rs[j] = preVal;
                    } else {
                        if (pchar == s.charAt(i - 1))
                            rs[j] = preVal;
                        else
                            rs[j] = false;
                    }
                }
                preVal = temp;
            }
        }
        return rs[plen];
    }
}
