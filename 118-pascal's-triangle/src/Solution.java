import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Author lenovo
 * @Date 2020/1/10 1:33
 * @Description
 * @Version 1.0
 **/
public class Solution {
    /**
     * 解法一：迭代
     *
     * @param numRows 行数
     * @return 杨辉三角
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    level.add(1);
                }
                else {
                    level.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(level);
        }

        return res;
    }

    /**
     * 解法二：递归
     *
     * @param numRows 行数
     * @return 杨辉三角
     */
    public List<List<Integer>> generateDf(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = generateDf(numRows - 1);
        List<Integer> bottom = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                bottom.add(1);
            } else {
                bottom.add(res.get(numRows - 2).get(i - 1) + res.get(numRows - 2).get(i));
            }
        }
        res.add(bottom);

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateDf(5);
    }
}
