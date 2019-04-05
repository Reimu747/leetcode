/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 1:02
 * @Description
 * @Version 1.0
 **/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';
    private static final int CHAR_ZERO = '0';
    private static final int CHAR_NINE = '9';

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> numList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c != RIGHT_BRACKET) {
                stack.push(c);
            } else {
                StringBuilder temp = new StringBuilder();
                while (stack.peek() != LEFT_BRACKET) {
                    temp.append(stack.pop());
                }
                temp = temp.reverse();
                stack.pop();

                StringBuilder count = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= CHAR_ZERO && stack.peek() <= CHAR_NINE) {
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
