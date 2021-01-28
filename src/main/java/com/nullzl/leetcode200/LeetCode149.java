package main.java.com.nullzl.leetcode200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LeetCode149 {

    class Point{
        int x;
        int y;
        public Point(int a,int b){
            x = a;
            y = b;
        }
        public int hashCode(){
            return x * y;
        }
        public boolean equals(Object obj){
            if(null == obj)
                return false;
            if(obj.getClass() != this.getClass())
                return false;
            if(obj == this)
                return true;
            Point p = (Point)obj;
            if(p.x == x && p.y == y)
                return true;
            return false;
        }
    }

    class Line{
        long a,b,c,e;
        int size;
        LinkedList<Point> points;
        public Line(Point p1,Point p2,int c1,int c2){
            size = 0;
            points = new LinkedList<>();
            points.add(p1);
            points.add(p2);
            size += c1;
            size += c2;
            a = p1.x - p2.x;
            if(0 == a){
                e = p1.x;
            }else{
                b = p1.y - p2.y;
                c = (a * p1.y) - b * p1.x;
            }
        }
        public boolean contains(Point p){
            if(0 == a){
                return p.x == e;
            }else{
                return p.y * a == (b * p.x + c);
            }
        }
        public void addPoint(Point p,int c){
            this.points.add(p);
            this.size += c;
        }
        public void addSet(HashSet<Point> set){
            Iterator<Point> iterator = this.points.iterator();
            while(iterator.hasNext()){
                set.add(iterator.next());
            }
        }

    }

    /**
     * 特殊输入：
     * 1. 只输入一个点，结果为1
     * 2. 输入的点，可能包含相同的点
     * 3. 相同的点在同一直线
     */
    public int maxPoints(int[][] points) {

        if(null == points || 0 == points.length)
            return 0;
        if(1 == points.length)
            return 1;
        Point[] ps = new Point[points.length];
        LinkedList<Line> lines = new LinkedList<>();
        int count,size = 0;
        int max = 0;
        HashMap<Point,Integer> map = new HashMap<>();
        for(int i = 0 ; i < points.length ; i++){
            Point p = new Point(points[i][0],points[i][1]);
            count = map.getOrDefault(p,0);
            map.put(p,count + 1);
            if(0 == count)
                ps[size++] = p;
            if(count + 1 > max)
                max = count + 1;
        }
        Iterator<Line> iterator;
        Line line;
        HashSet<Point> set = new HashSet<>();
        for(int i = 1; i < size ; i++){
           iterator = lines.iterator();
           while(iterator.hasNext()){
               line = iterator.next();
               if(line.contains(ps[i])){
                   line.addSet(set);
                   line.addPoint(ps[i],map.get(ps[i]));
               }
           }
           for(int j = 0 ; j < i ; j++){
               if(!set.contains(ps[j])){
                   lines.add(new Line(ps[j],ps[i],map.get(ps[j]),map.get(ps[i])));
               }
           }
           set.clear();
        }
        iterator = lines.iterator();
        while(iterator.hasNext()){
            line = iterator.next();
            count = line.size;
            if(count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[][] points = new int[][]{
                {560,248},{0,16},{30,250},{950,187},{630,277},{950,187},{-212,-268},{-287,-222},{53,37},{-280,-100},{-1,-14},{-5,4},{-35,-387},{-95,11},{-70,-13},{-700,-274},{-95,11},{-2,-33},{3,62},{-4,-47},{106,98},{-7,-65},{-8,-71},{-8,-147},{5,5},{-5,-90},{-420,-158},{-420,-158},{-350,-129},{-475,-53},{-4,-47},{-380,-37},{0,-24},{35,299},{-8,-71},{-2,-6},{8,25},{6,13},{-106,-146},{53,37},{-7,-128},{-5,-1},{-318,-390},{-15,-191},{-665,-85},{318,342},{7,138},{-570,-69},{-9,-4},{0,-9},{1,-7},{-51,23},{4,1},{-7,5},{-280,-100},{700,306},{0,-23},{-7,-4},{-246,-184},{350,161},{-424,-512},{35,299},{0,-24},{-140,-42},{-760,-101},{-9,-9},{140,74},{-285,-21},{-350,-129},{-6,9},{-630,-245},{700,306},{1,-17},{0,16},{-70,-13},{1,24},{-328,-260},{-34,26},{7,-5},{-371,-451},{-570,-69},{0,27},{-7,-65},{-9,-166},{-475,-53},{-68,20},{210,103},{700,306},{7,-6},{-3,-52},{-106,-146},{560,248},{10,6},{6,119},{0,2},{-41,6},{7,19},{30,250}
        };
        System.out.println(new LeetCode149().maxPoints(points));
    }
}
