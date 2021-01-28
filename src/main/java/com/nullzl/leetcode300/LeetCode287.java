package main.java.com.nullzl.leetcode300;

public class LeetCode287 {


    /**
     * 1. 数组大小为n+1,里面包含的数的范围为1到n，所以必有重复的数
     * 2. 题目中规定了只有一组重复的数，且重复的个数不一定
     * 3. 如果是n个数，n个位置，那么以(x=nums[1])->(y=nums[x])->(nums[y])->...
     * 4. 由于n个数正好，所以链表一定会回到nums[1](不一定可遍历所有的数，但是遍历nums[1]所在的错位链)
     * 5. 题目中n+1个数，放在n个位置，nums[0]所在的错位链，一定存在重复的数，此错位链一定是一个有环链表
     *    所以问题变为了寻找有环链表的环点
     * 6. 使用快慢指针
     */
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do{
            if(fast == nums[fast])
                return fast;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
