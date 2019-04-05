/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 1:02
 * @Description
 * @Version 1.0
 **/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> numList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder temp = new StringBuilder();
                while (stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                temp = temp.reverse();
                stack.pop();

                StringBuilder count = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= 48 && stack.peek() <= 57) {
                    count.append(stack.pop());
                }
                count = count.reverse();


                StringBuilder unitStr = new StringBuilder();
                for (int i = 0; i < Integer.parseInt(count.toString()); i++) {
                    unitStr.append(temp);
                }

                for (char ch : unitStr.toString().toCharArray()) {
                    stack.push(ch);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char c : stack) {
            builder.append(c);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("3[a2[c]]"));
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
    }
}
