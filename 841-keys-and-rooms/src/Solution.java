import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * BFS
     *
     * @param rooms 房间列表
     * @return 是否能进入每一个房间
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] hasVisited = new boolean[rooms.size()];
        hasVisited[0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> keys = rooms.get(queue.peek());
                for (int key : keys) {
                    if (!hasVisited[key]) {
                        hasVisited[key] = true;
                        queue.offer(key);
                    }
                }
                queue.poll();
            }
        }

        for (boolean b : hasVisited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    /**
     * DFS
     *
     * @param rooms 房间列表
     * @return 是否能进入每一个房间
     */
    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] hasVisited = new boolean[rooms.size()];
        dfs(0, hasVisited, rooms);

        for (boolean b : hasVisited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int curRoom, boolean[] hasVisited, List<List<Integer>> rooms) {
        hasVisited[curRoom] = true;
        for (int key : rooms.get(curRoom)) {
            if (!hasVisited[key]) {
                dfs(key, hasVisited, rooms);
            }
        }
    }
}
