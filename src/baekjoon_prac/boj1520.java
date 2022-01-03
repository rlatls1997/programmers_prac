package baekjoon_prac;

import java.util.*;
//1520_내리막 길
public class boj1520 {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int findRoute(int[][] board, int[][] visited, int col, int row) {
        int totalRoute = 0;

        if (col == board.length - 1 && row == board[0].length - 1) {
            return 1;
        }

        for (int[] direction : directions) {
            int nextCol = col + direction[0];
            int nextRow = row + direction[1];

            if (nextCol >= 0 && nextCol < board.length &&
                    nextRow >= 0 && nextRow < board[0].length &&
                    board[col][row] > board[nextCol][nextRow]) {
                if (visited[nextCol][nextRow] == -1) {
                    continue;
                }
                if (visited[nextCol][nextRow] != 0) {
                    totalRoute += visited[nextCol][nextRow];
                } else {
                    totalRoute += findRoute(board, visited, nextCol, nextRow);
                }
            }
        }

        visited[col][row] = totalRoute;
        if (totalRoute == 0) {
            visited[col][row] = -1;
        }
        return totalRoute;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int col = s.nextInt();
        int row = s.nextInt();
        int[][] board = new int[col][row];
        int[][] visited = new int[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                board[i][j] = s.nextInt();
            }
        }

        System.out.println(findRoute(board, visited, 0, 0));
    }
}
