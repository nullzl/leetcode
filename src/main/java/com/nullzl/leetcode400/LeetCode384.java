package com.nullzl.leetcode400;

import java.util.Arrays;
import java.util.Random;

public class LeetCode384 {

    class Solution1 {

        private int[] array;
        private Random random;

        public Solution1(int[] nums) {
            this.array = nums;
            this.random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.array;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] rs = new int[this.array.length];
            Arrays.fill(rs,-1);
            int size = this.array.length;
            for(int i = 0 ; i < this.array.length ; i++){
                int pos = random.nextInt(size--);
                for(int j = 0 ,count = 0; j < rs.length; j++){
                    if(-1 == rs[j])
                        count++;
                    if(count == pos + 1){
                        rs[j] = i;
                        break;
                    }
                }
            }
            for(int i = 0 ;i < rs.length ; i++)
                rs[i] = this.array[rs[i]];
            return rs;
        }
    }

    /**
     * 洗牌算法
     * 遍历每个位置，假设当前遍历到i，则生成i到len-1的一个随机数k，将nums[i]与nums[k]交换。相当于对于每个位置，随机从剩余的数中取出一个数。保证了概率相同
     */
    class Solution {

        private int[] array;
        private Random random;

        public Solution(int[] nums) {
            this.array = nums;
            this.random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.array;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] rs = Arrays.copyOf(this.array,this.array.length);
            int size = this.array.length;
            for(int i = 0 ; i < this.array.length - 1; i++){
                int pos = i + random.nextInt(size--);
                if(i != pos){
                    rs[i] = rs[i] ^ rs[pos];
                    rs[pos] = rs[i] ^ rs[pos];
                    rs[i] = rs[i] ^ rs[pos];
                }
            }
            return rs;
        }
    }

}
