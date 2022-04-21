package com.nullzl.offer;

public class Offer46 {
    public int translateNum(int num) {

        if(0 == num)
            return 1;

        int num1 = num % 10;
        int num2 = num % 100;

        if(num2 >= 10 && num2 <= 25)
            return translateNum(num / 10) + translateNum(num / 100);
        else
            return translateNum(num / 10);

    }
}
