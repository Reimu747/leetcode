import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Author lenovo
 * @Date 2020/1/10 1:53
 * @Description
 * @Version 1.0
 **/
public class Solution {
    /**
     * 解法一：迭代
     * @param rowIndex 行数
     * @return 杨辉三角的第N层
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
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

        return res.get(rowIndex);
    }
    /**
     * 解法二：递归
     * @param rowIndex 行数
     * @return 杨辉三角的第N层
     */
    public List<Integer> getRowDf(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer>res = new ArrayList<>();
            res.add(1);
            return res;
        }
        List<Integer> before = getRowDf(rowIndex - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0 || i == rowIndex) {
                res.add(1);
            } else {
                res.add(before.get(i - 1) + before.get(i));
            }
        }
        return res;
    }
}
