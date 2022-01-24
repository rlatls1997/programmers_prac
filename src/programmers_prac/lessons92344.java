package programmers_prac;
//2022 KAKAO BLIND RECRUITMENT
//파괴되지 않은 건물
public class lessons92344 {
    public int solution(int[][] board, int[][] skill) {
        int[][] tmp = new int[board.length][board[0].length];
        for (int[] command : skill) {
            int type = command[0];
            int c1 = command[1];
            int r1 = command[2];
            int c2 = command[3] + 1;
            int r2 = command[4] + 1;
            int degree = command[5];

            tmp[c1][r1] += type == 1 ? -degree : degree;
            if (c2 < tmp.length) {
                tmp[c2][r1] += type == 1 ? degree : -degree;
            }
            if (r2 < tmp[0].length) {
                tmp[c1][r2] += type == 1 ? degree : -degree;
            }
            if (c2 < tmp.length && r2 < tmp[0].length) {
                tmp[c2][r2] += type == 1 ? -degree : degree;
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            int prev = tmp[i][0];
            for (int j = 1; j < tmp[i].length; j++) {
                tmp[i][j] += prev;
                prev = tmp[i][j];
            }
        }

        for (int i = 0; i < tmp[0].length; i++) {
            int prev = tmp[0][i];
            for (int j = 1; j < tmp.length; j++) {
                tmp[j][i] += prev;
                prev = tmp[j][i];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += tmp[i][j];
            }
        }

        return getOk(board);
    }

    int getOk(int[][] board) {
        int count = 0;
        for (int[] col : board) {
            for (int building : col) {
                if (building > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
