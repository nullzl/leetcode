package main.java.com.nullzl.leetcode300;

import java.util.*;

public class LeetCode218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> rs = new LinkedList<>();
        if(null == buildings || 0 == buildings.length)
            return rs;

        PriorityQueue<int[]> spoints = new PriorityQueue<int[]>(buildings.length,
                (p1,p2) ->{
                    if(p1[2] == p2[2]){
                        return p1[1] - p2[1];
                    }
                    return p2[2] - p1[2];
                });
        PriorityQueue<int[]> epoints = new PriorityQueue<int[]>(buildings.length,
                (p1,p2) ->{
                    return p1[1] - p2[1];
                });
        HashSet<int[]> finished = new HashSet();

        for(int i = 0 ; i < buildings.length || !epoints.isEmpty() ;){
            if(i < buildings.length &&
                    (epoints.isEmpty() || epoints.peek()[1] >= buildings[i][0])){
                if(buildings[i][0] == buildings[i][1]) {
                    i++;
                    continue;
                }
                int x = buildings[i][0];
                int y = buildings[i][2];
                int maxHeight = spoints.isEmpty() ? 0 : spoints.peek()[2];
                while(i < buildings.length && x == buildings[i][0]){
                    if(buildings[i][0] == buildings[i][1]) {
                        i++;
                        continue;
                    }
                    y = Math.max(y,buildings[i][2]);
                    spoints.add(buildings[i]);
                    epoints.add(buildings[i]);
                    i++;
                }
                if(y > maxHeight){

                    ArrayList<Integer> item = new ArrayList<>(2);
                    item.add(x);
                    item.add(y);
                    rs.add(item);
                }

            }else{
                int x = epoints.peek()[1];
                int y = epoints.peek()[2];
                while(!epoints.isEmpty() && epoints.peek()[1] == x){
                    int[] p = epoints.poll();
                    finished.add(p);
                    y = Math.max(y,p[2]);
                }
                while(!spoints.isEmpty() && finished.contains(spoints.peek()))
                    spoints.poll();
                int maxHeight = spoints.isEmpty() ? 0 : spoints.peek()[2];

                if(y > maxHeight){
                    ArrayList<Integer> item = new ArrayList<>(2);
                    item.add(x);
                    item.add(maxHeight);
                    rs.add(item);
                }
            }

        }
        return rs;
    }

    public static void main(String[]args){
        new LeetCode218().getSkyline(new int[][]{
                {1,2,1}, {1,2,2}, {1,2,3}, {15,20,10}, {19,24,8}
        }).stream().forEach(list ->{
            list.stream().forEach(num -> System.out.print(num + "\t"));
            System.out.println();
        });
    }
}
