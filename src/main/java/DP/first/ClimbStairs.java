package DP.first;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author 包成
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    public int climbStairs2(int n) {
        if (n <= 2) return n;
        int p, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
