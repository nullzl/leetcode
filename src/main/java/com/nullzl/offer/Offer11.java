package com.nullzl.offer;

public class Offer11 {

    public int minArray(int[] numbers) {
        if(null == numbers || 0 == numbers.length)
            throw new IllegalArgumentException();

        int s = 0;
        int e = numbers.length - 1;
        while(s < e){
            int mid = s + ((e - s) >>> 1);

            if(numbers[e] > numbers[mid])
                e = mid;
            else if(numbers[e] < numbers[mid])
                s = mid + 1;
            else
                e--;
        }

        return numbers[s];

    }
}
