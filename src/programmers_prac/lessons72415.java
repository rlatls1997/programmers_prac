package programmers_prac;
//2021 KAKAO BLIND RECRUITMENT
//카드 짝 맞추기
import java.util.LinkedList;
import java.util.Queue;

public class lessons72415 {
    static final int BLANK = 0;

    public int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        int numOfCards = getNumOfCards(board);
        if (board[r][c] != BLANK) {
            answer = getMinTimes(board, r, c, numOfCards, 1, true);
        }
        answer = Math.min(answer, getMinTimes(board, r, c, numOfCards, 0, false));
        return answer;
    }

    int getMinTimes(int[][] board, int c, int r, int numOfCards, int times, boolean opened) {
        int minTimes = Integer.MAX_VALUE;
        if (numOfCards == 0) {
            return times;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (opened && !(i == c && j == r) && board[i][j] == board[c][r]) {
                    int moveTimes = getMinTimeToOne(board, c, r, i, j) + 1;
                    if (moveTimes == 0) {
                        return Integer.MAX_VALUE;
                    }
                    int tmp = board[i][j];
                    board[i][j] = BLANK;
                    board[c][r] = BLANK;
                    minTimes = getMinTimes(board, i, j, numOfCards - 2, times + moveTimes, false);
                    board[i][j] = tmp;
                    board[c][r] = tmp;
                }
                if (!opened && !(i == c && j == r) && board[i][j] != BLANK) {
                    int moveTimes = getMinTimeToOne(board, c, r, i, j) + 1;
                    if (moveTimes == 0) {
                        continue;
                    }
                    minTimes = Math.min(minTimes, getMinTimes(board, i, j, numOfCards, times + moveTimes, true));
                }
            }
        }
        return minTimes;
    }

    int getMinTimeToOne(int[][] board, int c, int r, int i, int j) {
        Queue<int[]> positions = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];

        positions.add(new int[]{c, r, 0});
        visited[c][r] = true;

        while (!positions.isEmpty()) {
            int[] position = positions.poll();
            if (position[0] == i && position[1] == j) {
                return position[2];
            }

            int[] cols = {position[0] - 1, position[0] + 1};  //min, max
            int[] rows = {position[1] - 1, position[1] + 1};  //min, max

            for (int q = 0; q < 4; q++) {
                if (cols[0] > 0 && board[cols[0]][position[1]] == BLANK) {
                    cols[0]--;
                }
                if (cols[1] < 3 && board[cols[1]][position[1]] == BLANK) {
                    cols[1]++;
                }
                if (rows[0] > 0 && board[position[0]][rows[0]] == BLANK) {
                    rows[0]--;
                }
                if (rows[1] < 3 && board[position[0]][rows[1]] == BLANK) {
                    rows[1]++;
                }
            }
            for (int q = 0; q < 2; q++) {
                if (cols[q] >= 0 && cols[q] < 4 && !visited[cols[q]][position[1]]) {
                    visited[cols[q]][position[1]] = true;
                    positions.add(new int[]{cols[q], position[1], position[2] + 1});
                }
                if (rows[q] >= 0 && rows[q] < 4 && !visited[position[0]][rows[q]]) {
                    visited[position[0]][rows[q]] = true;
                    positions.add(new int[]{position[0], rows[q], position[2] + 1});
                }
            }
            for (int q = -1; q < 2; q += 2) {
                int newCol = position[0] + q;
                int newRow = position[1] + q;
                if (newCol >= 0 && newCol < 4 && !visited[newCol][position[1]]) {
                    visited[newCol][position[1]] = true;
                    positions.add(new int[]{newCol, position[1], position[2] + 1});
                }
                if (newRow >= 0 && newRow < 4 && !visited[position[0]][newRow]) {
                    visited[position[0]][newRow] = true;
                    positions.add(new int[]{position[0], newRow, position[2] + 1});
                }
            }
        }
        return -1;
    }

    int getNumOfCards(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != BLANK) {
                    count++;
                }
            }
        }
        return count;
    }
}
