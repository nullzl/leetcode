package com.nullzl.leetcode400;

import java.util.Arrays;

public class LeetCode354 {


    //官方改进：初始排序时，一个维度从小到大，另一个维度从大到小，就不需要考虑第一个维度相同，影响结果的问题
    //因为，第二个维度从大到小处理，较小值不会受较大值的影响，较大值会受较小值的影响
    //比如(5,4)和(5,6)，如果(5,4)先更新，更新(5,6)时，可能更新（5，4）的下一个位置，此时就出现了一个序列中（5，6）放在(5，4)后的情况
    //反之，先处理(5,6)，结尾(5,6)的序列不会影响(5,4)
    public int maxEnvelopes(int[][] envelopes) {

        if(null == envelopes || 0 == envelopes.length
                || null == envelopes[0] || 0 == envelopes[0].length
                )
            return 0;

        if(1 == envelopes.length)
            return 1;

        Arrays.sort(envelopes,(op1,op2) ->{
            return op1[0] - op2[0];
        });

        int[] len = new int[envelopes.length + 1];
        int[][] tmp = new int[envelopes.length][2];
        len[0] = -1;
        int index = 0;
        for(int i = 0 ; i < envelopes.length ; ){
            int k = i + 1;
            while(k < envelopes.length && envelopes[k][0] == envelopes[k-1][0])
                k++;
            int j = 0;
            for(; i < k ; i++){
                int pos = Arrays.binarySearch(len,0,index + 1,envelopes[i][1]);
                if(pos < 0){
                    tmp[j++][0] = -pos - 1;
                    tmp[j-1][1] = envelopes[i][1];
                }
            }

            for(int x = 0 ; x < j ; x++){
                if(tmp[x][0] > index){
                    len[++index] = tmp[x][1];
                }else{
                    len[tmp[x][0]] = Math.min(len[tmp[x][0]],tmp[x][1]);
                }
            }
        }

        return index;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode354().maxEnvelopes(new int[][]
                {{5,5},
                        {4,6},
                        {6,7},
                        {2,3},
                        {1,1}}
        ));
    }
}
