package com.nullzl.interview;

public class Interview0810 {

    public void dfs(int[][] image,int i,int j,int oldColor){
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length
                || image[i][j] != oldColor || -1 == image[i][j]){
            return ;
        }
        image[i][j] = -1;
        dfs(image,i - 1,j,oldColor);
        dfs(image,i + 1,j,oldColor);
        dfs(image,i,j-1,oldColor);
        dfs(image,i,j+1,oldColor);
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;
        dfs(image,sr,sc,image[sr][sc]);
        for(int i = 0 ; i < image.length ; i++){
            for(int j = 0 ; j < image[i].length ; j++){
                if(-1 == image[i][j])
                    image[i][j] = newColor;
            }
        }
        return image;
    }
}
