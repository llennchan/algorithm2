package Recursion.first;

/**
 * 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 *
 * @author 包成
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        return func(nums, 0, nums.length - 1);
    }

    private int func(int[] nums, int lo, int hi) {
        // 单个元素的情况 递归终止
        if (lo == hi) return nums[lo];

        // 中间的序号
        int mid = (hi - lo) / 2 + lo;
        // 左半部分的众数
        int left = func(nums, lo, mid);
        // 右半部分的众数
        int right = func(nums, mid + 1, hi);

        if (left == right) return left;

        // 左众数在总范围中的次数
        int leftCount = count(nums, left, lo, hi);
        // 右众数在总范围中的次数
        int rightCount = count(nums, right, lo, hi);
        // 如果(左半边的众数在整体出现的次数) > (右半边的众数在整体出现的次数), 那么整体的众数就是左半边的众数
        return leftCount > rightCount ? left : right;
    }

    private int count(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
