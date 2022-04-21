package com.nullzl.offer;

public class Offer19 {

    public boolean match(char ch1,char ch2){
        if('.' == ch1 || '.' == ch2)
            return true;
        return ch1 == ch2;
    }


    public boolean isMatch(String s, String p) {
        if(null == s || null == p)
            throw new IllegalArgumentException();

        boolean match[] = new boolean[p.length() + 1];
        match[0] = true;
        for(int i = 1; i <= p.length() ; i++){
            if('*' == p.charAt(i-1))
                match[i] = match[i - 2];
        }

        for(int i = 1 ; i <= s.length() ; i++){
            boolean pre = match[0];
            match[0] = false;
            for(int j = 1; j <= p.length() ; j++){
                if(j < p.length() && '*' == p.charAt(j))
                    continue;

                boolean tmp = match[j];
                if('*' == p.charAt(j - 1)){
                    match[j] = (match(s.charAt(i - 1),p.charAt(j - 2)) && match[j])
                            || match[j-2];
                }else{
                    match[j] = match(s.charAt(i-1),p.charAt(j - 1)) && pre;
                }
                pre = tmp;
            }
        }

        return match[p.length()];
    }
}
