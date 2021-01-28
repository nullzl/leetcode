package main.java.com.nullzl.leetcode200;

public class LeetCode135 {

    public int candy(int[] ratings) {

        if(null == ratings || 0 == ratings.length)
            return 0;

        int[] candy = new int[ratings.length];
        int preRating = 0x7FFFFFFF;
        int start = 0x7FFFFFFF;

        for(int i = 0 ; i < ratings.length ; i++){

            if(ratings[i] > preRating)
                candy[i] = candy[i-1] + 1;
            else{
                int next = (i == ratings.length - 1) ? 0x7FFFFFFF : ratings[i+1];
                if(ratings[i] <= next){
                    candy[i] = 1;
                    int j ;
                    for(j = i - 1; j >= start ; j--){
                        candy[j] = candy[j+1] + 1;
                    }
                    for(; j>=0 && ratings[j] > ratings[j+1] && candy[j] <= candy[j+1];j--)
                        candy[j] = candy[j+1] + 1;
                    start = 0x7FFFFFFF;
                }else if(start == 0x7FFFFFFF){
                    start = i;
                }
            }
            preRating = ratings[i];

        }
        int sum = 0;
        for(int i = 0 ; i < candy.length ; i++)
            sum += candy[i];
        return sum;
    }
}
