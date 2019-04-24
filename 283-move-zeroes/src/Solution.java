import java.util.Arrays;

/**
 * @Author Liu Zihao
 * @Date 2019/4/24
 * @Time 20:12
 * @Description
 */
public class Solution {
    /**
     * 动态规划
     * 如果数组最后一位是0，则直接处理移动数组前一部分即可
     * 如果数组最后一位不是0，则处理移动数组前一部分后，将最后一位与数组中的第一个零元素交换即可
     *
     * @param nums 数组
     */
    public void moveZeroes(int[] nums) {
        df(nums, nums.length - 1);
    }

    private void df(int[] nums, int index) {
        if (index == 0) {
            return;
        }
        df(nums, index - 1);

        if (nums[index] != 0) {
            int i = index;
            while (i > 0 && nums[i - 1] == 0) {
                i--;
            }
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}