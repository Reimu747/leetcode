import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * BFS
     *
     * @param image    原图像
     * @param sr       初始点横坐标
     * @param sc       初始点纵坐标
     * @param newColor 新颜色值
     * @return 渲染后的图像
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] needCheck = new boolean[image.length][image[0].length];
        resetNeedCheck(needCheck);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        needCheck[sr][sc] = false;
        int oriColor = image[sr][sc];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.peek()[0];
                int y = queue.peek()[1];
                image[x][y] = newColor;

                if (x - 1 > -1 && image[x - 1][y] == oriColor && needCheck[x - 1][y]) {
                    needCheck[x - 1][y] = false;
                    queue.offer(new int[]{x - 1, y});
                }
                if (x + 1 < image.length && image[x + 1][y] == oriColor && needCheck[x + 1][y]) {
                    needCheck[x + 1][y] = false;
                    queue.offer(new int[]{x + 1, y});
                }
                if (y - 1 > -1 && image[x][y - 1] == oriColor && needCheck[x][y - 1]) {
                    needCheck[x][y - 1] = false;
                    queue.offer(new int[]{x, y - 1});
                }
                if (y + 1 < image[0].length && image[x][y + 1] == oriColor && needCheck[x][y + 1]) {
                    needCheck[x][y + 1] = false;
                    queue.offer(new int[]{x, y + 1});
                }
                queue.poll();
            }
        }
        return image;
    }

    private void resetNeedCheck(boolean[][] needCheck) {
        for (int i = 0; i < needCheck.length; i++) {
            for (int j = 0; j < needCheck[0].length; j++) {
                needCheck[i][j] = true;
            }
        }
    }

    /**
     * DFS
     *
     * @param image    原图像
     * @param sr       初始点横坐标
     * @param sc       初始点纵坐标
     * @param newColor 新颜色值
     * @return 渲染后的图像
     */
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        boolean[][] needCheck = new boolean[image.length][image[0].length];
        resetNeedCheck(needCheck);
        dfs(sr, sc, newColor, needCheck, image);
        return image;
    }

    private void dfs(int x, int y, int newColor, boolean[][] needCheck, int[][] image) {
        int oriColor = image[x][y];
        image[x][y] = newColor;
        needCheck[x][y] = false;

        if (x - 1 > -1 && needCheck[x - 1][y] && image[x - 1][y] == oriColor) {
            dfs(x - 1, y, newColor, needCheck, image);
        }
        if (x + 1 < image.length && needCheck[x + 1][y] && image[x + 1][y] == oriColor) {
            dfs(x + 1, y, newColor, needCheck, image);
        }
        if (y - 1 > -1 && needCheck[x][y - 1] && image[x][y - 1] == oriColor) {
            dfs(x, y - 1, newColor, needCheck, image);
        }
        if (y + 1 < image[0].length && needCheck[x][y + 1] && image[x][y + 1] == oriColor) {
            dfs(x, y + 1, newColor, needCheck, image);
        }
    }
}
