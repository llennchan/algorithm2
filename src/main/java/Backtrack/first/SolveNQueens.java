package Backtrack.first;

import java.util.*;

/**
 * N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(
            List<List<String>> solutions, int[] queens, int n, int row,
            Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // 递归结束场景
        if (row == n) {
            solutions.add(generateBoard(queens, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 剪枝
            // 同一列
            if (columns.contains(i)) continue;
            // 同一 '\'
            if (diagonals1.contains(i - row)) continue;
            // 同一 '/'
            if (diagonals2.contains(i + row)) continue;

            // 存储已经占用的列 '\' '/'
            columns.add(i);
            diagonals1.add(i - row);
            diagonals2.add(i + row);

            // 第row行的queen放在第i列
            queens[row] = i;
            // 递归, 计算第row + i行的queen
            backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);

            // 这一列判断结束, 无论成功还是失败, 开始"还原现场"
            queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(i - row);
            diagonals2.remove(i + row);
        }
    }

    // 每一行, queen所在的序号
    public List<String> generateBoard(int[] queens, int n) {
        List<String> ret = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            ret.add(new String(row));
        }
        return ret;
    }

}
