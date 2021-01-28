package main.java.com.nullzl.leetcode400;

import javafx.util.Pair;

import java.util.PriorityQueue;

public class LeetCode378 {

    class Node{
         int i;
         int j;
         int len;
         boolean flag;

         public Node(int x,int y , int n){
             flag = true;
             i = x;
             j = y;
             len = n;
         }

        public boolean next(){
            if(flag && i + 1 < len - j) {
                i++;
                return true;
            }
            if(flag && i + 1 == len - j && j + 1 < len){
                flag = false;
                j++;
                return true;
            }else if(!flag && j + 1 < len) {
                j++;
                return true;
            }
            return false;
        }
    }

    public int kthSmallest1(int[][] matrix, int k) {
        if(null == matrix || 0 == matrix.length
                || null == matrix[0] || 0 == matrix[0].length)
            throw new IllegalArgumentException();
        if(k > matrix.length * matrix.length)
            throw new IllegalArgumentException();
        int n = matrix.length;
        Node node;
        PriorityQueue<Node> heap = new PriorityQueue<>(n,
                (n1,n2) -> {
                    return matrix[n1.i][n1.j] - matrix[n2.i][n2.j];
                });
        for(int i = 0 ;i < n ; i++){
            heap.add(new Node(0,i,n));
        }
        for(int i = 1 ; i < k ; i++){
            node = heap.poll();
            if(node.next())
                heap.add(node);
        }
        node = heap.poll();
        return matrix[node.i][node.j];
    }

    public int kthSmallest2(int[][] matrix, int k) {
        if(null == matrix || 0 == matrix.length
                || null == matrix[0] || 0 == matrix[0].length)
            throw new IllegalArgumentException();
        if(k > matrix.length * matrix.length)
            throw new IllegalArgumentException();
        int n = matrix.length;
        PriorityQueue<Pair<Integer,Integer>> heap = new PriorityQueue<>(
            n ,(p1,p2)->{
                return matrix[p1.getKey()][p1.getValue()] - matrix[p2.getKey()][p2.getValue()];
            }
        );
        for(int i = 0 ; i < matrix.length ; i++)
            heap.add(new Pair<>(0,i));
        Pair<Integer,Integer> p;
        for(int i = 1; i <k ; i++){
            p = heap.poll();
            if(p.getKey() + 1 < n)
                heap.add(new Pair<>(p.getKey() + 1,p.getValue()));
        }
        p = heap.poll();
        return matrix[p.getKey()][p.getValue()];
    }


    private int count(int[][] matrix,int mid,int k){
        int i = matrix.length - 1;
        int j = 0;
        int count = 0;
        while(i >= 0 && j < matrix.length && count <= k){
            if(matrix[i][j] <= mid){
                count += (i + 1);
                j++;
            }else{
                i--;
            }
        }
        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int s = matrix[0][0];
        int e = matrix[n-1][n-1];

        while(s <= e){
            int mid = s + ((e - s) >> 1);

            int count = count(matrix,mid,k) ;
//            int j = 0;
//            for(int i = n - 1; i >= 0 && count <= k ; i--){
//                while(j < n && matrix[i][j] <= mid)j++;
//                count += j;
//            }
            //一次遍历，以行计数
//            int i = n - 1;
//            int j = 0;
//            while(i >= 0 && count <= k){
//                if(j == n || matrix[i][j] > mid){
//                    count += j;
//                    i--;
//                }else{
//                    j++;
//                }
//            }
            //一次遍历，以列计数

            if(count < k )
                s = mid + 1;
            else
                e = mid - 1;
        }
        return s;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode378().kthSmallest(
                new int[][]{
                        { 1,  5,  9},
                        {10, 11, 13},
                        {12, 13, 15}
                },7
        ));
    }
}
