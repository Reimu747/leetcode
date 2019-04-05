import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 1:07
 * @Description
 * @Version 1.0
 **/
class Solution {
    /**
     * BFS，未通过时间要求，待优化
     *
     * @param matrix 矩阵
     * @return 结果
     */
    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        boolean[][] needCheck = new boolean[matrix.length][matrix[0].length];
        resetNeedCheck(needCheck);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resetNeedCheck(needCheck);
                if (matrix[i][j] != 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    needCheck[i][j] = false;
                    int step = -1;
                    boolean endThisTurn = false;

                    while (!queue.isEmpty() && !endThisTurn) {
                        step++;
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int x = queue.peek()[0];
                            int y = queue.peek()[1];
                            if (matrix[x][y] == 0) {
                                res[i][j] = step;
                                endThisTurn = true;
                                break;
                            }
                            if (x - 1 > -1 && needCheck[x - 1][y]) {
                                needCheck[x - 1][y] = false;
                                queue.offer(new int[]{x - 1, y});
                            }
                            if (y + 1 < matrix[0].length && needCheck[x][y + 1]) {
                                needCheck[x][y + 1] = false;
                                queue.offer(new int[]{x, y + 1});
                            }
                            if (x + 1 < matrix.length && needCheck[x + 1][y]) {
                                needCheck[x + 1][y] = false;
                                queue.offer(new int[]{x + 1, y});
                            }
                            if (y - 1 > -1 && needCheck[x][y - 1]) {
                                needCheck[x][y - 1] = false;
                                queue.offer(new int[]{x, y - 1});
                            }
                            queue.poll();
                        }
                    }
                }
            }
        }

        return res;
    }

    private void resetNeedCheck(boolean[][] needCheck) {
        for (int i = 0; i < needCheck.length; i++) {
            for (int j = 0; j < needCheck[i].length; j++) {
                needCheck[i][j] = true;
            }
        }
    }

    /**
     * 优化的方法
     * 找邻域，确定与0的距离。
     * 第一次循环，遍历所有点，如果当前点小于等于0，跳过；否则，找其邻域4个点是否有0，如果有，跳过；如果没有，将该点的值+1；
     * 第二次循环，如果当前点小于等于1，跳过；否则，找其邻域4个点是否有1，如果有，跳过；如果没有，将该点的值+1；
     * 依次类推。在循环中，对跳过点计数，如果所有点都被跳过，则说明已完成，结束。
     *
     * @param matrix 矩阵
     * @return 结果
     */
    public int[][] updateMatrix2(int[][] matrix) {
        int numOfSkipPoint = 0;
        int numOfLoop = 0;

        while (numOfSkipPoint != matrix.length * matrix[0].length) {
            numOfSkipPoint = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] <= numOfLoop) {
                        numOfSkipPoint++;
                    }
                    else {
                        boolean neighborsHasTarget =
                                (i - 1 > -1 && matrix[i - 1][j] == numOfLoop) || (i + 1 < matrix.length && matrix[i + 1][j] == numOfLoop) || (j - 1 > -1 && matrix[i][j - 1] == numOfLoop) || (j + 1 < matrix[0].length && matrix[i][j + 1] == numOfLoop);
                        if (neighborsHasTarget) {
                            numOfSkipPoint++;
                        }
                        else {
                            matrix[i][j]++;
                        }
                    }
                }
            }
            numOfLoop++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] matrix2 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        System.out.println(Arrays.deepToString(solution.updateMatrix(matrix1)));
        System.out.println(Arrays.deepToString(solution.updateMatrix(matrix2)));

        System.out.println(Arrays.deepToString(solution.updateMatrix2(matrix1)));
        System.out.println(Arrays.deepToString(solution.updateMatrix2(matrix2)));
    }
}
