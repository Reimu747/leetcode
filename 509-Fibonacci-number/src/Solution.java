import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Author lenovo
 * @Date 2020/1/10 2:47
 * @Description
 * @Version 1.0
 **/
public class Solution {
    /**
     * 解法一：迭代
     * @param N index
     * @return 斐波那契数列第N项值
     */
    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        int first = 0;
        int second = 1;
        int res = 1;
        for (int i = 2; i <= N; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }

    /**
     * 解法二：递归
     * @param N index
     * @return 斐波那契数列第N项值
     */
    public int fibDf(int N) {
        if (N < 2) {
            return N;
        }
        return fibDf(N - 1) + fibDf(N - 2);
    }

    /**
     * 解法三：记忆化递归
     * @param N index
     * @return 斐波那契数列第N项值
     */
    private Map<Integer, Integer> cache = new HashMap<>();
    public int fibDfMemory(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        int res;
        if (N < 2) {
            res = N;
        } else {
            res = fibDfMemory(N - 1) + fibDfMemory(N - 2);
        }
        cache.put(N, res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fib(4));
    }
}
