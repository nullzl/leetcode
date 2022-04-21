package com.race;

public class LeetCode1899 {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean f1 =false,f2=false,f3=false;
        for(int[] triple : triplets){
            if(!f1 && triple[0] == target[0] && triple[1] <= target[1] && triple[2] <= target[2])
                f1 = true;
            if(!f2 && triple[0] <= target[0] && triple[1] == target[1] && triple[2] <= target[2])
                f2 = true;
            if(!f3 && triple[0] <= target[0] && triple[1] <= target[1] && triple[2] == target[2])
                f3 = true;
            if(f1 && f2 && f3)
                break;
        }
        return f1 && f2 && f3;
    }
}
