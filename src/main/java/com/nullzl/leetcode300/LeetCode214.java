package main.java.com.nullzl.leetcode300;

public class LeetCode214 {

    public String shortestPalindrome(String s) {

        if(null == s || 0 == s.length() || 1 ==  s.length())
            return s;

        int[] match = new int[s.length() >> 1];
        match[0] = -1;
        for(int k = 1 ; k < match.length ; k++)
            match[k] = -2;
        int size = 1;
        int i,j;
        for(i = 0 , j = s.length() - 1 ; i < j ; ){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                if(-2 == match[i]){
                    for(; size <= i ; size++){
                        int temp = match[size - 1];
                        while(-1 != temp && s.charAt(temp) != s.charAt(size-1))
                            temp = match[temp];
                        match[size] = temp + 1;
                    }
                }

                int temp = match[i];
                while(-1 != temp && s.charAt(temp) != s.charAt(j))
                    temp = match[temp];
                i = temp + 1;
                j--;
            }
        }
        int len = s.length() - (i << 1);
        if(i == j){
            len = s.length() - (i << 1) - 1;
        }
        StringBuffer rs = new StringBuffer(s.substring(s.length()- len ,s.length()));
        rs.reverse();
        rs.append(s);
        return rs.toString();

    }

    public static  void main(String[] args){
        System.out.println(new LeetCode214().shortestPalindrome("ababbbabbaba"));
    }
}
