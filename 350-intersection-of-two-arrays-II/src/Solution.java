import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Liu Zihao
 * @Date 2019/4/23
 * @Time 11:13
 * @Description
 */
public class Solution {
    /**
     * 先排序后，声明两个指针从两个数组头部开始遍历。
     * 较小的元素指针后移一位，若遇到相等的元素，就存取后两个指针都后移一位，直到遍历完某个数组后为止。
     *
     * n为较长的数组长度
     * 额外空间O(n)，因为需要动态存取相等的元素，声明了一个列表，等存取完成后再转为数组
     * 时间复杂度基于排序算法
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            }
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[list.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
