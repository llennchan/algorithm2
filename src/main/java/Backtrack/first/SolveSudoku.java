package Backtrack.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 *
 * @author 包成
 */
public class SolveSudoku {

    // 存储行存在的数字
    private boolean[][] line = new boolean[9][9];
    // 存储列存在的数字
    private boolean[][] column = new boolean[9][9];
    // 存储九宫格存在的数字
    private boolean[][][] block = new boolean[3][3][9];

    // 没有数据的坐标
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[] {i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        backtrack(board, 0);
    }

    // 最终是否满足数独
    private boolean valid = false;

    // pos表示没有数据坐标的元素索引
    private void backtrack(char[][] board, int pos) {
        // 递归结束条件
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0];
        int j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            // 剪枝
            if (line[i][digit] || column[j][digit] || block[i / 3][j / 3][digit]) continue;

            line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
            board[i][j] = (char) (digit + '0' + 1);

            // 下一个
            backtrack(board, pos + 1);

            // 回溯
            line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
        }
    }

}
