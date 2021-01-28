package main.java.com.nullzl.leetcode1000;

import javax.lang.model.element.NestingKind;

public class LeetCode906 {

    class Number{
         String left;
         String middle;
         long leftNum;
         long midNum;
         long num;
         long exp;

         private void init(long n){
             String s = String.valueOf(n);
             exp = 1;
             if(1 == s.length()){
                 left = "";
                 leftNum = 0;
                 middle = s;
                 midNum = Long.parseLong(s);
                 num = n;
                 exp = 1;
             }else{
                 for(int i = 1; i < s.length() ; i++){
                     exp *= 10;
                 }
                 left = s.substring(0,s.length() >> 1);
                 leftNum = Long.parseLong(left);
                 if(s.length() % 2 == 1){
                     middle = s.substring((s.length() >> 1),((s.length()>>1) + 1));
                     midNum = Long.parseLong(middle);
                 }else{
                     middle = "";
                     midNum = 0;
                 }
                 String right = s.substring(
                         (s.length() % 2 == 1)?(s.length()>>1) + 1 : (s.length() >> 1),
                         s.length()
                 );
                 String leftReverse = new StringBuffer(left).reverse().toString();
                 if(Long.parseLong(leftReverse) < Long.parseLong(right)){
                     next();
                 }else{
                    num = Long.parseLong(left + middle + leftReverse);
                 }
             }
         }

         public Number(long n){
             this.init(n);
         }

        public void next(){
             long add = 0;
             if(!"".equals(this.middle)){
                midNum++;
                add = midNum / 10;
                midNum = midNum % 10;
                middle = String.valueOf(midNum);
             }else{
                 add = 1;
             }

             if(0 != add){
                 if("".equals(left) ||
                 String.valueOf(leftNum + 1).length() != left.length()){
                    exp = exp * 10;
                    long n = exp + 1;
                    init(n);
                 }else{
                    leftNum++;
                    left = String.valueOf(leftNum);
                 }
             }
            num = Long.parseLong(left+middle+new StringBuffer(left).reverse().toString());
        }

    }

    public int superpalindromesInRange(String L, String R) {
        long left = Long.parseLong(L);
        long right = Long.parseLong(R);
        if(right < left)
            throw new IllegalArgumentException();

        long s = (long)Math.sqrt(left);
        long e = (long)Math.sqrt(right);

        Number num = new Number(s);
        int count = 0;
        while(num.num <= e){
            long rs = num.num * num.num;
            String str = String.valueOf(rs);
            count++;
            for(int i = 0, j= str.length() - 1; i < j ; i++,j--){
                if(str.charAt(i) != str.charAt(j)){
                    count--;
                    break;
                }
            }
            num.next();
        }
        return count;

    }

    public static void main(String[] args){
        LeetCode906 l = new LeetCode906();
        System.out.println(l.superpalindromesInRange("4","1000"));
    }
}
