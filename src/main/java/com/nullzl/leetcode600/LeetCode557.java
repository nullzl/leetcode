package main.java.com.nullzl.leetcode600;

public class LeetCode557 {

    private void reverse(char[] chs,int s,int e){
        char ch;
        for(; s < e; s++,e--){
            ch = chs[s];
            chs[s] = chs[e];
            chs[e] = ch;
        }
    }

    public String reverseWords(String s) {

        if(null == s)
            return "";

        char[] chs = s.toCharArray();
        char ch ;
        int x = -1,y = -1;
        for(int i = 0 ; i < chs.length ; i++){
            ch = chs[i];
            if((' ' == ch && -1 == x) ||
                    (' ' != ch && -1 != x)){
                continue;
            }else if(' ' == ch && -1 != x){
                y = i - 1;
                reverse(chs,x,y);
                x = y = -1;
            }else{
                x = i;
            }
        }
        if(-1 != x){
            reverse(chs,x,chs.length - 1);
        }
        return new String(chs);
    }

    public static void main(String[] args){
        System.out.print(new LeetCode557().reverseWords("   abc edf  hig  kxy  "));
    }
}
