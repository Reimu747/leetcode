import java.util.Arrays;

/**
 * @Author Liu Zihao
 * @Date 2019/4/25
 * @Time 20:41
 * @Description
 */
public class Solution {
    /**
     * 双指针，分别指向头和尾，每交换两个元素一次，就将两个指针向后向前移动一次，直到原头指针不在原尾指针的前方为止
     * 额外空间O(1)
     * 时间复杂度O(n)
     *
     * @param s 字符数组
     */
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }

    /**
     * 递归算法，将数组前一部分的字符翻转后，再依次向后移动一位，最后令头部的元素为尾部的元素即可
     *
     * @param s 字符数组
     */
    public void reverseString2(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        recursion(s, s.length - 1);
    }

    private void recursion(char[] s, int i) {
        if (i == 0) {
            return;
        }
        recursion(s, i - 1);
        char temp = s[i];
        System.arraycopy(s, 0, s, 1, i);
        s[0] = temp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] chars1 = new char[]{'a', 'b', 'c'};
        char[] chars2 = new char[]{'a', 'b', 'c', 'd'};
        solution.reverseString2(chars1);
        solution.reverseString2(chars2);

        System.out.println(Arrays.toString(chars1));
        System.out.println(Arrays.toString(chars2));
    }
}
