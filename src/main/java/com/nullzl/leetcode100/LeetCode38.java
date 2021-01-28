package main.java.com.nullzl.leetcode100;

public class LeetCode38 {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";

        StringBuilder preStr = new StringBuilder("1");
        StringBuilder str;
        for(int i = 2 ; i <= n ; i++){
            str = new StringBuilder();
            char preChar = preStr.charAt(0);
            int count = 1;
            for(int j = 1 ; j < preStr.length() ; j++){
                char temp = preStr.charAt(j);
                if(preChar == temp){
                    count++;
                }else{
                    str.append(count);
                    str.append(preChar);
                    preChar = temp;
                    count = 1;
                }
            }
            str.append(count);
            str.append(preChar);
            preStr = str;
        }
        return preStr.toString();
    }
}
