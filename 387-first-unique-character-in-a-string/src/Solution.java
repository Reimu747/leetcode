/**
 * @Author Liu Zihao
 * @Date 2019/4/30
 * @Time 15:59
 * @Description
 */
public class Solution {
    /**
     * 两次遍历，注意遍历到某个字符时，也要比较其前面有没有重复的字符
     * 额外空间：O(1)
     * 时间复杂度：O(n^2)
     *
     * @param s 字符串
     * @return 第一个不重复的字符索引
     */
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                if (j == i) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 申请一个长度为26的数组，遍历一次字符串，将数组对应的元素加1，最后返回字符串中第一个数组对应元素为1的字符索引
     * 额外空间：O(1)
     * 时间复杂度：O(n)
     *
     * @param s 字符串
     * @return 第一个不重复的字符索引
     */
    public int firstUniqChar2(String s) {
        if (s == null) {
            return -1;
        }
        int[] chs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chs[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chs[s.charAt(i) - 97] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("ve"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
        System.out.println(solution.firstUniqChar("cc"));

        System.out.println(solution.firstUniqChar2("ve"));
        System.out.println(solution.firstUniqChar2("loveleetcode"));
        System.out.println(solution.firstUniqChar2("cc"));
    }
}
