package Bitewise.first;

/**
 * 2 的幂
 * https://leetcode-cn.com/problems/power-of-two/
 *
 * @author 包成
 */
public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & -n) == n);
    }

}
