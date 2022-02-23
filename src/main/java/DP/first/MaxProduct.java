package DP.first;

/**
 * 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * @author 包成
 */
public class MaxProduct {

    private int recursion(int[] nums, int[][] mem, int start, int end) {
        if (start >= nums.length || end >= nums.length) {
            return 0;
        }

        if (mem[start][end] != 0) {
            return mem[start][end];
        }

        int result = nums[start];
        for (int i = start + 1; i <= end; i++) {
            result = nums[i] * result;
        }
        int row = recursion(nums, mem, start, end + 1);
        int col = recursion(nums, mem, start + 1, end);
        mem[start][end] = Math.max(row, Math.max(col, result));
        return mem[start][end];
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] mem = new int[nums.length][nums.length];
        return recursion(nums, mem, 0, 0);
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int ret = maxProduct.maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(ret);
    }

    public int maxProduct2(int[] nums) {
        int max = nums[0], min = nums[0], ret = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int tempMax = max;
            max = Math.max(tempMax * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(min * nums[i], Math.min(tempMax * nums[i], nums[i]));
            ret = Math.max(ret, max);
        }
        return ret;
    }

}
