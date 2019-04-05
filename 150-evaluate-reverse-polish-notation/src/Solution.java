/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 0:58
 * @Description
 * @Version 1.0
 **/

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])) {
                int a = stack.pop();
                int b = stack.pop();
                int res;

                if ("+".equals(tokens[i])) {
                    res = b + a;
                }
                else if ("-".equals(tokens[i])) {
                    res = b - a;
                }
                else if ("*".equals(tokens[i])) {
                    res = b * a;
                }
                else {
                    res = b / a;
                }

                stack.push(res);
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(s.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(s.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5",
                "+"}));
    }
}
