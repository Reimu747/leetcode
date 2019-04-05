/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 1:03
 * @Description
 * @Version 1.0
 **/
public class Solution {
    // 动态规划
    public int findTargetSumWays(int[] nums, int S) {
        return f(nums, nums.length - 1, S);
    }
    private int f(int[] nums, int i, int S) {
        if (i == 0) {
            if (S == 0 && nums[i] == 0) {
                return 2;
            }
            if (S == nums[i] || S == nums[i] * (-1)) {
                return 1;
            }
            return 0;
        }
        return f(nums, i - 1, S + nums[i]) + f(nums, i - 1, S - nums[i]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1};
        System.out.println(solution.findTargetSumWays(nums, 1));
    }
}
