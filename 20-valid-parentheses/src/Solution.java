/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 0:54
 * @Description
 * @Version 1.0
 **/
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (ch == ')') {
                    if (pop != '(') {
                        return false;
                    }
                }
                else if (ch == ']') {
                    if (pop != '[') {
                        return false;
                    }
                }
                else {
                    if (pop != '{') {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}