import java.util.Arrays;

/**
 * @Author Liu Zihao
 * @Date 2019/4/24
 * @Time 17:09
 * @Description
 */
public class Solution {
    /**
     * 动态规划
     * 最后一位不是9，则直接将最后一位+1返回即可
     * 最后一位是9，则返回数组前一部分+1后的数组，后面再拼接一个0即可
     * 于是边界条件即：数组长度为0时，返回new int[]{1}
     *
     * @param digits 原数组
     * @return 加一后的数组
     */
    public int[] plusOne(int[] digits) {
        return dp(digits);
    }

    private int[] dp(int[] digits) {
        if (digits.length == 0) {
            return new int[]{1};
        }

        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            int[] temp = new int[digits.length - 1];
            if (temp.length > 0) {
                System.arraycopy(digits, 0, temp, 0, temp.length);
            }
            int[] arrayOne = dp(temp);
            int[] res = new int[arrayOne.length + 1];
            System.arraycopy(arrayOne, 0, res, 0, arrayOne.length);
            return res;
        }
    }

    /**
     * 一般思路的算法
     * 最后一位不是9，则直接将最后一位+1返回即可
     * 最后一位是9，则从数组后端起找到第一位不是9的元素，其后面的元素都设为0，其自身+1即可
     * 如果数组中全是9，则扩容一位，+1后返回
     *
     * @param digits 原数组
     * @return 加一后的数组
     */
    public int[] plusOne2(int[] digits) {
        int flagZero = digits.length - 1;
        boolean flag = false;
        for (int i = digits.length - 1; i > -1 && !flag; i--) {
            if (digits[i] == 9) {
                flagZero--;
            } else {
                flag = true;
            }
        }

        int[] res;
        if (flagZero < 0) {
            res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = 0;
            }
            return res;
        } else {
            res = new int[digits.length];
            System.arraycopy(digits, 0, res, 0, flagZero);
            res[flagZero] = digits[flagZero] + 1;
            for (int i = flagZero + 1; i < res.length; i++) {
                res[i] = 0;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 9, 8, 9})));
    }
}
