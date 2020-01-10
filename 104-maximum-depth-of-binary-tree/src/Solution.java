import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * @ClassName Solution
 * @Author lenovo
 * @Date 2020/1/11 5:45
 * @Description
 * @Version 1.0
 **/
public class Solution {
    /**
     * 解法一：层序遍历返回层数（BFS）
     * @param root 根节点
     * @return 树深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int levelCap = queue.size();

        while (!queue.isEmpty()) {
            TreeNode out = queue.poll();
            levelCap--;

            if (out.left != null) {
                queue.offer(out.left);
            }
            if (out.right != null) {
                queue.offer(out.right);
            }
            if (levelCap == 0) {
                levelCap = queue.size();
                level++;
            }
        }

        return level;
    }

    /**
     * 解法二：递归
     * @param root 根节点
     * @return 树深度
     */
    public int maxDepthDf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthDf(root.left), maxDepthDf(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
