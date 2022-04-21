package com.nullzl.leetcode800;

public class LeetCode798 {

    private void add(int[] arr, int idx, int val) {

        while (idx < arr.length) {
            arr[idx] += val;
            idx += (idx & (-idx));
        }
    }

    private int query(int[] arr, int idx) {
        int rs = 0;
        while (idx != 0) {
            rs += arr[idx];
            idx = idx & (idx - 1);
        }
        return rs;
    }

    public int bestRotation(int[] nums) {

        if (null == nums || 0 == nums.length)
            return 0;
        int MAX_LENGTH = nums.length;
        int delta = nums.length + 1;
        int[] left = new int[(MAX_LENGTH << 1) + 2];
        int[] right = new int[(MAX_LENGTH << 1) + 2];
        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i] - i + delta;
            add(left, idx, 1);
        }
        int rs = 0;
        int points = query(left, delta);
        for (int k = 0; k < nums.length - 1; k++) {
            int idx = nums[k] - k + delta;
            add(left, idx, -1);
            add(right, idx, 1);
            int p = query(left, -k - 1 + delta) + query(right, nums.length - 1 - k + delta);
            if (p > points) {
                points = p;
                rs = k + 1;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
//        Random r = new Random();
//        int len = r.nextInt(20000) + 1;
//        System.out.println(Util.generateRandomArray(len,0,len));


    }


}
