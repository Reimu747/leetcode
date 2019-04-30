/**
 * @Author Liu Zihao
 * @Date 2019/4/30
 * @Time 17:17
 * @Description
 */
public class Solution {
    /**
     * 迭代
     * 时间复杂度O(logn)
     *
     * @param nums   数组
     * @param target 目标
     * @return 目标索引
     */
    public int search(int[] nums, int target) {
        int mid = nums.length / 2;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[mid] > target) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else if (nums[mid] < target) {
                low = mid + 1;
                mid = (low + high) / 2;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 递归
     * 时间复杂度O(logn)
     *
     * @param nums   数组
     * @param target 目标
     * @return 目标索引
     */
    public int search2(int[] nums, int target) {
        return dp(nums, target, 0, nums.length - 1);
    }

    private int dp(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] > target) {
            return dp(nums, target, low, mid - 1);
        } else if (nums[mid] < target) {
            return dp(nums, target, mid + 1, high);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));

        System.out.println(solution.search2(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.search2(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
