package com.nullzl.offer;

public class Offer33 {

    public boolean verify(int[] order, int s , int e){
        if(s >= e)
            return true;

        int i = e - 1;
        while( i >= s && order[i] >= order[e]) i--;
        int pos = i;
        while(i >= s && order[i] < order[e]) i--;
        if(i >= s)
            return false;
        return verify(order ,s,pos) && verify(order,pos + 1,e - 1);
    }

    public boolean verifyPostorder(int[] postorder) {
        if(null == postorder)
            return true;

        return verify(postorder,0,postorder.length - 1);
    }
}
