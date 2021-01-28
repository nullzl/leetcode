package main.java.com.nullzl.leetcode100;

public class LeetCode06 {
    public String convert(String s, int numRows) {
        if(null == s || 0 == s.length() || numRows < 1)
            return "";

        if(1 == numRows)
            return s;

        int size = 2 * numRows - 2;
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < numRows ; i++){
            int start = 0;
            for(; start < s.length() ; start += size){
                int index1 = start + i;
                int index2 = start + 2 * numRows - 2 - i;
                if(index1 < s.length() && index1 < start + size )
                    result.append(s.charAt(index1));
                if(index2 < s.length() && index2 < start + size && index2 != index1)
                    result.append(s.charAt(index2));
            }
        }
        return result.toString();
    }
    public static void main(String[] args){
        System.out.println(new LeetCode06().convert("LEETCODEISHIRING",4));
    }
}
