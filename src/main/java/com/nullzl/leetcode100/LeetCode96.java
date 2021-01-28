package main.java.com.nullzl.leetcode100;

public class LeetCode96 {

    public int numTrees(int n) {

        if(n <= 0)
            return 0 ;
        int[] size = new int[n];
        size[0] = 1;
        for(int i = 2; i <= n ; i++){
            size[i-1] = 2 * size[i-2];
            for(int j = 2 ; j < i ; j++){
                size[i-1]  +=  (size[j-2] * size[i-j-1]);
            }
        }
        return size[n-1];
    }

    public static void main(String[] args){
        System.out.println(new LeetCode96().numTrees(5));
    }
}
