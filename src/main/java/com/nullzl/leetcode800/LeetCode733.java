package com.nullzl.leetcode800;

public class LeetCode733 {

    private void dfs(int[][] visited,int[][] image,int r,int c,int color){
        if(r < 0 || r >= image.length || c < 0
                || c >= image[0].length || image[r][c] != color
                || visited[r][c] == -1)
            return ;
        visited[r][c] = -1;
        dfs(visited,image,r + 1 , c , color);
        dfs(visited,image,r - 1, c , color);
        dfs(visited,image,r , c + 1 , color);
        dfs(visited,image,r , c - 1 , color);

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        int[][] visited = new int[image.length][image[0].length];
        dfs(visited,image,sr,sc,image[sr][sc]);
        for(int i = 0 ; i < image.length ; i++){
            for(int j = 0 ; j < image[i].length ; j++){
                if(-1 == visited[i][j])
                    image[i][j] = color;
            }
        }
        return image;
    }
}
