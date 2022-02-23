package Bitewise.first;

/**
 * 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode-solution-jnwf/
 *
 * @author 包成
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n = n & n - 1;
            ret++;
        }
        return ret;
    }

}
