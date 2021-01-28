package main.java.com.nullzl.leetcode200;

public class LeetCode168 {

    public String convertToTitle(int n) {

        StringBuffer rs = new StringBuffer();
        int left = n;
        while(0 != left){
            left--;
            rs.append((char)((left % 26) + 'A'));
            left /= 26;
        }
        return rs.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(new LeetCode168().convertToTitle(27));
    }
}
