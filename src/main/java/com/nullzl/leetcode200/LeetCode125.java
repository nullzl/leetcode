package main.java.com.nullzl.leetcode200;

public class LeetCode125 {

    public boolean isPalindrome(String s) {
        if(null == s)
            return false;
        if(0 == s.length())
            return true;

        for(int i = 0 ,j = s.length() - 1; i < j ; i++,j--){
            while(i < j){
                char ch1 = s.charAt(i);
                if((ch1 >= '0' && ch1 <= '9') || (ch1 >= 'a' && ch1 <= 'z') || (ch1 >= 'A' && ch1 <= 'Z')){
                    break;
                }
                i++;
            }

            while( j > i){
                char ch2 = s.charAt(j);
                if((ch2 >= '0' && ch2 <= '9') || (ch2 >= 'a' && ch2 <= 'z') || (ch2>= 'A' && ch2 <= 'Z')){
                    break;
                }
                j--;
            }
            if(i < j) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                ch1 = (char)((ch1 >= 'A' && ch1 <= 'Z') ? ch1 + ('a' - 'A') : ch1);
                ch2 = (char)((ch2 >= 'A' && ch2 <= 'Z') ? ch2 + ('a' - 'A') : ch2);
                if(ch1 != ch2)
                    return false;
            }
        }
        return true;

    }
}
