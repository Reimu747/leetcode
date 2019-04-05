/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 1:03
 * @Description
 * @Version 1.0
 **/
public class Solution {
    /**
     * 动态规划
     *
     * @param nums 数组
     * @param s    目标
     * @return 结果数
     */
    public int findTargetSumWays(int[] nums, int s) {
        return f(nums, nums.length - 1, s);
    }

    private int f(int[] nums, int i, int s) {
        if (i == 0) {
            if (s == 0 && nums[i] == 0) {
                return 2;
            }
            if (s == nums[i] || s == nums[i] * (-1)) {
                return 1;
            }
            return 0;
        }
        return f(nums, i - 1, s + nums[i]) + f(nums, i - 1, s - nums[i]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1};
        System.out.println(solution.findTargetSumWays(nums, 1));
    }
}
