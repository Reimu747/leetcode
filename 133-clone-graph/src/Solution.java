/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 0:58
 * @Description
 * @Version 1.0
 **/
import java.util.*;

public class Solution {
    // BFS
    public Node cloneGraphByBFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node res = new Node();
        res.val = node.val;
        Map<Node, Node> map = new HashMap<>();
        map.put(node, res);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0;i < size;i++) {
                Node cur = queue.peek();
                List<Node> list = new ArrayList<>();
                for (Node n : cur.neighbors) {
                    if (!map.containsKey(n)) {
                        queue.offer(n);
                        Node newNode = new Node();
                        newNode.val = n.val;
                        list.add(newNode);
                        map.put(n, newNode);
                    }
                }
                map.get(cur).neighbors = list;
                queue.poll();
            }
        }

        return res;
    }

    // DFS
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node cur, Map<Node, Node> visited) {
        if (visited.containsKey(cur)) {
            return visited.get(cur);
        }
        Node res = new Node();
        visited.put(cur, res);
        res.val = cur.val;
        List<Node> list = new ArrayList<>();
        for (Node n : cur.neighbors) {
            list.add(dfs(n, visited));
        }
        res.neighbors = list;
        return res;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}