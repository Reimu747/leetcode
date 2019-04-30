/**
 * @Author Liu Zihao
 * @Date 2019/4/29
 * @Time 12:24
 * @Description
 */
public class Solution {
    public int reverse(int x) {
        long res = 0;
        while (!(x < 10 && x > -10)) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }

        res *= 10;
        res += x;

        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }

    public static void main(String[] args) {
        // System.out.println(-12 / 10);
        Solution solution = new Solution();
        System.out.println(solution.reverse(1234567809));
        System.out.println(solution.reverse(-12));
    }
}
