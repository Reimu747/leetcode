import java.util.Arrays;

/**
 * @Author Liu Zihao
 * @Date 2019/4/15
 * @Time 20:09
 * @Description
 */
public class Solution {
    /**
     * 解法一：将整个数组向右旋转k次，每次旋转1位
     * 时间复杂度kn
     *
     * @param nums 数组
     * @param k    旋转位数
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 解法二：三次翻转数组，第一次翻转全部，第二次翻转前k个元素，第三次翻转后n - k个元素
     * 时间复杂度n
     *
     * @param nums 数组
     * @param k    旋转位数
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{7, 6, 5, 4, 3, 2, 1};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
