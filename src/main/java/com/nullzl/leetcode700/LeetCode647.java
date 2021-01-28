package main.java.com.nullzl.leetcode700;

public class LeetCode647 {


    /**
     * 动态规划0(n2)
     * 递推公式：
     * dp[i][j] :
     * i = j : true
     * j = i + 1 : s[i] = s[j] ? true : false
     * s[i] == s[j] && dp[i+1][j-1]
     */
    public int countSubstrings1(String s) {

        if(null == s)
            return 0;
        if(0 == s.length() || 1 == s.length() )
            return s.length();

        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for(int i = 0 ; i < s.length() - 1 ; i++){
            dp[i][i] = true;
            count++;
            if(s.charAt(i) == s.charAt( i + 1)){
                count++;
                dp[i][i+1] = true;
            }
        }
        dp[s.length() - 1][s.length() - 1] = true;
        count++;

        for(int step = 2 ; step < s.length() ; step++){
            for(int i = 0 ;i + step < s.length() ; i++){
                if((s.charAt(i) == s.charAt(i + step)) && dp[i + 1][i + step - 1]){
                    dp[i][i + step] = true;
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 马拉车算法
     * 1. 字符串中间间隙加入'#',不影响回文判断，但是可忽略奇偶数的影响，只需要考虑奇数
     * 2. 对于每个字符s[i]，记录回文半径len[i]，表示以s[i]为中心的回文。
     *      回文半径为1，表示s[i-1]s[i]s[i+1]为回文
     * 3. 遍历每个字符，记录i + len[i]的最大值R，以及中心位置M。即回文半径最远可达的位置
     * 4.
     * 5. 初始M=R=0,len[0] = 0
     * 6. 对于任何的s[i]
     *    6.1  如果i>=R,则不能使用已有结果，遍历字符，找到len[i]，并可能更新M和R
     *    6.2  如果i<R,则可以使用以往的结果，
     *         假设以s[M]为中心，半径为R的回文为s1，s2,,...,sj,...,sm,...,si,...,sr，si对称为sj
     *         j = 2 * m - i,可以使用以sj为中心的回文和以sm为中心的回文，来推导以si为中心的回文
     *         由于si和sj以sm为镜像，所以sj的回文也会镜像到si。主要取决于len[j]和r（和m的距离不会影响，都有镜像）。
     *         当len[j]超出了i到r的距离，由于超出了镜像范围，需要重新探测。
     *         6.2.1 如果len[j] < r - i，len[i] = len[j]
     *         6.2.1 如果len[j] >= r - i ,则需要以s[i]为中心，从r+1开始重新探测
     *
     */
    private boolean isEqual(String s,int i, int j){
        if( 1 == (i % 2) &&  1 == (j % 2))
            return true;
        else if(1 == (i % 2) || 1 == (j % 2))
            return false;
        if(s.charAt(i >> 1) == s.charAt(j >> 1))
            return true;
        return false;
    }
    public int countSubstrings(String s) {
        if(null == s)
            return 0;
        if(0 == s.length() || 1 ==  s.length())
            return s.length();
        int m = 0,r = 0;
        int[] len = new int[(s.length() << 1) - 1];
        len[0] = 0;
        int size;
        for(int i = 1 ; i < len.length ; i++){
            if(i >= r){
                for(size = 1 ; i - size >= 0
                        && i + size < len.length
                        && this.isEqual(s,i-size,i+size)  ; size++);
                len[i] = --size;
                m = i;
                r = i + size;
            }else{
                int j = (m << 1) - i;
                if(len[j] < r - i){
                    len[i] = len[j];
                }else{
                    for(size = 1 ; i - size >= 0
                            && i + size < len.length
                            && this.isEqual(s,i-size,i+size)  ; size++);
                    len[i] = --size;
                    if(i + len[i] > r){
                        r = i + len[i];
                        m = i;
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0 ; i < len.length ; i++){
            if(1 == i % 2){

                if(1 == len[i] % 2){
                    count += ((len[i] + 1) >> 1);
                }else{
                    count += (len[i] >> 1);
                }

            }else{
                if(1 == len[i] % 2){
                    count += (1 + ((len[i] - 1) >> 1));
                }else{
                    count += (1 + (len[i] >> 1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode647().countSubstrings("aaaaa"));
    }
}
