package com.nullzl.interview;

public class Interview1610 {

    public int maxAliveYear(int[] birth, int[] death){

        int min = birth[0];
        int max = death[0];
        for(int num : birth)
            min = Math.min(min,num);
        for(int num :death){
            max = Math.max(max,num);
        }

        int[] years = new int[max - min + 2];
        for(int num : birth){
            years[num - min]++;
        }
        for(int num : death){
            years[num - min + 1]--;
        }

        int count = 0;
        int year = 0;
        int maxCount = 0;
        for(int i = 0 ; i < years.length; i++){
            count += years[i];
            if(count > maxCount){
                maxCount = count;
                year = min + i;
            }
        }
        return year;
    }
}
