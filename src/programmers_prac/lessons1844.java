package programmers_prac;

import java.util.LinkedList;
import java.util.Queue;

public class lessons1844 {
    public static int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        return findRoute(maps, visited);
    }

    public static int findRoute(int[][] maps, boolean[][] visited) {
        int minDistance = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        visited[0][0] = true;
        queue.add(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            if (position[0] == maps.length - 1 && position[1] == maps[0].length - 1) {
                minDistance = position[2];
            }

            for (int i = 0; i < directions.length; i++) {
                int newCol = position[0] + directions[i][0];
                int newRow = position[1] + directions[i][1];
                int distance = position[2] + 1;

                if (newCol >= 0 && newCol < maps.length &&
                        newRow >= 0 && newRow < maps[0].length &&
                        maps[newCol][newRow] == 1 && !visited[newCol][newRow]) {
                    visited[newCol][newRow] = true;
                    queue.add(new int[]{newCol, newRow, distance});
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        solution(arr);
    }
}
