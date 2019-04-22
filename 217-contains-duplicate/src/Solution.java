import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Liu Zihao
 * @Date 2019/4/22
 * @Time 16:13
 * @Description
 */
public class Solution {
    /**
     * 通过Set的特性实现
     * 额外空间O(n)
     * 时间复杂度O(n)
     *
     * @param nums 数组
     * @return 是否有重复元素
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set.size() != nums.length;
    }

    /**
     * 排序后两两比较相邻元素
     * 原地算法
     * 时间复杂度基于排序算法
     *
     * @param nums 数组
     * @return 是否有重复元素
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
