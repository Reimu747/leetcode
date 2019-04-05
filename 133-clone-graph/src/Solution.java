/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 0:58
 * @Description
 * @Version 1.0
 **/

import java.util.*;

public class Solution {
    /**
     * BFS
     *
     * @param node 提供的头节点
     * @return 克隆的头节点
     */
    public Node cloneGraphByBFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node res = new Node();
        res.val = node.val;
        Map<Node, Node> map = new HashMap<>(100);
        map.put(node, res);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
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

    /**
     * DFS
     *
     * @param node 提供的头节点
     * @return 克隆的头节点
     */
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>(100);
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

    public Node() {
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return val == node.val && Objects.equals(neighbors, node.neighbors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, neighbors);
    }
}