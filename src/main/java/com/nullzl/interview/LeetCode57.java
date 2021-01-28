package main.java.com.nullzl.interview;

import java.util.LinkedList;
import java.util.List;

public class LeetCode57 {

    public int[][] findContinuousSequence(int target) {

        int max = target / 2 + 1;
        List<int[]> list = new LinkedList<>();
        int sum = 3;
        for(int i = 1,j = 2 ; i < j && j <= max ; ){
            if(sum == target){
                int[] nums = new int[j - i + 1];
                for(int x = i ; x <= j; x++)
                    nums[x - i] = x;
                list.add(nums);
                j++;
                sum += j;
            }else if(sum > target){
                sum -= i;
                i++;
            }else{
                j++;
                sum += j;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args){

    }
}
