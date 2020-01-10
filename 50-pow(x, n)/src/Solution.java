public class Solution {
    /**
     * 解法一：递归
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0 && n > -2147483648) {
            return 1 / myPow(x, -n);
        }
        if (n == -2147483648) {
            return myPow(x, n + 1) / x;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        else {
            return myPow(x * x, n / 2) * x;
        }
    }

    /**
     * 解法二：迭代
     *
     * @param x
     * @param n
     * @return
     */
    public double myPowTwo(double x, int n) {
        if (n == 0) {
            return 1;
        }
        else if (n < 0) {
            double res = 1;
            for (int i = 0; i < -n; i++) {
                res *= x;
            }
            return 1 / res;
        }
        else {
            double res = 1;
            for (int i = 0; i < n; i++) {
                res *= x;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPowTwo(2, 10));
    }
}