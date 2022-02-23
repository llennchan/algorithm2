package Backtrack.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效的数独
 * https://leetcode-cn.com/problems/valid-sudoku/
 *
 * @author 包成
 */
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // 存储行存在的数字
        boolean[][] line = new boolean[9][9];
        // 存储列存在的数字
        boolean[][] column = new boolean[9][9];
        // 存储九宫格存在的数字
        boolean[][][] block = new boolean[3][3][9];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0' - 1;
                    if (line[i][digit] || column[j][digit] || block[i / 3][j / 3][digit]) return false;

                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        return true;
    }

}
