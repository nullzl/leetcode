package com.nullzl.leetcode1100;

import java.util.Random;

class MountainArray{

    public int[] arr;
    public int count = 0;

    public MountainArray(){
        Random r = new Random();
        int len = r.nextInt(10000) + 3;
        arr = new int[len];
        int m = r.nextInt(len -2) + 1;
        int s = r.nextInt(1000000000) - 2 * len;
        s = s < 0 ? 2 : s;
        int i;
        for(i = 0 ; i <= m ; i++){
            s += (r.nextInt(2) + 1);
            arr[i] = s;
        }

        for( ; i < len ; i++){
            s -= (r.nextInt(2) + 1);
            arr[i] = s;
        }
    }

    public int get(int index){
        count++;
        return arr[index];
    }
    public int length(){
        return arr.length;
    }
}

public class LeetCode1095 {

    private int getMountain(MountainArray arr,int len){
        int s = 1;
        int e = len - 1;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            int m = arr.get(mid);
            int m1 = arr.get(mid + 1);
            if(m > m1)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return s;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length() - 1;
        int m = getMountain(mountainArr,len);

        int s = 0;
        int e = m;

        while (s <= e) {
            int mid = s + ((e - s) >> 1);
            int t = mountainArr.get(mid);
            if(t == target)
                return mid;
            if(t < target)
                s = mid + 1;
            else
                e = mid - 1;
        }

        s = m + 1;
        e = len;
        while(s <= e){
            int mid  = s + ((e -s) >> 1);
            int t = mountainArr.get(mid);
            if(t == target)
                return mid;
            if(t < target)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        Random r = new Random();
        LeetCode1095 l = new LeetCode1095();
        for(int i = 0 ; i < 10000 ; i++){
            MountainArray arr = new MountainArray();
            int target = arr.arr[r.nextInt(arr.arr.length)]  + (r.nextInt(2) + 1);
            int index = l.findInMountainArray(target,arr);
            int rs = -1;
            for(int j = 0 ; j < arr.arr.length ; j++){
                if(arr.arr[j] == target){
                    rs = j;
                    break;
                }
            }
            if(rs == index && arr.count < 90){
                System.out.println(i + "\t" + arr.arr.length + "\t" + index + "\t" + rs + "\tok" );
            }else{
                System.out.println(i + "\t" + arr.arr.length + "\t" + index + "\t" + rs + "\terror");
                break;
            }
        }
    }
}
