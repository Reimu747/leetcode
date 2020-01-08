import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution {
    /**
     * 解法一：BFS 层序遍历
     *
     * @param root 二叉树根节点
     * @return 返回root
     */
    public Node connect(Node root) {
        // root为空则直接返回
        if (root == null) {
            return null;
        }

        // 队列里面存放结点
        Queue<Node> queue = new LinkedList<Node>();
        // 根节点先入队
        queue.offer(root);

        // 只要队列非空就一直循环;
        while (!queue.isEmpty()) {
            // 获取当前层的节点数
            int levelNum = queue.size();

            // 遍历当前层结点
            for (int i = 0; i < levelNum; i++) {
                // 队首出队
                Node node = queue.poll();
                // 将出队的结点的next指针指向队首的结点，如果是某一层的最后一个结点，则不操作
                if (i != levelNum - 1) {
                    node.next = queue.peek();
                }

                // 将非空左右子树加入queue
                if (node.left != null) {
                    // 如果队首的左结点不为空就把左结点入队
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    // 如果队首的右结点不为空就把右结点入队
                    queue.offer(node.right);
                }
            }

        }
        return root;
    }

    /**
     * 解法二：DF 递归
     * 对于root节点的递归，分三种情况：
     * root没有子节点：直接返回
     * root有一个子节点：将这个子节点的next属性设置为同层的下一个节点，即为root.next的最左边的一个节点，如果root.next没有子节点，则考虑root.next.next依次类推
     * root有两个节点：左子节点指向右子节点，然后右子节点同第二种情况的做法
     *
     * 注意，由于每次递归有前提条件：root这一层的next链必须完整，因此必须从右往左递归
     *
     * @param root 二叉树根节点
     * @return 返回root
     */
    public Node connectDf(Node root) {
        // root为空则直接返回
        if (root == null) {
            return null;
        }

        // 如果root没有孩子
        if (root.left == null && root.right == null) {
            return root;
        }
        // 如果root有两个孩子
        else if (root.left != null && root.right != null) {
            root.left.next = root.right;
            // 设置right的next指向，指向root.next的第一个孩子
            Node next = root.next;
            while (next != null) {
                if (next.left == null && next.right == null) {
                    next = next.next;
                } else if (next.left != null) {
                    root.right.next = next.left;
                    next = null;
                } else {
                    root.right.next = next.right;
                    next = null;
                }
            }
        }
        // 如果root只有一个孩子
        else {
            // 如果root有left孩子
            if (root.left != null) {
                setLittleChildNext(root, root.left);
            }
            // 如果root有right孩子
            else {
                setLittleChildNext(root, root.right);
            }
        }

        // 必须从右往左递归
        connectDf(root.right);
        connectDf(root.left);

        return root;
    }

    /**
     * 设置little child的next指向，指向root.next的第一个孩子
     * @param root 根节点
     * @param littleChild root最小的孩子
     */
    private void setLittleChildNext(Node root, Node littleChild) {
        // 设置little child的next指向，指向root.next的第一个孩子
        Node next = root.next;
        while (next != null) {
            if (next.left == null && next.right == null) {
                next = next.next;
            } else if (next.left != null) {
                littleChild.next = next.left;
                next = null;
            } else {
                littleChild.next = next.right;
                next = null;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.connect(null);
    }
}