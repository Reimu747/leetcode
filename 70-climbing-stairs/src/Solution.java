import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Author lenovo
 * @Date 2020/1/10 3:07
 * @Description
 * @Version 1.0
 **/
public class Solution {
    /**
     * 解法一：记忆化递归
     * @param n 层数
     * @return 方法数
     */
    private Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int res;
        if (n <= 2) {
            res = n;
        } else {
            res = climbStairs(n - 1) + climbStairs(n - 2);
        }
        cache.put(n, res);
        return res;
    }

    /**
     * 解法二：迭代
     * @param n 层数
     * @return 方法数
     */
    public int climbStairsTwo(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 2;i < n;i++)
        {
            int temp = b;
            b += a;
            a = temp;
        }
        return b;
    }
}
