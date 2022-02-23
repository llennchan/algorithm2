package DP.first;

import java.util.List;

/**
 * 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 *
 * @author 包成
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        // 初始值
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            // 最左侧的值, 只能是上一行最左侧的值 + 本身的值
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            // 最右侧的值, 只能是上一行最右侧的值 + 本身的值
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
            // 坐标(i,j), 只能从(i-1, j-1)或者(i-1,j)移动过来
            // 也就是dp(i,j) = min(dp(i-1, j-1), dp(i-1, j)) + triangle(i, j)
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        // 最后一行最左侧的值
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            // 到达最后一层的每个dp值
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }

}
