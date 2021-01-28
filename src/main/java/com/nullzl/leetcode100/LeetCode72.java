package main.java.com.nullzl.leetcode100;

public class LeetCode72 {

    public int minDistance(String word1, String word2) {

        if(null == word2 || 0 == word2.length())
            return ((null == word1 || 0 == word1.length()) ? 0 : word1.length());

        int[][] dis = new int[word1.length() + 1][word2.length() + 2];
        for(int i = 0 ; i <= word2.length() ; i++)
            dis[0][i] = i;
        for(int i = 1 ; i <= word1.length() ; i++)
            dis[i][0] = i;

        for(int i = 1 ;i <= word1.length() ; i++){
            for(int j = 1; j <= word2.length() ; j++){
                if(word1.charAt( i - 1) == word2.charAt( j - 1)){
                    dis[i][j] = dis[i-1][j-1];
                }else{
                    dis[i][j] = Math.min(dis[i-1][j-1] + 1,dis[i-1][j] + 1);
                    dis[i][j] = Math.min(dis[i][j],dis[i][j-1] + 1);
                }
            }
        }
        return dis[word1.length()][word2.length()];
    }
}
