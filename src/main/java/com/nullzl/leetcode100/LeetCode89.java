package main.java.com.nullzl.leetcode100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89 {

    public List<Integer> grayCode(int n) {
        if(n < 0 || n > 31)
            return new ArrayList<Integer>();

        ArrayList<Integer> rs = new ArrayList<Integer>(1 << n);
        rs.add(0);

        for(int i = 1,k = 1 ; i <= n ; i++,k=k<<1){
            for(int j = rs.size() - 1 ; j >= 0 ; j--){
                rs.add(rs.get(j) | k);
            }
        }
        return rs;

    }
}
