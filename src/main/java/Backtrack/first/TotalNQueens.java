package Backtrack.first;

import java.util.HashSet;
import java.util.Set;

/**
 * N皇后 II
 * https://leetcode-cn.com/problems/n-queens-ii/
 *
 * @author 包成
 */
public class TotalNQueens {

    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    private int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // 递归终止条件
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) continue;
            
            int a = i - row;
            if (diagonals1.contains(a)) continue;
            
            int b = i + row;
            if (diagonals2.contains(b)) continue;

            columns.add(i);
            diagonals1.add(a);
            diagonals2.add(b);

            count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
            columns.remove(i);
            diagonals1.remove(a);
            diagonals2.remove(b);
        }

        return count;
    }

    public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 1;
            // 计算结果为1的位, 即可放置的位
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            // 存在1的位
            while (availablePositions != 0) {
                // 获取最小1的位
                int position = availablePositions & (-availablePositions);
                // 去掉最小1的位
                availablePositions = availablePositions & (availablePositions - 1);
                // 递归下一行, columns占用, diagonals1左移, diagonals2右移
                count += solve(n, row + 1, columns | position,
                        (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
            }
            return count;
        }
    }

}
