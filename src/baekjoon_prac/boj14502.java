package baekjoon_prac;
//14502
//연구소
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj14502 {
    static int getMaximumSafeZone(int[][] arr, boolean[][] visited, int depth) {
        int maximumSafeZone = Integer.MIN_VALUE;
        if (depth == 3) {
            int[][] clonedArr = clone(arr);
            readyToSpreadVirus(clonedArr);
            return getNumOfSafeZone(clonedArr);

        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    arr[i][j] = 1;
                    int safeZone = getMaximumSafeZone(arr, visited, depth + 1);
                    maximumSafeZone = Math.max(safeZone, maximumSafeZone);
                    visited[i][j] = false;
                    arr[i][j] = 0;
                }
            }
        }
        return maximumSafeZone;
    }

    static int getNumOfSafeZone(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static void readyToSpreadVirus(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        List<int[]> initialVirus = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 2) {
                    initialVirus.add(new int[]{i, j});
                }
            }
        }

        for (int[] virus : initialVirus) {
            spreadVirus(arr, visited, virus[0], virus[1]);
        }

    }

    static void spreadVirus(int[][] arr, boolean[][] visited, int col, int row) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < directions.length; i++) {
            int nextCol = col + directions[i][0];
            int nextRow = row + directions[i][1];

            if (nextCol >= 0 && nextCol < arr.length &&
                    nextRow >= 0 && nextRow < arr[0].length &&
                    !visited[nextCol][nextRow] && arr[nextCol][nextRow] == 0) {
                arr[nextCol][nextRow] = 2;
                visited[nextCol][nextRow] = true;
                spreadVirus(arr, visited, nextCol, nextRow);
            }
        }
    }

    static int[][] clone(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int element = s.nextInt();
                arr[i][j] = element;

                if (element == 0) {
                    visited[i][j] = false;
                } else {
                    visited[i][j] = true;
                }
            }
        }
        System.out.println(getMaximumSafeZone(arr, visited, 0));
    }
}
