/**
 * @Author Liu Zihao
 * @Date 2019/4/28
 * @Time 20:44
 * @Description
 */
public class Solution {
    public void rotate(int[][] matrix) {
        rotateOnDiagonal(matrix);
        rotateReverse(matrix);
    }

    /**
     * 沿主对角线翻转图像
     *
     * @param matrix 图像
     */
    private void rotateOnDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * 左右翻转图像
     *
     * @param matrix 图像
     */
    private void rotateReverse(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
            int k = matrix[i].length - 1;
            while (j < k) {
                int temp = matrix[i][j];
                matrix[i][j++] = matrix[i][k];
                matrix[i][k--] = temp;
            }
        }
    }
}
