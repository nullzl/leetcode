package main.java.com.nullzl.leetcode100;

public class LeetCode45 {


    //最远边界
    public int jump(int[] nums) {

        int len = nums.length - 1;
        int end = 0;            //当前最远可达
        int step = 0;           //当前步数
        int pos = 0;            //当前步数下最远可达
        if(end >= len)
            return step;
        //每一次都尝试更新最远可达位置
        //每次循环，都是为了更新step+1步可达的最远距离
        //当到达pos时，step+1可达最远更新完毕，需要重新设置step和pos
        for(int i = 0 ;i < len && end < len;i++){
            if(i > pos){
                step++;
                pos = end;
            }
            int next = nums[i] + i;
            if(next > end)
                end = next;

        }
        return step + 1;

    }

    public int jump2(int[] nums) {

        int len = nums.length - 1;
        int[] steps = new int[nums.length];
        steps[0] = 0;
        for(int i = 0 ;i < len;i++){
            for(int j = 1 ; j <= nums[i] ;j++){
                int next = i + j;
                if(next < nums.length && 0 == steps[next])
                    steps[next] = steps[i] + 1;
                if(next == len)
                    return steps[len];
            }
        }
        return steps[len];

    }


}
