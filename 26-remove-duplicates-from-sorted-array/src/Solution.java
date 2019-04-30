/**
 * @Author Liu Zihao
 * @Date 2019/4/29
 * @Time 12:10
 * @Description
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
