package main.java.com.nullzl.leetcode100;

public class LeetCode28 {

    public int strStr(String haystack, String needle) {

        if(null == haystack || null == needle)
            return -1;
        if("".equals(needle))
            return 0;
        if(haystack.length() < needle.length())
            return -1;

        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int[] len = new int[target.length];
        len[0] = -1;
        for(int i = 1 ; i < target.length; i++){
            char ch = target[i - 1];
            int k = len[i - 1];
            len[i] = 0;
            while(k != -1){
                if(ch == target[k]){
                    len[i] = k + 1;
                    break;
                }
                k = len[k];
            }
        }

        int i,j;
        for(i = 0 ,j = 0; i < source.length && j < target.length;i++,j++){
            if(source[i] != target[j]){
                j = len[j];
                while(-1 != j){
                    if(target[j] == source[i]){
                        break;
                    }
                    j = len[j];
                }
            }
        }

        if(j == target.length){
            return i - j;
        }else
            return -1;
    }
    public static void main(String[] args){
        String source = "mississippi";
        String target = "issip";
        System.out.println(new LeetCode28().strStr(source,target));
    }
}
