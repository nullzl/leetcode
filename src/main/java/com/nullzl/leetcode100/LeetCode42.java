package main.java.com.nullzl.leetcode100;

public class LeetCode42 {

    public int trap(int[] height) {

        if(null == height || 0 == height.length)
            return 0 ;
        int[] count = new int[height.length];
        int max = -1;
        for(int i = 0 ; i < height.length ; i++){
            if(height[i] > max)
                max = height[i];
            count[i] = max;
        }
        max = -1;
        int sum = 0;
        for(int i = height.length - 1; i>= 0 ; i--){
            if(height[i] > max)
                max = height[i];
            if(count[i] > height[i] && max > height[i]){
                sum += (max > count[i] ? count[i] - height[i] : max - height[i]);
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new LeetCode42().trap(height));
    }
}
