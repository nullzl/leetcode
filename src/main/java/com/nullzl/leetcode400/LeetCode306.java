package com.nullzl.leetcode400;

public class LeetCode306 {

    private StringBuffer add(StringBuffer p1,StringBuffer p2){
        int x = 0,y = 0;
        int tmp = 0;
        StringBuffer rs = new StringBuffer();
        while (x < p1.length() && y < p2.length()){
            int op1 = p1.charAt(x) - '0';
            int op2 = p2.charAt(y) - '0';
            tmp += (op1 + op2);
            rs.append((char)(tmp % 10 + '0'));
            tmp /= 10;
            x++;
            y++;
        }
        while(x < p1.length() && tmp != 0){
            tmp += (p1.charAt(x++) - '0');
            rs.append((char)(tmp % 10 + '0'));
            tmp /= 10;
        }
        while(x < p1.length()){
            rs.append(p1.charAt(x++));
        }
        while(y < p2.length() && tmp != 0){
            tmp +=(p2.charAt(y++) - '0');
            rs.append((char)(tmp % 10 + '0'));
            tmp /= 10;
        }
        while(y < p2.length())
            rs.append(p2.charAt(y++));
        if(0 != tmp)
            rs.append((char)(tmp + '0'));
        return rs;
    }

    private boolean valid(String num,int len1,int len2){
        if((len1 > 1 && num.charAt(0) == '0')
                || (len2 >1 && num.charAt(len1) == '0')){
            return false;
        }
        StringBuffer pre = new StringBuffer(num.substring(0,len1)).reverse();
        StringBuffer sum = new StringBuffer(num.substring(len1,len1 + len2)).reverse();
        for(int i = len1 + len2 ; i < num.length() ; ){
            StringBuffer tmp = add(pre,sum);
            pre = sum;
            sum = tmp;
            if(num.length() - i < sum.length())
                return false;
            for(int k = sum.length() - 1 ; k >= 0 ; ){
                if(sum.charAt(k--) != num.charAt(i++))
                    return false;
            }
        }
        return true;
    }

    public boolean isAdditiveNumber(String num) {
        if(null == num || 3 > num.length())
            return false;

        for(int i = 1 ; (i << 1) + 1 <= num.length() ; i++){
            for(int j = 1 ; i + j + Math.max(i,j) <= num.length() ; j++){
                if(valid(num,i,j))
                    return true;
            }
        }
        return false;
    }

    public static  void main(String[] args){
        LeetCode306 l = new LeetCode306();
        System.out.print(l.isAdditiveNumber("199001200"));
    }
}
