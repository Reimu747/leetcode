/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 1:00
 * @Description
 * @Version 1.0
 **/

import java.util.LinkedList;

public class Solution {
    /**
     * BFS
     *
     * @param grid 地图
     * @return 岛屿数量
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        boolean[][] needCheck = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < needCheck.length; i++) {
            for (int j = 0; j < needCheck[i].length; j++) {
                needCheck[i][j] = true;
            }
        }

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (needCheck[i][j] && grid[i][j] == '1') {
                    res++;
                    LinkedList<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));
                    needCheck[i][j] = false;

                    while (queue.size() > 0) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int x = queue.getFirst().x;
                            int y = queue.getFirst().y;

                            if (y + 1 < grid[i].length) {
                                if (grid[x][y + 1] == '1') {
                                    if (needCheck[x][y + 1]) {
                                        queue.add(new Point(x, y + 1));
                                        needCheck[x][y + 1] = false;
                                    }
                                }
                            }
                            if (x + 1 < grid.length) {
                                if (grid[x + 1][y] == '1') {
                                    if (needCheck[x + 1][y]) {
                                        queue.add(new Point(x + 1, y));
                                        needCheck[x + 1][y] = false;
                                    }
                                }
                            }
                            if (y - 1 > -1) {
                                if (grid[x][y - 1] == '1') {
                                    if (needCheck[x][y - 1]) {
                                        queue.add(new Point(x, y - 1));
                                        needCheck[x][y - 1] = false;
                                    }
                                }
                            }
                            if (x - 1 > -1) {
                                if (grid[x - 1][y] == '1') {
                                    if (needCheck[x - 1][y]) {
                                        queue.add(new Point(x - 1, y));
                                        needCheck[x - 1][y] = false;
                                    }
                                }
                            }

                            queue.remove(0);
                        }
                    }
                }
            }
        }

        return res;
    }

    /**
     * DFS
     *
     * @param grid 地图
     * @return 岛屿数量
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        boolean[][] needCheck = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < needCheck.length; i++) {
            for (int j = 0; j < needCheck[i].length; j++) {
                needCheck[i][j] = true;
            }
        }

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (needCheck[i][j] && grid[i][j] == '1') {
                    res++;


                }
            }
        }

        return res;
    }

    private class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        char[][] grid2 = new char[][]{{'1'}};
        char[][] grid3 = new char[][]{
                {'1', '1'},
                {'0', '1'}};

        System.out.println(solution.numIslands2(grid1));
    }
}
