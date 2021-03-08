package com.nullzl.leetcode100;

public class LeetCode4 {

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        if((null == nums1 || 0 == nums1.length) &&
                (null == nums2 || 0 == nums2.length)){
            throw new IllegalArgumentException();
        }

        if(null == nums2 || (null != nums1 && nums2.length < nums1.length))
            return findMedianSortedArrays(nums2,nums1);

        if(null == nums1 || 0 == nums1.length){
            return nums2.length % 2 == 1
            ? nums2[(nums2.length - 1) / 2]
            : ((double)(nums2[(nums2.length - 1) / 2] + nums2[(nums2.length - 1) / 2 + 1])) / 2;
        }

        int k = (nums1.length + nums2.length + 1) / 2;
        int s = 0,e = nums1.length - 1;
        while(s <= e){
            int mid = (s + e) >> 1;
            int t = k - mid - 2;
            if(( t + 1 >= nums2.length || nums1[mid] <= nums2[t + 1])
                    && (t < 0 || mid + 1 >= nums1.length || nums2[t] <= nums1[mid+1])){
                int left = nums1[mid];
                if(t >= 0)
                    left = Math.max(left,nums2[t]);
                if((nums1.length + nums2.length) % 2 == 1){
                    return left;
                }else{
                    int right = Integer.MAX_VALUE;
                    if(mid + 1 < nums1.length)
                        right = Math.min(right,nums1[mid + 1]);
                    if(t + 1 < nums2.length)
                        right = Math.min(right,nums2[t + 1]);
                    return (((double)left) + right) / 2;
                }
            }else if(t + 1 < nums2.length && nums1[mid] > nums2[t + 1]){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        int left = nums2[k - 1];
        if((nums1.length + nums2.length) % 2 == 1)
            return left;
        else{
            int right = nums1[0];
            if(k < nums2.length)
                right = Math.min(nums2[k],right);
            return (((double)left) + right) / 2;
        }

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((null == nums1 || 0 == nums1.length) &&
                (null == nums2 || 0 == nums2.length)){
            throw new IllegalArgumentException();
        }

        if(null == nums2 || (null != nums1 && nums2.length < nums1.length))
            return findMedianSortedArrays(nums2,nums1);

        if(null == nums1 || 0 == nums1.length){
            return nums2.length % 2 == 1
                    ? nums2[(nums2.length - 1) / 2]
                    : ((double)(nums2[(nums2.length - 1) / 2] + nums2[(nums2.length - 1) / 2 + 1])) / 2;
        }

        int s = 0;
        int e = nums1.length - 1;
        int partLen = (nums1.length + nums2.length) >> 1;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            int t = partLen - mid;
            if(t < 0 )
                e = mid - 1;
            else if(t > nums2.length)
                s = mid + 1;
            else if(t < nums2.length && nums1[mid] > nums2[t])
                e = mid -1;
            else if(t > 0 && mid + 1 < nums1.length && nums2[t-1] > nums1[mid+1])
                s = mid + 1;
            else{
                double rs ;
                int temp1 = nums1[mid];
                int temp2 = (--t >= 0) ? nums2[t] : Integer.MIN_VALUE;
                if(temp1 > temp2){
                    temp1 = (--mid >= 0) ? nums1[mid] : Integer.MIN_VALUE;
                    rs = temp1;
                }else{
                    rs = temp2;
                    temp2 = (--t >= 0) ? nums2[t] : Integer.MIN_VALUE;
                }
                if(1 == (nums1.length + nums2.length) % 2){
                    return rs;
                }else{
                    return (rs + Math.max(temp1,temp2)) / 2;
                }
            }
        }
        //没有找到，说明数组nums1中任何元素都不属于前半部分
        if(1 == (nums1.length + nums2.length) % 2){
            return nums2[partLen];
        }else{
            return (nums2[partLen-1] + nums2[partLen]) / 2.0;
        }
    }

    public static void main(String[] args){
        System.out.println(new LeetCode4().findMedianSortedArrays(
                new int[]{8,9},
                new int[]{3,4,5,6,7}
        ));
    }
}
