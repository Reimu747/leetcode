/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 1:01
 * @Description
 * @Version 1.0
 **/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numSquares(int n) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                for (int j = (int) Math.sqrt(queue.element()); j > 0; j--) {
                    if (j * j == queue.element()) {
                        return res + 1;
                    }
                    queue.add(queue.element() - j * j);
                }
                queue.remove();
            }

            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        long t2 = System.currentTimeMillis();
        System.out.println(s.numSquares(7168));
        System.out.println(System.currentTimeMillis() - t2);
    }
}
