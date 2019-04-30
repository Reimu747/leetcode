/**
 * @Author Liu Zihao
 * @Date 2019/4/26
 * @Time 12:21
 * @Description
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!rowAndLineIsValid(board, i)) {
                return false;
            }
        }

        return subSudokuIsValid(board);
    }

    /**
     * 判断第index行及第index列是否合法
     *
     * @param board 数独
     * @param index 行、列索引
     * @return 是否合法
     */
    private boolean rowAndLineIsValid(char[][] board, int index) {
        for (int i = 0; i < 9; i++) {
            if (board[index][i] != '.') {
                for (int j = i + 1; j < 9; j++) {
                    if (board[index][i] == board[index][j]) {
                        return false;
                    }
                }
            }
            if (board[i][index] != '.') {
                for (int j = i + 1; j < 9; j++) {
                    if (board[i][index] == board[j][index]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 判断9个子数独是否合法
     *
     * @param board 数独
     * @return 是否合法
     */
    private boolean subSudokuIsValid(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] != '.') {
                            for (int m = i; m < i + 3; m++) {
                                for (int n = j; n < j + 3; n++) {
                                    if (m == k && n == l) {
                                        continue;
                                    }
                                    if (board[k][l] == board[m][n]) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '.', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '8', '.', '.', '.', '3', '.'},
                {'.', '5', '.', '.', '2', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '9'},
                {'.', '.', '.', '.', '.', '.', '4', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '7'},
                {'.', '1', '.', '.', '.', '.', '.', '.', '.'},
                {'2', '4', '.', '.', '.', '.', '9', '.', '.'}
        };
        Solution solution = new Solution();
        boolean flag = solution.isValidSudoku(board);
        System.out.println(flag);
    }
}
