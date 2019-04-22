/**
 * @Author Liu Zihao
 * @Date 2019/4/22
 * @Time 20:36
 * @Description
 */
public class Solution {
    /**
     * 相邻元素两两异或，最后结果就是所要的结果
     * 额外空间O(1)
     * 时间复杂度O(n)
     *
     * @param nums 数组
     * @return 唯一的数字
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
