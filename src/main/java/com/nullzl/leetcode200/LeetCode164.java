package main.java.com.nullzl.leetcode200;

import java.util.LinkedList;

public class LeetCode164 {
    //基数排序
    public void radixSort(int[] nums){
        LinkedList<Integer>[] lists = new LinkedList[10];
        for(int i = 0 ; i < 10; i++)
            lists[i] = new LinkedList<>();
        int maxVal = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] > maxVal )
                maxVal = nums[i];
        }
        long radix = 1;
        while(maxVal / radix > 0){

            for(int i = 0; i < nums.length ; i++){
                lists[(int)((nums[i] / radix) % 10)].offerLast(nums[i]);
            }

            for(int i = 0,j = 0 ; i < 10 ; i++){
                LinkedList<Integer> list = lists[i];
                while(!list.isEmpty()){
                    nums[j++] = list.pollFirst();
                }
            }
            radix *= 10;
        }

        for(int i = 0 ; i < nums.length ;i++){
            System.out.print(nums[i] + "\t");
        }

    }

    public int maximumGap1(int[] nums) {

        if(null == nums || nums.length < 2)
            return 0;
        radixSort(nums);

        int gap = 0;
        for(int i = 1 ; i < nums.length ; i++){
            int temp = nums[i] - nums[i-1];
            if(temp > gap)
                gap = temp;
        }
        return gap;
    }

    // 桶 + 鸽巢原理

    /**
     * 对于n个元素的数组，最大值为max，最小值为min
     * 结论1：最大相邻差值的最小值为：MAX = (max - min) / (n - 1)
     *       min经过n-1个差值，变为max，最大相邻差值如果小于结论1，则不能增加到max
     * 将n个元素，分到几个连续区间的桶中
     * 结论2：如果每个桶可容纳的最大值和最小值之差小于MAX，
     *       那么计算最大相邻值就不需要考虑桶内元素的差值，因为他们的差值小于MAX，一定不是候选者
     *       所以候选者，只会在桶和桶之间的元素产生
     * 结论3：考虑桶和通之间的最大相邻差值，只需要考虑前一个桶的最大值和后一个桶的最小值
     *
     */
    public int maximumGap(int[] nums) {

        if(null == nums || nums.length < 2)
            return 0;

        int max = nums[0];
        int min = nums[0];
        for(int i = 1 ; i < nums.length;i++){
            if(nums[i] > max)
                max = nums[i];
            if(nums[i] < min)
                min = nums[i];
        }
        if(max == min)
            return 0;

        int intervalSize = (max - min) / (nums.length - 1);
        intervalSize = (intervalSize == 0 ? 1 : intervalSize);
        int bucketSize = ((max - min) / intervalSize) + 1;

        int[][] b = new int[bucketSize][3];
        for(int i = 0 ; i < bucketSize ; i++){
            b[i][1] = 0x7FFFFFFF;
            b[i][2] = 0;
        }

        for(int i = 0 ; i < nums.length ; i++){
            int k = (nums[i] - min) / intervalSize ;
            b[k][0] = 1;
            if(nums[i] < b[k][1])
                b[k][1] = nums[i];
            if(nums[i] > b[k][2])
                b[k][2] = nums[i];
        }

        int preMax = b[0][2];
        int maxGap = 0;
        for(int i = 1 ; i < bucketSize ;i++){
            if(0 != b[i][0]){
                int gap = b[i][1] - preMax;
                if(gap > maxGap)
                    maxGap = gap;
                preMax = b[i][2];
            }
        }
        return maxGap;

    }

    public static void main(String[] args){
        new LeetCode164().maximumGap(new int[]{
                //0x7FFFFFFF,10000,2,5,8
                3,6,9,1
        });
    }


}
