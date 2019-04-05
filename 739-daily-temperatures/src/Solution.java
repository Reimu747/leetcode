/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 1:03
 * @Description
 * @Version 1.0
 **/
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    // 递减栈，栈中存的是下标值而不是元素值
    // 若当前元素小于等于栈顶元素，入栈
    // 否则，按顺序出栈，每出一个，计算下标差并存到结果中，直到栈空，或者当前元素小于等于栈顶元素时为止，此时当前元素入栈
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
